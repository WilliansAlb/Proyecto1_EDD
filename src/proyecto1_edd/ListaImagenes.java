/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_edd;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class ListaImagenes {

    private Imagen raiz;
    public String inicioGraph = "digraph G{\n"
            + "rankdir=TB; graph [fontsize=10 fontname=\"Verdana\"];\n"
            + "node [shape=box fontsize=10 fontname=\"Verdana\"];";

    public ListaImagenes() {
        raiz = null;

    }

    public void agregar_imagen(int id) {
        Imagen nueva = new Imagen(id);
        if (raiz == null) {
            raiz = nueva;
            raiz.setSiguiente(nueva);
            raiz.setAnterior(nueva);
        } else {
            Imagen temp = raiz;
            do {
                if (temp.getSiguiente() == raiz) {
                    if (temp.getId() > id) {
                        nueva.setAnterior(temp.getAnterior());
                        temp.getAnterior().setSiguiente(nueva);
                        nueva.setSiguiente(temp);
                        raiz = nueva;
                        break;
                    } else {
                        nueva.setSiguiente(raiz);
                        temp.setSiguiente(nueva);
                        nueva.setAnterior(temp);
                        temp.setAnterior(nueva);
                        break;
                    }
                } else {
                    if (temp == raiz && temp.getId() > id) {
                        nueva.setAnterior(temp.getAnterior());
                        nueva.getAnterior().setSiguiente(nueva);
                        nueva.setSiguiente(temp);
                        temp.setAnterior(nueva);
                        raiz = nueva;
                        break;
                    } else {
                        if (temp.getId() < id && temp.getSiguiente().getId() > id) {
                            nueva.setSiguiente(temp.getSiguiente());
                            temp.setSiguiente(nueva);
                            nueva.setAnterior(temp);
                            temp.setAnterior(nueva);
                            break;
                        }
                    }
                }
                temp = temp.getSiguiente();
            } while (temp != raiz);
        }
    }

    public void agregar_imagen(Imagen agregar) {
        Imagen nueva = agregar;
        int id = nueva.getId();
        if (raiz == null) {
            raiz = nueva;
            raiz.setSiguiente(nueva);
            raiz.setAnterior(nueva);
        } else {
            Imagen temp = raiz;
            do {
                if (temp.getSiguiente() == raiz) {
                    if (temp.getId() > id) {
                        nueva.setAnterior(temp.getAnterior());
                        temp.getAnterior().setSiguiente(nueva);
                        nueva.setSiguiente(temp);
                        raiz = nueva;
                        break;
                    } else {
                        nueva.setSiguiente(raiz);
                        temp.setSiguiente(nueva);
                        nueva.setAnterior(temp);
                        temp.setAnterior(nueva);
                        break;
                    }
                } else {
                    if (temp == raiz && temp.getId() > id) {
                        nueva.setAnterior(temp.getAnterior());
                        nueva.getAnterior().setSiguiente(nueva);
                        nueva.setSiguiente(temp);
                        temp.setAnterior(nueva);
                        raiz = nueva;
                        break;
                    } else {
                        if (temp.getId() < id && temp.getSiguiente().getId() > id) {
                            nueva.setSiguiente(temp.getSiguiente());
                            temp.setSiguiente(nueva);
                            nueva.setAnterior(temp);
                            temp.setAnterior(nueva);
                            break;
                        }
                    }
                }
                temp = temp.getSiguiente();
            } while (temp != raiz);
        }
    }

    public void eliminar_imagen() {

    }

    public void imprimir() {
        Imagen reco = raiz;
        do {
            System.out.println("Numero de imagen: " + reco.getId());
            reco = reco.getSiguiente();
        } while (reco != raiz);
    }

    public String escribir_doc() {
        System.out.println("llega");
        Imagen reco = raiz;
        String retorno = inicioGraph;
        String otro = "{ rank = same; ";
        do {
            retorno += "nodeIMG" + reco.getId() + "[label = \"IMAGEN - " + reco.getId() + "\"];\n";
            otro += "nodeIMG" + reco.getId()+"; ";
            if (reco.getInicio() != null) {
                NodoImagen par = reco.getInicio();
                while (par.getSiguiente() != null) {
                    retorno += "nodeCAP" + par.getId()+"_"+reco.getId()+ "[label = \"CAPA - " + par.getId() + "\"];\n";
                    retorno += "nodeCAP" + par.getSiguiente().getId()+"_"+reco.getId()+ "[label = \"CAPA - " + par.getSiguiente().getId() + "\"];\n";
                    retorno += "\"nodeCAP" + par.getId()+"_"+reco.getId() + "\" -> \"nodeCAP" + par.getSiguiente().getId()+"_"+reco.getId() + "\";\n";
                    if (par == reco.getInicio()) {
                        retorno += "\"nodeIMG" + reco.getId() + "\" -> \"nodeCAP" + par.getId()+"_"+reco.getId() + "\";\n";
                    }
                    par = par.getSiguiente();
                }
            }
            retorno += "\"nodeIMG" + reco.getId() + "\" -> \"nodeIMG" + reco.getSiguiente().getId() + "\";\n";
            retorno += "\"nodeIMG" + reco.getSiguiente().getId() + "\" -> \"nodeIMG" + reco.getId() + "\";\n";
            reco = reco.getSiguiente();
        } while (reco != raiz);
        retorno += otro+"}";
        retorno += "}";
        System.out.println(retorno);
        return retorno;
    }

    public Imagen obtener_imagen(int id) {
        Imagen reco = raiz;
        Imagen retorno = null;
        do {
            if (reco.getId() == id) {
                retorno = reco;
                break;
            }
            reco = reco.getSiguiente();
        } while (reco != raiz);
        return retorno;
    }

    public Imagen getRaiz() {
        return raiz;
    }

    public void setRaiz(Imagen raiz) {
        this.raiz = raiz;
    }

}
