/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_edd;

import Analizador.Generadores;
import Analizador.Lexer;
import Analizador.LexerImg;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author willi
 */
public class Tests {

    public Tests() {

    }

    public void probarMatriz() {
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

    public void probarImagenes() {
        ListaImagenes nueva = new ListaImagenes();
        nueva.agregar_imagen(3);
        nueva.agregar_imagen(5);
        nueva.agregar_imagen(0);
        nueva.agregar_imagen(2);
        nueva.agregar_imagen(11);
        nueva.agregar_imagen(7);
        nueva.agregar_imagen(45);
        nueva.agregar_imagen(10);
        nueva.agregar_imagen(1);
        nueva.agregar_imagen(4);
        nueva.imprimir();
    }

    public void pruebaLexer(String texto) throws IOException {
        Lexer nuevo = new Lexer(new StringReader(texto));

        while (true) {
            Symbol temp = nuevo.next_token();
            if (temp.value == null) {
                break;
            } else {
                System.out.println("Valor: " + temp.value + " Linea: " + temp.left + " Columna: " + temp.right);
            }
        }
    }

    public void pruebaLexerImg(String texto) throws IOException {
        LexerImg nuevo = new LexerImg(new StringReader(texto));
        while (true) {
            Symbol temp = nuevo.next_token();
            if (temp.value == null) {
                break;
            } else {
                System.out.println("Valor: " + temp.value + " Linea: " + temp.left + " Columna: " + temp.right);
            }
        }
    }

    public void generarAmbos() {
        Generadores g = new Generadores();
        try {
            g.generar();
            g.generar2();
        } catch (IOException ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
