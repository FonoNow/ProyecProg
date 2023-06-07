/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;
import datos.EmpleadoDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Franco
 */
public class Controlador_ver_cursos {
    public ver_cursos vistacursos;
    public DefaultTableModel tCursos;
    private EmpleadoDAO em= new EmpleadoDAO();
    public ArrayList<unCurso> arrayListCurso= new ArrayList<unCurso>();
    public unCurso Curso= new unCurso();
    public Controlador_ver_cursos(){
    vistacursos= new ver_cursos();
    
}
    public DefaultTableModel tablacursos(ArrayList<unCurso> arrayListCurso){
        int contadorTabla=0;
        String x[][]={};
        String nombresColumnas[]={"Titulo","Fecha de inicio","Fecha Fin"};
        tCursos= new DefaultTableModel(x,nombresColumnas);
        if(arrayListCurso != null){
            for(int i=0;i<arrayListCurso.size();i++){
               tCursos.insertRow(contadorTabla, new Object[]{});
               tCursos.setValueAt(arrayListCurso.get(i).getTitulo(), contadorTabla, 0);
                tCursos.setValueAt(arrayListCurso.get(i).getFechaInicio(), contadorTabla, 1);
                tCursos.setValueAt(arrayListCurso.get(i).getFechaFin(), contadorTabla, 2);
                contadorTabla++;
        }
    }return tCursos;
}
}
