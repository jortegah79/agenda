/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.*;

/**
 *
 * @author jorte
 */
public class Contacto implements Serializable {

    private String nombre;
    private String apellido;
    private int telefono;
    private String email;
    private int id;
    private static int idSiguiente;
    private boolean borrado;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, int telefono, String email) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        borrado = false;
        id = idSiguiente;
        idSiguiente++;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public boolean isBorrado() {
        return borrado;
    }

}

class companero extends Contacto implements Serializable {

    public companero(String nombre, String apellido, int telefono, String email) {

        super(nombre, apellido, telefono, email);

    }

    public String toString() {
        String texto = String.format("%5i %15s %15s %15i %20s ", getId(), getNombre(), getApellido(), getTelefono(), getEmail());
        return texto;
    }
}

class amigos extends companero implements Serializable {

    private String facebook;
    private String twitter;

    public amigos(String nombre, String apellido, int telefono, String email, String facebook, String twitter) {

        super(nombre, apellido, telefono, email);

        this.facebook = facebook;
        this.twitter = twitter;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String toString() {
        String texto = String.format("%5i %15s %15s %15i %20s %15s %15s", getId(), getNombre(), getApellido(), getTelefono(), getEmail(), getTwitter(), getFacebook());
        return texto;
    }
}

class familia extends amigos implements Serializable {

    private String direccion;

    public familia(String nombre,String apellido,int telefono, String email, String facebook, String twitter, String direccion) {

        super(nombre, apellido, telefono, email, facebook, twitter);

        this.direccion = direccion;

    }

    public String toString() {
        String texto = String.format("%5i %15s %15s %15i %20s %15s %15s %20s", getId(), getNombre(), getApellido(), getTelefono(), getEmail(), getTwitter(), getFacebook(), getDireccion());
        return texto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
