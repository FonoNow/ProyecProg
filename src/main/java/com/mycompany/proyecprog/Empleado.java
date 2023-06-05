package com.mycompany.proyecprog;


public class Empleado {
    private int idEmpleado;
    private int DNI;
    private String Nombre;
    private  String Direccion;
    private  String NroTelefono;
    private  double SueldoBase;
    private  int Puntos;
    private boolean tipo_empleado;

    public Empleado() {
    }
    public Empleado(int DNI, String Nombre, String Direccion, String NroTelefono, double SueldoBase, int Puntos, boolean tipo_empleado) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.NroTelefono = NroTelefono;
        this.SueldoBase = SueldoBase;
        this.Puntos = Puntos;
        this.tipo_empleado = tipo_empleado;
    }
    

    public Empleado(int DNI, String Nombre, String Direccion, String NroTelefono, double SueldoBase, int Puntos) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.NroTelefono = NroTelefono;
        this.SueldoBase = SueldoBase;
        this.Puntos = Puntos;
    }
    public double importeBruto(){
        return 0;
    };
    //constructor para la clase EmpleadoDAO
    public Empleado(int idEmpleado, int DNI, String Nombre, String Direccion, String NroTelefono, double SueldoBase, int Puntos, boolean tipo_empleado) {
        this.idEmpleado = idEmpleado;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.NroTelefono = NroTelefono;
        this.SueldoBase = SueldoBase;
        this.Puntos = Puntos;
        this.tipo_empleado = tipo_empleado;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getNroTelefono() {
        return NroTelefono;
    }

    public void setNroTelefono(String NroTelefono) {
        this.NroTelefono = NroTelefono;
    }

    public double getSueldoBase() {
        return SueldoBase;
    }

    public void setSueldoBase(double SueldoBase) {
        this.SueldoBase = SueldoBase;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public boolean isTipo_empleado() {
        return tipo_empleado;
    }

    public void setTipo_empleado(boolean tipo_empleado) {
        this.tipo_empleado = tipo_empleado;
    }
    
    
}
