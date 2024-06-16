package impl;

import api.ColaStringTDA;
import api.DiccionarioProvinciasTDA;

public class DiccionarioProvinciasDinamico implements DiccionarioProvinciasTDA{

    class NodoClave{
        String clave;
        NodoValor ciudades; // ? guarda el primer nodo valor?
        NodoClave sigClave;
    }
    class NodoValor{
        String ciudad;
        NodoValor sigValor;
    }

    NodoClave  origen;

    private NodoClave BuscarNodoClave( String clave){
        NodoClave aux = origen;
        while ( aux != null && aux.clave!= clave){
            aux = aux.sigClave;
        }
        return aux ;
    }

    private void EliminarValorEnNodo ( NodoClave nodo , String ciudad){ 
        if ( nodo.ciudades!= null ) {
            if ( nodo.ciudades.ciudad == ciudad) {
                nodo.ciudades = nodo .ciudades.sigValor;
            }
            else {
                NodoValor aux = nodo.ciudades;
                while ( aux . sigValor != null && aux .sigValor.ciudad!= ciudad) {
                    aux = aux.sigValor;
                }
                if ( aux.sigValor!= null ) {
                    aux.sigValor= aux.sigValor.sigValor;
                }
            }
            }
    }

    public void InicializarDiccionarioProvinciasTDA () {
        origen = null;
    }

    public void Agregar( String clave , String ciudad){
        NodoClave nodoClave = BuscarNodoClave(clave);
        if (nodoClave == null) { // Si no esta en los nodos crea nuevo nodo clave para unir a los nodos claves
            nodoClave = new NodoClave();
            nodoClave.clave=clave;
            nodoClave.sigClave= origen; // ?  ORIGEN ESTA VACIO?
            origen=nodoClave;
        }
        NodoValor aux =nodoClave.ciudades;
        while ( aux != null && aux.ciudad!= ciudad) {
            aux = aux.sigValor;
        }
        if ( aux == null ) {
            NodoValor nodoValor = new NodoValor ();
            nodoValor.ciudad = ciudad;
            nodoValor.sigValor = nodoClave.ciudades; // ?  que hace?
            nodoClave.ciudades = nodoValor;
        }
    }
    public void Eliminar( String clave){
        if (origen != null) {
            if (origen.clave == clave) {
                origen=origen.sigClave;
            }
            else{
                NodoClave aux = origen;
                while (aux.sigClave != null && aux.sigClave.clave != clave) {
                    aux= aux.sigClave;
                }
                if (aux.sigClave != null) {
                    aux.sigClave=aux.sigClave.sigClave;
                }
            }
        }
    }

    public void EliminarValor( String clave , String ciudad){
        if ( origen!=null ) {
            if ( origen. clave == clave) {
                EliminarValorEnNodo ( origen , ciudad);
                if ( origen. ciudades == null ) {
                    origen = origen. sigClave;
                }
            }
            else {
                NodoClave aux = origen;
                while ( aux . sigClave != null && aux . sigClave. clave != clave) {
                    aux = aux.sigClave;
                }
                if ( aux . sigClave!= null ) {
                    EliminarValorEnNodo ( aux . sigClave , ciudad);
                    if ( aux . sigClave. ciudades==null ) {
                        aux . sigClave= aux . sigClave. sigClave;
                    }
                }
            }
        }
    }

    public ColaStringTDA Recuperar( String clave ){
        NodoClave n = BuscarNodoClave( clave) ;
        ColaStringTDA c = new ColaStringDinamica() ;
        c.InicializarCola(); ;
        if ( n!= null ) {
            NodoValor aux = n. ciudades;
            while ( aux != null ) {
                c.Acolar( aux. ciudad);
                aux = aux.sigValor;
            }
        }
        return c;
    }

    public  ColaStringTDA Claves(){
        NodoClave aux = origen;
        ColaStringTDA c = new ColaStringDinamica() ;
        c.InicializarCola();
        if ( aux!= null ) {
            while ( aux != null ) {
                c.Acolar( aux.clave);
                aux = aux.sigClave;
            }
        }
        return c;
    }

}
