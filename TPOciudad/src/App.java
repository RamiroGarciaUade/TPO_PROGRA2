import algoritmos.metodosTPOciudad;
import api.*;
import impl.*;

public class App {

    public static void main(String[] args) throws Exception {
        TPOciudadTDA t1 =new TPOciudad();
        t1.cargarDatos();
        t1.listarProvincias();
        t1.listarCiudad();
        t1.ciudadesVecinas("Villa Carlos Paz");
        t1.ciudadesFuertementeConectadas();
    }
}
