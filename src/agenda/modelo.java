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
class modelo {

    public void escribeArchivo(ObjectOutputStream oos, Contacto[] agenda) {
        Vista v = new Vista();
        try (oos) {
            oos.writeObject(agenda);
            oos.close();
        } catch (IOException e) {
            e.getMessage();
        }

        v.mensaje("Agenda Guardada.");
    }

    public void escribeArchivo(MiObjectOutputStream oos, Contacto[] agenda) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase Contacto2
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        Vista v = new Vista();
        try (oos) {
            oos.writeObject(agenda);
            oos.close();
        } catch (IOException e) {
            e.getMessage();
        }
        v.mensaje("Contacto introducido");
    }

    public Contacto[] leerArchivo(ObjectInputStream ois) {
        //declaramos algunas variables. 
        Contacto[] agenda = new Contacto[150];
        try (ois) {
            while (ois.available() > 0) {
                agenda = (Contacto[]) ois.readObject();
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return agenda;
    }
}
