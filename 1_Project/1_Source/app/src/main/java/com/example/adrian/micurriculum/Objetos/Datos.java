package com.example.adrian.micurriculum.Objetos;

/**
 * Created by Adrian on 22/04/2015.
 */
public class Datos {

    private String Nombre;
    private String Direccion;
    private String DNI;
    private String FechaDeNacimiento;
    private String Telefono;
    private String CorreoElectronico;
    private String CarnetConducir;

    public Datos(String nombre, String carnetConducir, String correoElectronico, String telefono, String fechaDeNacimiento, String DNI, String direccion) {
        Nombre = nombre;
        CarnetConducir = carnetConducir;
        CorreoElectronico = correoElectronico;
        Telefono = telefono;
        FechaDeNacimiento = fechaDeNacimiento;
        this.DNI = DNI;
        Direccion = direccion;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public String getDNI() {
        return DNI;
    }

    public String getFechaDeNacimiento() {
        return FechaDeNacimiento;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    public String getCarnetConducir() {
        return CarnetConducir;
    }
}
