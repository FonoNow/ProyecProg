/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import datos.CursoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class Controlador_Menu implements ActionListener{
   public Menu menu;
   public Controlador_Nuevo contnuevo;
   public Controlador_Consulta contconsu;
   public Controlador_Ver_empleados contveremple;
   public Controlador_ver_maxPuntos contverpuntos;
   public CursoDAO cur= new CursoDAO();
   public ArrayList<unCurso> cursos= new ArrayList<unCurso>();

    public Controlador_Menu() {
        this.menu = new Menu();
        menu.boton_nuevoempleado.addActionListener(this);
        menu.boton_listaempleados.addActionListener(this);
        menu.crear_curso.addActionListener(this);
        contnuevo= new Controlador_Nuevo();
        contconsu= new Controlador_Consulta();
        contverpuntos=new Controlador_ver_maxPuntos();
        contveremple= new Controlador_Ver_empleados();
        menu.Consultar.addActionListener(this);
        menu.maxPuntos.addActionListener(this);
    }
   public void Menuvisible(){
       menu.setVisible(true);
   }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() ==menu.boton_nuevoempleado){
            contnuevo.nuevo.nuevoDNI.setText("");
            contnuevo.nuevo.nuevoTelefono.setText("0");
            contnuevo.nuevo.nuevoNombre.setText("");
            contnuevo.nuevo.nuevoDireccion.setText("");
            contnuevo.nuevo.checkPermanente.setSelected(false);
            contnuevo.nuevo.setVisible(true);


        }
        if(e.getSource()==menu.Consultar){
            contconsu.consu.nombre_consulta.setText("");
            contconsu.consu.consulta_dni.setText("");
            contconsu.consu.direccion_consulta.setText("");
            contconsu.consu.telefono_consulta.setText("");
            contconsu.consu.empleadoperma_consulta.setText("");
            contconsu.consu.seleccionar_curso.removeAllItems();
            contconsu.consu.setVisible(true);
            cursos=cur.seleccionarCurso();
            for(int i=0;i<cursos.size();i++){
            contconsu.consu.seleccionar_curso.addItem(cursos.get(i));
        }
        }
        if(e.getSource()==menu.boton_listaempleados){
            contveremple.vistaempleados.setVisible(true);
            contveremple.vistaempleados.tabla_empleados.setModel(contveremple.tablaempleados(contveremple.arrayListEmpleado));
        }
        if(e.getSource() ==menu.crear_curso){
             CursoDAO cur=new CursoDAO();
             
            String titulo=JOptionPane.showInputDialog("Ingrese titulo del curso");
            int cargahoraria=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cargar horaria"));
            int tiempolimite=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de meses que tiene para hacer el curso consecutivo"));
            int puntos=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de puntos requeridos para realizar el curso"));
            unCurso c1=new unCurso(titulo,puntos,cargahoraria,tiempolimite);
            cur.insertarCurso(c1);
        }
        if(e.getSource()==menu.maxPuntos){
            contverpuntos.ver_puntos.setVisible(true);
            contverpuntos.ver_puntos.jTable1.setModel(contverpuntos.tablapuntos(contverpuntos.arrayListEmpleado));
        }
    }
}
