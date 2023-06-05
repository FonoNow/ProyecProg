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
    public Controlador_Consulta(){
        consu = new Consulta();
        consu.boton_consultar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==consu.boton_consultar) {
            EmpleadoDAO em = new EmpleadoDAO();
            em.seleccionar();
        }
    }
}
