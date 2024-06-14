package impl;

import api.ColaStringTDA;

public class ColaStringDinamica implements ColaStringTDA {
    Nodo primero;
    Nodo ultimo;

    class Nodo {
        String info;
        Nodo sig; // Es un puntero que apunta  direccion de memoria del nodo que esta apuntarando
    }

    public void InicializarCola(){
        primero = null;
        ultimo = null;
    }

    public void Acolar(String x){
        Nodo aux = new Nodo();
        aux.info = x;
        aux.sig =null;
        if (ultimo != null){
            ultimo.sig = aux;
        }
        ultimo = aux;
        if (primero == null) {
            primero = ultimo;
        }
    }

    public void Desacolar(){
        primero = primero.sig;
        if (primero == null) {
            ultimo = null;
        }
    }

    public boolean ColaVacia(){
        return (ultimo == null);
    }

    public String Primero(){
        return primero.info;
    }
}
