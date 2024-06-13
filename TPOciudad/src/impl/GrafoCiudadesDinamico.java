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
    }  // siempre que el grafo este inicializado y no exista el nodo

    public void AgregarVertice(String ciudad){ // El vertice se inserta al inicio de la lista de nodos
        NodoGrafo aux = new NodoGrafo() ;
        aux . ciudad = ciudad;
        aux . arista = null ;
        aux . sigNodo = origen;
        origen = aux ;
    }  // siempre que el grafo est´e inicializado y exista el nodo

    /*
    * Para agregar una nueva arista al grafo , primero se deben
    * buscar los nodos entre los cuales se va agregar la arista ,
    * y luego se inserta sobre la lista de adyacentes del nodo
    * origen ( en este caso nombrado como v1)
    */
    // siempre que el grafo este inicializado , no exista la  arista , pero existan ambos nodos
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
        // recorre los nodo para devolver el nodo buscado
        NodoGrafo aux = origen;
        while ( aux != null && !aux.ciudad.equals(v) ){
            aux = aux . sigNodo;
        }
        return aux ; 
    }

   
    public  void EliminarVertice (String ciudad) {
        // Se recorre la lista de v´ertices para remover el nodo v y las aristas con este vertice.
        // Distingue el caso que sea el primer nodo
        if ( origen. ciudad == ciudad) {
            origen = origen. sigNodo;
        }
        NodoGrafo aux = origen;
        while ( aux != null ){
            this.EliminarAristaNodo ( aux , ciudad); // remueve de aux todas las aristas hacia v ( osea elemina las arista que apuntaba al nodo eleminado) por  cada nodo que le pases
            if ( aux.sigNodo!= null && aux.sigNodo.ciudad == ciudad) {
                // Si el siguiente nodo de aux es v , lo elimina
                aux.sigNodo = aux.sigNodo.sigNodo;
            }
            aux = aux.sigNodo;
        }
    }

    private void EliminarAristaNodo ( NodoGrafo nodo , String ciudad ){ // elemina la conexion
        NodoArista aux = nodo . arista;
        if ( aux != null ) {
            // Si la arista a eliminar es la primera en
            // la lista de nodos adyacentes
            if ( aux.nodoDestino.ciudad == ciudad){ // mi primera arista tiene  como destino el nodo a sacar? (recorra que cada nodo puede apuntar a otro nodo con solo una arista)
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

    // siempre que el grafo este inicializado y exista la arista
    public void EliminarArista( String ciudadOrigen , String ciudadDestino ){ // ? que hace ?
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen );
        EliminarAristaNodo (n1 , ciudadDestino  );
    }


    public ColaStringTDA Vertices() { // los valores de los nodos en un conjunto
        ColaStringTDA c = new ColaStringDinamica() ;
        c.InicializarCola(); ;
        NodoGrafo aux = origen;
        while ( aux != null ){
            c. Acoplar(aux.ciudad ) ;
            aux = aux . sigNodo;
        }
        return c;
    }

    // siempre que el grafo este inicializado y existan los nodos
    public boolean ExisteArista( String ciudadOrigen , String ciudadDestino ){
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen); // tomas del nodo salida
        NodoArista aux = n1 . arista; // recorres toda la arista del nodo salida para ver si existe una arista apuntando al nodo destino
        while ( aux != null && aux.nodoDestino.ciudad != ciudadDestino ){
            aux = aux.sigArista;
        }
        // Solo si se encontro la arista buscada , aux no es null
        return (aux != null) ;
    }
    // siempre que el grafo este inicializado y exista la arista
    public int PesoArista(String ciudadOrigen , String ciudadDestino){
        NodoGrafo n1 = Vert2Nodo( ciudadOrigen); // tomas del nodo salida
        NodoArista aux = n1 . arista; // recorres toda la arista del nodo salida para ver si existe una arista apuntando al nodo destino
        while ( aux . nodoDestino. ciudad != ciudadDestino){
            aux = aux . sigArista;
        } 
        // Se encontro la arista entre los dos nodos
        return aux . km;
    }

}
