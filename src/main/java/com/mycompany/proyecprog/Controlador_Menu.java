package com.mycompany.proyecprog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador_Menu implements ActionListener{
   public Menu menu;
   public Controlador_Nuevo contnuevo;
   public Controlador_Consulta contconsu;

    public Controlador_Menu() {
        this.menu = new Menu();
        menu.boton_nuevoempleado.addActionListener(this);
        contnuevo= new Controlador_Nuevo();
        contconsu= new Controlador_Consulta();
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
    }
}
