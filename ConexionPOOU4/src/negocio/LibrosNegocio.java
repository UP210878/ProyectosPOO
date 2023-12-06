package negocio;
import datos.ConexionBaseDatos;
import datos.GenerosDatos;
import datos.LibrosDatos;
import encapsuladores.Genero;
import encapsuladores.Libro;
import excepciones.GenericaExcepcion;
import java.sql.Connection;
import java.util.List;
public class LibrosNegocio {
    public String insertar(Libro libro) throws Exception{
        Connection connection = null;
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        try {
            connection = conexionBaseDatos.abrirConexion();
            new LibrosDatos().insertar(connection, libro);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
        return libro.getIdLibro();
    }
    
    public void eliminar(Libro libro) throws Exception{
        Connection connection = null;
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        LibrosDatos librosDatos = new LibrosDatos();
        try {
            connection = conexionBaseDatos.abrirConexion();
            Libro libroAEliminar = librosDatos.consultarPorIdLibro(connection, libro);
            if (libroAEliminar == null)
                throw new GenericaExcepcion(71);
            librosDatos.eliminar(connection, libro);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
    }

    public void actualizarPremiado(Libro libro) throws Exception{
        Connection connection = null;
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        LibrosDatos librosDatos = new LibrosDatos();
        try {
            connection = conexionBaseDatos.abrirConexion();
            Libro libroAActualizar = librosDatos.consultarPorIdLibro(connection, libro);
            if (libroAActualizar == null)
            throw new GenericaExcepcion(71);
            librosDatos.actualizarPremiado(connection, libro);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
    }
    
    public Libro consultarPorIdLibro(Libro libro) throws Exception {
        Connection connection = null;
        Libro libroObtenido = null;
        ConexionBaseDatos conexionBaseDatos = new
        ConexionBaseDatos();
        try {
            connection = conexionBaseDatos.abrirConexion();
            libroObtenido = new LibrosDatos().consultarPorIdLibro(connection, libro);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
        return libroObtenido;
    }

    public List<Libro> consultarTodos() throws Exception {
        Connection connection=null;
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        List<Libro> listaLibros = null;
        try {
            connection = conexionBaseDatos.abrirConexion();
            listaLibros = new LibrosDatos().consultarTodos(connection);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
        return listaLibros;
    }

    public Integer consultarNumeroFilas() throws Exception {
        Connection connection=null;
        ConexionBaseDatos conexionBaseDatos = new
        ConexionBaseDatos();
        Integer numFilas = null;
        try {
            connection = conexionBaseDatos.abrirConexion();
            numFilas = new
            LibrosDatos().consultarNumeroFilas(connection);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
        return numFilas;
    }

    public List<Genero> consultarGeneros() throws Exception {
        Connection connection=null;
        ConexionBaseDatos conexionBaseDatos = new ConexionBaseDatos();
        List<Genero> listaGeneros = null;
        try {
            connection = conexionBaseDatos.abrirConexion();
            listaGeneros = new
            GenerosDatos().consultarGeneros(connection);
        }
        catch (Exception excepcion)
        {
            throw excepcion;
        }
        finally
        {
            conexionBaseDatos.cerrarConexion(connection);
        }
        return listaGeneros;
    }
}
