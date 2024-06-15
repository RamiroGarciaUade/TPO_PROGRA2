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
    public void eliminarCaminoCiudad(String ciudadOrigen , String ciudadDestino){
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

     // De. Precondición que las ciudades origen y destino pertenezcan.
    public ColaPrioridadTDA ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
 
        ColaStringTDA vecinos = new ColaStringDinamica();
        ColaStringTDA todasLasCiudades = new ColaStringDinamica();
        ColaPrioridadTDA puentes = new ColaPrioridadDinamica();

        vecinos.InicializarCola();
        todasLasCiudades.InicializarCola();
        puentes.inicializarCola();

        todasLasCiudades=mapa.Vertices();
        
        while (!todasLasCiudades.ColaVacia()) {
            String ciudadPuente = todasLasCiudades.Primero();
            if (mapa.ExisteArista(ciudadOrigen, ciudadPuente) && mapa.ExisteArista(ciudadPuente, ciudadDestino))
                puentes.acolarPrioridad(mapa.PesoArista(ciudadOrigen, ciudadPuente)+mapa.PesoArista(ciudadPuente, ciudadDestino), ciudadPuente);
            
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
        String ciudad;
        //boolean tieneAristas = false;
        ColaStringTDA vecinos;
        boolean esExtremo = true;
        ColaStringTDA ciudadesExtremo= new ColaStringDinamica();

        ciudadesExtremo.InicializarCola();

        while (!todasLasCiudades.ColaVacia()) {
            esExtremo=true;
            ciudad = todasLasCiudades.Primero();
            vecinos = mapa.Vertices();
            while (!vecinos.ColaVacia()) {
      
                if (mapa.ExisteArista(ciudad, vecinos.Primero())) 
                    esExtremo = false; // La ciudad tiene al menos una arista saliente
                
                vecinos.Desacolar();
            }

            if (esExtremo) 
                ciudadesExtremo.Acolar(ciudad);
            
            todasLasCiudades.Desacolar();
            
        }
        return ciudadesExtremo;

    } 
    
    public ColaStringTDA ciudadesFuertementeConectadas(){
        ColaStringTDA ciudades = new ColaStringDinamica();
        ColaStringTDA ciudades2 = new ColaStringDinamica();
        ColaStringTDA ciudadesFuertes = new ColaStringDinamica();

        ciudades.InicializarCola();
        ciudadesFuertes.InicializarCola();
        ciudades=mapa.Vertices();

        while(!ciudades.ColaVacia()){
            metodosCola.copiarCola(ciudades,ciudades2);
            while (!ciudades2.ColaVacia()) {
                if(mapa.ExisteArista(ciudades.Primero(), ciudades2.Primero())&& mapa.ExisteArista(ciudades2.Primero(), ciudades.Primero())){
                    ciudadesFuertes.Acolar(ciudades.Primero());
                }
                ciudades2.Desacolar();
            }
            ciudades.Desacolar();
        }
        return ciudadesFuertes;
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    
    public void camino(String ciudadOrigen , String ciudadDestino){

        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
   
}
