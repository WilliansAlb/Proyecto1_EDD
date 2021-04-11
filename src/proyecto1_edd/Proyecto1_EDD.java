/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_edd;

import Analizador.Generadores;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author willi
 */
public class Proyecto1_EDD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Generadores n = new Generadores();
        try {
            n.generar();
        } catch (IOException ex) {
            Logger.getLogger(Proyecto1_EDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Proyecto1_EDD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
