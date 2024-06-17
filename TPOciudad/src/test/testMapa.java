package test;

import org.junit.Test;

import api.ColaPrioridadTDA;
import api.ColaStringTDA;
import api.MapaTDA;
import impl.ColaPrioridadDinamica;
import impl.ColaStringDinamica;
import impl.Mapa;
import metodos.metodosCola;

public class testMapa {

    @Test
    public void testCargaMapa() {

        MapaTDA test = new Mapa();
        ColaStringTDA aux_ciudades = new ColaStringDinamica();
        ColaStringTDA aux_provincias = new ColaStringDinamica();

        test.InicializarMapa();

        test.cargarCiudades("BUENOS AIRES", "CABA");

        aux_ciudades = test.listarCiudad();

        assert (aux_ciudades.Primero().equals("CABA"));

        test.cargarCiudades("MENDOZA", "MENDOZA");

        aux_ciudades = test.listarCiudad();

        assert (aux_ciudades.Primero().equals("CABA") || aux_ciudades.Primero().equals("MENDOZA"));

        aux_ciudades.Desacolar();

        assert (aux_ciudades.Primero().equals("CABA") || aux_ciudades.Primero().equals("MENDOZA"));

        aux_provincias = test.listarProvincias();

        assert (aux_provincias.Primero().equals("BUENOS AIRES") || aux_provincias.Primero().equals("MENDOZA"));

        aux_ciudades.Desacolar();

        assert (aux_provincias.Primero().equals("BUENOS AIRES") || aux_provincias.Primero().equals("MENDOZA"));

        test.eliminarCiudades("BUENOS AIRES", "CABA");

        aux_ciudades = test.listarCiudad();

        assert (aux_ciudades.Primero().equals("MENDOZA"));

        assert (!aux_ciudades.Primero().equals("CABA"));

        test.eliminarCiudades("MENDOZA", "MENDOZA");

        aux_ciudades = test.listarCiudad();

        assert (aux_ciudades.ColaVacia());

    }

    @Test
    public void testCargaAristas() {
        MapaTDA test = new Mapa();
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        test.InicializarMapa();

        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES", "LANUS");
        test.cargarCiudades("BUENOS AIRES", "LA PLATA");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");
        test.cargarCiudades("CATAMARCA", "BELEN");

        test.cargarCaminoCiudad("CABA", "LANUS", 14);
        test.cargarCaminoCiudad("LA PLATA", "CORDOBA", 1500);
        test.cargarCaminoCiudad("TRELEW", "LA PLATA", 2000);

        aux = test.ciudadesVecinas("CABA");

        assert ((aux.Primero().equals("LANUS")));

        aux = test.ciudadesVecinas("LANUS");

        assert ((aux.Primero().equals("CABA")));

        aux = test.ciudadesVecinas("CORDOBA");

        assert (aux.Primero().equals("LA PLATA"));

        aux = test.ciudadesVecinas("LA PLATA");

        assert (aux.Primero().equals("TRELEW") || aux.Primero().equals("CORDOBA"));

        aux = test.ciudadesVecinas("BELEN");

        assert (aux.ColaVacia());

        test.eliminarCaminoCiudad("CABA", "LANUS");

        aux = test.ciudadesVecinas("CABA");

        assert (aux.ColaVacia());

        test.eliminarCaminoCiudad("LA PLATA", "CORDOBA");

        aux = test.ciudadesVecinas("LA PLATA");

        assert (aux.Primero().equals("TRELEW"));

        test.eliminarCaminoCiudad("TRELEW", "LA PLATA");

        aux = test.ciudadesVecinas("LA PLATA");

        assert (aux.ColaVacia());

    }

    @Test
    public void ciudades_predecesoras() {

        MapaTDA test = new Mapa();
        ColaStringTDA cola_aux = new ColaStringDinamica();

        test.InicializarMapa();
        cola_aux.InicializarCola();

        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES", "LANUS");
        test.cargarCiudades("CATAMARCA", "BELEN");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");
        test.cargarCiudades("FORMOSA", "FORMOSA");

        test.cargarCaminoCiudad("CABA", "TRELEW", 1200);
        test.cargarCaminoCiudad("TRELEW", "CORDOBA", 2000);
        test.cargarCaminoCiudad("CORDOBA", "BELEN", 1200);
        test.cargarCaminoCiudad("CABA", "LANUS", 1200);
        test.cargarCaminoCiudad("LANUS", "CORDOBA", 1200);

        cola_aux = test.ciudadesPredecesoras("CORDOBA");
        assert (cola_aux.Primero().equals("TRELEW") || cola_aux.Primero().equals("LANUS"));
        cola_aux.Desacolar();
        assert (cola_aux.Primero().equals("LANUS"));
        cola_aux = test.ciudadesPredecesoras("TRELEW");
        assert (cola_aux.Primero().equals("CABA"));
        cola_aux = test.ciudadesPredecesoras("FORMOSA");
        assert (cola_aux.ColaVacia());

    }

