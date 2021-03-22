/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan O. @Darth_johny
 */
public class Agenda {

    /**
     * @param args the command line arguments
     */
    //nuestro array de datos;
    Contacto[] agendaContactos = new Contacto[150];

    public static void main(String[] args) {
        Agenda a = new Agenda();
        a.menuInicio();
    }

    public void menuInicio() {
        modelo m = new modelo();
        File f = new File("d:/agenda.dat");
        if (f.exists()) {
            try {
                FileInputStream fis = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fis);
                agendaContactos = m.leerArchivo(ois);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Vista v = new Vista();
        int opcion = -1;
        for (int i = 0; i < agendaContactos.length; i++) {
            System.out.println(agendaContactos.toString());
        }

        //este es nuestro punto de inicio
        do {
            //mostramos el menú, hacemos una selección y vamos hasta el método indicado
            //para cumplir con la selección del usuario
            v.mostrarMenu();
            opcion = v.introduceSeleccion();
            menuSeleccion(opcion);
        } while (opcion != 0);
    }

    public void menuSeleccion(int opcion) {
        Vista v = new Vista();
        switch (opcion) {
            case 0:
                System.out.println("Fin del programa");
                break;
            case 1:
                seleccionNuevoContacto();
                break;
            case 2:
                seleccionMostrarContactos();
                break;
            case 3:
                seleccionBuscarPorNombreApellido();
                break;
            case 4:
                seleccionBuscarPorTelefono();
                break;
            case 5:
                seleccionModificaContacto();
                break;
            case 6:
                seleccionBorrarContacto();
                break;
            default:
                v.mensaje("Error...");
        }

    }

    public void seleccionNuevoContacto() {
        Vista v = new Vista();
        modelo m = new modelo();
        Contacto c = v.nuevoContacto();

        //desde la clase vista hacemos una introduccion de datos para cada contacto nuevo
        try {
            File f = new File("d:/agenda.dat");
            FileOutputStream fos;
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                MiObjectOutputStream moos = new MiObjectOutputStream(fos);
                m.escribeArchivo(moos, agendaContactos);
                moos.close();
                fos.close();
            } else {
                fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                m.escribeArchivo(oos, agendaContactos);
                oos.close();
                fos.close();
            }

//            creamos un flujo de datos binario para enviarselo al metodo que hay en la clase companero
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void seleccionMostrarContactos() {

    }

    public void seleccionBuscarPorNombreApellido() {

    }

    public void seleccionBuscarPorTelefono() {

    }

    public void seleccionModificaContacto() {

    }

    public void seleccionBorrarContacto() {

    }

}
