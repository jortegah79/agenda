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

    Vista v = new Vista();

    public void escribeContacto(ObjectOutputStream oos, Contacto c) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase Contacto
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        try {
            oos.writeObject(c);
        } catch (IOException e) {
            e.getMessage();
        }
        
        v.mensaje("Contacto introducido");
    }

    public void escribeContacto(MiObjectOutputStream oos, Contacto c) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase companero
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
//        try {
//
//            dos.writeUTF(c.nombre);
//            dos.writeInt(c.telefono);
//            dos.writeUTF(c.email);
//            dos.writeBoolean(c.borrado);
//
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        Vista.mensaje("Contacto introducido");
    }

    public void escribeContacto(ObjectOutputStream oos, Contacto[] lista) {
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase companero
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
//        try {
//            for (int i = 0; i < lista.length; i++) {
//
//                if (lista[i] != null) {
//                    if (lista[i].isBorrado() == false) {
//                        
//                        dos.writeUTF(lista[i].getNombre());
//                        dos.writeInt(lista[i].getTelefono());
//                        dos.writeUTF(lista[i].getEmail());
//                        dos.writeBoolean(lista[i].isBorrado());
//                      
//                    }
//                }
//            }
//        } catch (IOException e) {
//            e.getMessage();
//        }
    }

    public Contacto[] leerDatos(ObjectInputStream ois) {
//        int i = 0;
//        Contacto[] lista = new Contacto[150];
//        try {
//            while (ois.available() > 0 && i < 150) {
//                nombre = dis.readUTF();
//                telefono = dis.readInt();
//                email = dis.readUTF();
//                borrado = dis.readBoolean();
//               
//                //Controlamos si esta borrado el contacto
//                if (borrado != true) {
//                    companero c = new companero(nombre, telefono, email, borrado);
//                    lista[i] = c;
//                    i++;
//                }
//            }
//        } catch (IOException e) {
//            e.getMessage();
//        }
        return null;//lista;
    }

}
