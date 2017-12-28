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
public class ListaDoble {

    Nodo first, last;
    int size;

    public ListaDoble() {
        first = last = null;
        size = 0;
    }

    public boolean add(Object dato) {
        if (first == null) {
            first = last = new Nodo(dato);

        } else {
            Nodo nuevo = new Nodo(dato);
            last.sig = nuevo;
            nuevo.ant = last;
            last = nuevo;

        }
        size++;
        return true;
    }

    public Nodo buscar(String valor) {
        Nodo temp = first;
        if (first == null) {
            return null;
        } else {
            while (temp != null) {
                //Aqui podes castear a String el valor de vertical o horizontal pero esto funciona supongo
                if (temp.dato.equals(valor)) {
                    return temp;
                }
                temp = temp.sig;
            }
        }
        return null;
    }

    public boolean remove(String valor) {

        if (first != null) {
            Nodo temporal = first;
            while (temporal != null) {
                if (temporal.dato.equals(valor)) {
                    if (temporal == first) {
                        first = temporal.sig;
                        return true;
                    } else if (temporal.sig == null) {
                        temporal.ant.sig = null;
                        return true;
                    } else {
                        temporal.ant.sig = temporal.sig;
                        return true;
                    }
                } else {
                    temporal = temporal.sig;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public void imprimir() {
        Nodo temp = first;
        while (temp != null) {
            System.out.println(temp.dato);
            temp = temp.sig;
        }
    }
}
