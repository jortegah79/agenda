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
    private String tipoContacto;
    private String facebook;
    private String twitter;
    private String direccion;
    
    
    public Contacto(){
        
    }          

    public Contacto(String nombre, int telefono, String email) {
        
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        facebook = "";
        twitter = "";
        direccion = "";
        tipoContacto = "companero";
        id = idSiguiente;
        idSiguiente++;
    }
     public Contacto(String nombre, int telefono, String email, String facebook, String twitter) {
        
          
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.facebook = facebook;
        this.twitter = twitter;
        direccion = "";
        tipoContacto = "amigos";
        id = idSiguiente;
        idSiguiente++;
    }
     public Contacto(String nombre, int telefono, String email, String facebook, String twitter, String direccion) {
        
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.facebook = facebook;
        this.twitter = twitter;
        this.direccion = direccion;
        tipoContacto = "familia";
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
    
    public void setTipoContacto(String tipoContacto){
        this.tipoContacto=tipoContacto;
    }
    public String getTipoContacto(){
        return tipoContacto;
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
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String toString(){
        return ("Id: "+ getId() + "\t\t" + tipoContacto+"\t\t "+ nombre + "\t\t "+ telefono +"\t\t "+ email+"\t "+facebook +" \t"+twitter +"\t"+ direccion);
    }
}
