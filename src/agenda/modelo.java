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
        //cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase Contacto
        //que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
        try {
            oos.writeObject(c);
        } catch (IOException e) {
            e.getMessage();
        }

        v.mensaje("Contacto introducido");
    }

    public Contacto[] leerDatos(ObjectInputStream ois) {
        //declaramos algunas variables. 
        String [][]lista=new String[150][9];
        int i = 0;
//        Contacto[] lista = new Contacto[150];
        Contacto c;

        try {
            while (ois.available() > 0 && i < 150) {
                //mientras haya datos por leer, leeremos objetos casteados de tipo contactos    
                c = (Contacto) ois.readObject();
               lista[i][0]=c.getId()+"";
               lista[i][1]=c.getTipoContacto();
               lista[i][2]=c.getNombre();
               lista[i][3]=c.getTelefono()+"";
               lista[i][4]=c.getEmail();
               lista[i][5]=c.
               
               
                i++;
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return lista;
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

    public void escribeContacto(MiObjectOutputStream oos, Contacto c) {
//        cogemos el flujo de datos que viene de la clase agenda y el objeto de la clase companero
//        que hemos creado en la clase vista y enviamos los datos al archivo incluido un boolean para indicar si esta o no borrado.
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
//    }

    }
}