    @Test
    public void ciudades_puente(){
        MapaTDA test = new Mapa();
        ColaPrioridadTDA cola_aux = new ColaPrioridadDinamica();

        test.InicializarMapa();
        cola_aux.inicializarCola();

        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES","LANUS");
        test.cargarCiudades("CATAMARCA", "BELEN");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");
        test.cargarCiudades("FORMOSA", "FORMOSA");

        test.cargarCaminoCiudad("CABA", "TRELEW", 1200);
        test.cargarCaminoCiudad("TRELEW", "CORDOBA", 2000);
        test.cargarCaminoCiudad("CORDOBA", "BELEN", 1200);
        test.cargarCaminoCiudad("CABA", "LANUS", 1200);
        test.cargarCaminoCiudad("LANUS", "CORDOBA", 1200);
    
        cola_aux=test.ciudadesPuente("CABA", "CORDOBA");

        assert(cola_aux.prioridad()==2400);//Distancia por camino Puente Lanus Ordena de menor a mayor

        assert(cola_aux.tope().equals("LANUS"));

        cola_aux.desacolar();

        assert(cola_aux.prioridad()==3200);

        assert(cola_aux.tope().equals("TRELEW"));

        cola_aux.desacolar();

        assert(cola_aux.esVacia());

        cola_aux=test.ciudadesPuente("CORDOBA", "CABA");

        assert(cola_aux.esVacia());
    
    }
    @Test
    public void ciudades_extremo(){
        MapaTDA test = new Mapa();
        ColaStringTDA cola_aux = new ColaStringDinamica();

        test.InicializarMapa();
        cola_aux.InicializarCola();

        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES","LANUS");
        test.cargarCiudades("CATAMARCA", "BELEN");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");
       

        test.cargarCaminoCiudad("CABA", "TRELEW", 1200);
        test.cargarCaminoCiudad("TRELEW", "CORDOBA", 2000);
        test.cargarCaminoCiudad("CORDOBA", "BELEN", 1200);
        test.cargarCaminoCiudad("CABA", "LANUS", 1200);
        test.cargarCaminoCiudad("LANUS", "CORDOBA", 1200);
        
        
        cola_aux = test.ciudadesExtremo();

        assert(cola_aux.Primero().equals("BELEN"));

        cola_aux.Desacolar();

        assert(cola_aux.ColaVacia());
        
        
        test.cargarCiudades("FORMOSA", "FORMOSA");
        test.cargarCaminoCiudad("CABA", "FORMOSA", 3000);


        cola_aux = test.ciudadesExtremo();

        assert(cola_aux.Primero().equals("BELEN")||cola_aux.Primero().equals("FORMOSA"));

        cola_aux.Desacolar();

        assert(cola_aux.Primero().equals("BELEN")||cola_aux.Primero().equals("FORMOSA"));

        cola_aux.Desacolar();

        assert(cola_aux.ColaVacia());
   
    }

    @Test
    public void ciudades_fuertemente_conectadas(){
        MapaTDA test = new Mapa();
        ColaStringTDA cola_aux = new ColaStringDinamica();

        test.InicializarMapa();
        cola_aux.InicializarCola();

        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES","LANUS");
        test.cargarCiudades("CATAMARCA", "BELEN");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");

        test.cargarCaminoCiudad("CABA", "TRELEW", 1200);
        test.cargarCaminoCiudad("TRELEW", "CORDOBA", 2000);
        test.cargarCaminoCiudad("TRELEW", "CABA", 1200);
        test.cargarCaminoCiudad("CABA", "LANUS", 1200);
        test.cargarCaminoCiudad("LANUS", "CABA", 1200);
        test.cargarCaminoCiudad("LANUS", "CORDOBA", 800);

        cola_aux = test.ciudadesFuertementeConectadas();
        assert(cola_aux.Primero().equals("LANUS")||cola_aux.Primero().equals("CABA")||cola_aux.Primero().equals("TRELEW"));
        cola_aux.Desacolar();
        assert(cola_aux.Primero().equals("LANUS")||cola_aux.Primero().equals("CABA")||cola_aux.Primero().equals("TRELEW"));
        assert(!cola_aux.ColaVacia());
        cola_aux.Desacolar();
        assert(cola_aux.Primero().equals("LANUS")||cola_aux.Primero().equals("CABA")||cola_aux.Primero().equals("TRELEW"));
        cola_aux.Desacolar();
        assert(cola_aux.ColaVacia());

    }

    @Test
    public void camino(){
        MapaTDA test = new Mapa();
        ColaPrioridadTDA cola_aux = new ColaPrioridadDinamica();

        test.InicializarMapa();
        cola_aux.inicializarCola();
        test.cargarCiudades("BUENOS AIRES", "CABA");
        test.cargarCiudades("BUENOS AIRES","LANUS");
        test.cargarCiudades("CATAMARCA", "BELEN");
        test.cargarCiudades("CORDOBA", "CORDOBA");
        test.cargarCiudades("CHUBUT", "TRELEW");
        test.cargarCiudades("FORMOSA", "FORMOSA");

        test.cargarCaminoCiudad("CABA", "TRELEW", 1200);
        test.cargarCaminoCiudad("TRELEW", "CORDOBA", 2000);
        test.cargarCaminoCiudad("CORDOBA", "FORMOSA", 1200);
        test.cargarCaminoCiudad("TRELEW", "FORMOSA", 1200);
        /*test.cargarCaminoCiudad("LANUS", "CABA", 1200);
        test.cargarCaminoCiudad("LANUS", "CORDOBA", 800);
        test.cargarCaminoCiudad("TRELEW","BELEN" , 1500);
        test.cargarCaminoCiudad("BELEN", "FORMOSA", 1500);*/

        cola_aux= test.camino("CABA", "FORMOSA");
        System.out.println(cola_aux.tope());
        metodosCola.mostrarCiudadesColaPrioridad(cola_aux);


       // assert(cola_aux.tope().equals("TRELEW")||cola_aux.tope().equals("CORDOBA"));
    }

}
