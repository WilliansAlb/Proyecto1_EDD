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
public class ArbolUsuarios {

    private NodoUsuario raiz;
    private int no_nodos;
    public String inicioGraph = "digraph G{\n"
            + "node [shape = record,height=.1];";
    public int encontraste = -1;

    public ArbolUsuarios() {
        raiz = null;
        no_nodos = 0;
    }

    public NodoUsuario buscar(int d, NodoUsuario r) {
        if (raiz == null) {
            return null;
        } else if (r.getId() == d) {
            return r;
        } else if (r.getId() < d) {
            return buscar(d, r.getDerecha());
        } else {
            return buscar(d, r.getIzquierda());
        }
    }

    public int obtener_factor(NodoUsuario x) {
        if (x == null) {
            return -1;
        } else {
            return x.getFe();
        }
    }

    //rotacion simple izquierda
    public NodoUsuario rotacion_izq(NodoUsuario c) {
        NodoUsuario aux = c.getIzquierda();
        c.setIzquierda(aux.getDerecha());
        aux.setDerecha(c);
        c.setFe(Math.max(obtener_factor(c.getIzquierda()), obtener_factor(c.getDerecha())) + 1);
        aux.setFe(Math.max(obtener_factor(aux.getIzquierda()), obtener_factor(aux.getDerecha())) + 1);
        return aux;
    }

    //rotacion simple derecha
    public NodoUsuario rotacion_der(NodoUsuario c) {
        NodoUsuario aux = c.getDerecha();
        c.setDerecha(aux.getIzquierda());
        aux.setIzquierda(c);
        c.setFe(Math.max(obtener_factor(c.getIzquierda()), obtener_factor(c.getDerecha())) + 1);
        aux.setFe(Math.max(obtener_factor(aux.getIzquierda()), obtener_factor(aux.getDerecha())) + 1);
        return aux;
    }

    //rotacion doble izquierda
    public NodoUsuario rotacion_doble_izq(NodoUsuario c) {
        NodoUsuario temp;
        c.setIzquierda(rotacion_der(c.getIzquierda()));
        temp = rotacion_izq(c);
        return temp;
    }

    //rotacion doble derecha
    public NodoUsuario rotacion_doble_der(NodoUsuario c) {
        NodoUsuario temp;
        c.setDerecha(rotacion_izq(c.getDerecha()));
        temp = rotacion_der(c);
        return temp;
    }

    public NodoUsuario insertarAVL(NodoUsuario nuevo, NodoUsuario subAr) {
        NodoUsuario nuevoPadre = subAr;
        if (nuevo.getId() < subAr.getId()) {
            if (subAr.getIzquierda() == null) {
                subAr.setIzquierda(nuevo);
            } else {
                subAr.setIzquierda(insertarAVL(nuevo, subAr.getIzquierda()));
                if ((obtener_factor(subAr.getIzquierda()) - obtener_factor(subAr.getDerecha())) == 2) {
                    if (nuevo.getId() < subAr.getIzquierda().getId()) {
                        nuevoPadre = rotacion_izq(subAr);
                    } else {
                        nuevoPadre = rotacion_doble_izq(subAr);
                    }
                }
            }
        } else if (nuevo.getId() > subAr.getId()) {
            if (subAr.getDerecha() == null) {
                subAr.setDerecha(nuevo);
            } else {
                subAr.setDerecha(insertarAVL(nuevo, subAr.getDerecha()));
                if ((obtener_factor(subAr.getDerecha()) - obtener_factor(subAr.getIzquierda())) == 2) {
                    if (nuevo.getId() > subAr.getDerecha().getId()) {
                        nuevoPadre = rotacion_der(subAr);
                    } else {
                        nuevoPadre = rotacion_doble_der(subAr);
                    }
                }
            }
        } else {
            System.out.println("Nodo duplicado");
        }
        if ((subAr.getIzquierda() == null) && (subAr.getDerecha() != null)) {
            subAr.setFe(subAr.getDerecha().getFe() + 1);
        } else if ((subAr.getDerecha() == null) && (subAr.getIzquierda() != null)) {
            subAr.setFe(subAr.getIzquierda().getFe() + 1);
        } else {
            subAr.setFe((Math.max(obtener_factor(subAr.getIzquierda()), obtener_factor(subAr.getDerecha())) + 1));
        }
        return nuevoPadre;
    }

    public void insertar(String nombre) {
        NodoUsuario nuevo = new NodoUsuario();
        nuevo.setId(no_nodos);
        if (raiz == null) {
            raiz = nuevo;
            no_nodos++;
        } else {
            raiz = insertarAVL(nuevo, raiz);
            no_nodos++;
        }

    }

    public void insertar(NodoUsuario nuevo) {
        nuevo.setId(no_nodos);
        if (raiz == null) {
            raiz = nuevo;
            no_nodos++;
        } else {
            raiz = insertarAVL(nuevo, raiz);
            no_nodos++;
        }

    }

    public String recorrido(NodoUsuario recorrida) {
        String retorno = "";
        if (recorrida != null) {
            retorno += recorrido(recorrida.getIzquierda());
            retorno += "node" + recorrida.getId() + "[label = \"<f0> |<f1> " + recorrida.getNombreUsuario() + "|<f2> \"];\n";
            if (recorrida.getIzquierda() != null) {
                retorno += "\"node" + recorrida.getId() + "\":f0 -> \"node" + recorrida.getIzquierda().getId() + "\":f1;\n";
            }
            if (recorrida.getDerecha() != null) {
                retorno += "\"node" + recorrida.getId() + "\":f2 -> \"node" + recorrida.getDerecha().getId() + "\":f1;\n";
            }
            retorno += recorrido(recorrida.getDerecha());
        }
        return retorno;
    }

    public NodoUsuario buscarUsuario(int id) {
        NodoUsuario temporal = raiz;
        NodoUsuario retorno = null;
        while (temporal != null) {
            if (id > temporal.getId()) {
                temporal = temporal.getDerecha();
            } else if (id < temporal.getId()) {
                temporal = temporal.getIzquierda();
            } else if (id == temporal.getId()) {
                retorno = temporal;
                break;
            }
        }
        return retorno;
    }

    public int recorrerHasta(NodoUsuario recorr, String usuario) {
        String retorno = "";
        int ret = -1;
        NodoUsuario recorrida = recorr;
        if (recorrida != null) {
            if (recorrida.getNombreUsuario().equals(usuario)) {
                ret = recorrida.getId();
                encontraste = ret;
            } else {
                retorno += recorrerHasta(recorrida.getIzquierda(), usuario);
                retorno += recorrerHasta(recorrida.getDerecha(), usuario);
            }
        }
        return ret;
    }

    public String obtener_todos_usuarios(NodoUsuario recorr) {
        String retorno = "";
        NodoUsuario recorrida = recorr;
        if (recorrida != null) {
            retorno += recorr.getNombreUsuario()+"-";
            retorno += obtener_todos_usuarios(recorrida.getIzquierda());
            retorno += obtener_todos_usuarios(recorrida.getDerecha());
        }
        return retorno;
    }

    public String escribir_doc() {
        String doc = inicioGraph;
        doc += recorrido(raiz);
        doc += "}";
        System.out.println(doc);
        return doc;
    }

    public NodoUsuario getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoUsuario raiz) {
        this.raiz = raiz;
    }

}
