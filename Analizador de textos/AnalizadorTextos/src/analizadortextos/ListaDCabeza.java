package analizadortextos;

/**
 * Clase que realiza diversas operaciones sobre un texto almacenado como lista
 * doblemente ligada con nodo cabeza
 *
 * @author Felipe López
 * @version 1.0.0
 * @since AnalizadorTextos 1.0.0
 */
public class ListaDCabeza {

    /**
     * Variable global de tipo NodoD que se utiliza para realizar operaciones
     * dentro de la lista de palabras
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD aux = new NodoD();
    /**
     * Variable global de tipo NodoD que se utiliza para indicar cuál es la
     * cabeza de la lista de palabras
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD cabeza;
    /**
     * Variable global de tipo NodoD que se utiliza para indicar cuál es la
     * primer palabra de la lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD primero;
    /**
     * Variable global de tipo NodoD que se utiliza para indicar cuál es la
     * ultima palabra de la lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    private NodoD ultimo;
    /**
     * Arrego de tipo String usado para almacenar las preposiciones
     *
     * @since AnalizadorTextos 1.0.0
     */
    final String[] vectorPreposiciones;
    /**
     * Arrego de tipo int usado para almacenar la cantidad de veces que se
     * repiten las preposiciones en la lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    private int[] contador;
    /**
     * Variable de tipo String usado para los retornos de varios métodos
     *
     * @since AnalizadorTextos 1.0.0
     */
    private String textoMostrar = "";

    /**
     * Método que asigna la cabeza a la lista de palabras
     *
     * @param cabeza nodo que representa la cabeza de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaCabeza(NodoD cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * Método que asigna el primer nodo a la lista de palabras
     *
     * @param primero nodo que representa la primer palabra de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaPrimero(NodoD primero) {
        this.primero = primero;
    }

    /**
     * Método que asigna el último nodo a la lista de palabras
     *
     * @param ultimo nodo que representa la primer palabra de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public void asignaUltimo(NodoD ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Método que retora la cabeza de la lista de palabras
     *
     * @return el nodo que representa la caebeza de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD retornaCabeza() {
        return cabeza;
    }

    /**
     * Método que retora el primer nodo de la lista de palabras
     *
     * @return el primer nodo de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD retornaPrimero() {
        return primero;
    }

    /**
     * Método que retora el último nodo de la lista de palabras
     *
     * @return el último nodo de la lista
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD retornaUltimo() {
        return ultimo;
    }

    /**
     * Constructor para la lista de palabras
     *
     * @since AnalizadorTextos 1.0.0
     */
    public ListaDCabeza() {
        this.vectorPreposiciones = new String[]{"a", "ante", "bajo", "cabe", "con", "contra", "de", "desde", "durante", "en", "entre", "hacia", "hasta", "mediante", "para", "por", "según", "sin", "so", "sobre", "tras", "versus", "vía"};
        cabeza = new NodoD();
    }

    /**
     * Método que analiza si la lista es vacía
     *
     * @return valor booleano dependiendo del resultado
     * @since AnalizadorTextos 1.0.0
     */
    public boolean esVacia() {
        boolean vacia = false;
        if (primero == null) {
            vacia = true;
        }
        return vacia;
    }

    /**
     * Método que limpia la lista de palabras
     *
     * @since AnalizadorTextos 1.0.0
     */
    public void limpiarLista() {
        primero = null;
    }

    /**
     * Método que inserta una palabra a la lista
     *
     * @param x String que contiene una palabra
     * @since AnalizadorTextos 1.0.0
     */
    public void insertarPalabra(String x) {
        NodoD nuevo = new NodoD(x);
        if (esVacia() == true) {
            primero = ultimo = nuevo;
            cabeza.asignaSiguiente(primero);
        } else {
            ultimo.asignaSiguiente(nuevo);
            nuevo.asignaAnterior(ultimo);
            ultimo = nuevo;
        }
    }

    /**
     * Método que imprime la lista de palabras
     *
     * @return texto que contiene toda la lista de palabras
     * @since AnalizadorTextos 1.0.0
     */
    public String mostrarLista() {
        textoMostrar = "La nueva lista es la siguiente: \n";
        aux = primero;
        while (aux != null) {
            textoMostrar = textoMostrar + aux.retornaPalabra() + " ";
            aux = aux.retornaSiguiente();
        }
        return textoMostrar;
    }

