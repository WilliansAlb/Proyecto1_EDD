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
public class Tests {
    public Tests(){
    
    }
    
    public void probarMatriz(){
        Matriz nueva = new Matriz();
        nueva.agregarNodo("rojo", 0, 6);
        nueva.agregarNodo("rojo", 0, 0);
        nueva.agregarNodo("violeta", 0, 1);
        nueva.agregarNodo("azul", 0, 5);
        nueva.agregarNodo("azul", 0, 2);
        nueva.agregarNodo("morado", 0, 3);
        nueva.agregarNodo("blanco", 1, 0);
        nueva.agregarNodo("gris", 1, 1);
        nueva.agregarNodo("purpura", 1, 2);
        nueva.agregarNodo("marron", 1, 3);
        nueva.agregarNodo("ocre", 2, 0);
        nueva.agregarNodo("celeste", 2, 1);
        nueva.agregarNodo("amarillo", 2, 2);
        nueva.agregarNodo("verde", 2, 3);
        nueva.agregarNodo("cafe", 3, 5);
        nueva.agregarNodo("cafe", 3, 0);
        nueva.agregarNodo("naranja", 3, 2);
        nueva.agregarNodo("lima", 3, 3);
        nueva.printShort();
    }
}
