/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class Controlador_Nuevo implements ActionListener{
    public Nuevo nuevo;
    public Controlador_Nuevo(){
        nuevo=new Nuevo();
        nuevo.boton_crear.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==nuevo.boton_crear){
            
            try{
                String insertar;
            int DNI=Integer.parseInt(nuevo.nuevoDNI.getText());
            String Nombre= nuevo.nuevoNombre.getText();
            String Direccion= nuevo.nuevoDireccion.getText();
            double Telefono=Double.parseDouble(nuevo.nuevoTelefono.getText());
            if(nuevo.checkPermanente.isEnabled()){
                if(DNI>0){
                insertar="INSERT INTO empleado(DNI,Nombre,Direccion,NroTelefono,SueldoBase,Puntos) VALUES("+DNI+","+Nombre+","+Direccion+","+Telefono+",50000,0";
                JOptionPane.showMessageDialog(null,"Empleado creado con exito");
                nuevo.setVisible(false);
            }else{
                    JOptionPane.showMessageDialog(null,"Dni tiene que ser mayor a 0");
              //crear exception de cuando el dni es menor a 0
            }
            }
        }catch(NumberFormatException a){
          JOptionPane.showMessageDialog(null,"Solo se aceptan numeros para los campos DNI y Telefono");  
        }
        }
    }
    
}
