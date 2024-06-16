package api;

public interface ConjuntoTDA {
    void inicializarConjunto();
    boolean conjuntoVacio();
    void agregar(String x);
    String elegir();
    void sacar(String x);
    boolean pertenece(String x);
}
