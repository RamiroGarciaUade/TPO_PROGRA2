package impl;

import api.CaminoTDA;
import api.ColaPrioridadTDA;
import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;
import api.GrafoCiudadesTDA;
import api.MapaTDA;

import impl.DiccionarioProvinciasDinamico;
import impl.GrafoCiudadesDinamico;
import impl.GrafoCiudadesDinamico.NodoGrafo;
import algoritmos.metodosCola;

public class Mapa implements MapaTDA{

    DiccionarioProvinciasTDA diccionario =new DiccionarioProvinciasDinamico();
    GrafoCiudadesTDA mapa =new GrafoCiudadesDinamico();

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
            provincias.DesAcoplar();
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
         
            if(mapa.ExisteArista(ciudades.Primero(), ciudad)){
                ciudades_vecinas.Acoplar(ciudades.Primero());
                ciudades.DesAcoplar();
            }
        
        }
    
        return ciudades_vecinas;
    }

     // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION. Precondición que las ciudades origen y destino pertenezcan.
    public void ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
        ColaPrioridadTDA aux = new ColaPrioridadDinamica();
        ColaStringTDA vecinos = new ColaStringDinamica();

       aux.inicializarCola();

       vecinos = this.ciudadesVecinas(ciudadOrigen);
       
       aux.acolarPrioridad(0, ciudadOrigen);

       

        
    }
    public ColaStringTDA ciudadesPredecesoras (String ciudad){
        ColaStringTDA aux = new ColaStringDinamica();
        ColaStringTDA ciudadesPredecesoras = new ColaStringDinamica();
        aux.InicializarCola();
        ciudadesPredecesoras.InicializarCola();

        aux = mapa.Vertices();

        while(!aux.ColaVacia()){
            if(mapa.ExisteArista(aux.Primero(), ciudad)){
                ciudadesPredecesoras.Acoplar(aux.Primero());
                aux.DesAcoplar();
            }
        
        }
        return ciudadesPredecesoras;

    }// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public ColaStringTDA ciudadesExtremo(){

        ColaStringTDA aux = new ColaStringDinamica();
        ColaStringTDA aux2 = new ColaStringDinamica();
        ColaStringTDA ciudadesExtremo = new ColaStringDinamica();
        aux.InicializarCola();
        aux2.InicializarCola();
        ciudadesExtremo.InicializarCola();
        aux = mapa.Vertices();
        boolean es_extremo= false;


        while(!aux.ColaVacia()){
            aux2=mapa.Vertices();
            while(!aux2.ColaVacia()){
                es_extremo=mapa.ExisteArista(aux.Primero(), aux2.Primero());
                aux2.DesAcoplar();
            }
            if(es_extremo) 
                ciudadesExtremo.Acoplar(aux.Primero());
            aux.DesAcoplar();    
        }

        return ciudadesExtremo;

    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public ColaStringTDA ciudadesFuertementeConectadas(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public CaminoTDA camino(String ciudadOrigen , String ciudadDestino){
        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
    @Override
    public void eliminarCaminoCiudad(String ciudadOrigen, String ciudadDestino) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarCaminoCiudad'");
    }
}
