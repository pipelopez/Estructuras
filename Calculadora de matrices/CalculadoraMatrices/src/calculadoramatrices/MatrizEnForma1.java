package calculadoramatrices;

/**
 * Clase que crea una MatrizEnForma1
 *
 * @author Felipe López
 * @version 1.0.0
 * @since CalculadoraMatrices 1.0.0
 */
public class MatrizEnForma1 {

    /**
     * Variable global de tipo NodoDoble que se utiliza para definir el nodo
     * cabeza de todos los nodos cabeza
     *
     * @since CalculadoraMatrices 1.0.0
     */
    private final NodoDoble mat;
    /**
     * Variable global de tipo int que se utiliza para realizar definir el total
     * de filas y columnas de la matriz.
     *
     * @since CalculadoraMatrices 1.0.0
     */
    private int m, n;

    /**
     * Constructor de la clase
     *
     * @param i entero que representa el número de filas
     * @param j entero que representa el número de columnas
     * @since CalculadoraMatrices 1.0.0
     */
    public MatrizEnForma1(int i, int j) {
        Tripleta t = new Tripleta(i, j, null);
        mat = new NodoDoble(t);
        t.asignaValor(mat);
        mat.asignaDato(t);
    }

    /**
     * Método que retorna el nodo cabeza de la lista de nodos cabeza
     *
     * @return el nodo cabeza
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble nodoCabeza() {
        return mat;
    }

    /**
     * Método que retorna el nodo cabeza de la lista de nodos cabeza
     *
     * @return el primer nodo cabeza de la MatrizEnForma1
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble primerNodo() {
        Tripleta tp = (Tripleta) mat.retornaDato();
        NodoDoble p = (NodoDoble) tp.retornaValor();
        return p;
    }

    /**
     * Método para saber si la MatrizEnForma1 está vacía
     *
     * @return booleano si el nodo primero es igual a la cabeza de los nodos
     * cabeza
     * @since CalculadoraMatrices 1.0.0
     */
    public boolean esVacia() {
        NodoDoble p = primerNodo();
        return p == mat;
    }

    /**
     * Método para saber si un nodo ya terminó su recorrido
     *
     * @return booleano si el nodo de ingreso es igual al nodo mat
     * @param p nodo de referencia de la búsqueda
     * @since CalculadoraMatrices 1.0.0
     */
    public boolean finDeRecorrido(NodoDoble p) {
        return p == mat;
    }

    /**
     * Método que retorna un String con la matriz representada en texto
     *
     * @return el nodo cabeza
     *
     * @since CalculadoraMatrices 1.0.0
     */
    public String mostrarMatriz() {
        NodoDoble aux;//Nodo auxiliar para recorrer la matriz 
        Tripleta taux;//tripleta para retornar el dato del nodo auxiliar
        String resultado = "";//hilera que almacena el resultado de la operación
        for (int i = 1; i <= 3; i++) {//avanza por filas
            for (int j = 1; j <= 3; j++) {//avanza por columnas
                aux = buscarFilaColumna(i, j);//posiciona el nodo auxiliar en la posición de cada combinación
                taux = (Tripleta) aux.retornaDato();//retorno el dato del nodo  
                resultado = resultado + taux.retornaValor() + "\t";//hago resultado igual a lo que tenía almacenado más el valor del nodo visitado
            }
            aux = buscarFilaColumna(i, 4);//busco el nodo que contiene el resultado de la fila que se está escribiendo
            taux = (Tripleta) aux.retornaDato();//retorno el dato del nodo de la fila actual
            resultado = resultado + "|\t" + taux.retornaValor() + "\t" + "\n\n";//hago el resultado igual a lo que ya tenía más el valor del nodo resultado de la fila actual
        }
        return resultado;//retorno el resultado
    }

    /**
     * Método que construye los nodos cabeza
     *
     * @since CalculadoraMatrices 1.0.0
     */
    public void construyeNodosCabeza() {
        int mayor, i;
        NodoDoble x, ultimo;
        Tripleta t;
        ultimo = nodoCabeza();
        t = (Tripleta) ultimo.retornaDato();
        m = t.retornaFila();
        n = t.retornaColumna();
        mayor = m;
        if (n > m) {
            mayor = n;
        }
        for (i = 1; i <= mayor; i++) {
            t = new Tripleta(i, i, nodoCabeza());
            x = new NodoDoble(t);
            x.asignaLd(x);
            x.asignaLi(x);
            t = (Tripleta) ultimo.retornaDato();
            t.asignaValor(x);
            ultimo.asignaDato(t);
            ultimo = x;
        }
    }

    /**
     * Método que conecta un nodo por filas
     *
     * @param x nodo que se conectará por filas
     * @since CalculadoraMatrices 1.0.0
     */
    public void conectaPorFilas(NodoDoble x) {
        NodoDoble p, q, anterior;
        Tripleta tp, tq, tx;
        int i;
        tx = (Tripleta) x.retornaDato();
        p = primerNodo();
        for (i = 1; i < tx.retornaFila(); i++) {
            tp = (Tripleta) p.retornaDato();
            p = (NodoDoble) tp.retornaValor();
        }
        anterior = p;
        q = p.retornaLd();
        tq = (Tripleta) q.retornaDato();
        while ((q != p) && (tq.retornaColumna() < tx.retornaColumna())) {
            anterior = q;
            q = q.retornaLd();
            tq = (Tripleta) q.retornaDato();
        }
        anterior.asignaLd(x);
        x.asignaLd(q);
    }

