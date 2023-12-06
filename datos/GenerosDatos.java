package datos;
import encapsuladores.Genero;
import excepciones.GenericaExcepcion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class GenerosDatos {
    public List<Genero> consultarGeneros(Connection connection) throws Exception {
        List<Genero> listaGeneros = new ArrayList();
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            String sql = "SELECT * FROM generos ORDER BY codigo";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Genero genero = new Genero();
                genero.setCodigo(resultSet.getString(1));
                genero.setDescripcion(resultSet.getString(2));
                listaGeneros.add(genero);
            }
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(90);
        }
        finally
        {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
        }
        return listaGeneros;
    }
}
