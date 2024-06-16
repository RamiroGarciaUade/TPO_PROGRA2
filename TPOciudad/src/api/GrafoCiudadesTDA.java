package api;

public interface GrafoCiudadesTDA {
    void InicializarGrafo () ;
    void AgregarVertice(String ciudad);
    void EliminarVertice (String ciudad) ;
    ColaStringTDA Vertices() ;
    void AgregarArista(String ciudadOrigen , String ciudadDestino , int km );
    void EliminarArista( String ciudadOrigen , String ciudadDestino  );
    boolean ExisteArista( String ciudadOrigen , String ciudadDestino );
    int PesoArista( String ciudadOrigen , String ciudadDestino );
}
