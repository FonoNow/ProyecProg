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
public class Controlador_ver_maxPuntos {
    public ver_maxPuntos ver_puntos;
    public DefaultTableModel tPuntos;
    public EmpleadoDAO em= new EmpleadoDAO();
    public ArrayList<Empleado> arrayListEmpleado= new ArrayList<Empleado>();
    public Empleado empleado= new Empleado();
    public Controlador_ver_maxPuntos(){
        ver_puntos=new ver_maxPuntos();
        this.arrayListEmpleado=em.MaximoPuntaje();
        
    }
    public DefaultTableModel tablapuntos(ArrayList<Empleado> arrayListEmpleado){
        int contadorTabla=0;
        int maxpuntos=0;
        String x[][]={};
        String nombresColumnas[]= {"Nombre","Puntos"};
       tPuntos = new DefaultTableModel(x,nombresColumnas);
        if(arrayListEmpleado != null){
           for(int i=0;i<arrayListEmpleado.size();i++){
               if(maxpuntos<=arrayListEmpleado.get(i).getPuntos()){
                   maxpuntos=arrayListEmpleado.get(i).getPuntos();
               }
           }
           for(int i=0;i<arrayListEmpleado.size();i++){
               if(maxpuntos==arrayListEmpleado.get(i).getPuntos()){
               tPuntos.insertRow(contadorTabla, new Object[]{});
                tPuntos.setValueAt(arrayListEmpleado.get(i).getNombre(), contadorTabla, 0);
                tPuntos.setValueAt(arrayListEmpleado.get(i).getPuntos(), contadorTabla, 1);
                contadorTabla++;
               }
               
           }
        }
        return tPuntos;
    }
}
