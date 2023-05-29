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
public class Controlador implements ActionListener{
   public Menu menu;
   public Nuevo nuevo;

    public Controlador() {
        this.menu = new Menu();
        this.nuevo = new Nuevo();
        menu.boton_nuevoempleado.addActionListener(this);
    }
   public void Menuvisible(){
       menu.setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==menu.boton_nuevoempleado){
            nuevo.setVisible(true);
            
            
        }
    }
}