    /**
     * Método que imprime la lista de preposiciones y el número de veces que se
     * repiten cada una de ellas
     *
     * @return String con la lista de preposiciones
     * @since AnalizadorTextos 1.0.0
     */
    public String mostrarPreposiciones() {
        ListaDCabeza listaPreposiciones = new ListaDCabeza();
        contador = new int[this.vectorPreposiciones.length];
        aux = primero;
        while (aux != null) {
            int i = 0;
            while (i < this.vectorPreposiciones.length) {
                if (this.vectorPreposiciones[i].equalsIgnoreCase(aux.retornaPalabra())) {
                    if (contador[i] == 0) {
                        listaPreposiciones.insertarPalabra(aux.retornaPalabra());
                        contador[i] = contador[i] + 1;
                    } else {
                        contador[i] = contador[i] + 1;
                    }
                }
                i++;
            }
            aux = aux.retornaSiguiente();
        }
        if (listaPreposiciones.esVacia()) {
            textoMostrar = "No hay presposiciones en la lista.";
        } else {
            textoMostrar = listaPreposiciones.mostrarLista() + "\n";
        }
        aux = listaPreposiciones.primero;
        while (aux != null) {
            int i = 0;
            while (i < this.vectorPreposiciones.length) {
                if (this.vectorPreposiciones[i].equalsIgnoreCase(aux.retornaPalabra())) {
                    textoMostrar = textoMostrar + "La preposición " + "\"" + aux.retornaPalabra() + "\"" + " está un número de veces igual a: " + contador[i] + "\n";
                }
                i++;
            }
            aux = aux.retornaSiguiente();
        }
        return textoMostrar;
    }

    /**
     * Método que elimina una palabra e imprime la lista luego de realizar la
     * operación de eliminación
     *
     * @param palabra String que contiene la palabra que se sitúa justo luego de
     * la que se va a eliminar
     * @return la lista luego del resultado de la eliminación
     * @since AnalizadorTextos 1.0.0
     */
    public String eliminarPalabra(String palabra) {
        aux = buscar(palabra);
        if (aux != null && aux != primero) {
            if (cabeza.retornaSiguiente().retornaSiguiente() == aux) {
                cabeza.asignaSiguiente(aux);
                aux.asignaAnterior(cabeza);
                primero = aux;
                textoMostrar = mostrarLista();
            } else {
                aux.asignaAnterior(aux.retornaAnterior().retornaAnterior());
                aux.retornaAnterior().asignaSiguiente(aux);
                textoMostrar = mostrarLista();
            }
        } else {
            textoMostrar = "La palabra que ingresó no existe o es la primer palabra del texto.";
        }

        return textoMostrar;
    }

    /**
     * Método que busca una palabra en la lista de palabras
     *
     * @param palabra String que contiene la palabra a buscar en la lista
     * @return un nodo con la posición de dicha palabra
     * @since AnalizadorTextos 1.0.0
     */
    public NodoD buscar(String palabra) {
        NodoD z;
        z = primero;
        while (z != null && !z.retornaPalabra().equalsIgnoreCase(palabra)) {
            z = z.retornaSiguiente();
        }
        return z;
    }

    /**
     * Método que imprime la lista de palabras al revés
     *
     * @return String con la lista de palabras en orden inverso
     * @since AnalizadorTextos 1.0.0
     */
    public String textoInverso() {
        textoMostrar = "El orden inverso es el siguiente: \n";
        aux = ultimo;
        while (aux != null) {
            textoMostrar = textoMostrar + aux.retornaPalabra() + " ";
            aux = aux.retornaAnterior();
        }
        return textoMostrar;
    }

    /**
     * Método que que reemplaza una palabra por otra todas las veces que aparece
     * en la lista de palabras
     *
     * @param reemplazar String que contiene la palabra a reemplazar
     * @param con String que contiene la palabra de reemplazo
     * @return String con la lista de palabras luego de realizar la operación
     * @since AnalizadorTextos 1.0.0
     */
    public String sustituirPalabra(String reemplazar, String con) {
        String por = con;
        String palabra = reemplazar;
        aux = buscar(palabra);
        if (aux == null) {
            palabra = "La palabra que quiere reemplazar NO EXISTE en el texto.";
            return palabra;
        } else {
            while (aux != null) {
                aux.asignaPalabra(por);
                aux = buscar(palabra);
            }
        }
        return mostrarLista();
    }

