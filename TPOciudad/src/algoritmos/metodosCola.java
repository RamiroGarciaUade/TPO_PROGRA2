package algoritmos;

import java.util.ArrayList;

import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;
import impl.ColaStringDinamica;
import impl.DiccionarioProvinciasDinamico;


// CREAR METODO DE PASA UNA COLA A PILA PARA NO REPETIR CODIGO

public class metodosCola {


    public static void pasarCola(ColaStringTDA cola1 , ColaStringTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.DesAcoplar();
        }
        while (!cola1.ColaVacia()) {
            cola2.Acoplar(cola1.Primero());
            cola1.DesAcoplar();
        }
    }

    public static void copiarCola(ColaStringTDA cola1 , ColaStringTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.DesAcoplar();
        }
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        pasarCola(cola1 ,aux);
        while (!aux.ColaVacia()) {
            cola1.Acoplar(aux.Primero());
            cola2.Acoplar(aux.Primero());
            aux.DesAcoplar();
        }
    }
    /*Concatena la cola2 en la cola1 */
    public static void concatenarCola(ColaStringTDA cola1, ColaStringTDA cola2){
        ColaStringTDA aux = new ColaStringDinamica();
        copiarCola(cola2,aux);


        while(!aux.ColaVacia()){
            cola1.Acoplar(aux.Primero());
            aux.DesAcoplar();
        }

    }

    public static void mostrarCola(ColaStringTDA cola){
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        while (!cola.ColaVacia()){
            System.out.println(cola.Primero());
            aux.Acoplar(cola.Primero());
            cola.DesAcoplar();
        }
        pasarCola(aux, cola);
    }

    public static void mostrarProvinciaCiudad(DiccionarioProvinciasTDA c1){
        ColaStringTDA colaProvincias= c1.Claves();
        
        while (!colaProvincias.ColaVacia()) {
            ColaStringTDA colaCiudad= c1.Recuperar(colaProvincias.Primero());
            System.out.println("----------PROVINCIA----------");
            System.out.println(colaProvincias.Primero());
            System.out.println("----------CIUDADES DE LA PROVINCIA----------");
            metodosCola.mostrarCola(colaCiudad);
            colaProvincias.DesAcoplar();
        }
        System.out.println("--------------------------");
    }

    public static void mostrarCiudades(DiccionarioProvinciasTDA c1){
        ColaStringTDA colaProvincias= c1.Claves();
        System.out.println("----------CIUDADES----------");
        while (!colaProvincias.ColaVacia()) {
            ColaStringTDA colaCiudad= c1.Recuperar(colaProvincias.Primero());
            metodosCola.mostrarCola(colaCiudad);
            colaProvincias.DesAcoplar();
        }
        System.out.println("--------------------------");
    }
}
