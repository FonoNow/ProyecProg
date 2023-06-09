package datos;

import com.mysql.cj.xdevapi.Statement;
import java.sql.*;

/**
 *
 * @author gonza
 */
public class Conexion {//esta clase se encargara de crear la conexion y de cerrar los resultset, intruccion y conexion
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/empleados_puntaje_facultad?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD="12345678g";
    
    public static Connection getConnection() throws SQLException{//metodo para obtener la conexion hacia la base de datos
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);//Esto deberia estar en un try catch pero reportamos la exepcin
        
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    
    public static void close(PreparedStatement smtm) throws SQLException{//sobrecarga
        smtm.close();
    }
    
    public static void close(Connection conn) throws SQLException{
        conn.close();
    }
}
