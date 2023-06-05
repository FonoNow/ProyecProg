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
 * @author gonza
 */
public class Controlador_Ver_empleados {
    public Ver_empleados vistaempleados;
    public DefaultTableModel tEmpleados;
    public EmpleadoDAO em= new EmpleadoDAO();
    public ArrayList<Empleado> arrayListEmpleado= new ArrayList<Empleado>();
    public Empleado empleado = new Empleado();
    public Controlador_Ver_empleados(){
        vistaempleados= new Ver_empleados();
        this.arrayListEmpleado = em.seleccionar();
    }
    public DefaultTableModel tablaempleados(ArrayList<Empleado> arrayListEmpleado){
        int contadorTabla=0;
        String x[][]={};
        String nombresColumnas[]= {"Dni","Nombre","Direccion","Telefono"};
        tEmpleados = new DefaultTableModel(x,nombresColumnas);
        if(arrayListEmpleado != null){
           for(int i=0;i<arrayListEmpleado.size();i++){
               tEmpleados.insertRow(contadorTabla, new Object[]{});
               tEmpleados.setValueAt(arrayListEmpleado.get(i).getDNI(), contadorTabla, 0);
                tEmpleados.setValueAt(arrayListEmpleado.get(i).getNombre(), contadorTabla, 1);
                tEmpleados.setValueAt(arrayListEmpleado.get(i).getDireccion(), contadorTabla, 2);
                tEmpleados.setValueAt(arrayListEmpleado.get(i).getNroTelefono(), contadorTabla, 3);
                contadorTabla++;
               
           }
        }
        return tEmpleados;
    }
}
