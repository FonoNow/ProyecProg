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
             "SELECT Codigo, Titulo, CargaHoraria, Puntos, fecha_inicio, fecha_fin, Realizacion_prev,tiempo_limite FROM cursos;";
             
             
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
     
     
     
     public List<unCurso> seleccionarCurso() {
        Connection conn = null;//variable de tipo conexion
        PreparedStatement stmt = null;          //en este caso es mas conveniente usar preparedstatement para trabajar conq querys
        ResultSet rs = null;//devuelve una consulta
        unCurso curso = null;
        List<unCurso> cursos = new ArrayList<>();
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
                
                String fecha_in = rs.getString("fecha_inicio");
                String fecha_fin = rs.getString("fecha_fin");
                String reali = rs.getString("Realizacion_prev");
                int MaxMeses = rs.getInt("tiempo_limite");
                
                unCurso curs= new unCurso(id, titu, puntoss, carga_horaria, fecha_in, fecha_fin, MaxMeses);
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
     
}
