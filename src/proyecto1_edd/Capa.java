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
public class Capa {
    private Capa izquierda;
    private Capa derecha;
    private int id;
    private Matriz dispersa;

    public Capa(int id) {
        this.izquierda = null;
        this.derecha = null;
        this.id = id;
        this.dispersa = null;
    }

    public Capa() {
    }

    public Capa getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Capa izquierda) {
        this.izquierda = izquierda;
    }

    public Capa getDerecha() {
        return derecha;
    }

    public void setDerecha(Capa derecha) {
        this.derecha = derecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Matriz getDispersa() {
        return dispersa;
    }

    public void setDispersa(Matriz dispersa) {
        this.dispersa = dispersa;
    }
    
    
    
}
