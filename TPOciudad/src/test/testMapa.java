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
    


}
