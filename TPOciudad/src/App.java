
import api.*;
import impl.*;
import metodos.metodosCola;

public class App {

    public static void main(String[] args) throws Exception {
        MapaTDA t1 =new Mapa();
        t1.InicializarMapa();
        t1.cargarDatos();
        t1.listarCiudad();
        t1.listarProvincias();
        
        /* 
        aux=t1.listarCiudad();

        assert(aux.Primero().equals("CABA"));
        
        t1.eliminarCiudades("Buenos aires", "CABA");
        
        assert(!aux.Primero().equals("CABA"));

        t1.cargarCiudades("Buenos aires", "CABA");

        assert(aux.Primero().equals("Mar del Plata"));
        */
        
        

        // mostar

        System.out.println("--=--=--");

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