    /**
     * Método que conecta un nodo por columnas
     *
     * @param x nodo que se conectará por columnas
     * @since CalculadoraMatrices 1.0.0
     */
    public void conectaPorColumnas(NodoDoble x) {
        NodoDoble p, q, anterior;
        Tripleta tp, tq, tx;
        int i;
        tx = (Tripleta) x.retornaDato();
        p = primerNodo();
        for (i = 1; i < tx.retornaColumna(); i++) {
            tp = (Tripleta) p.retornaDato();
            p = (NodoDoble) tp.retornaValor();
        }
        anterior = p;
        q = p.retornaLi();
        tq = (Tripleta) q.retornaDato();
        while ((q != p) && (tq.retornaFila() < tx.retornaFila())) {
            anterior = q;
            q = q.retornaLi();
            tq = (Tripleta) q.retornaDato();
        }
        anterior.asignaLi(x);
        x.asignaLi(q);
    }

    /**
     * Método que intercambia los valores de dos columnas ingresadas como
     * parámetro
     *
     * @param col1 entero que representa la columna uno del cambio
     * @param col2 entero que representa la columna dos del cambio
     * @since CalculadoraMatrices 1.0.0
     */
    public void intercambiaColumnas(int col1, int col2) {
        int qc, rc;//enteros columna de q y columna de r siendo q y r dos nodos
        double aux;//variable auxiliar para hacer operacioes de retorno
        NodoDoble p, q, r;//nodos p, q y r usados para recorrer por filas y luego buscar las columnas en cada fila
        Tripleta tp, tq, tr;//tripletas de cada uno de los nodos respectivamente
        p = primerNodo();//posiciono p en el primer nodo de la matriz
        while (!finDeRecorrido(p)) {//mientras p no sea igual a mat
            q = p.retornaLd();//hago q igual al siguiente de p
            tq = (Tripleta) q.retornaDato();//retorno el dato de q
            qc = tq.retornaColumna();//almaceno el valor de la columna en la variable qc
            while (q != p && qc != col1) {//si q diferente de p y el valor de la columna del nodo q diferente de la columna uno ingresada por el usuario
                q = q.retornaLd();//avanzo a la siguiente columna de la fila actual
                tq = (Tripleta) q.retornaDato();//retorno nuevamente el dato de la nueva posición de q
                qc = tq.retornaColumna();//hago columna de q igual al valor de la columna de q
            }
            if (qc == col1) {//si columna de q igual a la columna uno buscada
                r = p.retornaLd();//avanzo con r por la misma fila 
                tr = (Tripleta) r.retornaDato();//retorno el dato de r
                rc = tr.retornaColumna();//llevo a rc la columna de r
                while (r != p && rc != col2) {//mientras r diferente de p y columna de r diferente de colummna dos buscada
                    r = r.retornaLd();//avanzo con r
                    tr = (Tripleta) r.retornaDato();//retorno el dato de r
                    rc = tr.retornaColumna();//almaceno el dato de r en columan r o rc
                }
                if (rc == col2) {//si columna de r es la columna dos buscada
                    aux = retornarValorTripleta(tq);//llevo el valor de r a la variable auxiliar
                    tq.asignaValor(tr.retornaValor());//almaceno en q el valor de r
                    tr.asignaValor(aux);//almaceno en r el valor de q
                    q.asignaDato(tq);
                    r.asignaDato(tr);
                }
            }
            tp = (Tripleta) p.retornaDato();//avanzo a la siguiente fila de p
            p = (NodoDoble) tp.retornaValor();
        }
    }

    /**
     * Método que intercambia los valores de dos filas ingresadas como parámetro
     *
     * @param fil1 entero que representa la fila uno del cambio
     * @param fil2 entero que representa la fila dos del cambio
     * @since CalculadoraMatrices 1.0.0
     */
    public void intercambiaFilas(int fil1, int fil2) {
        int pf, rf;//variable para la fila de p y de r
        double aux;//una variable auxiliar para operaciones de cambio
        NodoDoble p, q, r, s;//nodos para recorrer la matriz
        Tripleta tp, tq, tr, ts;//tripletas correspondientes a cada nodo
        p = buscarFila(fil1);//se usa el método buscarFila, para buscar la fila uno y posicionar el nodo p
        tp = (Tripleta) p.retornaDato();//se retorna el dato de p
        pf = tp.retornaFila();//se almacena en pf la fila de p
        r = buscarFila(fil2);//con el nodo r se busca la fila dos
        tr = (Tripleta) r.retornaDato();//se retorna el dato de r
        rf = tr.retornaFila();//se almacena la fila de r en la variable auxiliar
        if (pf == fil1 && rf == fil2) {//si ya se hallaron las filas
            q = p.retornaLd();//con q avanzo por la fila de p
            s = r.retornaLd();//con s avanzo por la fila de r
            while (q != p && s != r) {//mientas q diferente de p y s de r
                tq = (Tripleta) q.retornaDato();//retorno el dato de q
                ts = (Tripleta) s.retornaDato();//retorno el dato de s
                aux = retornarValorTripleta(tq);//en la variable auxiliar almaceno el dato de q
                tq.asignaValor(ts.retornaValor());//alamceno el q el valor de s
                ts.asignaValor(aux);//almaceno en s el valor de q
                q = q.retornaLd();//avanzo con q
                s = s.retornaLd();//avanzo con s
            }
        }
    }

