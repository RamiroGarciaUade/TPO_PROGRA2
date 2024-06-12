import algoritmos.metodosCola;
import api.*;
import impl.*;

public class App {

    public static void main(String[] args) throws Exception {
        TPOciudadTDA t1 =new TPOciudad();

        // cargando ciudades
        t1.cargarCiudades("Buenos aires", "CABA");
        t1.cargarCiudades("Buenos aires", "Mar de plata");
        t1.cargarCiudades("Buenos aires", "La Plata");
        t1.cargarCiudades("Buenos aires", "Tandil");

        t1.cargarCiudades("Cordoba","Ciudad de Cordoba");
        t1.cargarCiudades("Cordoba","Rio Cuarto");
        t1.cargarCiudades("Cordoba","Villa Carlos Paz");

        t1.cargarCiudades("Salta", "Cafayate");

        t1.cargarCiudades("Chubut", "Rawson");
        t1.cargarCiudades("Chubut", "Trelew");
        t1.cargarCiudades("Chubut", "Puerto Madryn");

        // mostar
        t1.listarCiudad();
        t1.listarProvincias();
        

        //CARGANDO caminos
        t1.cargarCaminoCiudad("CABA", "Mar del Plata", 400);
        t1.cargarCaminoCiudad("CABA", "La Plata", 60);
        t1.cargarCaminoCiudad("CABA", "Tandil", 350);
        t1.cargarCaminoCiudad("CABA", "Ciudad de Cordoba", 1300);

        t1.cargarCaminoCiudad("Mar de plata", "CABA", 500);
        t1.cargarCaminoCiudad("Mar de plata", "Ciudad de Cordoba", 1800);

        t1.cargarCaminoCiudad("La Plata", "Ciudad de Cordoba", 1500);
        t1.cargarCaminoCiudad("La Plata", "Rawson", 2700);

        t1.cargarCaminoCiudad("Tandil", "CABA", 480);

        
        t1.cargarCaminoCiudad("Ciudad de Cordoba", "Rawson", 2800);
        t1.cargarCaminoCiudad("Ciudad de Cordoba", "Río Cuarto", 200);

        t1.cargarCaminoCiudad("Río Cuarto", "Puerto Madryn", 1150);

        t1.cargarCaminoCiudad("Villa Carlos Paz", "Ciudad de Cordoba", 40);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Río Cuarto", 250);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Trelew", 1400);

        t1.cargarCaminoCiudad("Rawson", "Villa Carlos Paz", 1200);
        t1.cargarCaminoCiudad("Rawson", "Cafayate", 2200);
        t1.cargarCaminoCiudad("Rawson ", "Trelew", 20);

        // mostar
        t1.listarCiudad();
        t1.listarProvincias();

        /* 
        DiccionarioProvinciasTDA d1 = new DiccionarioProvinciasDinamico();
        d1.InicializarDiccionarioProvinciasTDA();
        d1.Agregar("Buenos aires","CABA");
        d1.Agregar("Buenos aires","Chacamus");
        d1.Agregar("Buenos aires","Escobar");

        d1.Agregar("Neuquen","San martin de los andes");
        d1.Agregar("Buenos aires","Baliloche");
        d1.Agregar("Buenos aires","CABA");
        d1.Eliminar("Neuquen");
        d1.EliminarValor("Buenos aires", "CABA");
        metodosCola.mostrarProvinciaCiudad(d1);
        */
    }
}
