package api;

public interface DiccionarioProvinciasTDA {
    void InicializarDiccionarioProvinciasTDA () ;
    void Agregar( String clave , String ciudad);
    void Eliminar( String clave);
    void EliminarValor( String clave , String ciudad);
    ColaStringTDA Recuperar( String clave);
    ColaStringTDA Claves();
}
