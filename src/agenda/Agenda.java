/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.*;
import java.util.*;

/**
 *
 * @author jorte
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
       Vista v = new Vista();
    public static void main(String[] args) {
        Vista v = new Vista();
        Scanner teclado = new Scanner(System.in);
        Agenda a = new Agenda();
        int opcion = -1;
        //este es nuestro punto de inicio
        do {
            //mostramos el menú, hacemos una selección y vamos hasta el método indicado
            //para cumplir con la selección del usuario
            v.mostrarMenu();
            opcion = v.introduceSeleccion();
            a.menuSeleccion(opcion);

        } while (opcion != 0);
       
    }

    public  void menuSeleccion(int opcion) {
        switch (opcion) {
            case 0:
                break;
            case 1:
                //Este nos envia a crear un nuevo contacto.
                nuevoContacto();
                break;
            case 2:
                //Aqui hacemos una llamada a un método que nos devuelve un listado
                //de los contactos.
                Contacto[] lista = mostrarContactos();
                //una vez tenemos el listado, lo enviamos a la vista para listarlos por pantalla.
                v.mostrarContactos(lista);
                break;
            case 3:
                //mediante un método, buscamos un contacto mediante el nombre y lo mostramos mediante la vista.
//                Contacto c = busquedaNombre(mostrarContactos());
//                v.muestraContactoNombre(c);
                break;
            case 4:
                //mediante un método, buscamos un contacto  mediante el acceso directo  y lo mostramos mediante la vista.
//                c = busquedaNumero(mostrarContactos());
//                v.muestraContactoNombre(c);

                break;
            case 5:
                //modificamos el contacto mediante el método determinado.
//                modificaContacto(mostrarContactos());
                break;
            case 6:
                //eliminamos el contacto mediante un metodo determinado.
//                borraContacto(mostrarContactos());
                break;
            default:
                v.mensaje("Error...");
        }

    }

    public  void nuevoContacto() {
        modelo m=new modelo(); 
        Contacto c = v.nuevoContacto();
        //desde la clase vista hacemos una introduccion de datos para cada contacto nuevo
        try {
            File f= new File("d:/agenda.dat");
            FileOutputStream fos = new FileOutputStream(f, true);
//            if(f.exists()){
//                MiObjectOutputStream moos=new MiObjectOutputStream(fos);
//                 modelo.escribeContacto(moos, c);
//            }else{
            ObjectOutputStream oos = new ObjectOutputStream(fos);
             m.escribeContacto(oos, c);
//            }           
            //creamos un flujo de datos binario para enviarselo al metodo que hay en la clase companero
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public  Contacto [] mostrarContactos() {
        modelo m=new modelo();
        Contacto c=new Contacto();

        try {
            FileInputStream fis = new FileInputStream("d:/agenda.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            //creamos un flujo de datos para mostrar los contactos de nuestro archivo y se lo mandamos a la clase companero
            Contacto[] lista =m.leerDatos(ois);
            return lista;
        } catch (IOException e) {
            e.printStackTrace();
        }
        Contacto[] lista = new Contacto[150];
        return lista;
    }

    public  Contacto busquedaNombre(companero[] lista) {
        //obtenemos por parametro una lista  de la cual extraemos el contacto que coincide con en el nombre que obtenemos
        //desde la clase vista.
 Contacto c=null;
        int indice = 0;
//        companero c = new companero();
//        String nombre = Vista.introduceNombre();
//        for (int i = 0; i < lista.length; i++) {
//            if (lista[i] != null) {
//                if (lista[i].getNombre().equalsIgnoreCase(nombre)) {
//                    indice = i;
//                }
//            }
//        }
//        c = lista[indice];
        return c;
    }

    public  Contacto busquedaNumero(Contacto[] lista) {
Contacto c=null;
//        
//companero c = new companero();
//        int indice = 0;
//        int telefono = Vista.introduceTelefono();
//        for (int i = 0; i < lista.length; i++) {
//            if (lista[i] != null) {
//                if (lista[i].getTelefono() == telefono) {
//                    indice = i;
//                }
//            }
//        }
//        c = lista[indice];
        return c;
    }

    public  void modificaContacto(companero[] lista) {
//        //primer paso obtener listado
//
//        companero[] listado = lista;
//
//        //segundo paso obtener contacto a modificar y su posicion en el array
//        companero c = busquedaNombre(mostrarContactos());
//        int indice = 0;
//        for (int i = 0; i < listado.length; i++) {
//            if (listado[i] != null) {
//                if (listado[i].getNombre().equalsIgnoreCase(c.getNombre())) {
//                    indice = i;
//                }
//            }
//        }
//        
//
//        //tercer paso modificar el contacto obtenido y escribirlo en el array
//        companero d = Vista.nuevoContacto();
//        listado[indice].setNombre(d.getNombre());
//        listado[indice].setTelefono(d.getTelefono());
//        listado[indice].setEmail(d.getEmail());
//        listado[indice].setBorrado(d.isBorrado());
//
//        //cuarto paso enviar listado a la clase companero para exportarlo al archivo..
//        try {
//            FileOutputStream fos = new FileOutputStream("d:/agenda.dat");
//            DataOutputStream dos = new DataOutputStream(fos);
//
//            companero.escribeContacto(dos, listado);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//
//    }
//
//    public  void borraContacto(companero[] lista) {
//       //primer paso obtener listado
//
//        companero[] listado = lista;
//
//        //segundo paso obtener contacto a eliminar y su posicion en el array
//       
//        companero c = busquedaNombre(mostrarContactos());
//        int indice = 0;
//        for (int i = 0; i < listado.length; i++) {
//            if (listado[i] != null) {
//                if (listado[i].getNombre().equalsIgnoreCase(c.getNombre())) {
//                    indice = i;
//                }
//            }
//        }
//
//
//        //tercer paso modificar el contacto obtenido y escribirlo en el array
//       
//        listado[indice].setBorrado(true);
//
//        //cuarto paso enviar listado a la clase companero para exportarlo al archivo..
//        try {
//            FileOutputStream fos = new FileOutputStream("d:/agenda.dat");
//            DataOutputStream dos = new DataOutputStream(fos);
//
//            companero.escribeContacto(dos, listado);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//
    }

}
