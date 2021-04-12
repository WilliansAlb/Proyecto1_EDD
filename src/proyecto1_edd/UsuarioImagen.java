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
public class UsuarioImagen {
    private int id;
    private Imagen actual;
    private UsuarioImagen siguiente;

    public UsuarioImagen(int id, Imagen actual, UsuarioImagen siguiente) {
        this.id = id;
        this.actual = actual;
        this.siguiente = siguiente;
    }

    public UsuarioImagen(int id, Imagen actual) {
        this.id = id;
        this.actual = actual;
    }

    public UsuarioImagen(int id) {
        this.id = id;
    }

    public UsuarioImagen() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Imagen getActual() {
        return actual;
    }

    public void setActual(Imagen actual) {
        this.actual = actual;
    }

    public UsuarioImagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(UsuarioImagen siguiente) {
        this.siguiente = siguiente;
    }
}
