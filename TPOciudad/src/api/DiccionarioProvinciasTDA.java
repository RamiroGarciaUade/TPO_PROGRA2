package api;

public interface DiccionarioProvinciasTDA {
    void InicializarDiccionarioProvinciasTDA () ;
    // siempre que el diccionario est´e inicializado  conjunto de valores, pero esos valores no se pueden repetir.
    void Agregar( String clave , String ciudad);
    // siempre que el diccionario est´e inicializado
    void Eliminar( String clave);
    // siempre que el diccionario est´e inicializado
    void EliminarValor( String clave , String ciudad);
    // siempre que el diccionario est´e inicializado eliminar el valor, la clave no tiene otros valores asociados se debe eliminar la misma.
    ColaStringTDA Recuperar( String clave);
    // siempre que el diccionario est´e inicializado
    ColaStringTDA Claves();
}
