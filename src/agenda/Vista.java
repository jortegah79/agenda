/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.util.*;
import java.io.*;

/**
 *
 * @author jorte
 */
public class Vista {

    private static final int MINOPCIONES = 0;
    private static final int MAXOPCIONES = 6;

    public void mostrarMenu() {
        mensaje("Este es el menú de tu agenda");
        mensaje("1.Crear nuevo contacto");
        mensaje("2.Mostrar la lista de contactos.");
        mensaje("3.Busqueda contacto por nombre");
        mensaje("4.Busca contacto por el telefono");
        mensaje("5.Modifica un contacto");
        mensaje("6.Borrar un contacto");
        mensaje("");
        mensaje("0.Salir");
    }

    public int introduceSeleccion() {
        Scanner teclado = new Scanner(System.in);
        int seleccion = -1;
        do {
            mensaje("Indicame tu selección");
            if (teclado.hasNextInt()) {
                seleccion = teclado.nextInt();
            } else {
                teclado.nextLine();
                mensaje("Por favor indica una opcion correcta.");
                mostrarMenu();
            }
        } while (seleccion < MINOPCIONES && seleccion > MAXOPCIONES);
        return seleccion;
    }
    //metodo que sirve para seleccionar el tipo de contacto que vamos a crear.

    public int seleccionTipoContacto() {
        Scanner teclado = new Scanner(System.in);
        int tipo = 0;
        boolean datoOk = false;
        while (!datoOk) {
            mensaje("Por favor, que tipo de contacto es?\n1.compañeros\n2.amigos\n3.familiares");
            datoOk = teclado.hasNextInt();
            tipo = teclado.nextInt();
            teclado.nextLine();
            if (tipo == 1 || tipo == 2 || tipo == 3) {
                datoOk = true;
            } else {
                datoOk = false;
            }
        }
        return tipo;
    }

    //**************************************************************************************************************************************************
    //Este es el metodo que nos permite entrar los datos de los nuevos contactos.    
    public Contacto nuevoContacto() {
        //solicitamos que tipo de contacto es
        int tipo = seleccionTipoContacto();
        //inicializammos todas las variables..
        boolean correcto = false;
        int telefono = 0;
        Contacto c = null;
        String nombre = "", email = "", facebook = "", twitter = "", direccion = "";
        Scanner teclado = new Scanner(System.in);
        //segun la seleccion que obtengamos antes, haremos más o menos entradas por teclado.
        if (tipo == 1 || tipo == 2 || tipo == 3) {
            mensaje("Escribe nombre de contacto");
            nombre = teclado.nextLine();
            mensaje("Escribe numero de telefono");
            while (!correcto) {
                if (teclado.hasNextInt()) {
                    telefono = teclado.nextInt();
                    correcto = true;
                } else {
                    teclado.nextLine();
                    mensaje("Error.No es un entero");
                }
            }
            teclado.nextLine();
            mensaje("Introduce el email");
            email = teclado.nextLine();
        }//hasta aqui seria un companero...si es de los otros 2 tipos , continuara
        if (tipo == 2 || tipo == 3) {
            mensaje("Escribe la cuenta de  facebook");
            facebook = teclado.nextLine();
            mensaje("Escribe la cuenta de twitter twitter");
            twitter = teclado.nextLine();
        }//hasta aqui serian los amigos.
        if (tipo == 3) {
            mensaje("Escribe la direccion");
            direccion = teclado.nextLine();
        }

        //finalmente, aqui habremos llegado si introducimos un familiar.
        //***Ahora crearemos los nuevos contactos, segun el tipo elegido.
        if (tipo == 1) {
            c = new companero(nombre, telefono, email);
        } else if (tipo == 2) {
            c = new amigos(nombre, telefono, email, facebook, twitter);

        } else {
            c = new familia(nombre, telefono, email, facebook, twitter, direccion);
        }
        mensaje("contacto introducido.\n");
        return c;
    }
//*******************************************************************************************************************************************************************************

    public void mensaje(String mensaje) {
        System.out.println(mensaje);

    }
    // Aqui hay un conflicto con los datos introducidos...

    public void mostrarContactos(Contacto[] lista) {

        String nombre, email, facebook, twitter, direccion;
        int telefono;
        System.out.println("Tu agenda dispone de los siguientes contactos\n");
        mensaje("contacto\tNombre\t\tTelefono\temail\n");
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                mensaje(lista[i].toString());
            }
            System.out.println("Fin\n\n");
        }
    }

    public String introduceNombre() {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        mensaje("Introduce el nombre que quieres buscar...");
        nombre = teclado.next();

        return nombre;
    }

    public int introduceTelefono() {
        boolean correcto = false;
        Scanner teclado = new Scanner(System.in);
        int telefono = 0;
        while (!correcto) {
            mensaje("Introduce el telefono que quieres buscar...");
            if (teclado.hasNextInt()) {
                telefono = teclado.nextInt();
                correcto = true;
            } else {
                mensaje("Recuerda!un numero de telefono solo tiene numeros");
            }
        }
        return telefono;
    }

    public void muestraContactoTelefono(Contacto c) {
        mensaje("Nombre\t\tTelefono\tEmail\n");
        System.out.println(c.getNombre() + "\t\t" + c.getTelefono() + "\t" + c.getEmail());
    }

    public void muestraContactoNombre(Contacto c) {
        mensaje("Nombre\t\tTelefono\tEmail\n");
        System.out.println(c.getNombre() + "\t" + c.getTelefono() + "\t" + c.getEmail());

    }

}
