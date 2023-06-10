/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class CursoDAO {
     private static final String SQL_INSERTAR_CURSO=
             "INSERT INTO `cursos`(Titulo,CargaHoraria,Puntos,Realizacion_prev,tiempo_limite)VALUES(?,?,?,?,?);";
     private static final String SQL_SELECCIONAR_CURSO=
             "SELECT Codigo, Titulo, CargaHoraria, Puntos, Realizacion_prev,tiempo_limite FROM cursos;";
      
     private static final String SQL_ELIMINAR_CURSO=
             "DELETE FROM cursos WHERE codigo = ?;";
     
     private static final String SQL_INSERTAR_CURSOS_REALIZADO=
             "insert into cursos_realizados (cod_curso, id_empl,fecha_inicio,fecha_fin) values (?,?,?,?);";
     
     
     
     public int insertar_cur_reali(unCurso curso, Empleado empleado, String fecha,String fecha_fin){
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_INSERTAR_CURSOS_REALIZADO);
            stmt.setInt(1, curso.getIDCodigo());
            stmt.setInt(2, empleado.getIdEmpleado());
            stmt.setString(3, fecha);
            stmt.setString(4,fecha_fin);
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
     
             
     public int insertarCurso(unCurso curso){
        Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_INSERTAR_CURSO);
            stmt.setString(1, curso.getTitulo());//1 seria el parametro de la consulta, es dcir a: ?
            stmt.setInt(2, curso.getCargaHoraria());
            stmt.setInt(3, curso.getPuntos());
            stmt.setString(4, curso.realizacionPrevia());
            stmt.setInt(5, curso.getMaxCantMeses());//tipo_empleado es booleano
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
     
     
     
     public ArrayList<unCurso> seleccionarCurso() {
        Connection conn = null;//variable de tipo conexion
        PreparedStatement stmt = null;          //en este caso es mas conveniente usar preparedstatement para trabajar conq querys
        ResultSet rs = null;//devuelve una consulta
        unCurso curso = null;
        ArrayList<unCurso> cursos = new ArrayList<>();
        /*
            ahora nos conectamos con la base de datos
            como la conexion puede fallar se encierra en un try catch
         */
        try {
            conn = getConnection();//metodo de la clase Empleado para crear la conexion
            stmt = conn.prepareStatement(SQL_SELECCIONAR_CURSO);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("Codigo");
                String titu = rs.getString("Titulo");
                int carga_horaria = rs.getInt("CargaHoraria");
                int puntoss = rs.getInt("Puntos");
                String reali = rs.getString("Realizacion_prev");
                int MaxMeses = rs.getInt("tiempo_limite");
                
                unCurso curs= new unCurso(id, titu, puntoss, carga_horaria,  MaxMeses);
                cursos.add(curs);
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
        return cursos;
    }
    
     public int EliminarCurso(unCurso curso){
         Connection conn=null;
        PreparedStatement stmt= null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt=conn.prepareCall(SQL_ELIMINAR_CURSO);
            stmt.setInt(1, curso.getIDCodigo());
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
