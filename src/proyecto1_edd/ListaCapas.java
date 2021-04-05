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

    public boolean insertarCapa(Capa nueva){
        boolean temp = false;
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
        return temp;
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
    
    public Capa getRaiz() {
        return raiz;
    }

    public void setRaiz(Capa raiz) {
        this.raiz = raiz;
    }
    
    
}