    /**
     * Método que convierte el valor de una tripleta a un double
     *
     * @param t entero que representa la columna uno del cambio
     * @return valor double para realizar operaciones de cálculos
     * @since CalculadoraMatrices 1.0.0
     */
    public double retornarValorTripleta(Tripleta t) {
        String aux = (String.valueOf(t.retornaValor()));//creo un string auxiliar y le llevo el valor de la tripleta
        double valor = Double.parseDouble(aux);//convierto el valor a un double para poder realizar aperaciones
        return valor;//retorno el valor
    }

    /**
     * Método que retorna la primera posición de una fila ingresada como
     * parámetro, es decir su nodo cabeza
     *
     * @param fila entero que representa la columna uno del cambio
     * @return nodo cabeza de una fila
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble buscarFila(int fila) {
        int f = fila;//variable para la fila
        NodoDoble p;//nodo para recorrer
        Tripleta tp;//tripleta correspondiente al nodo
        int pf;//variable para almacenar la fila de p
        p = primerNodo();//me posiciono en el primer nodo
        tp = (Tripleta) p.retornaDato();//retorno el dato del nodo p
        pf = tp.retornaFila();//retorno la fila de p y la guardo en la variable
        while (pf != f && !finDeRecorrido(p)) {//mientras fila de p diferente de la fila buscada y no haya finalizado el recorrido p
            p = (NodoDoble) tp.retornaValor();//p avanza por filas
            tp = (Tripleta) p.retornaDato();
            pf = tp.retornaFila();//retorna la fla de p
        }
        return p;//retorna la posición del nodo
    }

    /**
     * Método que busca un valor de acuerdo a su fila y columna
     *
     * @param fila entero que representa la columna uno del cambio
     * @param columna entero que representa la columna dos del cambio
     * @return nodo en el que se halla el valor que corresponde a una fila y
     * columna entradas como parámetro
     * @since CalculadoraMatrices 1.0.0
     */
    public NodoDoble buscarFilaColumna(int fila, int columna) {
        NodoDoble p, q;//nodos para hacer el recorrido en la matri
        Tripleta tq;//tripleta de q para retornar el dato de q
        int qc;//variable para la columna de q
        p = buscarFila(fila);//hago p igual a la fila buscada
        q = p.retornaLd();//avanzo por la derecha de p luego de encontrarlo
        tq = (Tripleta) q.retornaDato();//retorno el dato de q
        qc = tq.retornaColumna();//almaceno la columna de q
        while (q != p && qc != columna) {//si q es diferente de p y la columna de q no es la buscada
            q = q.retornaLd();//avanzo con q
            tq = (Tripleta) q.retornaDato();//retorno el dato de q
            qc = tq.retornaColumna();//almaceno su columna
        }
        return q;//y finalmente retorna al encontrarlo
    }

