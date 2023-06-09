/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import datos.EmpleadoDAO;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gonza
 */
public class Controlador_mayorPuntaje {
    public MayorPuntaje vistaempleados;
    public DefaultTableModel tEmpleados;
    public EmpleadoDAO em= new EmpleadoDAO();
    public ArrayList<Empleado> arrayListEmpleado= new ArrayList<Empleado>();
    public Empleado empleado = new Empleado();
    public Controlador_mayorPuntaje(){
        vistaempleados= new MayorPuntaje();
        this.arrayListEmpleado = em.MaximoPuntaje();
        
    }
    public DefaultTableModel tablaempleados(ArrayList<Empleado> arrayListEmpleado){
        int contadorTabla=0;
        String x[][]={};
        String nombresColumnas[]= {"Dni","Nombre","Puntos"};
        tEmpleados = new DefaultTableModel(x,nombresColumnas);
        if(arrayListEmpleado != null){
           for(int i=0;i<arrayListEmpleado.size();i++){
               tEmpleados.insertRow(contadorTabla, new Object[]{});
               tEmpleados.setValueAt(arrayListEmpleado.get(i).getDNI(), contadorTabla, 0);
                tEmpleados.setValueAt(arrayListEmpleado.get(i).getNombre(), contadorTabla, 1);
                tEmpleados.setValueAt(arrayListEmpleado.get(i).getPuntos(), contadorTabla, 2);
                contadorTabla++;
               
           }
        }
        return tEmpleados;
    }
}
