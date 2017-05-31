
package calculadoramatrices;

/**
 * Clase que crea un NodoDoble
 *
 * @author Felipe López
 * @version 1.0.0
 * @since CalculadoraMatrices 1.0.0
 */
class NodoDoble {
/**
     * Variables globales de tipo NodoDoble que se utiliza para indicar las ligas
     * del nodo
     *
     * @since CalculadoraMatrices 1.0.0
     */
    private NodoDoble li, ld;
    /**
     * Variable global de tipo Object que se utiliza para almacenar el dato en 
     * el nodo
     *
     * @since CalculadoraMatrices 1.0.0
     */
    private Object dato;
   
/**
     * Crea un nuevo NodoD
     *
     * @param d a almacenar en el nodo
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble(Object d) {
        dato = d;
        ld = null;
        li = null;
    }
/**
     * Método que retorna el dato
     *
     * @return Object objeto con el dato almacenado en el nodo
     * @since CalculadoraMatrices 1.0.0
     */
    public Object retornaDato() {
        return dato;
    }
/**
     * Método que asigna la palabra
     *
     * @param t contiene el dato que será almacenado
     * @since CalculadoraMatrices 1.0.0
     */
    public void asignaDato(Object t) {
        dato = t;
    }
/**
     * Método que asigna el siguiente nodo
     *
     * @param x nodo siguiente
     * @since CalculadoraMatrices 1.0.0
     */
    public void asignaLd(NodoDoble x) {
        ld = x;
    }
 /**
     * Método que asigna el nodo anterior
     *
     * @param x nodo anterior
     * @since CalculadoraMatrices 1.0.0
     */
    public void asignaLi(NodoDoble x) {
        li = x;
    }
 /**
     * Método que retorna el siguiente nodo
     *
     * @return el siguiente nodo
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble retornaLd() {
        return ld;
    }
/**
     * Método que retorna el anterior nodo
     *
     * @return el anterior nodo
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble retornaLi() {
        return li;
    }
}
