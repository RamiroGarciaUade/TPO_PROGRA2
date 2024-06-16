package api;

public interface MapaTDA {
    void InicializarMapa();
    void cargarDatos();
    void listarProvincias(); // MOSTAR PROVICIAS Y SUS CIUDADES
    void listarCiudad(); // MOSTAR CIUDADES DE UNA PROVICIA
    void cargarCiudades(String provicia , String ciudad);
    void eliminarCiudades(String provicia , String ciudad);
    void cargarCaminoCiudad(String ciudadOrigen , String ciudadDestino , int km);
    void eliminarCaminoCiudad(String ciudadOrigen , String ciudadDestino);
    ColaStringTDA ciudadesVecinas(String ciudad); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaPrioridadTDA ciudadesPuente(String ciudadOrigen , String ciudadDestino); 
    ColaStringTDA ciudadesPredecesoras (String ciudad);// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaStringTDA ciudadesExtremo(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaStringTDA ciudadesFuertementeConectadas(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaPrioridadTDA camino(String ciudadOrigen , String ciudadDestino); // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
