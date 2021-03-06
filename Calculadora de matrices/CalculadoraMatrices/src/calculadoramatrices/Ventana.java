
package calculadoramatrices;
/**
 * Clase que crea una ventana
 *
 * @author Felipe López
 * @version 1.0.0
 * @since CalculadoraMatrices 1.0.0
 */
import javax.swing.JOptionPane;


public class Ventana extends javax.swing.JFrame {
private MatrizEnForma1 a = new MatrizEnForma1(3, 4);
private MatrizEnForma1 b; 
            
    /**
     * Creates new form Ventana
     */
    public Ventana() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Calculadora de sistemas de ecuaciones 3 x 3");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMatriz = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaResultado = new javax.swing.JTextArea();
        botonIngresarMatriz = new javax.swing.JButton();
        botonCramer = new javax.swing.JButton();
        botonGauss = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setText("Ingresar los coeficientes del sistema de ecuaciones en la tabla:");

        tablaMatriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "X", "Y", "Z", "D"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaMatriz);

        textAreaResultado.setEditable(false);
        textAreaResultado.setColumns(20);
        textAreaResultado.setRows(5);
        textAreaResultado.setName(""); // NOI18N
        jScrollPane2.setViewportView(textAreaResultado);

        botonIngresarMatriz.setText("Ingresar matriz");
        botonIngresarMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarMatrizActionPerformed(evt);
            }
        });

        botonCramer.setText("Solucionar con Cramer");
        botonCramer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCramerActionPerformed(evt);
            }
        });

        botonGauss.setText("Solucionar con Gauss-Jordan");
        botonGauss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGaussActionPerformed(evt);
            }
        });

        botonLimpiar.setText("Limpiar todo");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(botonIngresarMatriz))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(botonCramer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonGauss))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(botonLimpiar)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonIngresarMatriz)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonCramer)
                            .addComponent(botonGauss))
                        .addGap(18, 18, 18)
                        .addComponent(botonLimpiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonIngresarMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIngresarMatrizActionPerformed
        try {
            a.construyeNodosCabeza();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    Tripleta t = new Tripleta(i + 1, j + 1, Double.parseDouble(String.valueOf(tablaMatriz.getValueAt(i, j))));
                    NodoDoble x = new NodoDoble(t);
                    a.conectaPorFilas(x);
                    a.conectaPorColumnas(x);
                }
            }
            this.textAreaResultado.setText("");
            this.textAreaResultado.append("La matriz original es:\n"+a.mostrarMatriz());
           this.botonIngresarMatriz.setVisible(false);
        } catch (Exception e) {
            this.botonIngresarMatriz.setVisible(true);
            JOptionPane.showMessageDialog(this, "Recuerde dejar sin seleccionar\nninguna celda luego de ingresar los\ndatos, mejor tabule y verifique que \ntodas las celdas tengan datos.");
        }
        
    }//GEN-LAST:event_botonIngresarMatrizActionPerformed

    private void botonCramerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCramerActionPerformed
        try {
            this.textAreaResultado.setText("");
            this.textAreaResultado.append("La matriz original es:\n"+a.mostrarMatriz());
            b= a.CopiarMatriz();
           textAreaResultado.append(b.cramer());
           this.botonCramer.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la lectura de datos, \nposiblemente no ha ingresado nada aún.");
            this.botonCramer.setVisible(true);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCramerActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        try {
            this.textAreaResultado.setText("");
            this.botonCramer.setVisible(true);
            this.botonIngresarMatriz.setVisible(true);
            this.botonGauss.setVisible(true);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    tablaMatriz.setValueAt(null, i, j);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la lectura de datos");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonGaussActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGaussActionPerformed
        try {
            this.textAreaResultado.setText("");
            this.textAreaResultado.append("La matriz original es:\n"+a.mostrarMatriz());
            b= a.CopiarMatriz();
            this.textAreaResultado.append(b.gaussJordan());
            this.botonGauss.setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en la lectura de datos, \nposiblemente no ha ingresado nada.");
            this.botonGauss.setVisible(true);
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGaussActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCramer;
    private javax.swing.JButton botonGauss;
    private javax.swing.JButton botonIngresarMatriz;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tablaMatriz;
    private javax.swing.JTextArea textAreaResultado;
    // End of variables declaration//GEN-END:variables
}
