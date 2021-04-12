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
public class ListaCapas {
    private Capa raiz;
    public String inicioGraph = "digraph G{\n"
            + "node [shape = record,height=.1];";

    public ListaCapas() {
        raiz = null;
    }

    public void insertarCapa(Capa nueva){
        if (raiz==null){
            raiz = nueva;
        } else {
            Capa aux = raiz;
            Capa padre;
            while(true){
                padre = aux;
                if (nueva.getId()<aux.getId()){
                    aux = aux.getIzquierda();
                    if (aux == null){
                        padre.setIzquierda(nueva);
                        break;
                    }
                } else {
                    aux = aux.getDerecha();
                    if (aux==null){
                        padre.setDerecha(nueva);
                        break;
                    }
                }
            }
        }
    }
    
    public Capa buscarCapa(int id){
        Capa temporal = raiz;
        Capa retorno = null;
        while (temporal!=null){
            if (id > temporal.getId()){
                temporal = temporal.getDerecha();
            } else if (id < temporal.getId()){
                temporal = temporal.getIzquierda();
            } else if (id == temporal.getId()) {
                retorno = temporal;
                break;
            }
        }
        return retorno;
    }
    
    public String recorrido_inOrden(Capa recorrida){
        String retorno = "";
        if (recorrida!=null){
            retorno += recorrido_inOrden(recorrida.getIzquierda());
            retorno += recorrida.getId();
            retorno += "-"; 
            retorno += recorrido_inOrden(recorrida.getDerecha());
        }
        return retorno;
    }
    
    public String recorrido(Capa recorrida){
        String retorno = "";
        if (recorrida!=null){
            retorno += recorrido(recorrida.getIzquierda());
            retorno += "node"+recorrida.getId()+"[label = \"<f0> |<f1> "+recorrida.getId()+"|<f2> \"];\n";
            if (recorrida.getIzquierda()!=null){
                retorno+= "\"node"+recorrida.getId()+"\":f0 -> \"node"+recorrida.getIzquierda().getId()+"\":f1;\n";
            }
            if (recorrida.getDerecha()!=null){
                retorno+= "\"node"+recorrida.getId()+"\":f2 -> \"node"+recorrida.getDerecha().getId()+"\":f1;\n";
            }
            retorno += recorrido(recorrida.getDerecha());
        }
        return retorno;
    }
    
    public String recorrido_preOrden(Capa recorrida){
        String retorno = "";
        if (recorrida!=null){
            retorno += recorrida.getId();
            retorno += "-"; 
            retorno += recorrido_preOrden(recorrida.getIzquierda());
            retorno += recorrido_preOrden(recorrida.getDerecha());
        }
        return retorno;
    }
    
    public String recorrido_postOrden(Capa recorrida){
        String retorno = "";
        if (recorrida!=null){
            retorno += recorrido_postOrden(recorrida.getIzquierda());
            retorno += recorrido_postOrden(recorrida.getDerecha());
            retorno += recorrida.getId();
            retorno += "-"; 
        }
        return retorno;
    }
    
    public Capa getRaiz() {
        return raiz;
    }

    public void setRaiz(Capa raiz) {
        this.raiz = raiz;
    }
    
    public String escribir_doc(){
        String doc = inicioGraph;
        doc+= recorrido(raiz);
        doc+="}";
        return doc;
    }
}
