package metodos;



import api.ColaPrioridadTDA;
import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;

import impl.ColaStringDinamica;



// CREAR METODO DE PASA UNA COLA A PILA PARA NO REPETIR CODIGO

public class metodosCola {


    public static void pasarCola(ColaStringTDA cola1 , ColaStringTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.Desacolar();
        }
        while (!cola1.ColaVacia()) {
            cola2.Acolar(cola1.Primero());
            cola1.Desacolar();
        }
    }

    public static void copiarCola(ColaStringTDA cola1 , ColaStringTDA cola2){
        while (!cola2.ColaVacia()) {
            cola2.Desacolar();
        }
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        pasarCola(cola1 ,aux);
        while (!aux.ColaVacia()) {
            cola1.Acolar(aux.Primero());
            cola2.Acolar(aux.Primero());
            aux.Desacolar();
        }
    }
    /*Concatena la cola2 en la cola1 */
    public static void concatenarCola(ColaStringTDA cola1, ColaStringTDA cola2){
        ColaStringTDA aux = new ColaStringDinamica();
        copiarCola(cola2,aux);


        while(!aux.ColaVacia()){
            cola1.Acolar(aux.Primero());
            aux.Desacolar();
        }

    }

    public static void mostrarCola(ColaStringTDA cola){
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        while (!cola.ColaVacia()){
            System.out.println(cola.Primero());
            aux.Acolar(cola.Primero());
            cola.Desacolar();
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
            colaProvincias.Desacolar();
        }
        System.out.println("--------------------------");
    }

    public static void mostrarCiudades(DiccionarioProvinciasTDA c1){
        ColaStringTDA colaProvincias= c1.Claves();
        System.out.println("----------CIUDADES----------");
        while (!colaProvincias.ColaVacia()) {
            ColaStringTDA colaCiudad= c1.Recuperar(colaProvincias.Primero());
            metodosCola.mostrarCola(colaCiudad);
            colaProvincias.Desacolar();
        }
        System.out.println("--------------------------");
    }

    public static void mostrarCiudadesColaPrioridad(ColaPrioridadTDA c){
        ColaPrioridadTDA c1=c;
        System.out.println("----------CIUDADES Y SU KM A RECORRER----------");
        while (!c1.esVacia()) {
            System.out.println(c1.tope()+"--"+c1.prioridad()+"KM");
            c1.desacolar();
        }
        System.out.println("--------------------------");
    }

    

}
