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
public class NodoUsuario {
    private String nombreUsuario;
    private NodoUsuario izquierda, derecha;
    private UsuarioImagen inicio;
    private int id;
    private int fe;

    public NodoUsuario() {
        nombreUsuario = "";
        izquierda = null;
        derecha = null;
        inicio = null;
        id = -1;
        fe = 0;
    }
    
    public void agregar_nodo(UsuarioImagen ag) {
        UsuarioImagen nuevo = ag;
        if (inicio == null) {
            nuevo.setSiguiente(null);
            inicio = nuevo;
        } else {
            UsuarioImagen tmp = inicio;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            nuevo.setSiguiente(null);
            tmp.setSiguiente(nuevo);
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public NodoUsuario getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoUsuario izquierda) {
        this.izquierda = izquierda;
    }

    public NodoUsuario getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoUsuario derecha) {
        this.derecha = derecha;
    }

    public UsuarioImagen getInicio() {
        return inicio;
    }

    public void setInicio(UsuarioImagen inicio) {
        this.inicio = inicio;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }
    
}
