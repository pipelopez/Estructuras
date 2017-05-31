package analizadortextos;

/**
 * Clase que crea un NodoD
 *
 * @author Felipe López
 * @version 1.0.0
 * @since AnalizadorTextos 1.0.0
 */
public class NodoD {

    /**
     * Variable global de tipo String que contiene la palabra que se almacenará
     * en el nodo
     *
     * @since AnalizadorTextos 1.0.0
     */
    private String palabra;
    /**
     * Variable global de tipo int que se utiliza para realizar el conteo de
     * repeticiones de una palabra
     *
     * @since AnalizadorTextos 1.0.0
     */
    private int cont;
    /**
     * Variable global de tipo NodoD que se utiliza para especificar el
     * siguiente nodo en una lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD siguiente;
    /**
     * Variable global de tipo NodoD que se utiliza para especificar el anterior
     * nodo en una lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD anterior;

    /**
     * Crea un nuevo NodoD
     */
    public NodoD() {
    }

    /**
     * Crea un nuevo NodoD
     *
     * @param palabra a almacenar en el nodo
     */
    public NodoD(String palabra) {
        this.palabra = palabra;
        this.anterior = null;
        this.siguiente = null;
    }

    /**
     * Crea un nuevo NodoD
     *
     * @param palabra a almacenar en el nodo
     * @param i contiene la cantidad de repeticiones de la palabra
     */
    public NodoD(String palabra, int i) {
        this.palabra = palabra;
        this.cont = i;
    }

    /**
     * Método que asigna el contador
     *
     * @param cont nodo que representa el contador de repeticiones de una
     * palabra
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaCont(int cont) {
        this.cont = cont;
    }

    /**
     * Método que retorna el contador
     *
     * @return int entero con la cantidad de repeticiones de una palabra
     * @since AnalizadorTextos 1.0.0
     */
    public int retornaCont() {
        return cont;
    }

    /**
     * Método que asigna la palabra
     *
     * @param palabra contiene la palabra que será almacenada
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * Método que retorna la palabra
     *
     * @return la palabra
     * @since AnalizadorTextos 1.0.0
     */
    public String retornaPalabra() {
        return palabra;
    }

    /**
     * Método que asigna el siguiente nodo
     *
     * @param siguiente nodo siguiente
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaSiguiente(NodoD siguiente) {
        this.siguiente = siguiente;
    }

    /**
     * Método que asigna el nodo anterior
     *
     * @param anterior nodo anterior
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaAnterior(NodoD anterior) {
        this.anterior = anterior;
    }

    /**
     * Método que retorna el siguiente nodo
     *
     * @return el siguiente nodo
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD retornaSiguiente() {
        return siguiente;
    }

    /**
     * Método que retorna el anterior nodo
     *
     * @return el anterior nodo
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD retornaAnterior() {
        return anterior;
    }
}