    /**
     * Método que ordena alfabéticamente la lista de palabras
     *
     * @return String con la lista de palabras luego de la operación y la
     * cantidad de veces que se repite cada una de ellas
     * @since AnalizadorTextos 1.0.0
     */
    public String ordenAlfabetico() {
        NodoD comparar = new NodoD();
        aux = primero;
        while (aux != null) {
            comparar = aux.retornaSiguiente();
            while (comparar != null) {
                if (aux.retornaPalabra().toLowerCase().compareTo(comparar.retornaPalabra().toLowerCase()) == 0) {
                    comparar = comparar.retornaSiguiente();
                } else {
                    if (aux.retornaPalabra().toLowerCase().compareTo(comparar.retornaPalabra().toLowerCase()) > 0) {
                        textoMostrar = aux.retornaPalabra();
                        aux.asignaPalabra(comparar.retornaPalabra());
                        comparar.asignaPalabra(textoMostrar);
                        comparar = comparar.retornaSiguiente();
                    } else {
                        comparar = comparar.retornaSiguiente();
                    }
                }
            }
            aux = aux.retornaSiguiente();
        }
        return mostrarLista() + "\n" + contarPalabras();
    }

    /**
     * Método que inserta una palabra en una lista y le asigna un contador
     *
     * @param x String que contiene la palabra que se va a insertar
     * @param i entero que representa la cantidad de veces que se repite la
     * palabra
     * @since AnalizadorTextos 1.0.0
     */
    public void InsertarPalabra(String x, int i) {
        NodoD nuevo = new NodoD(x, i);
        if (esVacia() == true) {
            primero = ultimo = nuevo;
            cabeza.asignaSiguiente(primero);
        } else {
            ultimo.asignaSiguiente(nuevo);
            nuevo.asignaAnterior(ultimo);
            ultimo = nuevo;
        }
    }

    /**
     * Método que cuenta la cantidad de veces que se repite una palabra dentro
     * de la lista
     *
     * @return Sgtring con la cantidad de veces que se repite cada palabra de la
     * lista
     * @since AnalizadorTextos 1.0.0
     */
    public String contarPalabras() {
        aux = primero;
        ListaDCabeza z = new ListaDCabeza();
        NodoD y = new NodoD();
        z.InsertarPalabra(aux.retornaPalabra(), 1);
        y = z.primero;
        int cont = 0;
        aux = aux.retornaSiguiente();
        while (aux != null) {
            while (y != null) {
                if (y.retornaPalabra().equalsIgnoreCase(aux.retornaPalabra())) {
                    y.asignaCont(y.retornaCont() + 1);
                    cont++;
                    y = null;
                } else {
                    y = y.retornaSiguiente();}
            }
            if (cont == 0) {
                z.InsertarPalabra(aux.retornaPalabra(), 1);
            }
            aux = aux.retornaSiguiente();
            cont = 0;
            y = z.primero;
        }
        String palabras = "";
        aux = z.primero;
        while (aux != null) {
            palabras = palabras + "La palabra " + "\"" + aux.retornaPalabra() + "\"" + " se repite un número de veces igual a: " + aux.retornaCont() + "\n";
            aux = aux.retornaSiguiente();
        }
        return palabras;
    }

    /**
     * Método que imprime las palabras tildadas
     *
     * @return String con la lista de palabras tildadas y la cantidad de veces
     * que se repite cada una de ellas en la lista de palabras
     * @since AnalizadorTextos 1.0.0
     */
    public String mostrarTildadas() {
        ListaDCabeza listaTildadas = new ListaDCabeza();
        aux = primero;
        while (aux != null) {
            if (aux.retornaPalabra().matches(".*[ÁÉÍÓÚáéíóú].*")) {
                listaTildadas.insertarPalabra(aux.retornaPalabra());
            }
            aux = aux.retornaSiguiente();
        }
        if (!listaTildadas.esVacia()) {
            textoMostrar = listaTildadas.mostrarLista() + "\n" + listaTildadas.contarPalabras();
        } else {
            textoMostrar = "No hay palabras tildadas dentro de la lista.";
        }
        return textoMostrar;
    }
}
