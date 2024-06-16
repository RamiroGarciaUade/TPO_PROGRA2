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

    public void cargarDatos(){
        cargarCiudades("Buenos aires", "La Plata");
        cargarCiudades("Buenos aires", "Mar del Plata");
        cargarCiudades("Buenos aires", "Tandil");
        cargarCiudades("Buenos aires", "CABA");

        cargarCiudades("Cordoba","Ciudad de Cordoba");
        cargarCiudades("Cordoba","Rio Cuarto");
        cargarCiudades("Cordoba","Villa Carlos Paz");

        cargarCiudades("Salta", "Cafayate");

        cargarCiudades("Chubut", "Rawson");
        cargarCiudades("Chubut", "Trelew");
        cargarCiudades("Chubut", "Puerto Madryn");
        

        //CARGANDO caminos
        cargarCaminoCiudad("CABA", "Mar del Plata", 400);
        cargarCaminoCiudad("CABA", "La Plata", 60);
        cargarCaminoCiudad("CABA", "Tandil", 350);
        cargarCaminoCiudad("CABA", "Ciudad de Cordoba", 1300);

        cargarCaminoCiudad("Mar del Plata", "CABA", 500);
        cargarCaminoCiudad("Mar del Plata", "Ciudad de Cordoba", 1800);

        cargarCaminoCiudad("La Plata", "Ciudad de Cordoba", 1500);
        cargarCaminoCiudad("La Plata", "Rawson", 2700);

        cargarCaminoCiudad("Tandil", "CABA", 480);

        
        cargarCaminoCiudad("Ciudad de Cordoba", "Rawson", 2800);
        cargarCaminoCiudad("Ciudad de Cordoba", "Rio Cuarto", 200);

        cargarCaminoCiudad("Rio Cuarto", "Puerto Madryn", 1150);

        cargarCaminoCiudad("Villa Carlos Paz", "Ciudad de Cordoba", 40);
        cargarCaminoCiudad("Villa Carlos Paz", "Rio Cuarto", 250);
        cargarCaminoCiudad("Villa Carlos Paz", "Trelew", 1400);

        cargarCaminoCiudad("Rawson", "Villa Carlos Paz", 1200);
        cargarCaminoCiudad("Rawson", "Cafayate", 2200);
        cargarCaminoCiudad("Rawson", "Trelew", 20);
    }
    

    public ColaStringTDA listarProvincias() {
        return diccionario.Claves();
        
    } // MOSTAR PROVINCIAS Y SUS CIUDADES
    public ColaStringTDA listarCiudad(){
        return mapa.Vertices();
    }
    public void cargarCiudades(String provicia , String ciudad){
            diccionario.Agregar(provicia, ciudad);
            mapa.AgregarVertice(ciudad);
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
        
        ColaStringTDA todasLasCiudades = new ColaStringDinamica();
        ColaPrioridadTDA puentes = new ColaPrioridadDinamica();

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
    
    public ColaPrioridadTDA camino(String ciudadOrigen , String ciudadDestino){
        ColaStringTDA todasLasCiudades = new ColaStringDinamica();
        ColaPrioridadTDA caminos = new ColaPrioridadDinamica();
        String ciudadPuente;

        todasLasCiudades.InicializarCola();
        caminos.inicializarCola();

        todasLasCiudades=mapa.Vertices();
        
        while (!todasLasCiudades.ColaVacia()) {
            ciudadPuente = todasLasCiudades.Primero();
            if (mapa.ExisteArista(ciudadOrigen, ciudadPuente) && mapa.ExisteArista(ciudadPuente, ciudadDestino))
                caminos.acolarPrioridad(mapa.PesoArista(ciudadOrigen, ciudadPuente)+mapa.PesoArista(ciudadPuente, ciudadDestino), ciudadPuente);
            todasLasCiudades.Desacolar();
        }
        if (mapa.ExisteArista(ciudadOrigen, ciudadDestino))
            caminos.acolarPrioridad(mapa.PesoArista(ciudadOrigen,ciudadDestino), "No tiene ciudad puente");
        return caminos;
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
   
}
