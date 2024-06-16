package impl;

import api.ColaStringTDA;
import api.GrafoCiudadesTDA;

public class GrafoCiudadesDinamico implements GrafoCiudadesTDA {

    class NodoArista{
        int km; // valor de la arista
        NodoGrafo nodoDestino; // a donde apunta la arista
        NodoArista sigArista; // Cada nodo puede tener varias arista por eso debemos que cada arista a punta a la sigiente arista que puede tener ese nodo
    }
        
    class NodoGrafo{
        String ciudad ; // valor del nodo
        NodoArista arista; // las arista que va a tener
        NodoGrafo sigNodo; // Sig nodo que hay en el l grafo
    }

    NodoGrafo origen;
        
    public void InicializarGrafo () {
        origen=null;
    }

    public void AgregarVertice(String ciudad){
        NodoGrafo aux = new NodoGrafo() ;
        aux . ciudad = ciudad;
        aux . arista = null ;
        aux . sigNodo = origen;
        origen = aux ;
    }

    public void AgregarArista( String ciudadOrigen , String ciudadDestino , int km ){
        // busca los dos nodos
        NodoGrafo n1 = Vert2Nodo(ciudadOrigen);
        NodoGrafo n2 = Vert2Nodo(ciudadDestino);
        // La nueva arista se inserta al inicio de la lista
        // de nodos adyacentes del nodo origen
        NodoArista aux = new NodoArista ();
        aux .km = km ;
        aux.nodoDestino = n2;  // apunta al nodo destino
        aux.sigArista = n1 . arista; // aux apunta a la primera arista  
        n1.arista = aux ; // aux se convierte en la primera arista

    }

    private NodoGrafo Vert2Nodo( String v) {
        NodoGrafo aux = origen;
        while ( aux != null && !aux.ciudad.equals(v) ){
            aux = aux . sigNodo;
        }
        return aux ; 
    }

   
    public  void EliminarVertice (String ciudad) {

        if ( origen. ciudad == ciudad) {
            origen = origen. sigNodo;
        }
        NodoGrafo aux = origen;
        while ( aux != null ){
            this.EliminarAristaNodo ( aux , ciudad);
            if ( aux.sigNodo!= null && aux.sigNodo.ciudad == ciudad) {
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private void EliminarAristaNodo ( NodoGrafo nodo , String ciudad ){ // elemina la conexion
        NodoArista aux = nodo . arista;
        if ( aux != null ) {

            if ( aux.nodoDestino.ciudad == ciudad){
                nodo.arista = aux.sigArista;
            }
            else {
                while ( aux.sigArista!= null && aux.sigArista.nodoDestino.ciudad != ciudad ){
                    aux = aux.sigArista;
                }
                if ( aux.sigArista != null ) {
                    // Quita la referencia a la arista hacia v
                    aux.sigArista = aux.sigArista.sigArista;
                }
            }
        }
    }

    public void EliminarArista( String ciudadOrigen , String ciudadDestino ){ // ? que hace ?
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen );
        EliminarAristaNodo (n1 , ciudadDestino  );
    }


    public ColaStringTDA Vertices() {
        ColaStringTDA c = new ColaStringDinamica() ;
        c.InicializarCola(); ;
        NodoGrafo aux = origen;
        while ( aux != null ){
            c. Acolar(aux.ciudad ) ;
            aux = aux . sigNodo;
        }
        return c;
    }

    public boolean ExisteArista( String ciudadOrigen , String ciudadDestino ){
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen);
        NodoArista aux = n1 . arista;
        while ( aux != null && aux.nodoDestino.ciudad != ciudadDestino ){
            aux = aux.sigArista;
        }
        return (aux != null) ;
    }

    public int PesoArista(String ciudadOrigen , String ciudadDestino){
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen);
        NodoArista aux = n1 . arista;
        while ( aux . nodoDestino. ciudad != ciudadDestino){
            aux = aux . sigArista;
        }
        return aux . km;
    }

}
