package datos;

import static datos.Conexion.*;
import com.mycompany.proyecprog.Empleado;
import com.mycompany.proyecprog.unCurso;
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
            = "INSERT INTO empleado(DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos,tipo_empleado) VALUES (?,?,?,?,?,?,?);";

    private static final String SQL_SELECCIONAR_EMPLEADO = "select id,DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos,tipo_empleado from empleado;";
    //lo conveniente es crear las consultas al principio
    
    private static final String SQL_SELECIONAR_DNI = "select id,DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos,tipo_empleado from empleado WHERE DNI= ?";
    
    private static final String SQL_ELIMINAR_EMPLEADO="DELETE FROM empleado WHERE id = ?;";
    
    private static final String SQL_OBTENERCURSO = "SELECT contar_cursos_realizados(?) AS cantidad; ";
    
    private static final String SQL_MUESTRA_CURSOS_REALIZADOS=
    "SELECT e.DNI DNIempleado, e.Nombre Nombre_Empleado, c.Titulo as titulo curso, cr.fecha_inicio, cr.fecha_fin FROM empleado e INNER JOIN cursos_realizados cr ON e.id = cr.id_empl INNER JOIN cursos c ON cr.cod_curso = c.Codigo WHERE id= ?;";
    
    private static final String SQL_UPDATE_EMPLEADO=
    "UPDATE empleado SET DNI = ?, Nombre = ?, Direccion = ?, NroTelefono = ?, SueldoBase = ?, Puntos = ?, tipo_empleado = ? WHERE id=?;";
    
    private static final String SQL_UPDATE_PUNTOS_EMPL=
    "UPDATE empleado SET Puntos = ? WHERE id=?; ";
    
    
    public int actualizarPuntos(Empleado empleado){
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_UPDATE_PUNTOS_EMPL);
            stmt.setDouble(1, empleado.getPuntos());
            stmt.setInt(2, empleado.getIdEmpleado());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return registros;
    }
    
    
    public int actualizar(Empleado empleado){
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_UPDATE_EMPLEADO);
            stmt.setInt(1, empleado.getDNI());//1 seria el parametro de la consulta, es dcir a: ?
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getDireccion());
            stmt.setString(4, empleado.getNroTelefono());
            stmt.setDouble(5, empleado.getSueldoBase());
            stmt.setDouble(6, empleado.getPuntos());
            stmt.setBoolean(7, empleado.isTipo_empleado());//tipo_empleado es booleano
            stmt.setInt(8, empleado.getIdEmpleado());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return registros;
    }
    
    
    
    
    public ArrayList<unCurso> seleccionar_Cursos_Hechos(int id__){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        unCurso cursos = null;
        ArrayList<unCurso> arrayCursos = new ArrayList<>();
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_MUESTRA_CURSOS_REALIZADOS);
            stmt.setInt(1, id__);
            rs = stmt.executeQuery();

                while (rs.next()) {
                    String titulo = rs.getString("titulo");
                    String fechaIni = rs.getString("cr.fecha_inicio");
                    String fecha_fin = rs.getString("fecha_fin");
                    
                    cursos=new unCurso(titulo, fechaIni, fecha_fin);
                    arrayCursos.add(cursos);
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
        return arrayCursos;
    }
    
    
    
    
    public int obtenerCurso(int iddd){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int cantidad = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_OBTENERCURSO);
            stmt.setInt(1, iddd);
            rs = stmt.executeQuery();
            
                if (rs.next()) {
                cantidad = rs.getInt("cantidad");
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
        return cantidad;
    }    
    
    public Empleado seleccionarDNI(int dni_){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECIONAR_DNI);
            stmt.setInt(1, dni_);
            rs = stmt.executeQuery();
            
            
                
                if (rs.next()) {
                int id = rs.getInt("id");
                int dni = rs.getInt("DNI");
                String nombre = rs.getString("Nombre");
                String direccion = rs.getString("Direccion");
                String nro = rs.getString("NroTelefono");
                double SueldoBase = rs.getDouble("SueldoBase");
                int puntos = rs.getInt("Puntos");
                boolean tipo = rs.getBoolean("tipo_empleado");
                empleado = new Empleado(id, dni, nombre, direccion, nro, SueldoBase, puntos, tipo);
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
        return empleado;
    }
    
    
    public ArrayList<Empleado> seleccionar() {
        Connection conn = null;//variable de tipo conexion
        PreparedStatement stmt = null;//en este caso es mas conveniente usar preparedstatement para trabajar conq querys
        ResultSet rs = null;//devuelve una consulta
        Empleado empleado = null;
        ArrayList<Empleado> empleados = new ArrayList<>();
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
                String nro = rs.getString("NroTelefono");
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
    
    
    public int insertar(Empleado empleado){
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_INSERTAR_EMPLEADO);
            stmt.setInt(1, empleado.getDNI());//1 seria el parametro de la consulta, es dcir a: ?
            stmt.setString(2, empleado.getNombre());
            stmt.setString(3, empleado.getDireccion());
            stmt.setString(4, empleado.getNroTelefono());
            stmt.setDouble(5, empleado.getSueldoBase());
            stmt.setDouble(6, empleado.getPuntos());
            stmt.setBoolean(7, empleado.isTipo_empleado());//tipo_empleado es booleano
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return registros;
    }
    
    
    public int EliminarEmpleado(Empleado empleado){
        
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_ELIMINAR_EMPLEADO);
            stmt.setInt(1, empleado.getIdEmpleado());
            registros=stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return registros;
     }
    }
    
