package api;

public interface CaminoTDA {
    
    void InicializarCamino();
    void AgregarParada(String ciudad);
    int Distancia();
    ColaStringTDA Recorrido();
    String Origen();
    String Destino();
}
