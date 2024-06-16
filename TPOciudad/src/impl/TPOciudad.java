package impl;

import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;
import api.GrafoCiudadesTDA;
import api.TPOciudadTDA;

import java.lang.annotation.Retention;

import algoritmos.metodosTPOciudad;

public class TPOciudad implements TPOciudadTDA{

    DiccionarioProvinciasTDA diccionario =new DiccionarioProvinciasDinamico();
    GrafoCiudadesTDA grafoCiudad =new GrafoCiudadesDinamico();

    public void cargarDatos(){
        // cargando ciudades
        cargarCiudades("Buenos aires", "CABA");
        cargarCiudades("Buenos aires", "Mar de plata");
        cargarCiudades("Buenos aires", "La Plata");
        cargarCiudades("Buenos aires", "Tandil");

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

        cargarCaminoCiudad("Mar de plata", "CABA", 500);
        cargarCaminoCiudad("Mar de plata", "Ciudad de Cordoba", 1800);

        cargarCaminoCiudad("La Plata", "Ciudad de Cordoba", 1500);
        cargarCaminoCiudad("La Plata", "Rawson", 2700);

        cargarCaminoCiudad("Tandil", "CABA", 480);

        
        cargarCaminoCiudad("Ciudad de Cordoba", "Rawson", 2800);
        cargarCaminoCiudad("Ciudad de Cordoba", "Río Cuarto", 200);

        cargarCaminoCiudad("Rio Cuarto", "Puerto Madryn", 1150);

        cargarCaminoCiudad("Villa Carlos Paz", "Ciudad de Cordoba", 40);
        cargarCaminoCiudad("Villa Carlos Paz", "Rio Cuarto", 250);
        cargarCaminoCiudad("Villa Carlos Paz", "Trelew", 1400);

        cargarCaminoCiudad("Rawson", "Villa Carlos Paz", 1200);
        cargarCaminoCiudad("Rawson", "Cafayate", 2200);
        /* 
        cargarCaminoCiudad("Rawson ", "Trelew", 20);
        */
    }

    public void  listarProvincias() { // ? andara?
        ColaStringTDA colaProvincias= diccionario.Claves();
        
        while (!colaProvincias.ColaVacia()) {
            ColaStringTDA colaCiudad= diccionario.Recuperar(colaProvincias.Primero());
            System.out.println("----------PROVINCIA----------");
            System.out.println(colaProvincias.Primero());
            System.out.println("----------CIUDADES DE LA PROVINCIA----------");
            metodosTPOciudad.mostrarCola(colaCiudad);
            colaProvincias.DesAcoplar();
        }
        System.out.println("--------------------------");
    } // MOSTAR PROVICIAS Y SUS CIUDADES
    public void listarCiudad(){
        ColaStringTDA colaProvincias= diccionario.Claves();
        System.out.println("----------CIUDADES----------");
        while (!colaProvincias.ColaVacia()) {
            ColaStringTDA colaCiudad= diccionario.Recuperar(colaProvincias.Primero());
            metodosTPOciudad.mostrarCola(colaCiudad);
            colaProvincias.DesAcoplar();
        }
        System.out.println("--------------------------");
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
    public void ciudadesVecinas(String ciudad){ // !
        ColaStringTDA c1 = grafoCiudad.Vertices();
        boolean estado=false;
        System.out.println("----------CIUDADES VECINAS DE "+ciudad+"----------");
        while (!c1.ColaVacia()) {
            if (ciudad != c1.Primero()) {
                if (grafoCiudad.ExisteArista(ciudad, c1.Primero()) || grafoCiudad.ExisteArista(c1.Primero(), ciudad)) {
                    System.out.println(c1.Primero());
                    estado=true;
                }
            }
            c1.DesAcoplar();
        }
        if (estado == false) {
            System.out.println("No hay ciudad vecinas en la ciudad "+ciudad);
        }

    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesPuente(String ciudadOrigen , String ciudadDestino){
        
    }
    public void ciudadesPredecesoras (String ciudad){
        
    }// MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesExtremo(){
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void ciudadesFuertementeConectadas(){ // ? andara
        System.out.println("----------CIUDADES FUERTEMENTE CONECTADAS----------");
        ColaStringTDA c1 = grafoCiudad.Vertices();
        boolean estado=false;
        while (!c1.ColaVacia()) {
            ColaStringTDA c2 = grafoCiudad.Vertices();
            while (!c2.ColaVacia()) {
                if (grafoCiudad.ExisteArista(c2.Primero(), c1.Primero()) && grafoCiudad.ExisteArista(c1.Primero() , c2.Primero())) {
                    System.out.println("La ciudad " +c1.Primero()+ " esta fuertemente conectado con la ciudad " + c2.Primero());
                    estado=true;
                }
                c2.DesAcoplar();
            }
            c1.DesAcoplar();
        }
        if (estado == false) {
            System.out.println("No hay ciudad fuertemente conectado");
        }
        
    } // MOSTRAR LAS CIUDADES QUE CUMPLA LA CONDICION
    public void camino(String ciudadOrigen , String ciudadDestino){
        
    } // MOSTRAR LOS KM RECORRIDOS Y LAS CIUDADES PUENTES DE A VER
}