    /**
     * Método que saca el determinante de una matriz
     *
     * @return un double para realizar operaciones con él
     * @since CalculadoraMatrices 1.0.0
     */
    public double sacarDeterminante() {
        int z = 1, d, f, c;//variables auxiliares para realizar operaciones
        double det = 1;//variable para los determinantes
        for (d = 1; d <= 3; d++) {//mientras d sea menor que el número de filas
            int p = 0;//variable auxliar igual a cero
            NodoDoble pivote = buscarFilaColumna(d, d);//busca el primer pivote
            Tripleta tpivote = (Tripleta) pivote.retornaDato();//retorna el dato del pivote
            double vtpivote = retornarValorTripleta(tpivote);//almacena el dato del pivote en la variable
            if (vtpivote == 0) {//si el valor del pivote es igual a cero
                p = -1;//la p toma un valor de -1
                f = d;//se igual la variable f a la d
                while (f <= 3 && p == -1) {//mientras f menor que tres y p igual a -1
                    pivote = buscarFilaColumna(f, d);//busco la posición del pivote
                    tpivote = (Tripleta) pivote.retornaDato();//retorno el dato del pivote
                    vtpivote = retornarValorTripleta(tpivote);//almaceno el dato del pivote
                    if (vtpivote != 0) {//si el valor del pivote es diferente de cero
                        p = f;//igualo la p a la f
                        intercambiaFilas(d, p);//se intercambian las filas 
                        z = z * -1;//se multiplica z por menos uno para finalmene multiplicarlo por el determinante y que el signo no se pierda al hacer los cambios de fila
                    }
                    f++;//aumento la variable de referencia para el recorrido
                }
            }
            pivote = buscarFilaColumna(d, d);//se busca nuevamente el pivote inicial
            tpivote = (Tripleta) pivote.retornaDato();//se retorna su dato
            vtpivote = retornarValorTripleta(tpivote);//se almacena el dato del pivote 
            if (p != -1) {//sip es diferente de menos uno
                for (f = d + 1; f <= 3; f++) {//voy a la siguiente fila de d
                    NodoDoble aux = buscarFilaColumna(f, d);//busco el siguiente valor
                    Tripleta taux = (Tripleta) aux.retornaDato();//retorno el valor del nodo
                    double vtaux = retornarValorTripleta(taux);//lo almaceno en la variable auxiliar
                    for (c = 1; c <= 3; c++) {//si la variable c menor que tres
                        NodoDoble aux2 = buscarFilaColumna(f, c);//en un nuevo nodo busco la posicipon solicitada
                        Tripleta taux2 = (Tripleta) aux2.retornaDato();//retorno el dato 
                        double vtaux2 = retornarValorTripleta(taux2);//lo almaceno
                        NodoDoble aux3 = buscarFilaColumna(d, c);//busco el dato siguiente  
                        Tripleta taux3 = (Tripleta) aux3.retornaDato();//retorno el dato
                        double vtaux3 = retornarValorTripleta(taux3);//almaceno el dato
                        vtaux2 = vtaux2 - (vtaux3 * (vtaux / vtpivote));//hago la operación de división para volver cero los números bajo la diagonal principal
                        taux2.asignaValor(vtaux2);//almaceno el nuevo dato
                        aux2.asignaDato(taux2);//llevo el dato al nodo
                    }
                }
            }
        }
        for (d = 1; d <= 3; d++) {//mientras de menor que filas
            NodoDoble piv = buscarFilaColumna(d, d);//el nodo pivote almancena nuevamente el pivote
            Tripleta tpiv = (Tripleta) piv.retornaDato();//retorna el dato del nodo
            double vtpiv = (double) tpiv.retornaValor();//se almacena en la variable auxiliar
            det = det * vtpiv;//se multiplican los números de la diagonal entre si luego de tener la diagonal superior
            det = det * z;//finalmente se multiplica por el signo del determinante
        }
        return det;//se retorna el resultado del determinante
    }

    /**
     * Método que crea una copia exacta de una matriz
     *
     * @return una matriz en forma 1
     * @since CalculadoraMatrices 1.0.0
     */
    public MatrizEnForma1 CopiarMatriz() {
        NodoDoble r, s;//nodos para recorrer la matriz
        Tripleta tr, ts;//tripleta de cada nodo
        r = nodoCabeza();//se ubila el nodo r en la cabeza de la matriz
        tr = (Tripleta) r.retornaDato();//se retorna el dato del nodo
        int w = tr.retornaFila();//se retorna la fila y se almacena
        int u = tr.retornaColumna();//se retorn la columna y se almancena
        MatrizEnForma1 a = new MatrizEnForma1(w, u);//se crea un anueva matriz de tamaña fila por columna retornados en los dos pasos anteriores
        a.construyeNodosCabeza();//se construyen los nodos cabeza de la nueva matriz
        r = primerNodo();//se hace r igual al primero nodo para empezar a recorrer
        while (!finDeRecorrido(r)) {//mientras r no sea igual a mat
            s = r.retornaLd();//s avanza por la fila en la que está situado r
            while (s != r) {//mientras s diferente de r
                ts = (Tripleta) s.retornaDato();//se retorna el dato de s
                int f = ts.retornaFila();//se saca la fila y se almacena
                int c = ts.retornaColumna();//se almacena la columna
                double v = retornarValorTripleta(ts);//se almacena el valor
                Tripleta t = new Tripleta(f, c, v);//se crea una nueva tripleta con los tres datos retornados de s
                NodoDoble x = new NodoDoble(t);//se guarda dicha tripleta en un nodo
                a.conectaPorColumnas(x);//se conecta dicho nodo por columnas
                a.conectaPorFilas(x);//se conecta dicho nodo por filas
                s = s.retornaLd();//se avanza con s
            }
            tr = (Tripleta) r.retornaDato();
            r = (NodoDoble) tr.retornaValor();//se avanza con r
        }
        return a;//se retorna la matriz
    }

