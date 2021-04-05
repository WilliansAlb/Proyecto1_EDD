/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_edd;

/**
 *
 * @author willi
 */
public class Proyecto1_EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz nueva = new Matriz();
        nueva.agregar_nodo("rojo", 0, 0);
        nueva.agregar_nodo("violeta", 0, 1);
        nueva.agregar_nodo("azul", 0, 2);
        nueva.agregar_nodo("morado", 0, 3);
        nueva.agregar_nodo("blanco", 1, 0);
        nueva.agregar_nodo("gris", 1, 1);
        nueva.agregar_nodo("purpura", 1, 2);
        nueva.agregar_nodo("marron", 1, 3);
        nueva.agregar_nodo("ocre", 2, 0);
        nueva.agregar_nodo("celeste", 2, 1);
        nueva.agregar_nodo("amarillo", 2, 2);
        nueva.agregar_nodo("verde", 2, 3);
        nueva.agregar_nodo("cafe", 3, 0);
        nueva.agregar_nodo("naranja", 3, 2);
        nueva.agregar_nodo("lima", 3, 3);
        nueva.printShort();
    }

}
