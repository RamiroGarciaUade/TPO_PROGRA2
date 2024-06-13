package api;

public interface TPOciudadTDA {
    void cargarDatos();
    void listarProvincias(); // MOSTAR PROVICIAS Y SUS CIUDADES
    void listarCiudad(); // MOSTAR CIUDADES DE UNA PROVICIA
    void cargarCiudades(String provicia , String ciudad);
    void eliminarCiudades(String provicia , String ciudad);
    void cargarCaminoCiudad(String ciudadOrigen , String ciudadDestino , int km);
    void eleminarCaminoCiudad(String ciudadOrigen , String ciudadDestino);
    void ciudadesVecinas(String ciudad); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    void ciudadesPuente(String ciudadOrigen , String ciudadDestino); 
    void ciudadesPredecesoras (String ciudad);// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    void ciudadesExtremo(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    void ciudadesFuertementeConectadas(); // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    void camino(String ciudadOrigen , String ciudadDestino); // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
