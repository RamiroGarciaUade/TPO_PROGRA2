package impl;

import api.ConjuntoTDA;

public class ConjuntoDinamico implements ConjuntoTDA {
    Nodo primero;
    int cantidad;

    @Override
    public void inicializarConjunto() {
        primero=null;
    }

    @Override
    public boolean conjuntoVacio() {
        return primero==null;
    }

    @Override
    public void agregar(String x) {
        Nodo aux;
        aux = new Nodo();
        aux.info=x;
        aux.sig=null;

        if(!this.pertenece(x)){
            aux.sig=primero;
            primero=aux;
            cantidad++;
        }

    }

    @Override
    public String elegir() {

        Nodo recorre;
        int elegido;
        
        recorre = this.primero;

        elegido = Math.abs((int)System.nanoTime() % cantidad);

        for(int i =0; i < elegido; i++)
            recorre=recorre.sig;    
        
        return recorre.info;
    }

    @Override
    public void sacar(String x) {
        Nodo recorre;
        boolean eliminado= false;
        

        if (primero.info==x){
            primero=primero.sig;
            cantidad--;
            eliminado=true;
        }
        else{
            recorre=primero;
            while(recorre.sig!=null&&eliminado==false){
               if (recorre.sig.info==x){
                    recorre.sig=recorre.sig.sig;
                    eliminado=true;
                    cantidad--;
                }else
                    recorre=recorre.sig;
            }
        }
        
    }

    @Override
    public boolean pertenece(String x) {
        Nodo recorre;

        recorre=primero;

        while(recorre!=null && !recorre.info.equals(x))
            recorre=recorre.sig;

        return recorre!=null;
    }
    

}
