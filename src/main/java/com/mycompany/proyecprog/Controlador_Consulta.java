/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import datos.EmpleadoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class Controlador_Consulta implements ActionListener {
    public Consulta consu;
    public Controlador_ver_cursos contcur;
    EmpleadoDAO em = new EmpleadoDAO();
    Empleado e1 = new Empleado();
    public Controlador_Consulta(){
        consu = new Consulta();
        contcur= new Controlador_ver_cursos();
        consu.boton_consultar.addActionListener(this);
        consu.boton_cursos.addActionListener(this);
        consu.agregar_curso.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==consu.boton_consultar) {
            System.out.println("boton consulta");
            
            int dnii=Integer.parseInt(consu.consulta_dni.getText());
            e1=em.seleccionarDNI(dnii);
            //if(e1.)
            consu.nombre_consulta.setText(e1.getNombre());
            consu.telefono_consulta.setText(e1.getNroTelefono());
            consu.direccion_consulta.setText(e1.getDireccion());
            if (e1.isTipo_empleado()) {
                consu.empleadoperma_consulta.setText("si");
            }else{
                consu.empleadoperma_consulta.setText("no");
            }
        }
        if(e.getSource() ==consu.boton_cursos){
            if(e1.getIdEmpleado()!= 0){
            contcur.arrayListCurso= em.seleccionar_Cursos_Hechos(e1.getIdEmpleado());
            contcur.vistacursos.setVisible(true);
            contcur.vistacursos.cursos.setModel(contcur.tablacursos(contcur.arrayListCurso));
            }else{
                JOptionPane.showMessageDialog(null, "Tiene que seleccionar un empleado primero");
            }
            /* System.out.println(e1.getIdEmpleado());
            
            System.out.println(e1.getIdEmpleado());
            int cur=em.obtenerCurso(e1.getIdEmpleado());
            System.out.println(em.obtenerCurso(e1.getIdEmpleado()));
            JOptionPane.showMessageDialog(null,"La cantidad de cursos realizados por: "+e1.getNombre()+ " es "+cur);
            }else{
                
            }*/
        }
        
        if(e.getSource()==consu.agregar_curso){
            if(e1.getIdEmpleado()!=0){
                
                JOptionPane.showMessageDialog(null,"No implementado");
                //consu.seleccionar_curso.getSelectedItem()
                // falta consulta de mysql para insertar cursos realizados
            }else{
                JOptionPane.showMessageDialog(null,"Tiene que seleccionar un empleado primero");
            }
        }
    }
}
