package impl;

import api.ColaPrioridadTDA;

public class ColaPrioridadDinamica implements ColaPrioridadTDA{
    NodoPrioridadString primero, ultimo;
    @Override
    public void inicializarCola() {
       primero=ultimo=null;

    }

    @Override
    public void acolarPrioridad(int p, String cadena) {
        NodoPrioridadString aux = new NodoPrioridadString();
        NodoPrioridadString recorre;
        aux.prioridad=p;
        aux.info= cadena;
        aux.siguiente=null;

        if(this.esVacia())
            primero = ultimo=aux;

        else if(aux.prioridad>ultimo.prioridad){
            ultimo.siguiente=aux;
            ultimo=aux;
        }else if(aux.prioridad<=primero.prioridad){
            aux.siguiente=primero;
            primero=aux;
        }else{ 
            recorre=primero;
            
            while(aux.prioridad>recorre.siguiente.prioridad) 
                recorre=recorre.siguiente;
            
            aux.siguiente=recorre.siguiente;
            recorre.siguiente=aux;
        }
    }

    @Override
    public void desacolar() {
        

        primero= primero.siguiente;
        ultimo=primero==null?null:ultimo;

    }

    @Override
    public String tope() {
        return primero.info;
    }

    @Override
    public boolean esVacia() {
            
        return primero==null;

    }

    @Override
    public int prioridad() {
        return primero.prioridad;
    }
    
}
