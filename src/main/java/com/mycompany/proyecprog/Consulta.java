/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecprog;

/**
 *
 * @author Franco
 */
public class Consulta extends javax.swing.JFrame {

    /**
     * Creates new form Consulta
     */
    public Consulta() {
        initComponents();
        this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        consulta_dni = new javax.swing.JTextField();
        boton_consultar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nombre_consulta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        telefono_consulta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        direccion_consulta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        empleadoperma_consulta = new javax.swing.JTextField();
        seleccionar_curso = new javax.swing.JComboBox<>();
        agregar_curso = new javax.swing.JButton();
        boton_cursos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar por DNI");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 200, 40));

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DNI");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));
        jPanel1.add(consulta_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 95, -1));

        boton_consultar.setText("Consultar");
        boton_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(boton_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        jPanel1.add(nombre_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 123, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));
        jPanel1.add(telefono_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 123, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Direccion");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));
        jPanel1.add(direccion_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 123, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Empleado permanente: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, -1, -1));
        jPanel1.add(empleadoperma_consulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 123, -1));

        seleccionar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionar_cursoActionPerformed(evt);
            }
        });
        jPanel1.add(seleccionar_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 80, -1));

        agregar_curso.setText("Agregar curso");
        agregar_curso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregar_cursoActionPerformed(evt);
            }
        });
        jPanel1.add(agregar_curso, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, -1, -1));

        boton_cursos.setText("Ver cursos");
        jPanel1.add(boton_cursos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 590, -1, -1));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CONSULTAR EMPLEADOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregar_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agregar_cursoActionPerformed

    private void boton_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_consultarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boton_consultarActionPerformed

    private void seleccionar_cursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionar_cursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleccionar_cursoActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton agregar_curso;
    public javax.swing.JButton boton_consultar;
    public javax.swing.JButton boton_cursos;
    public javax.swing.JTextField consulta_dni;
    public javax.swing.JTextField direccion_consulta;
    public javax.swing.JTextField empleadoperma_consulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField nombre_consulta;
    public javax.swing.JComboBox<unCurso> seleccionar_curso;
    public javax.swing.JTextField telefono_consulta;
    // End of variables declaration//GEN-END:variables
}
