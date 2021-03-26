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
        mensaje("3.Busqueda contacto por nombre y apellido");
        mensaje("4.Busca contacto por telefono");
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

    public Contacto nuevoContacto() {
        Scanner teclado = new Scanner(System.in);
        //solicitamos que tipo de contacto es
        int tipo = seleccionTipoContacto();
        //inicializammos todas las variables..
        boolean correcto = false;
        int telefono = 0;
        Contacto c = null;
        String nombre = "", apellido = "", email = "", facebook = "", twitter = "", direccion = "";
        //segun la seleccion que obtengamos antes, haremos más o menos entradas por teclado.
        switch (tipo) {
            case 1:
                c = pideCompanero();
                break;
            case 2:
                c = pideAmigos();
                break;
            case 3:
                c = pideFamilia();
                break;
        }
        return c;
    }

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

    public Contacto pideCompanero() {
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        String nombre, apellido, email;
        int telefono = 0;
        mensaje("Escribe nombre de contacto");
        nombre = teclado.nextLine();
        mensaje("Escribe apellido de contacto");
        apellido = teclado.nextLine();
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
        Contacto c = new companero(nombre, apellido, telefono, email);
        return c;
    }

    public Contacto pideAmigos() {
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        String nombre, apellido, email, facebook, twitter;
        int telefono = 0;
        mensaje("Escribe nombre de contacto");
        nombre = teclado.nextLine();
        mensaje("Escribe apellido de contacto");
        apellido = teclado.nextLine();
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
        mensaje("Escribe cuenta de facebook");
        facebook = teclado.nextLine();
        mensaje("Escribe cuenta de twitter");
        twitter = teclado.nextLine();
        Contacto c = new amigos(nombre, apellido, telefono, email, facebook, twitter);
        return c;
    }

    public Contacto pideFamilia() {
        Scanner teclado = new Scanner(System.in);
        boolean correcto = false;
        String nombre, apellido, email, facebook, twitter, direccion;
        int telefono = 0;
        mensaje("Escribe nombre de contacto");
        nombre = teclado.nextLine();
        mensaje("Escribe apellido de contacto");
        apellido = teclado.nextLine();
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
        mensaje("Escribe cuenta de facebook");
        facebook = teclado.nextLine();
        mensaje("Escribe cuenta de twitter");
        twitter = teclado.nextLine();
        mensaje("Escribe direccion");
        direccion = teclado.nextLine();
        Contacto c = new familia(nombre, apellido, telefono, email, facebook, twitter, direccion);
        return c;
    }

    public void mensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarContactos(Contacto[] lista) {

        System.out.printf("%10s %10s %15s %15s %25s %15s %15s %n", "Nombre", "Apellido", "telefono", "correo", "facebook", "Twitter", "Direccion");
        int i = 0;
        while (lista[i] != null) {
            mensaje(lista[i].toString());
            if(lista[i].isBorrado()){
            mensaje("ok");
            }
            i++;
        }
        System.out.println("Fin\n\n");
    }

    public void mostrarContactos(Contacto contacto) {

        System.out.printf("%10s %10s %15s %15s %25s %15s %15s %n", "Nombre", "Apellido", "telefono", "correo", "facebook", "Twitter", "Direccion");
        mensaje(contacto.toString());
        System.out.println("\n");
    }

    public String dameString(String tipo) {
        Scanner teclado = new Scanner(System.in);
        String texto;
        mensaje("Introduce el " + tipo + " que quieres buscar...");
        texto = teclado.next();
        return texto;
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
}
