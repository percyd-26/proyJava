/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Retos;
import java.util.Scanner;

/**
 *
 * @author percy
 */
public class Main {
    public static void main(String[] args){
        int nReto = 0;
        while (nReto != 3) {
            System.out.print("\n\n>>>>>>>>>>>>>>> RETO JAVA <<<<<<<<<<<<<<<");
            System.out.print("\n1. RETO 01: Ingresar ancho y alto y generar una matriz con numeros del 1 al 9");
            System.out.print("\n2. RETO 02: Justificar un texto ingresado por consola");
            System.out.print("\n3. SALIR");
            System.out.print("\n>>>>>>>>>>>>>>> RETO JAVA <<<<<<<<<<<<<<<\n");
            System.out.print("\nIngrese el número del reto que desea revisar: ");
            nReto = pedirEnteroDel1aN("número", 3);
            if (nReto == 3) {
                System.out.print("\nSALIENDO....Gracias por su tiempo.");
            }
            else
            {
                verReto(nReto);
            }
        }
        
    }
    public static void verReto(int nReto)
    {
        switch(nReto){
            case 1:
                System.out.print("\n======== RETO 01 ========");
                System.out.print("\nIngrese dos número entre 1 y 9 que representen al ancho y el alto de la matriz.");
                int ancho = pedirEnteroDel1aN("ancho", 9);
                int alto = pedirEnteroDel1aN("alto", 9);
                System.out.print("Alto:" + alto + "\tAncho:" + ancho + "\n");
                printMatrix(alto, ancho);
                break;
            case 2:
                System.out.print("\n======== RETO 02 ========");
                System.out.print("\nJustificar un texto ingresado por consola");
                String str = pedirTexto();
                justificar(str, 80);
                break;
        }
    }
    public static void justificar(String str, int ancho)
    {
        String[] sub = str.split(" ");
        int cont = 0;
        String line = "";
        String tline = "";
        while (cont != sub.length) {
            tline = "";
            int tot = 0;
            int nWord = 0;
            for (int i = cont; i < sub.length; i++) {
                if (!sub[i].trim().isEmpty()) {
                    if (tline.length() + sub[i].length() + 1 > ancho) {
                        int sp = (ancho - tot)/(nWord-1);
                        int tsp = ancho - tot;
                        int usp = tsp - (sp * (nWord-1));
                        line = "";
                        for (int j = cont; j < i; j++) {
                            if (j == i-1 - usp) {
                                line += getNEspacios(1);
                                usp--;
                            }
                            line += sub[j].trim() + getNEspacios(sp);
                        }
                        cont = i;
                        break;
                    }
                    tot += sub[i].trim().length();
                    nWord++;
                    if (tline.isEmpty()) {
                        tline = sub[i];
                    }
                    else
                        tline += " " + sub[i];
                    
                }
                if (i == sub.length - 1) {
                    cont = sub.length;
                    line = tline;
                }
            }
            System.out.print("\n" + line);
        }
    }
    public static String getNEspacios(int n){
        String str = "";
        for (int i = 0; i < n; i++) {
            str += " ";
        }
        return str;
    }
    public static int pedirEnteroDel1aN(String tag, int num){
        Scanner entrada = new Scanner(System.in);
        int n = 0;        
        while (n < 1 || n > num) {            
            System.out.print("\nIngrese el " + tag + ":");
            try {
                n = entrada.nextInt();
            } catch (Exception e) {
                System.out.print("\nERROR: Debe ingresar un número entre 1 y " + num + "...");
                entrada.next();
                continue;
            }            
            if (n < 1 || n > num) {
                System.out.print("\nNúmero inválido. Debe ingresar un número entre 1 y " + num + "...");
            }
        }
        return n;
    }
    
    public static String pedirTexto(){
        Scanner entrada = new Scanner(System.in);
        String str = "";        
        while (str.trim().isEmpty()) {            
            System.out.print("\nIngrese un texto: ");
            str = entrada.nextLine();
            if (str.trim().isEmpty()) {
                System.out.print("\nDato ingresado es incorrecto.");
            }
        }
        return str;
    }
    public static void printMatrix(int f, int c)
    {
        int ri = 0;
        int rj = 0;
        int x = 0;
        for (int i = 0; i < f; i++) {
            ri = f - i -1;
            for (int j = 0; j < c; j++) {
                rj = c - j -1;
                int ii;
                if (i> (f-1) / 2) {
                    ii = ri;
                }
                else
                    ii = i;
                if (j<ii) {
                    x=j;                        
                }
                else{
                    if (rj<ii) {
                        x = rj;
                    }
                    else
                        x=ii;                    
                }
                System.out.print(c - x);
            }
            System.out.print("\n");
        }
    }
}
