/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import datos.EmpleadoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Franco
 */
public class Controlador_Consulta implements ActionListener {
    public Consulta consu;
    EmpleadoDAO em = new EmpleadoDAO();
            Empleado e1 = new Empleado();
    public Controlador_Consulta(){
        consu = new Consulta();
        consu.boton_consultar.addActionListener(this);
        consu.boton_cursos.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==consu.boton_consultar) {
            System.out.println("boton consulta");
            
            int dnii=Integer.parseInt(consu.consulta_dni.getText());
            e1=em.seleccionarDNI(dnii);
            
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
            
        }
    }
}
