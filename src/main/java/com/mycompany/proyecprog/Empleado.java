/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

/**
 *
 * @author PC
 */
public abstract class Empleado {
    private int DNI;
    private String Nombre;
    private  String Direccion;
    private  int NroTelefono;
    private  double SueldoBase;
    private  int Puntos;

    public Empleado(int DNI, String Nombre, String Direccion, int NroTelefono, double SueldoBase, int Puntos) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.NroTelefono = NroTelefono;
        this.SueldoBase = SueldoBase;
        this.Puntos = Puntos;
    }
    public abstract double importeBruto();
    
    
}
