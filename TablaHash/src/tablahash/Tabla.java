/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablahash;

/**
 *
 * @author Andree
 */
public class Tabla {

    //vector de posiciones
    Nodo TablaHash[];
    int size = 0;

    public Tabla(int size) {
        this.TablaHash = new Nodo[size+1];
        this.size = size;
    }

    public boolean add(int id, String contenido) {

        int posicion = hashing(id);
        TablaHash[posicion] = new Nodo(id, contenido);
        return true;
    }
    

    public void imprimirHash() {
        for (int i = 0; i < TablaHash.length; i++) {
            if(TablaHash[i]!=null)
                System.out.println("["+String.valueOf(i)+"]-"+TablaHash[i].data);
            else
                System.out.println("["+String.valueOf(i)+"]-Espacio Disponible");
        }
    }

    private int hashing(int entrada) {
        int modular = entrada % size;
        boolean existe = buscar(modular);
        while (existe == true && modular <= size) {
            modular++;
            existe = buscar(modular);
        }
        return modular;
    }

    private boolean buscar(int modular) {
        if (TablaHash[modular] != null) {
            return true;
        } else {
            return false;
        }
    }
}

class Nodo {

    String data;
    int id;

    public Nodo(int id_, String data_) {
        id = id_;
        data = data_;
    }

}
