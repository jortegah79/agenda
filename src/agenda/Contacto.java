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
    private int telefono;
    private String email;
    private int id;
    private static int idSiguiente;
    private boolean borrado;

    public Contacto() {
    }

    public Contacto(String nombre, int telefono, String email) {

        this.nombre = nombre;
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

    public companero(String nombre, int telefono, String email) {

        super(nombre, telefono, email);

    }

    public String toString() {
        return ("Id: " + getId() + "\t\t" + this.getNombre() + "\t\t " + this.getTelefono() + "\t\t " + this.getEmail());
    }
}

class amigos extends companero implements Serializable {

    private String facebook;
    private String twitter;
    private boolean borrado;

    public amigos(String nombre, int telefono, String email, String facebook, String twitter) {

        super(nombre, telefono, email);

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
        return ("Id: " + getId() + "\t\t" + getNombre() + "\t\t " + getTelefono() + "\t\t " + getEmail() + "\t " + facebook + " \t" + twitter);
    }
}

class familia extends amigos implements Serializable {

    private String facebook;
    private String twitter;
    private String direccion;
    private boolean borrado;

    public familia(String nombre, int telefono, String email, String facebook, String twitter, String direccion) {

        super(nombre, telefono, email, facebook, twitter);

        this.facebook = facebook;
        this.direccion = direccion;
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
        return ("Id: " + getId() + "\t\t " + getNombre() + "\t\t " + getTelefono() + "\t\t " + getEmail() + "\t " + facebook + " \t" + twitter + "\t" + direccion);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
