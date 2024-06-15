package api;

public interface MapaTDA {
    void InicializarMapa();
    ColaStringTDA listarProvincias(); // MOSTAR PROVICIAS Y SUS CIUDADES
    ColaStringTDA listarCiudad(); // MOSTAR CIUDADES DE UNA PROVICIA
    void cargarCiudades(String provicia , String ciudad);
    void eliminarCiudades(String provicia , String ciudad);
    void cargarCaminoCiudad(String ciudadOrigen , String ciudadDestino , int km);
    void eliminarCaminoCiudad(String ciudadOrigen , String ciudadDestino);
    ColaStringTDA ciudadesVecinas(String ciudad); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaStringTDA ciudadesPuente(String ciudadOrigen , String ciudadDestino); 
    ColaStringTDA ciudadesPredecesoras (String ciudad);// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaStringTDA ciudadesExtremo(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    ColaStringTDA ciudadesFuertementeConectadas(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    void camino(String ciudadOrigen , String ciudadDestino); // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
