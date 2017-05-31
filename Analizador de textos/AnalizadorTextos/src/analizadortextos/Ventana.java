package analizadortextos;

/**
 * Clase que realiza diversas operaciones sobre un texto almacenado como lista
 * doblemente ligada con nodo cabeza haciendo el uso de los métodos
 * correspondientes a dicha lista
 *
 * @author Felipe López
 * @version 1.0.0
 * @since AnalizadorTextos 1.0.0
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    /**
     * Variable global de tipo ListaDCabeza utilizada para almacenar las
     * palabras como lista
     *
     * @since AnalizadorTextos 1.0.0
     */
    final ListaDCabeza listaPalabras = new ListaDCabeza();
    /**
     * Variable global de tipo String utilizada para realizar operaciones dentro
     * de los métodos de la clase
     *
     * @since AnalizadorTextos 1.0.0
     */
    private String palabra;
    /**
     * Variable global de tipo String utilizada para realizar operaciones dentro
     * de los métodos de la clase
     *
     * @since AnalizadorTextos 1.0.0
     */
    private StringTokenizer tkn;

    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Analizador de textos");
        this.setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTextoIngresado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaIngresado = new javax.swing.JTextArea();
        labelTextoResultado = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaResultado = new javax.swing.JTextArea();
        botonLimpiar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        botonExaminar = new javax.swing.JButton();
        barraMenu1 = new javax.swing.JMenuBar();
        menuOperaciones = new javax.swing.JMenu();
        menuItemMostrarPreposiciones = new javax.swing.JMenuItem();
        menuItemMostrarTildadas = new javax.swing.JMenuItem();
        menuItemEliminarPalabra = new javax.swing.JMenuItem();
        menuItemMostrarInvertido = new javax.swing.JMenuItem();
        menuItemReemplazarPalabra = new javax.swing.JMenuItem();
        menuItemOrdenAlfabetico = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analizador de textos");

        labelTextoIngresado.setText("Texto leido:");

        textAreaIngresado.setEditable(false);
        textAreaIngresado.setColumns(20);
        textAreaIngresado.setLineWrap(true);
        textAreaIngresado.setRows(5);
        textAreaIngresado.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textAreaIngresado);

        labelTextoResultado.setText("Resultado operación:");

        textAreaResultado.setEditable(false);
        textAreaResultado.setColumns(20);
        textAreaResultado.setLineWrap(true);
        textAreaResultado.setRows(5);
        textAreaResultado.setWrapStyleWord(true);
        jScrollPane2.setViewportView(textAreaResultado);

        botonLimpiar.setText("Limpiar");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar texto");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonExaminar.setText("Examinar");
        botonExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExaminarActionPerformed(evt);
            }
        });

        menuOperaciones.setText("Operaciones");

        menuItemMostrarPreposiciones.setText("Mostrar preposiciones");
        menuItemMostrarPreposiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMostrarPreposicionesActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemMostrarPreposiciones);

        menuItemMostrarTildadas.setText("Mostrar palabras tildadas");
        menuItemMostrarTildadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMostrarTildadasActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemMostrarTildadas);

        menuItemEliminarPalabra.setText("Eliminar palabra anterior a otra");
        menuItemEliminarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemEliminarPalabraActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemEliminarPalabra);

        menuItemMostrarInvertido.setText("Mostrar texto al revés");
        menuItemMostrarInvertido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMostrarInvertidoActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemMostrarInvertido);

        menuItemReemplazarPalabra.setText("Reemplazar palabra");
        menuItemReemplazarPalabra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReemplazarPalabraActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemReemplazarPalabra);

        menuItemOrdenAlfabetico.setText("Ordenar alfabéticamente");
        menuItemOrdenAlfabetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemOrdenAlfabeticoActionPerformed(evt);
            }
        });
        menuOperaciones.add(menuItemOrdenAlfabetico);

        barraMenu1.add(menuOperaciones);

        setJMenuBar(barraMenu1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTextoIngresado)
                            .addComponent(labelTextoResultado))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(113, Short.MAX_VALUE)
                .addComponent(botonExaminar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonGuardar)
                .addGap(18, 18, 18)
                .addComponent(botonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(labelTextoIngresado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelTextoResultado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonLimpiar)
                    .addComponent(botonSalir)
                    .addComponent(botonGuardar)
                    .addComponent(botonExaminar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Método que cierra la ventana
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed
    /**
     * Método que limpia la ventana y la lista de palabras
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        this.listaPalabras.limpiarLista();
        this.textAreaIngresado.setText("");
        this.textAreaResultado.setText("");
        this.botonGuardar.setVisible(true);
        this.botonExaminar.setVisible(true);
    }//GEN-LAST:event_botonLimpiarActionPerformed
    /**
     * Método que guarda el texto en la lista de palabras
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if (!this.textAreaIngresado.getText().isEmpty() && !this.textAreaIngresado.getText().equals("")) {
            tkn = new StringTokenizer(this.textAreaIngresado.getText(), " \":.,;{[^}]+*~¿¡'?=)(/&%#!|°¬$´-");
            palabra = tkn.nextToken();
            listaPalabras.insertarPalabra(palabra);
            while (tkn.hasMoreElements()) {
                palabra = tkn.nextToken();
                listaPalabras.insertarPalabra(palabra);
            }
            this.textAreaResultado.setText(listaPalabras.mostrarLista());
            this.botonGuardar.setVisible(false);
            this.botonExaminar.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese mas caracteres para continuar");
        }
    }//GEN-LAST:event_botonGuardarActionPerformed
    /**
     * Método que muestra la lista de preposiciones y el número de veces que se
     * repite cada una
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemMostrarPreposicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMostrarPreposicionesActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún texto");
        } else {
            this.textAreaResultado.setText(listaPalabras.mostrarPreposiciones());
        }
    }//GEN-LAST:event_menuItemMostrarPreposicionesActionPerformed
    /**
     * Método que elimina una palabra dentro de la lista y retorna el resultado
     * de la operación
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemEliminarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemEliminarPalabraActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún texto");
        } else {
            try {
                palabra = JOptionPane.showInputDialog("Ingrese la palabra situada \ndespués de la que quiere eliminar").trim();
                if (palabra.length() == 0) {
                    JOptionPane.showMessageDialog(null, "La palabra debe tener al menos un caracter");
                } else {
                    this.textAreaResultado.setText(listaPalabras.eliminarPalabra(palabra));
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_menuItemEliminarPalabraActionPerformed
    /**
     * Método que muestra la lista de palabras al revés
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemMostrarInvertidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMostrarInvertidoActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún texto");
        } else {
            this.textAreaResultado.setText(listaPalabras.textoInverso());
        }
    }//GEN-LAST:event_menuItemMostrarInvertidoActionPerformed
    /**
     * Método que reemplaza una palabra en la lista por otra todas las veces que
     * aparezca y retorna el resultado de la operación
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemReemplazarPalabraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReemplazarPalabraActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún texto");
        } else {
            try {
                palabra = JOptionPane.showInputDialog("Ingrese la palabra que desea reemplazar").trim();
                String por = JOptionPane.showInputDialog("Ingrese la palabra de reemplazo").trim();
                if (palabra.length() != 0 && por.length() != 0) {
                    if (palabra.matches("([a-z]|[A-Z]|[0-9]|[ÁÉÍÓÚáéíóú])+") && por.matches("([a-z]|[A-Z]|[0-9]|[ÁÉÍÓÚáéíóú])+")) {
                        this.textAreaResultado.setText(listaPalabras.sustituirPalabra(palabra, por));
                    } else {
                        this.textAreaResultado.setText("Recuerde ingresar sólo letras y números, no más de una palabra.");
                    }
                } else {
                    this.textAreaResultado.setText("Las palabras deben contener al menos un caracter.");
                }
            } catch (Exception ex) {
            }
        }
    }//GEN-LAST:event_menuItemReemplazarPalabraActionPerformed
    /**
     * Método que muestra las palabras tildadas dentro de la lista y su número
     * de ocurrencias dentro de la misma
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemMostrarTildadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMostrarTildadasActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningún texto");
        } else {
            this.textAreaResultado.setText(listaPalabras.mostrarTildadas());
        }
    }//GEN-LAST:event_menuItemMostrarTildadasActionPerformed
    /**
     * Método que muestra las palabras de la lista en orden alfabético y la
     * cantidad de veces que se repiten
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void menuItemOrdenAlfabeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemOrdenAlfabeticoActionPerformed
        if (listaPalabras.esVacia() == true) {
            JOptionPane.showMessageDialog(null, "No ha ingresado ningun texto");
        } else {

            this.textAreaResultado.setText(listaPalabras.ordenAlfabetico());
        }
    }//GEN-LAST:event_menuItemOrdenAlfabeticoActionPerformed
    /**
     * Método que permite llevar el contenido de un archivo de texto a un área
     * de texto para crear la lista de palabras
     *
     * @param evt click event
     * @since AnalizadorTextos 1.0.0
     */
    private void botonExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExaminarActionPerformed
        String ruta = "";
        JFileChooser fileChooser = new JFileChooser();
        int opcion = fileChooser.showOpenDialog(this);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            ruta = fileChooser.getSelectedFile().getPath();
        }
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader bf = new BufferedReader(fr);
            String texto;
            String aux = "";
            while ((texto = bf.readLine()) != null) {
                aux = aux + texto + " ";
            }
            this.textAreaIngresado.setText(aux);
        } catch (Exception ex) {
        }

    }//GEN-LAST:event_botonExaminarActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu1;
    private javax.swing.JButton botonExaminar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelTextoIngresado;
    private javax.swing.JLabel labelTextoResultado;
    private javax.swing.JMenuItem menuItemEliminarPalabra;
    private javax.swing.JMenuItem menuItemMostrarInvertido;
    private javax.swing.JMenuItem menuItemMostrarPreposiciones;
    private javax.swing.JMenuItem menuItemMostrarTildadas;
    private javax.swing.JMenuItem menuItemOrdenAlfabetico;
    private javax.swing.JMenuItem menuItemReemplazarPalabra;
    private javax.swing.JMenu menuOperaciones;
    private javax.swing.JTextArea textAreaIngresado;
    private javax.swing.JTextArea textAreaResultado;
    // End of variables declaration//GEN-END:variables
}
