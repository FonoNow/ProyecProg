package datos;

import static datos.Conexion.*;
import com.mycompany.proyecprog.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gonza
 */
public class EmpleadoDAO {//si tenemos muchas clases de entidad se debe crear una clase DAO por cada una

    private static final String SQL_INSERTAR_EMPLEADO
            = "INSERT INTO empleado(DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos,tipo_empleado) VALUES (    ); ";

    private static final String SQL_SELECCIONAR_EMPLEADO = "select id,DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos,tipo_empleado from empleado;";
    //lo conveniente es crear las consultas al principio

    public List<Empleado> seleccionar() {
        Connection conn = null;//variable de tipo conexion
        PreparedStatement stmt = null;          //en este caso es mas conveniente usar preparedstatement para trabajar conq querys
        ResultSet rs = null;//devuelve una consulta
        Empleado empleado = null;
        List<Empleado> empleados = new ArrayList<>();
        /*
            ahora nos conectamos con la base de datos
            como la conexion puede fallar se encierra en un try catch
         */
        try {
            conn = getConnection();//metodo de la clase Empleado para crear la conexion
            stmt = conn.prepareStatement(SQL_SELECCIONAR_EMPLEADO);
            /*crea un objeto PreparedStatement a partir de la conexión conn y la sentenci
            a SQL SQL_SELECCIONAR_EMPLEADO
             */
            rs = stmt.executeQuery();
            /*
            rs se utiliza para almacenar la referencia al objeto ResultSet devuelto por executeQuery()
            executeQuery() es un método de la clase PreparedStatement que se utiliza para ejecutar
            la consulta SQL y obtener los resultados. Este método devuelve un objeto 
            ResultSet que contiene los datos devueltos por la consulta.
             */
            while (rs.next()) {
                int id = rs.getInt("id");
                int dni = rs.getInt("DNI");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");
                int nro = rs.getInt("NroTelefono");
                double SueldoBase = rs.getDouble("SueldoBase");
                int puntos = rs.getInt("Puntos");
                boolean tipo = rs.getBoolean("tipo_empleado");
                empleado = new Empleado(id, dni, nombre, direccion, nro, SueldoBase,puntos, tipo);
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return empleados;
    }
    
    
}
