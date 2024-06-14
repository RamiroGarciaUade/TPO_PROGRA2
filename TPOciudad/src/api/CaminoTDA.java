package api;

public interface CaminoTDA {
    
    void InicializarCamino();
    void AgregarParada(String ciudad, int distancia);
    int Distancia();
    ColaStringTDA Recorrido();
    String Origen();
    String Destino();
}
