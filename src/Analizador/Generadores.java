/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizador;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java_cup.runtime.Symbol;
import jflex.exceptions.SilentExit;

/**
 *
 * @author willi
 */
public class Generadores {

    public Generadores() {
    }
    
    public void generar() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parser", decodedPath + "/src/Analizador/parser.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizador/Lexer.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get(dP + "/src/Analizador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/sym.java"),
                Paths.get(dP + "/src/Analizador/sym.java")
        );
        Path rutaSin = Paths.get(dP + "/src/Analizador/parser.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parser.java"),
                Paths.get(dP + "/src/Analizador/parser.java")
        );
    }
    
    public void generar2() throws UnsupportedEncodingException, SilentExit, IOException, Exception {
        String path2 = System.getProperty("user.dir");
        String decodedPath = URLDecoder.decode(path2, "UTF-8");
        String[] rutaS = {"-parser", "parserImg", "-symbols", "symImg", decodedPath + "/src/Analizador/parserImg.cup"};
        String[] rutaS2 = {decodedPath + "/src/Analizador/LexerImg.flex"};
        jflex.Main.generate(rutaS2);
        java_cup.Main.main(rutaS);

        String dP = URLDecoder.decode(path2, "UTF-8");

        Path rutaSym = Paths.get(dP + "/src/Analizador/symImg.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get(dP + "/symImg.java"),
                Paths.get(dP + "/src/Analizador/symImg.java")
        );
        Path rutaSin = Paths.get(dP + "/src/Analizador/parserImg.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get(dP + "/parserImg.java"),
                Paths.get(dP + "/src/Analizador/parserImg.java")
        );
    }
    
}
