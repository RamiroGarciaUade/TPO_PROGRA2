package api;

public interface MapaTDA {
    void InicializarMapa();

    void cargarDatos();

    ColaStringTDA listarProvincias();

    ColaStringTDA listarCiudad();

    void cargarCiudades(String provicia, String ciudad);

    void eliminarCiudades(String provicia, String ciudad);

    void cargarCaminoCiudad(String ciudadOrigen, String ciudadDestino, int km);

    void eliminarCaminoCiudad(String ciudadOrigen, String ciudadDestino);

    ColaStringTDA ciudadesVecinas(String ciudad);

    ColaPrioridadTDA ciudadesPuente(String ciudadOrigen, String ciudadDestino);

    ColaStringTDA ciudadesPredecesoras(String ciudad);

    ColaStringTDA ciudadesExtremo();

    ColaStringTDA ciudadesFuertementeConectadas();

    ColaPrioridadTDA camino(String ciudadOrigen, String ciudadDestino);

}
