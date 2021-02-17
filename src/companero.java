/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;

/**
 *
 * @author jortegah79
 * 
 */
public class companero {

    private String nombre;
    private int telefono;
    private String email;
    private boolean borrado;
       public companero() {
        nombre = "";
        telefono = 0;
        email = "";
        borrado = false;
    }
    public companero(String nombre, int telefono, String email,boolean borrado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.borrado = borrado;
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

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }

    public companero[] leerDatos(DataInputStream dis) {
        int i = 0;
        companero[] lista = new companero[150];
        try {
            while (dis.available() > 0 && i < 150) {
                nombre = dis.readUTF();
                telefono = dis.readInt();
                email = dis.readUTF();
                borrado = dis.readBoolean();
               
                //Controlamos si esta borrado el contacto
                if (borrado != true) {
                    companero c = new companero(nombre, telefono, email, borrado);
                    lista[i] = c;
                    i++;
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return lista;
    }

    public static void escribeContacto(DataOutputStream dos, companero c) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase companero
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        try {

            dos.writeUTF(c.nombre);
            dos.writeInt(c.telefono);
            dos.writeUTF(c.email);
            dos.writeBoolean(c.borrado);

        } catch (IOException e) {
            e.getMessage();
        }
        Vista.mensaje("Contacto introducido");
    }
    
    public static void escribeContacto(DataOutputStream dos, companero[] lista) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase companero
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        try {
            for (int i = 0; i < lista.length; i++) {

                if (lista[i] != null) {
                    if (lista[i].isBorrado() == false) {
                        
                        dos.writeUTF(lista[i].getNombre());
                        dos.writeInt(lista[i].getTelefono());
                        dos.writeUTF(lista[i].getEmail());
                        dos.writeBoolean(lista[i].isBorrado());
                      
                    }
                }
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
