package api;

public interface ColaPrioridadTDA {

    void inicializarCola();
    void acolarPrioridad(int p, String cadena);
    void desacolar();
    String tope();
    boolean esVacia();
    int prioridad();


}
