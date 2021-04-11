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
    
    public void recorrido_inOrden(Capa recorrida){
        if (recorrida!=null){
            recorrido_inOrden(recorrida.getIzquierda());
            System.out.println(recorrida.getId());
            recorrida.getDispersa().printShort();
            String c = recorrida.getDispersa().obtener_color(10, 11);
            System.out.println(c);
            recorrido_inOrden(recorrida.getDerecha());
        }
    }
    
    public void recorrido_preOrden(Capa recorrida){
        if (recorrida!=null){
            System.out.println(recorrida.getId());
            recorrida.getDispersa().printShort();
            recorrido_inOrden(recorrida.getIzquierda());
            recorrido_inOrden(recorrida.getDerecha());
        }
    }
    
    public void recorrido_postOrden(Capa recorrida){
        if (recorrida!=null){
            recorrido_inOrden(recorrida.getIzquierda());
            recorrido_inOrden(recorrida.getDerecha());
            System.out.println(recorrida.getId());
            recorrida.getDispersa().printShort();
        }
    }
    
    public Capa getRaiz() {
        return raiz;
    }

    public void setRaiz(Capa raiz) {
        this.raiz = raiz;
    }
    
    
}
