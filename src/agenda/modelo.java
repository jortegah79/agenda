/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorte
 */
class modelo {

    Vista v = new Vista();

    public void escribeContacto(ObjectOutputStream oos, Contacto c) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase Contacto2
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        
        try (oos) {
            oos.writeObject(c);
            oos.close();
        } catch (IOException e) {
            e.getMessage();
        }

        v.mensaje("Contacto introducido");
    }

    public void escribeContacto(MiObjectOutputStream oos, Contacto c) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase Contacto2
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        v.mensaje(c.toString());
        try (oos) {
            oos.writeObject(c);
            oos.close();
        } catch (IOException e) {
            e.getMessage();
        }
        v.mensaje("Contacto introducido");
    }

    public void leerDatos(ObjectInputStream ois) {
        //declaramos algunas variables. 
        Contacto[] lista = new Contacto[150];
        int j = 0;
        Contacto c;

        try (ois) {
            while (ois.available() > 0 && j < 150) {
                //mientras haya datos por leer, leeremos objetos casteados de tipo contactos    
                c = (Contacto) ois.readObject();
                lista[j] = c;
                j++;
        System.out.println(c.getNombre());
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
       for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i].toString());
                      
        }
    }

}
