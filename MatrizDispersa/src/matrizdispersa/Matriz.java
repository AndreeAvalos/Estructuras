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
public class Matriz {

    ListaDoble listaH, listaV;

    public Matriz() {
        //instanciamos la lista
        listaH = new ListaDoble();
        listaV = new ListaDoble();
    }

    public boolean add(Object dato, String horizontal, String vertical) {
        Nodo nuevo = new Nodo(dato, horizontal, vertical);
        //nodos que nos indican si existe el horizontal o el vertical
        Nodo auxH = listaH.buscar(horizontal);
        Nodo auxV = listaV.buscar(vertical);

        //aqui vamos a tener cuatro casos
        //1- si no existe vertical ni horizontal
        if (auxH == null && auxV == null) {

            listaH.add(horizontal);
            listaV.add(vertical);

            //buscamos los nodos en sus respectivas listas
            Nodo tempH = listaH.buscar(horizontal);
            Nodo tempV = listaV.buscar(vertical);
            //los enlazamos entre si
            //abajo a arriba 
            tempH.abajo = nuevo;
            nuevo.arriba = tempH;
            //derecha a izquierda
            tempV.derecha = nuevo;
            nuevo.izquierda = tempV;

            return true;
        } else if (auxH != null && auxV == null) {
            //insertamos solamente en el vertical 
            listaV.add(vertical);

            //buscamos los nodos en sus respectivas listas
            Nodo tempH = listaH.buscar(horizontal);
            Nodo tempV = listaV.buscar(vertical);

            tempV.derecha = nuevo;
            nuevo.izquierda = tempV;
            //instanciamos dos nodos temporales que serviran para recorrer y guardar el ultimo valor
            Nodo temporal = tempH;//recorre
            Nodo temporal2 = tempH;//guarda
            //se recorre hacia abajo
            while (temporal != null) {
                temporal2 = temporal;//guarda
                temporal = temporal.abajo;//recorre
            }
            //enlazamos temporal2 que tiene el valor del ultimo nodo 
            temporal2.abajo = nuevo;
            nuevo.arriba = temporal2;
            return true;

        } else if (auxH == null && auxV != null) {
            //insertamos solamente en el vertical 
            listaH.add(horizontal);

            //buscamos los nodos en sus respectivas listas
            Nodo tempH = listaH.buscar(horizontal);
            Nodo tempV = listaV.buscar(vertical);
            //enlazamos el nodo que proviene del horizontal hacia arriba y abajo
            tempH.abajo = nuevo;
            nuevo.arriba = tempH;
            //Creamos dos temporales que recorreran el vertical hacia derecha hasta encontrar el ultimo
            Nodo temporal = tempV;
            //temporal2 guarda el valor anterior digase el ultimo
            Nodo temporal2 = tempV;
            while (temporal != null) {
                temporal2 = temporal;
                temporal = temporal.derecha;
            }
            //enlazamos el tempora2 con el nuevo nodo y viceversa
            temporal2.derecha = nuevo;
            nuevo.izquierda = temporal2;
            return true;
        } else if (auxH != null && auxV != null) {
            //En este caso apilamos el valor en la lista
            //buscamos el nodo en la matriz
            Nodo temporal = buscar(horizontal, vertical);
            //comprobamos si el nodo no es nulo existe en la matriz
            if (temporal != null) {
                //lo agregamos a la lista de datos
                temporal.data.add(dato);
                //retornamos verdadero ya que se inserto
                return true;
            }
        }
        return false;
    }

    public Nodo buscar(String horizontal, String vertical) {
        //instanciamos un nuevo nodo temporal con la busqueda del horizontal
        Nodo temporal = listaH.buscar(horizontal);
        //recorremos el nodo en forma vertical hasta encontral o hacer match con el vertical;
        while (temporal != null) {
            //si el nodo actual con parametro vertical es igual al vertical que devuelva el nodo
            if (temporal.vertical.equals(vertical)) {
                return temporal;
                //de lo contrario que siga recorriendo
            } else {
                temporal = temporal.abajo;
            }
        }
        return null;
    }

}
