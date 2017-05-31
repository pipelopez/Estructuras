
package calculadoramatrices;

/**
 * Clase que crea una Tripleta
 *
 * @author Felipe López
 * @version 1.0.0
 * @since CalculadoraMatrices 1.0.0
 */
class Tripleta {
    /**
     *Variables de tipo global de tipo entero que representan la fila y la columna de un dato en una matriz
     * 
     * @since CalculadoraMatrices 1.0.0
     */
    private final int fila, columna;
    /**
     * Variable global de tipo objeto que representa el dato a almacenar en la tripleta
     * 
     * @since CalculadoraMatrices 1.0.0
     */
    private Object valor;
    /**
     * Constructor de la clase que asigna los valores correspondientes a una tripleta
     * @param f que representa el valor de la fila
     * @param c que representa el valor de la columna
     * @param v que representa el valor que se almacenará en la tripleta
     * @since CalculadoraMatrices 1.0.0
     */
    public Tripleta(int f, int c, Object v){
    fila=f;
    columna=c;
    valor=v;
    }
    /**
     * Método que asigna el valor a la tripleta
     * @param v que representa el valor a almacenar en la triplera
     * @since CalculadoraMatrices 1.0.0
     */
    public void asignaValor(Object v){
    valor = v;
    }
    /**
     * Método que retorna el objeto o valor almacenado en una tripleta
     * @return Object con el valor almacenado en la tripleta
     * @since CalculadoraMatrices 1.0.0
     */
    public Object retornaValor(){
    return valor;
    }
    /**
     * Método que retorna el valor de la fila correspondiente a dicha tripleta
     * @return int con el valor de la fila
     * @since CalculadoraMatrices 1.0.0
     */
    public int retornaFila(){
    return fila;
    }
    /**
     * Método que retorna el valor de la columna correspondiente a dicha tripleta
     * @return int con el valor de la columna
     * @since CalculadoraMatrices 1.0.0
     */
    public int retornaColumna(){
    return columna;
    }
}
