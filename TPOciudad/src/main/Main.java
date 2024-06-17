package main;

import api.MapaTDA;
import impl.Mapa;
import metodos.metodosCola;

public class Main {

    public static void main(String[] args) throws Exception {

        MapaTDA t1 = new Mapa();

        // Inicializar el mapa
        t1.InicializarMapa();

        // Cargar datos (ciudades y caminos)
        t1.cargarDatos();

        // Listar todas las provincias y ciudades
        System.out.println("----------Ciudades y Provincias después de cargar datos----------");
        System.out.println("----------Ciudades----------");
        metodosCola.mostrarCola(t1.listarCiudad());
        System.out.println("----------Provincias----------");
        metodosCola.mostrarCola(t1.listarProvincias());

        // Métodos agregados
        System.out.println("----------Ciudades Vecinas de CABA----------");
        metodosCola.mostrarCola(t1.ciudadesVecinas("CABA"));

        System.out.println("----------Ciudades Puente entre CABA y Trelew----------");
        metodosCola.mostrarCiudadesColaPrioridad(t1.ciudadesPuente("CABA", "Trelew"));

        System.out.println("----------Ciudades Predecesoras de Rawson----------");
        metodosCola.mostrarCola(t1.ciudadesPredecesoras("Rawson"));

        System.out.println("----------Ciudades Extremo----------");
        metodosCola.mostrarCola(t1.ciudadesExtremo());

        System.out.println("----------Ciudades Fuertemente Conectadas----------");
        metodosCola.mostrarCola(t1.ciudadesFuertementeConectadas());

        // Método para buscar camino entre dos ciudades
        System.out.println("----------Camino entre CABA y Ciudad de Córdoba----------");
        metodosCola.mostrarCiudadesColaPrioridad(t1.camino("CABA", "Ciudad de Córdoba"));

        // Métodos de eliminación
        System.out.println("----------Eliminando ciudad Tandil de Buenos Aires----------");
        t1.eliminarCiudades("Buenos Aires", "Tandil");
        System.out.println("----------Ciudades después de eliminar Tandil----------");
        metodosCola.mostrarCola(t1.listarCiudad());

        System.out.println("----------Eliminando camino entre CABA y La Plata----------");
        t1.eliminarCaminoCiudad("CABA", "La Plata");
        System.out.println("----------Ciudades vecinas de CABA después de eliminar el camino a La Plata----------");
        metodosCola.mostrarCola(t1.ciudadesVecinas("CABA"));
    }
}
