/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizdispersa;

/**
 *
 * @author Andree
 */
public class Nodo {

    Object dato;
    Nodo sig, ant;
    //atributos para el nodo matriz
    Nodo izquierda, derecha, arriba, abajo;

    public Nodo(Object val) {
        dato = val;
        sig = ant = null;
        izquierda = derecha = arriba = abajo = null;
    }

    ListaDoble data;
    String vertical, horizontal;

    public Nodo(Object val, String x, String y) {
        data = new ListaDoble();
        data.add(dato);
        
        izquierda = derecha = arriba = abajo = null;
        
        horizontal = x;
        vertical = y;

    }

}
