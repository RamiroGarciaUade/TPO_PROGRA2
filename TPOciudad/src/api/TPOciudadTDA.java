package api;

public interface TPOciudadTDA {
    void listarProvincias(); // UN DICCIONARIO MULTIPLE?
    void listarCiudad(); // COLA?
    void cargarCiudades();
    void eliminarCiudades();
    void ciudadesVecinas(); // COLA?
    double ciudadesPuente(); 
    void ciudadesPredecesoras();// COLA?
    void ciudadesExtremo(); // COLA?
    void ciudadesFuertementeConectadas(); // COLA?
    double camino(); 
}
