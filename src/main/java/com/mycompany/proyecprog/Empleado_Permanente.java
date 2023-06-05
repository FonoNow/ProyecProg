/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Empleado_Permanente extends Empleado {
    private int IDPermanente;
    private double Incentivo;
    public ArrayList<unCurso> cursos = new ArrayList<>();
    public double importeBruto(){
       
        return 0;
    }

    public void setIDPermanente(int IDPermanente) {
        this.IDPermanente = IDPermanente;
    }

    public void setIncentivo(double Incentivo) {
        this.Incentivo = Incentivo;
    }

    public int getIDPermanente() {
        return IDPermanente;
    }

    public double getIncentivo() {
        return Incentivo;
    }

    public Empleado_Permanente(int IDPermanente, double Incentivo,int DNI,String NOMBRE,String Direccion, String NroTelefono, double SueldoBase, int Puntos) {
        super(DNI,NOMBRE,Direccion,NroTelefono,SueldoBase,Puntos);
        this.IDPermanente = IDPermanente;
        this.Incentivo = Incentivo;
        
        
    }
    public boolean puedeRealizar(unCurso curso){
        return true;
    }
    public int maximoPuntaje(){
        return 0;
        
    }
    public void agregarCurso(unCurso curso){
        
    }
    
}
