package impl;

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
    }

    // MOSTAR PROVICIAS Y SUS CIUDADES
    public void listarCiudad(){
        metodosCola.mostrarCiudades(diccionario);
    }

    public void cargarCiudades(String provincia, String ciudad) {
        if (grafoCiudad == null) {
            diccionario.InicializarDiccionarioProvinciasTDA();
            grafoCiudad.InicializarGrafo();
        }

        diccionario.Agregar(provincia, ciudad);
        grafoCiudad.AgregarVertice(ciudad);
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
        System.out.println("----------Ciudades vecinas de " + ciudad + ":----------");
        ColaStringTDA vecinos = grafoCiudad.Vertices();
        while (!vecinos.ColaVacia()) {
            String ciudadVecina = vecinos.Primero();
            if (grafoCiudad.ExisteArista(ciudad, ciudadVecina) || grafoCiudad.ExisteArista(ciudadVecina, ciudad)) {
                System.out.println(ciudadVecina);
            }
            vecinos.Desacolar();
        }
    }

    public void ciudadesPuente(String ciudadOrigen, String ciudadDestino){
        System.out.println("----------Ciudades puente entre " + ciudadOrigen + " y " + ciudadDestino + ":----------");
        ColaStringTDA todasLasCiudades = grafoCiudad.Vertices();
        while (!todasLasCiudades.ColaVacia()) {
            String ciudadPuente = todasLasCiudades.Primero();
            if (grafoCiudad.ExisteArista(ciudadOrigen, ciudadPuente) && grafoCiudad.ExisteArista(ciudadPuente, ciudadDestino)) {
                System.out.println(ciudadPuente);
            }
            todasLasCiudades.Desacolar();
        }
    }

    public void ciudadesPredecesoras(String ciudad){
        System.out.println("----------Ciudades predecesoras de " + ciudad + ":----------");
        ColaStringTDA todasLasCiudades = grafoCiudad.Vertices();
        while (!todasLasCiudades.ColaVacia()) {
            String ciudadPredecesora = todasLasCiudades.Primero();
            if (grafoCiudad.ExisteArista(ciudadPredecesora, ciudad)) {
                System.out.println(ciudadPredecesora);
            }
            todasLasCiudades.Desacolar();
        }
    }

    // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesExtremo(){
        
    }

    // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesFuertementeConectadas(){
        
    }

    // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void camino(String ciudadOrigen , String ciudadDestino){
        
    }
}
