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
public class Matriz {

    private int noCol;
    private int noFil;
    private boolean vacia;
    private Nodo inicio;

    public Matriz(int noCol, int noFil) {
        this.noCol = noCol;
        this.noFil = noFil;
        this.vacia = true;
    }

    public Matriz() {
        this.vacia = true;
        this.noCol = 0;
        this.noFil = 0;
        Nodo ne = new Nodo();
    	ne.setY(-1);
    	ne.setX(-1);
        ne.setSigFil(inicio);
    	ne.setSigCol(inicio);
        this.inicio = ne;
    }
    
    

    public void agregar_nodo(String color, int fila, int col) {
        Nodo nuevo = new Nodo(col, fila, color);
        nuevo.setY(fila);
        nuevo.setX(col);
        //valida si la matriz esta completamente vacia
        if (vacia) {
            Nodo row_header = new Nodo("", fila, -1, nuevo, inicio);
            Nodo col_header = new Nodo("", -1, col, inicio, nuevo);
            nuevo.setSigCol(row_header);
            nuevo.setSigFil(col_header);
            inicio.setSigCol(col_header);
            inicio.setSigFil(row_header);
            this.vacia = false;
        } else {
            //Valida si la fila que se envia ya tiene un encabezado
            if (!validar_fila(fila)) {
                Nodo temporal = inicio;
                while (temporal.getSigFil() != inicio) {
                    temporal = temporal.getSigFil();
                    if ((temporal.getY() < fila) && ((temporal.getSigFil().getY() > fila)
                            || (temporal.getSigFil() == inicio))) {
                        Nodo encabezado_fila = new Nodo("", fila, -1, nuevo, temporal.getSigFil());
                        temporal.setSigFil(encabezado_fila);
                        nuevo.setSigCol(encabezado_fila);
                    }
                }
            } //Si la fila no tiene un encabezado aún ejecuta el siguiente codigo
            else {
                Nodo temporal = inicio;
                //Recorre todas las filas que hay
                while (temporal.getSigFil() != inicio) {
                    temporal = temporal.getSigFil();
                    if (temporal.getY() == fila) {
                        Nodo temp_columna = temporal;
                        //Si la siguiente columna del nodo en el que nos encontramos es mayor que la columna enviada
                        if (temp_columna.getSigCol().getX() > col) {
                            nuevo.setSigCol(temp_columna.getSigCol());
                            temp_columna.setSigCol(nuevo);
                        } else {
                            //Si la siguiente columna del nodo en el que encontramos la posicion es menor o igual
                            while (temp_columna.getSigCol() != temporal) {
                                temp_columna = temp_columna.getSigCol();
                                if (temp_columna.getX() == col) {
                                    temp_columna.setColor(color);
                                    break;
                                }
                                if ((temp_columna.getX() < col) && ((temp_columna.getSigCol().getX() > col)
                                        || (temp_columna.getSigCol() == temporal))) {
                                    nuevo.setSigCol(temp_columna.getSigCol());
                                    temp_columna.setSigCol(nuevo);
                                    
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (!validar_columna(col)) {
                Nodo temp_columna = inicio;
                while (temp_columna.getSigCol() != inicio) {
                    temp_columna = temp_columna.getSigCol();
                    if ((temp_columna.getX() < col)
                            && ((temp_columna.getSigCol().getX() > col)
                            || (temp_columna.getSigCol() == inicio))) {
                        Nodo columna = new Nodo("", -1, col, temp_columna.getSigCol(), nuevo);
                        temp_columna.setSigCol(columna);
                        nuevo.setSigFil(columna);
                    }
                }
            } else {
                Nodo temp_columna = inicio;
                while (temp_columna.getSigCol() != inicio) {
                    temp_columna = temp_columna.getSigCol();
                    if (temp_columna.getX() == col) {
                        Nodo temp_fila = temp_columna;
                        if (temp_fila.getSigFil().getY() > fila) {
                            nuevo.setSigFil(temp_fila.getSigFil());
                            temp_fila.setSigFil(nuevo);
                        } else {
                            while (temp_fila.getSigFil() != temp_columna) {
                                temp_fila = temp_fila.getSigFil();
                                if (temp_fila.getY() == fila) {
                                    temp_fila.setColor(color);
                                }
                                if ((temp_fila.getY() < fila) && ((temp_fila.getSigFil().getY() > fila) 
                                        || (temp_fila.getSigFil() == temp_columna))) {
                                    nuevo.setSigFil(temp_fila.getSigFil());
                                    temp_fila.setSigFil(nuevo);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public boolean validar_fila(int fila) {
        if (vacia) {
            return false;
        }
        Nodo temporal = inicio;
        while (temporal.getSigFil() != inicio) {
            temporal = temporal.getSigFil();
            if (temporal.getY() == fila) {
                return true;
            }
        }
        return false;
    }

    public boolean validar_columna(int col) {
        if (vacia) {
            return false;
        }
        Nodo temporal = inicio;
        while ((temporal.getSigCol() != inicio)) {
            temporal = temporal.getSigCol();
            if (temporal.getX() == col) {
                return true;
            }
        }
        return false;

    }

    public void printShort(){
    	Nodo temporal_fila = inicio;
    	while(temporal_fila.getSigFil()!= inicio){
    		temporal_fila = temporal_fila.getSigFil();
    		printRowValues(temporal_fila.getY());
                System.out.println("");
    	}
    }
    
    //Display, in short form, values represented by nodes from one row.
    public void printRowValues(int fila){
    	//if there is no row of that value there is nothing to return
    	if(!validar_fila(fila)){
    		return;
    	}
    	Nodo temporal_fila = inicio;
    	while(temporal_fila.getY() != fila){
    		temporal_fila = temporal_fila.getSigFil();
    	}
    	Nodo temporal_columna = temporal_fila;
    	while(temporal_columna.getSigCol() != temporal_fila){
    		temporal_columna = temporal_columna.getSigCol();
    		System.out.print("   ("+temporal_columna.getY()+", "
    							+temporal_columna.getX()+"):"
    							+temporal_columna.getColor());
    	}
    }
}
