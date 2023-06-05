package com.mycompany.proyecprog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Controlador_Consulta implements ActionListener {
    public Consulta consu;
    public Controlador_Consulta(){
        consu = new Consulta();
        consu.boton_consultar.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
