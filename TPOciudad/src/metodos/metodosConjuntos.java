package metodos;

import api.ColaStringTDA;
import api.ConjuntoTDA;
import impl.ColaStringDinamica;

public class metodosConjuntos {

   public static ColaStringTDA conjuntoToCola(ConjuntoTDA conjunto){
        ColaStringTDA cola = new ColaStringDinamica();
        cola.InicializarCola();
        String aux;

        while(!conjunto.conjuntoVacio()){
            cola.Acolar(aux=conjunto.elegir());
            conjunto.sacar(aux);
        }
        return cola;
    }

}
