
import api.*;
import impl.*;
import metodos.metodosCola;

public class App {

    public static void main(String[] args) throws Exception {
        MapaTDA t1 =new Mapa();
        ColaStringTDA aux = new ColaStringDinamica();

        aux.InicializarCola();
        // cargando ciudades
        t1.cargarCiudades("Buenos aires", "CABA");
        
        /* 
        aux=t1.listarCiudad();

        assert(aux.Primero().equals("CABA"));
        
        t1.eliminarCiudades("Buenos aires", "CABA");
        
        assert(!aux.Primero().equals("CABA"));

        t1.cargarCiudades("Buenos aires", "CABA");

        assert(aux.Primero().equals("Mar del Plata"));
        */
        
        t1.cargarCiudades("Buenos aires", "La Plata");
        t1.cargarCiudades("Buenos aires", "Mar del Plata");
        t1.cargarCiudades("Buenos aires", "Tandil");

        t1.cargarCiudades("Cordoba","Ciudad de Cordoba");
        t1.cargarCiudades("Cordoba","Rio Cuarto");
        t1.cargarCiudades("Cordoba","Villa Carlos Paz");

        t1.cargarCiudades("Salta", "Cafayate");

        t1.cargarCiudades("Chubut", "Rawson");
        t1.cargarCiudades("Chubut", "Trelew");
        t1.cargarCiudades("Chubut", "Puerto Madryn");
        

        //CARGANDO caminos
        t1.cargarCaminoCiudad("CABA", "Mar del Plata", 400);
        t1.cargarCaminoCiudad("CABA", "La Plata", 60);
        t1.cargarCaminoCiudad("CABA", "Tandil", 350);
        t1.cargarCaminoCiudad("CABA", "Ciudad de Cordoba", 1300);

        t1.cargarCaminoCiudad("Mar del Plata", "CABA", 500);
        t1.cargarCaminoCiudad("Mar del Plata", "Ciudad de Cordoba", 1800);

        t1.cargarCaminoCiudad("La Plata", "Ciudad de Cordoba", 1500);
        t1.cargarCaminoCiudad("La Plata", "Rawson", 2700);

        t1.cargarCaminoCiudad("Tandil", "CABA", 480);

        
        t1.cargarCaminoCiudad("Ciudad de Cordoba", "Rawson", 2800);
        t1.cargarCaminoCiudad("Ciudad de Cordoba", "Rio Cuarto", 200);

        t1.cargarCaminoCiudad("Rio Cuarto", "Puerto Madryn", 1150);

        t1.cargarCaminoCiudad("Villa Carlos Paz", "Ciudad de Cordoba", 40);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Rio Cuarto", 250);
        t1.cargarCaminoCiudad("Villa Carlos Paz", "Trelew", 1400);

        t1.cargarCaminoCiudad("Rawson", "Villa Carlos Paz", 1200);
        t1.cargarCaminoCiudad("Rawson", "Cafayate", 2200);
        t1.cargarCaminoCiudad("Rawson", "Trelew", 20);

        // mostar

        metodosCola.mostrarCola(t1.listarCiudad());
        t1.listarProvincias();

        ColaStringTDA a1= t1.ciudadesExtremo();
        metodosCola.mostrarCola(a1);
        System.out.println("---//--------///----");
        ColaStringTDA a2= t1.ciudadesVecinas("Ciudad de Cordoba");
        metodosCola.mostrarCola(a2);
        System.out.println("---//--------///----");
        ColaStringTDA a3= t1.ciudadesFuertementeConectadas();
        metodosCola.mostrarCola(a3);
        System.out.println("---//--------///----");
        ColaStringTDA a4= t1.ciudadesPredecesoras("CABA");
        metodosCola.mostrarCola(a4);
        System.out.println("---//--------///----");
        ColaPrioridadTDA a5= t1.ciudadesPuente("CABA", "Ciudad de Cordoba");
        metodosCola.mostrarCiudadesColaPrioridad(a5);
        ColaPrioridadTDA a6 = t1.camino("CABA","Ciudad de Cordoba" );
        metodosCola.mostrarCiudadesColaPrioridad(a6);
    }
}
