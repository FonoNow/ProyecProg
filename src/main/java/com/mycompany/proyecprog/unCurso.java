/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecprog;

/**
 *
 * @author PC
 */
public class unCurso {
   private int IDCodigo;
   private String Titulo;
   private int Puntos;
   private int CargaHoraria;
   private String FechaInicio;
   private String FechaFin;
   private int MaxCantMeses;

    public unCurso(int IDCodigo, String Titulo, int Puntos, int CargaHoraria, String FechaInicio, String FechaFin ,int MaxCantMeses) {
        this.IDCodigo = IDCodigo;
        this.Titulo = Titulo;
        this.Puntos = Puntos;
        this.CargaHoraria = CargaHoraria;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
        this.MaxCantMeses = MaxCantMeses;
        
    }

    public unCurso(String Titulo, String FechaInicio, String FechaFin) {
        this.Titulo = Titulo;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }
    
    
    
    public unCurso(int IDCodigo, String Titulo, int Puntos, int CargaHoraria ,int MaxCantMeses) {
        this.IDCodigo = IDCodigo;
        this.Titulo = Titulo;
        this.Puntos = Puntos;
        this.CargaHoraria = CargaHoraria;
        this.MaxCantMeses = MaxCantMeses;
        
    }

    public unCurso(String Titulo, int Puntos, int CargaHoraria, int MaxCantMeses) {
        this.Titulo = Titulo;
        this.Puntos = Puntos;
        this.CargaHoraria = CargaHoraria;
        this.MaxCantMeses = MaxCantMeses;
    }

    unCurso() {
        
    }
   
   
   
   
   
   
   
   
   
   

    public int getIDCodigo() {
        return IDCodigo;
    }

    public void setIDCodigo(int IDCodigo) {
        this.IDCodigo = IDCodigo;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getCargaHoraria() {
        return CargaHoraria;
    }

    public void setCargaHoraria(int CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    public String getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(String FechaFin) {
        this.FechaFin = FechaFin;
    }

    public int getMaxCantMeses() {
        return MaxCantMeses;
    }

    public void setMaxCantMeses(int MaxCantMeses) {
        this.MaxCantMeses = MaxCantMeses;
    }
   
   
   
   
   
   public String realizacionPrevia(){
       return "";
   }
}
