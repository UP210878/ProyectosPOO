package datos;
import encapsuladores.Libro;
import excepciones.GenericaExcepcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibrosDatos {
    public void insertar(Connection connection, Libro libro) throws Exception { 
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO libros VALUES(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, libro.getIdLibro());
            preparedStatement.setString(2, libro.getTitulo());
            preparedStatement.setString(3, libro.getGenero());
            preparedStatement.setDate(4, libro.getFechaEdicion());
            preparedStatement.setInt(5, libro.getNumeroPaginas());
            byte premiado = 0;
            if (libro.isPremiado())
                premiado = 1;
            preparedStatement.setByte(6, premiado);
            preparedStatement.executeUpdate();
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(80);
        }
        finally
        {
            if (preparedStatement != null)
                preparedStatement.close();
        }
    }
    
    public void actualizarPremiado(Connection connection, Libro libro) throws Exception {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE libros SET premiado = ? WHERE id_libro = CAST(? AS CHAR(5))";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(2, libro.getIdLibro());
            byte premiado = 0;
            if (libro.isPremiado())
                premiado = 1;
            preparedStatement.setByte(1, premiado);
            preparedStatement.executeUpdate();
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(81);
        }
        finally
        {
            if (preparedStatement != null)
                preparedStatement.close();
        }
    }
    
    public void eliminar(Connection connection, Libro libro) throws Exception 
    { 
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM libros WHERE id_libro = CAST(? AS CHAR(5))";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, libro.getIdLibro());
            preparedStatement.executeUpdate();
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(82);
        }
        finally
        {
            if (preparedStatement != null)
                preparedStatement.close();
        }
    }
    
    public Libro consultarPorIdLibro(Connection connection, Libro libro) throws Exception {
        Libro libroObtenido = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT id_libro, titulo, generos.codigo, generos.descripcion, fecha_edicion, numero_paginas, premiado FROM generos INNER JOIN libros ON generos.codigo = libros.genero WHERE id_libro = CAST(? AS CHAR(5))";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, libro.getIdLibro());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                libroObtenido = new Libro();
                libroObtenido.setIdLibro(resultSet.getString(1));
                libroObtenido.setTitulo(resultSet.getString(2));
                libroObtenido.setGenero(resultSet.getString(3));
                libroObtenido.setDescripcion(resultSet.getString(4));
                libroObtenido.setFechaEdicion(resultSet.getDate(5));
                libroObtenido.setNumeroPaginas(resultSet.getInt(6));
                byte premiado = resultSet.getByte(7);
                if (premiado == 1)
                    libroObtenido.setPremiado(true);
                else
                    libroObtenido.setPremiado(false);
            }
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(83);
        }
        finally
        {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null)
            preparedStatement.close();
        }
        return libroObtenido;
    }
        
    public List<Libro> consultarTodos(Connection connection) throws Exception
    {
        List<Libro> listaLibros = new ArrayList();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            String sql = 
            "SELECT id_libro, titulo, generos.codigo, generos.descripcion, fecha_edicion, numero_paginas, premiado FROM generos INNER JOIN libros ON generos.codigo = libros.genero ORDER BY titulo";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Libro libro = new Libro();
                libro = new Libro();
                libro.setIdLibro(resultSet.getString(1));
                libro.setTitulo(resultSet.getString(2));
                libro.setGenero(resultSet.getString(3));
                libro.setDescripcion(resultSet.getString(4));
                libro.setFechaEdicion(resultSet.getDate(5));
                libro.setNumeroPaginas(resultSet.getInt(6));
                byte premiado = resultSet.getByte(7);
                if (premiado == 1)
                    libro.setPremiado(true);
                else
                    libro.setPremiado(false);
                listaLibros.add(libro);
            }
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(84);
        }
        finally
        {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }
        return listaLibros;
        }
        
    public Integer consultarNumeroFilas(Connection connection) throws Exception {
        Integer numFilas = null;
        ResultSet resultSet = null;
        Statement statement = null;
        String sql = "SELECT COUNT(*) FROM libros";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                numFilas = (int)(resultSet.getInt(1));
            }
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(85);
        }
        finally
        {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
        }
        return numFilas;
    }
}
