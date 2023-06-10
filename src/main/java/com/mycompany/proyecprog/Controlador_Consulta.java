/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;


import datos.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Franco
 */
public class Controlador_Consulta implements ActionListener {
    public CursoDAO c1;
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
            e1.A=em.seleccionar_Cursos_Hechos(e1.getIdEmpleado());
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
            //if(e1.empleadoperma_consulta()){
                
            if(e1.getIdEmpleado()!=0){
                if(consu.empleadoperma_consulta.getText().equals("si")){
                    unCurso c = new unCurso();
                    CursoDAO c1 = new CursoDAO();
                    Calendar cal = Calendar.getInstance(); 
                    c=(unCurso) consu.seleccionar_curso.getSelectedItem();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date tiempoactual= cal.getTime();
                    String tempactual=sdf.format(tiempoactual);
                    cal.add(Calendar.MONTH,c.getMaxCantMeses() );  
                    Date updatedDate = cal.getTime();  
                      
                    String formattedDate = sdf.format(updatedDate);  
                    
                    
                    
                    if(e1.puedeRealizar(c)){
                        e1.setPuntos(1);
                        em.actualizarPuntos(e1);
                        c1.insertar_cur_reali(c,e1,tempactual,formattedDate);
                        JOptionPane.showMessageDialog(null,"El Curso a sido insertado con exito");
                    
                    }else{
                        JOptionPane.showMessageDialog(null,"No tiene los puntos suficientes para realizar el curso, debe realizar cursos anteriores o ya a realizado el curso");
                    }
                
            }else{
                  JOptionPane.showMessageDialog(null,"debe ser empleado permanente");

                }
                
            }else{
                JOptionPane.showMessageDialog(null,"Tiene que seleccionar un empleado primero");
            }
            }
    }
}
