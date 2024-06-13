package impl;

import api.CaminoTDA;
import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;
import api.GrafoCiudadesTDA;
import api.TPOciudadTDA;

import impl.DiccionarioProvinciasDinamico;
import impl.GrafoCiudadesDinamico;
import impl.GrafoCiudadesDinamico.NodoGrafo;
import algoritmos.metodosCola;

public class TPOciudad implements TPOciudadTDA{

    DiccionarioProvinciasTDA diccionario =new DiccionarioProvinciasDinamico();
    GrafoCiudadesTDA grafoCiudad =new GrafoCiudadesDinamico();

    public void listarProvincias() {
        metodosCola.mostrarProvinciaCiudad(diccionario);
    } // MOSTAR PROVICIAS Y SUS CIUDADES
    public void listarCiudad(){
        metodosCola.mostrarCiudades(diccionario);
    }// MOSTAR CIUDADES DE UNA PROVICIA

    public void cargarCiudades(String provicia , String ciudad){
        if (grafoCiudad == null) {
            diccionario.InicializarDiccionarioProvinciasTDA();
            grafoCiudad.InicializarGrafo();

            diccionario.Agregar(provicia, ciudad);
            grafoCiudad.AgregarVertice(ciudad);
        }
        else{
            diccionario.Agregar(provicia, ciudad);
            grafoCiudad.AgregarVertice(ciudad);
        }
    }
    public void cargarCaminoCiudad(String ciudadOrigen , String ciudadDestino , int km){
        grafoCiudad.AgregarArista(ciudadOrigen, ciudadDestino, km);
    }
    

    public void eliminarCiudades(String provicia , String ciudad){
        if (grafoCiudad != null) {
            diccionario.EliminarValor(provicia, ciudad);
            grafoCiudad.EliminarVertice(ciudad);
        }
    }
    public void eleminarCaminoCiudad(String ciudadOrigen , String ciudadDestino){
        if (grafoCiudad.ExisteArista(ciudadOrigen, ciudadDestino)) {
            grafoCiudad.EliminarArista(ciudadOrigen, ciudadDestino);
        }
    }
    public ColaStringTDA ciudadesVecinas(String ciudad){
        
        ColaStringTDA ciudades = new ColaStringDinamica(); 
        ColaStringTDA ciudades_vecinas= new ColaStringDinamica();

        ciudades.InicializarCola();
        ciudades_vecinas.InicializarCola();
        ciudades=grafoCiudad.Vertices();
        
        while(!ciudades.ColaVacia()){
         
            if(grafoCiudad.ExisteArista(ciudades.Primero(), ciudad)){
                ciudades_vecinas.Acoplar(ciudades.Primero());
                ciudades.DesAcoplar();
            }
        
        }
    
        return ciudades_vecinas;
    }

     // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
        
    }
    public ColaStringTDA ciudadesPredecesoras (String ciudad){
        
    }// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public ColaStringTDA ciudadesExtremo(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public ColaStringTDA ciudadesFuertementeConectadas(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public CaminoTDA camino(String ciudadOrigen , String ciudadDestino){
        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
