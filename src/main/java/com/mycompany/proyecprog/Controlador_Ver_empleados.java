/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import datos.EmpleadoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gonza
 */
public class Controlador_Ver_empleados implements ActionListener{
    public Ver_empleados vistaempleados;
    public DefaultTableModel tEmpleados;
    public EmpleadoDAO em= new EmpleadoDAO();
    public ArrayList<Empleado> arrayListEmpleado= new ArrayList<Empleado>();
    public Empleado empleado = new Empleado();
    public Controlador_Ver_empleados(){
        vistaempleados= new Ver_empleados();
        this.arrayListEmpleado = em.seleccionar();
        vistaempleados.modificar.addActionListener(this);
        vistaempleados.actualizar.addActionListener(this);
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==vistaempleados.modificar){
        try{
        
            int dni=(int) vistaempleados.tabla_empleados.getModel().getValueAt(vistaempleados.tabla_empleados.getSelectedRow(), 0);
            System.out.println(dni);
            //int DNI=Integer.parseInt(JOptionPane.showInputDialog("Ingrese DNI o deje vacio si no desea cambiarlo"));
            String Nombre= JOptionPane.showInputDialog("Ingrese nuevo nombre o deje vacio si no quiere modificar");
            String Direccion=JOptionPane.showInputDialog("Ingrese direccion o deje vacio si no quiere modificar");
            String Telefono=JOptionPane.showInputDialog("Ingrese telefono o deje vacio si no desea modificar");
            String bol=JOptionPane.showInputDialog("Ingrese 1 si desea que el empleado sea permanente o 0 para no permanente, o deje vacio si no desea cambiarlo");
            boolean bole;
            if(bol=="1"){
                bole=true;
            }else{
                bole=false;
            }
            System.out.println("Cambios: /n Dni: "+dni+"/nNombre: "+Nombre+"/nDireccion: "+Direccion+"/nTelefono: "+Telefono);
            Empleado e1;
            EmpleadoDAO em=new EmpleadoDAO();
            
            e1=em.seleccionarDNI(dni);
            System.out.println(e1.getNombre()+" "+e1.getDireccion());
            if(!"".equals(Nombre)){
                e1.setNombre(Nombre);
                
            }
            if(!"".equals(Direccion)){
                e1.setDireccion(Direccion);
                
            }
            if(!"".equals(Telefono)){
                e1.setNroTelefono(Telefono);
            }
            if(!"".equals(bol)){
                e1.setTipo_empleado(bole);
            }
            em.actualizar(e1);
        }
    catch(ArrayIndexOutOfBoundsException a){
        JOptionPane.showMessageDialog(null,"No se a seleccionado ningun empleado");
    }catch(NumberFormatException a){
        JOptionPane.showMessageDialog(null, "Solo se permiten numeros para los campos de DNI y telefono");
    }
    
}
        if(e.getSource()==vistaempleados.actualizar){
            arrayListEmpleado=em.seleccionar();
            vistaempleados.tabla_empleados.setModel(tablaempleados(arrayListEmpleado));
        }
    }
}

    
    

