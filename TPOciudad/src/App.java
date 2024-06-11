import algoritmos.metodosCola;
import api.*;
import impl.*;

public class App {

    public static void main(String[] args) throws Exception {
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
    }
}
