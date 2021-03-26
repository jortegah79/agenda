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

    public void escribeArchivo(Contacto[] agenda) {
        Vista v = new Vista();
        File f = new File("d:/agenda.dat");
        FileOutputStream fos;
        ObjectOutputStream oos;
        for (int i = 0; i < agenda.length; i++) {
            if (agenda[i] != null) {
                if (agenda[i].isBorrado()==true) {
                    agenda[i] = null;
                }
            }
        }

        try {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(agenda);
            oos.close();
            fos.close();
        } catch (IOException e) {
            v.mensaje("Archivo no accesible o no existe");
        }

        v.mensaje("Agenda Guardada.");
    }

    public Contacto[] leerArchivo() {
        Vista v = new Vista();
        File f = new File("d:/agenda.dat");
        FileInputStream fis;
        ObjectInputStream ois;
        Contacto[] agenda = new Contacto[150];
        Contacto[] agendaSinBorrados = new Contacto[150];
        try {
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            while (ois.available() >= 0) {
                agenda = (Contacto[]) ois.readObject();
            }
            ois.close();
        } catch (IOException | ClassNotFoundException ex) {
            v.mensaje("Fin transferencia");
        }
        return agenda;
    }
}
