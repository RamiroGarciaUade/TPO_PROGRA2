package api;

public interface GrafoCiudadesTDA {
    void InicializarGrafo () ;
    // siempre que el grafo este inicializado y no exista el nodo
    void AgregarVertice(String ciudad);
    // siempre que el grafo est´e inicializado y exista el nodo
    void EliminarVertice (String ciudad) ;
    // siempre que el grafo este inicializado
    ColaStringTDA Vertices() ;
    // siempre que el grafo este inicializado , no exista la  arista , pero existan ambos nodos
    void AgregarArista(String ciudadOrigen , String ciudadDestino , int km );
    // siempre que el grafo este inicializado y exista la arista
    void EliminarArista( String ciudadOrigen , String ciudadDestino  );
    // siempre que el grafo este inicializado y existan los nodos
    boolean ExisteArista( String ciudadOrigen , String ciudadDestino );
    // siempre que el grafo este inicializado y exista la arista
    int PesoArista( String ciudadOrigen , String ciudadDestino );
}
