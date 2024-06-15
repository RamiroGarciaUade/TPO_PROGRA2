package test;
import org.junit.Test;

import api.ColaStringTDA;
import api.MapaTDA;
import impl.ColaStringDinamica;
import impl.Mapa;





public class testMapa {

    @Test
    public void testCargaMapa(){

        MapaTDA test = new Mapa();
        ColaStringTDA aux_ciudades = new ColaStringDinamica();
        ColaStringTDA aux_provincias = new ColaStringDinamica();

        test.InicializarMapa();

        test.cargarCiudades("BUENOS AIRES","CABA");

        aux_ciudades = test.listarCiudad();

        assert(aux_ciudades.Primero().equals("CABA"));

        test.cargarCiudades("MENDOZA", "MENDOZA");

        aux_ciudades= test.listarCiudad();

        assert(aux_ciudades.Primero().equals("CABA")||aux_ciudades.Primero().equals("MENDOZA"));

        aux_ciudades.Desacolar();
        
        assert(aux_ciudades.Primero().equals("CABA")||aux_ciudades.Primero().equals("MENDOZA"));

        aux_provincias= test.listarProvincias();

        assert(aux_provincias.Primero().equals("BUENOS AIRES")||aux_provincias.Primero().equals("MENDOZA"));

        aux_ciudades.Desacolar();
        
        assert(aux_provincias.Primero().equals("BUENOS AIRES")||aux_provincias.Primero().equals("MENDOZA"));

        
        

    }

    @Test
    public void testCargaAristas(){
        MapaTDA test = new Mapa();
        ColaStringTDA aux = new ColaStringDinamica();
        aux.InicializarCola();
        test.InicializarMapa();
        
        test.cargarCiudades("BUENOS AIRES","CABA");
        test.cargarCiudades("BUENOS AIRES","LANUS");
        test.cargarCiudades("BUENOS AIRES","LA PLATA");
        test.cargarCiudades("CORDOBA","CORDOBA");
        test.cargarCiudades("CHUBUT","TRELEW");
        test.cargarCiudades("CATAMARCA","BELEN");

        test.cargarCaminoCiudad("CABA", "LANUS", 14);
        test.cargarCaminoCiudad("LA PLATA", "CORDOBA", 1500);
        test.cargarCaminoCiudad("TRELEW", "LA PLATA", 2000);
        
        aux=test.ciudadesVecinas("CABA");

        assert((aux.Primero().equals("LANUS")));

        aux=test.ciudadesVecinas("LANUS");

        assert((aux.Primero().equals("CABA")));

        aux=test.ciudadesVecinas("CORDOBA");

        assert(aux.Primero().equals("LA PLATA"));

        aux=test.ciudadesVecinas("LA PLATA");
        
        assert(aux.Primero().equals("TRELEW")||aux.Primero().equals("CORDOBA"));

        aux=test.ciudadesVecinas("BELEN");

        assert(aux.ColaVacia());
    
    }



}
