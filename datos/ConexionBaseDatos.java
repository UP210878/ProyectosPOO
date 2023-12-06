package datos;
import excepciones.GenericaExcepcion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBaseDatos {
    public Connection abrirConexion() throws Exception{

        Connection connection = null;

        try {
            // CONEXION MySQL
            Class.forName("com.mysql.jdbc.Driver");
            connection =
            DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca", "root", "");
            /*
            // CONEXION Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection =
            DriverManager.getConnection("jdbc:oracle:thin:@localho
            st:1521:ORCL", "scott", "tiger");
            */
        }
        catch (SQLException excepcion) {
            throw new GenericaExcepcion(50);
        }
        return connection;
    }

    public void cerrarConexion(Connection connection)
        throws GenericaExcepcion
        {
            try {
                if (connection!= null)
                connection.close();
            }
            catch (SQLException excepcion) {
                throw new GenericaExcepcion(50);
            }
        }
}
