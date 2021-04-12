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
public class NodoImagen {
    private int id;
    private Capa actual;
    private NodoImagen siguiente;

    public NodoImagen(int id, Capa actual, NodoImagen siguiente) {
        this.id = id;
        this.actual = actual;
        this.siguiente = siguiente;
    }

    public NodoImagen(int id, Capa actual) {
        this.id = id;
        this.actual = actual;
    }
    
    public NodoImagen(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Capa getActual() {
        return actual;
    }

    public void setActual(Capa actual) {
        this.actual = actual;
    }

    public NodoImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoImagen siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
