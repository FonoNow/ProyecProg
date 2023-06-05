/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author PC
 */
public class Controlador_Menu implements ActionListener{
   public Menu menu;
   public Controlador_Nuevo contnuevo;
   public Controlador_Consulta contconsu;
   public Controlador_Ver_empleados contveremple;

    public Controlador_Menu() {
        this.menu = new Menu();
        menu.boton_nuevoempleado.addActionListener(this);
        menu.boton_listaempleados.addActionListener(this);
        contnuevo= new Controlador_Nuevo();
        contconsu= new Controlador_Consulta();
        contveremple= new Controlador_Ver_empleados();
        menu.Consultar.addActionListener(this);
    }
   public void Menuvisible(){
       menu.setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==menu.boton_nuevoempleado){
            contnuevo.nuevo.setVisible(true);
            
            
        }
        if(e.getSource()==menu.Consultar){
            contconsu.consu.setVisible(true);
        }
        if(e.getSource()==menu.boton_listaempleados){
            contveremple.vistaempleados.setVisible(true);
            contveremple.vistaempleados.tabla_empleados.setModel(contveremple.tablaempleados(contveremple.arrayListEmpleado));
        }
    }
}