    /**
     * Método que realiza las operaciones necesarias para resolver un sistema de
     * ecuaciones lineales usando el método de cramer
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String cramer() {
        int y = 0;//entero auxiliar para realizar operaciones
        String resultado;//cadena para almacenar el resultado de la operación
        resultado = casosEspeciales();//se hace el llamado al método casos especiales o excepciones matriciales, aquellas que dan infinito o inconsistente
        if (!resultado.equals("")) {//si habían casos especiales
            return resultado;//retorna el resultado con los casos especiales encontrados
        } else {//si no
            double detx = 1, dety = 1, detz = 1;//se inicializan las variables de los determinantes con 1
            MatrizEnForma1 original = CopiarMatriz();//se crea una copia de la matriz original
            double detOriginal = original.sacarDeterminante();//se saca el determinante de la matriz original
            if (detOriginal == 0) {//si el determinante de la matriz origina el cero
                resultado = resultado + "El determinante de la matriz es cero, esto puede significar que el sistema \nes inconsistente o que tiene infinitas soluciones, la eliminación con Gauss-Jordan \nle puede ayudar a obtener una mejor respuesta.\n\n";//retorna este mensaje
                return resultado;
            } else {
                resultado = resultado + "El determinante de la matriz de coeficientes es: " + (String.valueOf(detOriginal)) + "\n\n";//sino se retorna este mensaje con el resultado del determinante de la matriz original
                for (int i = 1; i <= 3; i++) {//para i menor que el número de filas
                    MatrizEnForma1 copia = CopiarMatriz();//se crea otra copia de la matriz original ingresada por el usuario.
                    copia.intercambiaColumnas(i, 4);//se intercambian las columnas de x, y y z con la columna 4 cada que aumenta la i
                    String aux = copia.mostrarMatriz();//se muestra la nueva matriz generada al cambiar las columnas
                    double detCopia = copia.sacarDeterminante();//se saca el determinante de la nueva matriz generada
                    y++;//se aumenta el contador y
                    if (y == 1) {//si y igual a auno
                        resultado = resultado + "LA MATRIZ PARA EL DETERMINANTE DE X ES:\n\n" + aux + "El determinante para la matriz de X es: " + (String.valueOf(detCopia)) + "\n\n";//el resultado le corresponde a la x
                        detx = detx * detCopia / detOriginal;//se saca el resultado del valor de la X
                        resultado = resultado + "X = " + (String.valueOf(detCopia)) + "/" + (String.valueOf(detOriginal)) + " = " + (String.valueOf(detx)) + "\n\n";//se retorna el resultado del valor de X
                    }
                    if (y == 2) {//si y es igual a dos le corresponde a la y
                        resultado = resultado + "LA MATRIZ PARA EL DETERMINANTE DE Y ES:\n\n" + aux + "El determinante para para la matriz de Y es: " + (String.valueOf(detCopia)) + "\n\n";//se muestra el determinante de Y
                        dety = dety * detCopia / detOriginal;//se saca el valor correspondiente a Y
                        resultado = resultado + "Y = " + (String.valueOf(detCopia)) + "/" + (String.valueOf(detOriginal)) + " = " + (String.valueOf(dety)) + "\n\n";//se muestra el valor correspondiente a Y
                    }
                    if (y == 3) {//si y es igual a tres le corresponde el resultado a la Z
                        resultado = resultado + "LA MATRIZ PARA EL DETERMINANTE DE Z ES:\n\n" + aux + "El determinante para para la matriz de Z es: " + (String.valueOf(detCopia)) + "\n\n";//se muestra el resultado del determinante para la Z
                        detz = detz * detCopia / detOriginal;//se caca el valor de la Z
                        resultado = resultado + "Z = " + (String.valueOf(detCopia)) + "/" + (String.valueOf(detOriginal)) + " = " + (String.valueOf(detz)) + "\n\n";//se muestra el valor de la Z

                    }
                }
            }
        }
        return resultado;//se retorna el resultado
    }

    /**
     * Método que realiza las operaciones necesarias para resolver un sistema de
     * ecuaciones lineales usando el método de Gauss-Jordan
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String gaussJordan() {
        String resultado, pivotesCero;//variables para almacenar el resultado de operaciones
        NodoDoble pivote, aux;//nodos par amoverse en la matriz
        Tripleta tpivote, taux;//tripletas correspondientes a cada nodo
        double vtpivote, vtaux;//varibales para almacenar los valores de los nodos
        int i = 1, cont = 0;//se inicializan las variables de conteo
        resultado = casosEspeciales();//se hace un llamado al método de casos especiales y excepciones
        if (!resultado.equals("")) {//si hubo excepciones
            return resultado;//retorna
        } else {//sino
            resultado = resultado + cambiaFilasPivoteCero();//se hace un llamado al método para intercambiar filas con pivote cero
            while (i <= 3) {//mientras i menor que filas
                pivotesCero = "";//pivottescero igual a cero, es decir no hay pivotes con cero
                pivote = buscarFilaColumna(i, i);//se busca el primer pivote de la matriz
                tpivote = (Tripleta) pivote.retornaDato();//se retorna su dato
                vtpivote = retornarValorTripleta(tpivote);//se retorn el valor del nodo

                resultado = resultado + "(" + "1/" + vtpivote + ")" + " * Fila" + i + "\n";//se almacena el mensaje de la operación a realizar

                for (int j = 1; j <= 4; j++) {//para j menor que el número de columnas

                    aux = buscarFilaColumna(i, j);//se busca nuevamente el primer pivote
                    taux = (Tripleta) aux.retornaDato();////se retorna su dato
                    vtaux = retornarValorTripleta(taux);//se almacena su valor

                    vtaux = (vtaux / vtpivote);//se divide por el inverso aditivo para hacerlo uno
                    taux.asignaValor(vtaux);//se almacena el nuevo valor
                    aux.asignaDato(taux);//se asigna el nuevo valor
                }

                resultado = resultado + mostrarMatriz();//se almacena en el resultado la matriz resultante de la operación

                if (pivotesCero.equals("")) {//si no hay pivotes con cero
                    for (int x = 1; x <= 3; x++) {//mientras x menor que filas
                        if (i != x) {//si i diferente de x

                            aux = buscarFilaColumna(x, i);//se busca la posición debajo del primer pivote
                            taux = (Tripleta) aux.retornaDato();//se retorn el dato
                            vtaux = retornarValorTripleta(taux);//se almacena su valor

                            resultado = resultado + "Fila" + x + " + (-(" + vtaux + "))" + "* Fila" + i + "\n";//se almacena el mensaje con la nueva operación a realizar

                            for (int k = 1; k <= 4; k++) {//mientras k menor que columnas

                                NodoDoble col = buscarFilaColumna(x, k);//se avanza por la fila x
                                Tripleta tcol = (Tripleta) col.retornaDato();//se retorna el dato 
                                double vtcol = retornarValorTripleta(tcol);//se almancena

                                NodoDoble aux2 = buscarFilaColumna(i, k);//se avanza por la fila i
                                Tripleta taux2 = (Tripleta) aux2.retornaDato();//se retorna el dato
                                double vtaux2 = retornarValorTripleta(taux2);//se almacena

                                vtcol = vtcol - (vtaux * vtaux2);//se realiza la operación para volver cero los valores bajo el pivote
                                tcol.asignaValor(vtcol);//se almacena el nuevo valor 
                                col.asignaDato(tcol);//se asigna el nuevo valor al nodo

                            }
                            resultado = resultado + mostrarMatriz();//se almacena el resultado en la cadena de texto
                        }
                        pivotesCero = pivotesCero + cambiaFilasPivoteCero();//se hace un llamado al método para cambiar filas con pivotes con cero
                    }
                }
                resultado = resultado + pivotesCero;//se almacena nuevamente el resultado
                if (pivotesCero.equals("")) {//si no había pivotes con cero
                    i++;//se avana a la siguiente fila
                } else {//si había filas con pivote en cero
                    i = 1;//se realiza nuevamente todo el proceso hasta reducir totalmente
                }
            }
            resultado = resultado + "El sistema tiene solución única:\n";//se almacena el resultado
            for (int j = 1; j <= 3; j++) {//para j menor que filas
                cont++;//se aumenta el contador para saber a qué variable le corresponde cada valor
                aux = buscarFilaColumna(j, 4);//se busca el nodo de resutado de cada fila
                taux = (Tripleta) aux.retornaDato();//se retorna el dato de resultado
                vtaux = retornarValorTripleta(taux);//se almacena el valor de resultado
                if (cont == 1) {//si el contador es igual a uno el valor es de X
                    resultado = resultado + "X = " + vtaux + "\n";//se almacena el valor de X
                }
                if (cont == 2) {//si el contador es igual a dos el valor es de Y
                    resultado = resultado + "Y = " + vtaux + "\n";//se almancena el valor en la cadena
                }
                if (cont == 3) {//si el contador es igual a tres el valor es de Z
                    resultado = resultado + "Z = " + vtaux + "\n";//se almacena el valor en la cadena
                }
            }
        }
        return resultado;//se retorna el resultado de las operaciones
    }

    /**
     * Método que realiza las operaciones necesarias para dar a conoces las
     * excepciones e irregularidades que presenta una matriz, como pueden ser
     * soluciones infinitas o inconsistencia en el sistema
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String casosEspeciales() {
        double vtx;//variable auxilair apara realizar operaciones 
        String resultado = "";//variable para el resultado
        NodoDoble x;//nodo para moverse en la matriz
        Tripleta tx;//tripleta del nodo x
        for (int i = 1; i <= 3; i++) {//mientras i menor que filas
            double valor = 0;//se hace la variable valor igual a cero para verificar filas con ceros
            int j = 1;//se hace la variable j igual a uno
            while (valor == 0 && j <= 3) {//mientras valor permanezca en cero y j sea menor que tres
                x = buscarFilaColumna(i, j);//se busca el nodo
                tx = (Tripleta) x.retornaDato();//se retorna el dato
                valor = retornarValorTripleta(tx);//se almacena
                j++;//se aumenta la j
            }
            x = buscarFilaColumna(i, 4);//se busca el valor correspondiente a la fila que tiene todo en ceros
            tx = (Tripleta) x.retornaDato();//se restorna el valor del resultado 
            vtx = retornarValorTripleta(tx);//se almacena el valor de resultado
            if (valor == 0 && vtx == 0) {//si toda la fila tiene ceros
                resultado = resultado + "La fila " + i + " está llena de ceros, el sistema tiene soluciones infinitas.\n\n";//se muestra el mensaje de soluciones infinitas
                return resultado;//y se retorna el resultado
            }
            if (valor == 0 && vtx != 0) {//si toda la fila tiene ceros menos su celda de resultado
                resultado = resultado + "La fila " + i + " está llena de ceros y el valor final de ella no es cero, por tanto el \nsistema es inconsistente, no tiene solución.\n\n";//se muestra el mensaje de inconsistencia
                return resultado;//se retorna el resultado
            }
        }
        resultado = resultado + multiplicidadPorFilas();//se hace un llamado al método que informa de la multiplicidad entre filas
        if (!resultado.equals("")) {//si hay multiplicidad se retorna el resultado
            return resultado;
        }
        resultado = resultado + igualdadPorColumnas();//se hacu un llamado al método que informa sobre la igualdad de valores por columna
        return resultado;//se retorna el resultado
    }

    /**
     * Método que realiza las operaciones necesarias para verificar la
     * multiplicidad de una o más filas de la matriz
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String multiplicidadPorFilas() {
        String resultado = "";//variable para retornar el resultado de las operaciones
        NodoDoble x, y;//nodos para moverse en la matriz
        Tripleta tx, ty;//tripletas correspondientes a cada nodo
        double vtx, vty;//variables para almacenar el valor de cada nodo
        for (int j = 1; j <= 3; j++) {//mientras j menor que filas
            double cont, aux, div;//se crean las variables para realizar los cálculos aritméticos
            int k, z = 2;//se hace la z igual a 2
            if (j > 1) {//si la fila mayor que uno 
                z = 3;//se igual a a 3 la z
            }
            while (z <= 3) {//mientras z menor que filas
                aux = 0;//se iguala a cero el auxiliar
                div = 0;//se iguala a cero la variable para la división
                k = 1;//se igual a a uno la variable para las columanas
                cont = 0;//se igual a cero el contador de divisiones hechas por
                while (aux == div && k <= 3) {//mientras aux igual a div y filas menor igual a tres
                    cont++;//se aumenta el contador
                    x = buscarFilaColumna(j, k);//se avanza por la fila con x 
                    tx = (Tripleta) x.retornaDato();//se retorna el dato de x
                    vtx = retornarValorTripleta(tx);//se almacena el valor de x
                    y = buscarFilaColumna(z, k);//se avanza con  z por la fila siguiente a j
                    ty = (Tripleta) y.retornaDato();//se retorna el dato
                    vty = retornarValorTripleta(ty);//se almacena el valor
                    div = vtx / vty;//se hace la división
                    if (cont == 1) {//si el contador de veces que se divide igual a uno, entonces es la primer división
                        aux = div;//hacer el aux igual a div
                    }
                    k++;//aumento la variable de la columna
                }
                if (cont == 3 && aux == div) {//si contador de divisiones igual a 3 y aux aún es igual a d div
                    x = buscarFilaColumna(j, 4);//buscar el resultado correspondiente a la fila j
                    tx = (Tripleta) x.retornaDato();//retornar el dato
                    vtx = retornarValorTripleta(tx);//almacenar el valor
                    if (j + 1 <= 3) {//si la siguiente fila de j es menor o igual a filas
                        y = buscarFilaColumna(z, 4);//buscar el resultado de dicha fila
                        ty = (Tripleta) y.retornaDato();//restornar el dato
                        vty = retornarValorTripleta(ty);//almacenar el valor
                        div = vtx / vty;//hacer la división entre ellos
                        if (aux == div) {//si nuevamente son iguales al resultado de las anteriores divisiones
                            resultado = "Hay multiplicidad en la fila " + j + " y la fila " + z + ", por tanto el sistema tiene \nsoluciones infinitas.\n\n";//hay multiplicidad y se muestra este mensaje
                            return resultado;//se retorna el resultado
                        } else {//sino
                            resultado = "Hay multiplicidad en la fila " + j + " y la fila " + z + ", pero no en los resultados de ellas \npor tanto el sistema es inconsistente.\n\n";//el sistema es inconsistente
                        }
                    }
                }
                z++;//se aumenta la variable de la siguiente fila para seguir comparando
            }
        }
        return resultado;//se retorna
    }

    /**
     * Método que realiza las operaciones necesarias para verificar si una o más
     * columnas presentan el mismo valor en todas las celdas
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String igualdadPorColumnas() {
        String resultado = "", auxiliar = "";//variables para almacenar los resultados de operaciones
        NodoDoble x;//nodo para recorrer la matriz
        Tripleta tx;//tripleta del nodo
        double vtx;//variable para almacenar el valor del nodo
        int cont, nColumnas = 0, unaVez = 0, contFinal = 0, contCeros = 0;//se inicializan las variables de control
        if (nColumnas <= 3) {//si el número de columnas con valores repetidos es menor a o iguaal a tres
            for (int i = 1; i <= 3; i++) {//para i menor que filas
                double valor = 0;//se inicializa la variable del cero en cero
                int j = 2;//se iguala a dos la varibale de la j
                x = buscarFilaColumna(1, i);//se busca las columnas de la fila uno
                tx = (Tripleta) x.retornaDato();//se retorna el dato
                vtx = retornarValorTripleta(tx);//se almacena el valor
                valor = vtx;//se iguala el valor al valor del nodo x
                if (valor == 0) {//si el valor es cero
                    contCeros = 1;//aumenta el contador de ceros
                }
                cont = 1;//se aumenta el contador en uno para decir que se ha tomado un primer valor
                while (valor == vtx && j <= 3) {//si el valor igual al valor del nodo y j es menor que tres
                    x = buscarFilaColumna(j, i);//se leva x a la siguiente fila en la misma columna
                    tx = (Tripleta) x.retornaDato();//se retorna el dato
                    vtx = retornarValorTripleta(tx);//se almacena el valor
                    if (valor == vtx) {//si el valor es igual al valor del nodo x
                        cont++;//aumenta el contador de veces que se repite un valor
                        if (valor == 0) {//si el valor es igual a cero
                            contCeros++;//aumenta el contador de ceros por columna
                        }
                    }
                    j++;//aumenta la variable j para avanzar al siguiente valor en la misma columna
                }
                if (cont == 3) {//si el contador es igual a tres la columna tiene tres valores iguales  
                    auxiliar = auxiliar + "La columna " + i + " tiene los mismos valores en todas las celdas.\n";//se lleva el mensaje a la variable auxiliar
                    nColumnas++;//se aumenta el número de columnas con valores repetidos
                }
                if (unaVez < 1) {//si es la primer vez que se hace el recorrido se sacan los valores de la columna 4 y se almacenan
                    j = 2;//se hace j igual a dos 
                    x = buscarFilaColumna(i, 4);//se busca el de la columna de valores
                    tx = (Tripleta) x.retornaDato();//se retorna el dato
                    vtx = retornarValorTripleta(tx);//se almacena el valor
                    valor = vtx;//se iguala valor al valor del nodo 
                    contFinal = 1;//contador de columna final igual aumenta
                    while (valor == vtx && j <= 3) {//mientras valor de celdas sea igual y filas menor o igual a tres
                        x = buscarFilaColumna(j, 4);//busca la celda siguiente de dichac columna
                        tx = (Tripleta) x.retornaDato();//retorna el dato
                        vtx = retornarValorTripleta(tx);//almacena el valor
                        if (valor == vtx) {//si el valor es igual al valor del nodo
                            contFinal++;//el contador de columna final aumenta en uno
                        }
                        j++;//se avana de fila
                    }
                    unaVez++;//se aumenta el contador diciendo que ya se hizo la columna cuatro
                }
                if (nColumnas >= 2 & contFinal == 3) {//si el número de columnas con valores iguales es mayor o igual a dos y la columna de resultado tiene los mismmos valores
                    auxiliar = auxiliar + "La columna de resultado tiene los mismos valores en todas las celdas.\n";//almacena este resultado
                    resultado = resultado + "El sistema tiene soluciones infinitas porque:\n" + auxiliar + "\n\n";//almacena todo el la variable de resultado
                    return resultado;//retorna el resultado
                }
                if (nColumnas >= 2 & contFinal != 3) {//si el número de columnas con valores iguales es mayor o igual a dos y la columna de resultado tiene valores diferentes 
                    resultado = resultado + "El sistema es inconsitente porque:\n" + auxiliar + "Y la fila de resultado tiene valores distintos en sus celdas.\n";//almacena este resultado
                    return resultado;//retorna el resultado
                }
            }
            if (contCeros == 3 && nColumnas < 2) {//si el contador de ceros es igual a tres hay una columna de puros ceros 
                resultado = resultado + "El sistema es inconsistente porque:\n" + auxiliar + "Y todos son ceros";//almacena este resultado
                return resultado;//retorna el resultado
            }
        }
        return resultado;//retorna el resultado
    }

    /**
     * Método que realiza las operaciones necesarias para cambiar una fila por
     * otra cuando esta tiene un cero en la posición del pivote
     *
     * @return string con el resultado de toda la operación
     * @since CalculadoraMatrices 1.0.0
     */
    public String cambiaFilasPivoteCero() {
        String resultado = "";//variable para almacenar el resultado
        int i, f;//variables para hacer los aumentos en filas y columnas para moverse
        for (i = 1; i <= 3; i++) {//si la i menor que las filas
            int p = 0;//la variable p se iguala a cero
            NodoDoble pivote = buscarFilaColumna(i, i);//busco el pivote
            Tripleta tpivote = (Tripleta) pivote.retornaDato();//retorno el dato
            double vtpivote = retornarValorTripleta(tpivote);//almaceno el valor
            if (vtpivote == 0) {//si el valor del pivote es cero
                p = -1;//p se iguala a menos 1
                f = i;//la f se iguala a la i
                while (f <= 3 && p == -1) {//mientras f menor que filas y el valor del pivote igual a cero
                    pivote = buscarFilaColumna(f, i);//se busca el primer valor de la siguiente fila
                    tpivote = (Tripleta) pivote.retornaDato();//se retorna el dato
                    vtpivote = retornarValorTripleta(tpivote);//se almacena el dato
                    if (vtpivote != 0) {//si el dato es diferente de cero
                        p = f;//se igual la p con la f
                        resultado = resultado + "Fila" + i + " cambia por Fila" + p + " para evitar ceros de los pivotes\n";//se muestra el mensaje de las filas que se van a intercambiar
                        intercambiaFilas(i, p);//se hace el intercambio de filas
                        resultado = resultado + mostrarMatriz() + "\n\n";//se almacena el resultado de la operación
                    }
                    f++;//se aumenta la fila
                }
            }
        }
        return resultado;//se retorna le resultado
    }
}
