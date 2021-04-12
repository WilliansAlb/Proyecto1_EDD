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
public class Imagen {

    private Imagen siguiente;
    private Imagen anterior;
    private NodoImagen inicio;
    private int id;

    public Imagen(Imagen siguiente, Imagen anterior, NodoImagen inicio) {
        this.siguiente = siguiente;
        this.anterior = anterior;
        this.inicio = inicio;
    }

    public void agregar_nodo(int no_capa) {
        NodoImagen nuevo = new NodoImagen(no_capa);
        if (inicio == null) {
            nuevo.setSiguiente(null);
            inicio = nuevo;
        } else {
            NodoImagen tmp = inicio;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            nuevo.setSiguiente(null);
            tmp.setSiguiente(nuevo);
        }
    }

    public void agregar_nodo(NodoImagen ag) {
        NodoImagen nuevo = ag;
        if (inicio == null) {
            nuevo.setSiguiente(null);
            inicio = nuevo;
        } else {
            NodoImagen tmp = inicio;
            while (tmp.getSiguiente() != null) {
                tmp = tmp.getSiguiente();
            }
            nuevo.setSiguiente(null);
            tmp.setSiguiente(nuevo);
        }
    }

    public String obtener_superpuestos() {
        String superpuestos = "";
        if (inicio != null) {
            NodoImagen tm = inicio;
            while (tm != null) {
                superpuestos += tm.getId()+"-";
                tm = tm.getSiguiente();
            }
            return superpuestos;
        } else {
            return "SIN";
        }
    }

    public Imagen() {
        inicio = null;
    }

    public Imagen(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Imagen getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Imagen siguiente) {
        this.siguiente = siguiente;
    }

    public Imagen getAnterior() {
        return anterior;
    }

    public void setAnterior(Imagen anterior) {
        this.anterior = anterior;
    }

    public NodoImagen getInicio() {
        return inicio;
    }

    public void setInicio(NodoImagen inicio) {
        this.inicio = inicio;
    }

}
