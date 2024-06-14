package main;

import api.*;
import impl.*;

public class App {

    public static void main(String[] args) throws Exception {
        MapaTDA t1 = new Mapa();

        // Cargando ciudades
        t1.cargarCiudades("Buenos Aires", "La Plata");
        t1.cargarCiudades("Buenos Aires", "Mar del Plata");
        t1.cargarCiudades("Buenos Aires", "CABA");
        t1.cargarCiudades("Buenos Aires", "Tandil");

        t1.cargarCiudades("Córdoba", "Ciudad de Córdoba");
        t1.cargarCiudades("Córdoba", "Río Cuarto");
        t1.cargarCiudades("Córdoba", "Villa Carlos Paz");

        t1.cargarCiudades("Salta", "Cafayate");

        t1.cargarCiudades("Chubut", "Rawson");
        t1.cargarCiudades("Chubut", "Trelew");
        t1.cargarCiudades("Chubut", "Puerto Madryn");

        // Mostrar ciudades y provincias
        System.out.println("Ciudades y Provincias:");
        t1.listarCiudad();
        t1.listarProvincias();

        // Cargando caminos
        t1.cargarCaminoCiudad("CABA", "Mar del Plata", 400);
        t1.cargarCaminoCiudad("CABA", "La Plata", 60);
        t1.cargarCaminoCiudad("CABA", "Tandil", 350);
        t1.cargarCaminoCiudad("CABA", "Ciudad de Córdoba", 1300);

        t1.cargarCaminoCiudad("Mar del Plata", "CABA", 500);
        t1.cargarCaminoCiudad("Mar del Plata", "Ciudad de Córdoba", 1800);

        t1.cargarCaminoCiudad("La Plata", "Ciudad de Córdoba", 1500);
        t1.cargarCaminoCiudad("La Plata", "Rawson", 2700);

        t1.cargarCaminoCiudad("Tandil", "CABA", 480);

        t1.cargarCaminoCiudad("Ciudad de Córdoba", "Rawson", 2800);
        t1.cargarCaminoCiudad("Ciudad de Córdoba", "Río Cuarto", 200);

        t1.cargarCaminoCiudad("Río Cuarto", "Puerto Madryn", 1150);

        t1.cargarCaminoCiudad("Villa Carlos Paz", "Ciudad de Córdoba", 40);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Río Cuarto", 250);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Trelew", 1400);

        t1.cargarCaminoCiudad("Rawson", "Villa Carlos Paz", 1200);
        t1.cargarCaminoCiudad("Rawson", "Cafayate", 2200);
        t1.cargarCaminoCiudad("Rawson", "Trelew", 20);

        // Mostrar ciudades y provincias después de cargar caminos
        System.out.println("\nCiudades y Provincias después de cargar caminos:");
        t1.listarCiudad();
        t1.listarProvincias();

        // Métodos agregados
        System.out.println("----------Ciudades Vecinas----------");
        t1.ciudadesVecinas("CABA");

        System.out.println("----------Ciudades Puente----------");
        t1.ciudadesPuente("Mar del Plata", "Ciudad de Córdoba");

        System.out.println("----------Ciudades Predecesoras----------");
        t1.ciudadesPredecesoras("Rawson");

        System.out.println("----------Ciudades Extremo----------");
        t1.ciudadesExtremo();

        //t1.ciudadesFuertementeConectadas();

    }
}
