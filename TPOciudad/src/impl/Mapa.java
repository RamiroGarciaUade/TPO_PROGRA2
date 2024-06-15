package impl;


import api.ColaPrioridadTDA;
import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;
import api.GrafoCiudadesTDA;
import api.MapaTDA;


import metodos.metodosCola;

public class Mapa implements MapaTDA{
    DiccionarioProvinciasTDA diccionario =new DiccionarioProvinciasDinamico();
    GrafoCiudadesTDA mapa =new GrafoCiudadesDinamico();

    
    public void InicializarMapa(){
        diccionario.InicializarDiccionarioProvinciasTDA();
        mapa.InicializarGrafo();
    }

    public ColaStringTDA listarProvincias() {
        ColaStringTDA aux = new ColaStringDinamica();
        aux = diccionario.Claves();
        metodosCola.mostrarProvinciaCiudad(diccionario);
        return aux;
        
    } // MOSTAR PROVINCIAS Y SUS CIUDADES
    public ColaStringTDA listarCiudad(){
        
        ColaStringTDA provincias = new ColaStringDinamica();
        ColaStringTDA ciudades = new ColaStringDinamica();

        provincias.InicializarCola();
        ciudades.InicializarCola();

        provincias=this.listarProvincias();

        while (!provincias.ColaVacia()){
            metodosCola.concatenarCola(ciudades, diccionario.Recuperar(provincias.Primero()));
            provincias.Desacolar();
        }
        
        metodosCola.mostrarCiudades(diccionario);
        return ciudades;
        
    }// MOSTAR CIUDADES DE UNA PROVICIA

    public void cargarCiudades(String provicia , String ciudad){
        if (mapa == null) {
            diccionario.InicializarDiccionarioProvinciasTDA();
            mapa.InicializarGrafo();

            diccionario.Agregar(provicia, ciudad);
            mapa.AgregarVertice(ciudad);
        }
        else{
            diccionario.Agregar(provicia, ciudad);
            mapa.AgregarVertice(ciudad);
        }
    }
    /*Como precondicion es necesario que ambas ciudades esten pre cargadas */
    public void cargarCaminoCiudad(String ciudadOrigen , String ciudadDestino , int km){
        mapa.AgregarArista(ciudadOrigen, ciudadDestino, km);
    }
    

    public void eliminarCiudades(String provicia , String ciudad){
        if (mapa != null) {
            diccionario.EliminarValor(provicia, ciudad);
            mapa.EliminarVertice(ciudad);
        }
    }
    public void eleminarCaminoCiudad(String ciudadOrigen , String ciudadDestino){
        if (mapa.ExisteArista(ciudadOrigen, ciudadDestino)) {
            mapa.EliminarArista(ciudadOrigen, ciudadDestino);
        }
    }
    public ColaStringTDA ciudadesVecinas(String ciudad){
        
        ColaStringTDA ciudades = new ColaStringDinamica(); 
        ColaStringTDA ciudades_vecinas= new ColaStringDinamica();

        ciudades.InicializarCola();
        ciudades_vecinas.InicializarCola();
        ciudades=mapa.Vertices();
        
        while(!ciudades.ColaVacia()){
         
            if(mapa.ExisteArista(ciudad, ciudades.Primero()) || mapa.ExisteArista(ciudades.Primero(), ciudad))
                ciudades_vecinas.Acolar(ciudades.Primero());
                
            ciudades.Desacolar();
        
        }
    
        return ciudades_vecinas;
    }

     // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION. Precondición que las ciudades origen y destino pertenezcan.
    public ColaStringTDA ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
 
        ColaStringTDA vecinos = new ColaStringDinamica();
        ColaStringTDA todasLasCiudades = new ColaStringDinamica();
        ColaStringTDA puentes = new ColaStringDinamica();

        vecinos.InicializarCola();
        todasLasCiudades.InicializarCola();
        puentes.InicializarCola();

        todasLasCiudades=mapa.Vertices();
        
        while (!todasLasCiudades.ColaVacia()) {
            String ciudadPuente = todasLasCiudades.Primero();
            if (mapa.ExisteArista(ciudadOrigen, ciudadPuente) && mapa.ExisteArista(ciudadPuente, ciudadDestino))
                puentes.Acolar(ciudadPuente);
            
            todasLasCiudades.Desacolar();
        }
        
        return puentes;
        
    }
    
    public ColaStringTDA ciudadesPredecesoras (String ciudad){

        ColaStringTDA todasLasCiudades = mapa.Vertices();
        ColaStringTDA ciudadesPredecesoras = new ColaStringDinamica();

        ciudadesPredecesoras.InicializarCola();
        

        while (!todasLasCiudades.ColaVacia()) {
            
            if (mapa.ExisteArista(todasLasCiudades.Primero(), ciudad)) 
                ciudadesPredecesoras.Acolar(todasLasCiudades.Primero());
            todasLasCiudades.Desacolar();
        }
        return ciudadesPredecesoras;

    }// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public ColaStringTDA ciudadesExtremo(){
        
        ColaStringTDA todasLasCiudades = mapa.Vertices();
        String ciudad = todasLasCiudades.Primero();
        boolean tieneAristas = false;
        ColaStringTDA vecinos = mapa.Vertices();
        boolean esExtremo = true;
        ColaStringTDA ciudadesExtremo= new ColaStringDinamica();

        ciudadesExtremo.InicializarCola();

        while (!todasLasCiudades.ColaVacia()) {


            while (!vecinos.ColaVacia()) {
      
                if (mapa.ExisteArista(ciudad, vecinos.Primero())) {
                    tieneAristas = true;
                    esExtremo = false; // La ciudad tiene al menos una arista saliente
                }
                vecinos.Desacolar();
            }

            if (!tieneAristas && esExtremo) 
                ciudadesExtremo.Acolar(ciudad);
            
            todasLasCiudades.Desacolar();
        }
        return ciudadesExtremo;

    } 
    
    public ColaStringTDA ciudadesFuertementeConectadas(){
        ColaStringTDA aux = new ColaStringDinamica();

        return aux;
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    
    public void camino(String ciudadOrigen , String ciudadDestino){

        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
    @Override
    public void eliminarCaminoCiudad(String ciudadOrigen, String ciudadDestino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCaminoCiudad'");
    }
}
