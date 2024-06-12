package impl;

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
    public void ciudadesVecinas(String ciudad){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
    }
    public void ciudadesPredecesoras (String ciudad){
        
    }// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesExtremo(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesFuertementeConectadas(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void camino(String ciudadOrigen , String ciudadDestino){
        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
