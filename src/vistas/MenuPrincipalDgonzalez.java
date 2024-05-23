/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import bbdd.ConexionDgonzalez;
import static bbdd.ConexionDgonzalez.recuperarDatosUserLogado;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author David
 */
public class MenuPrincipalDgonzalez extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipalDgonzalez
     */
    public MenuPrincipalDgonzalez() throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
        initComponents();
    String tipoUsuario = (String) (LoginDgonzalez.usuarioLogadoDgonzalez[2]);
    LabelFecha.setText(java.time.LocalDate.now().toString());
    LabelFacultativo.setText("Facultativo: " + (LoginDgonzalez.usuarioLogadoDgonzalez[0]));     
    LabelNumeroCol.setText("N� de colegiado: " + (LoginDgonzalez.usuarioLogadoDgonzalez[1]));    
    DefaultTableModel modelo = (DefaultTableModel) TablaPaciente.getModel();
    
    if (tipoUsuario.equals("MEDICO")){
           botonConsultas.setEnabled(true);
           botonPaciente.setEnabled(true);  
           LabelAgenciaCitas.setText("AGENDA M�DICA");
           ConexionDgonzalez.recuperaCitasMedicasDgonzalez(modelo);
       } else if (tipoUsuario.equals("ENFERMERIA")) {
           botonEnfermeria.setEnabled(true);
           LabelAgenciaCitas.setText("AGENDA ENFERMER�A");
           ConexionDgonzalez.recuperaCitasEnfermeriaDgonzalez(modelo);
       } else if (tipoUsuario.equals("ADMIN")) {
           botonPersonal.setEnabled(true);
       }
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        LabelNumeroCol = new javax.swing.JLabel();
        LabelFacultativo = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        botonConsultas = new javax.swing.JButton();
        botonPaciente = new javax.swing.JButton();
        botonEnfermeria = new javax.swing.JButton();
        botonPersonal = new javax.swing.JButton();
        LabelAgenciaCitas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPaciente = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setPreferredSize(new java.awt.Dimension(1275, 750));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/logo_good.png"))); // NOI18N

        LabelFecha.setText("Fecha");

        LabelNumeroCol.setText("n colegiado");

        LabelFacultativo.setText("Facultativo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelNumeroCol)
                    .addComponent(LabelFecha)
                    .addComponent(LabelFacultativo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(70, 70, 70))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(LabelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelFacultativo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelNumeroCol)))
                .addGap(15, 15, 15))
        );

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 70, 0));

        botonConsultas.setBackground(new java.awt.Color(0, 153, 255));
        botonConsultas.setForeground(new java.awt.Color(255, 255, 255));
        botonConsultas.setText("CONSULTAS");
        botonConsultas.setEnabled(false);
        botonConsultas.setPreferredSize(new java.awt.Dimension(225, 135));
        botonConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultasActionPerformed(evt);
            }
        });
        jPanel4.add(botonConsultas);

        botonPaciente.setBackground(new java.awt.Color(0, 153, 255));
        botonPaciente.setForeground(new java.awt.Color(255, 255, 255));
        botonPaciente.setText("PACIENTE");
        botonPaciente.setEnabled(false);
        botonPaciente.setPreferredSize(new java.awt.Dimension(225, 135));
        jPanel4.add(botonPaciente);

        botonEnfermeria.setBackground(new java.awt.Color(0, 153, 255));
        botonEnfermeria.setForeground(new java.awt.Color(255, 255, 255));
        botonEnfermeria.setText("ENFERMERIA");
        botonEnfermeria.setEnabled(false);
        botonEnfermeria.setPreferredSize(new java.awt.Dimension(225, 135));
        botonEnfermeria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEnfermeriaActionPerformed(evt);
            }
        });
        jPanel4.add(botonEnfermeria);

        botonPersonal.setBackground(new java.awt.Color(0, 153, 255));
        botonPersonal.setForeground(new java.awt.Color(255, 255, 255));
        botonPersonal.setText("PERSONAL MEDICO");
        botonPersonal.setEnabled(false);
        botonPersonal.setPreferredSize(new java.awt.Dimension(225, 135));
        jPanel4.add(botonPersonal);

        LabelAgenciaCitas.setForeground(new java.awt.Color(255, 255, 255));
        LabelAgenciaCitas.setText("AGENCIA DE CITAS M�DICAS ");

        TablaPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "DIA", "HORA"
            }
        ));
        jScrollPane1.setViewportView(TablaPaciente);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/principal.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelAgenciaCitas)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(217, 217, 217))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(LabelAgenciaCitas)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel2)))
                .addGap(0, 101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1257, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botonConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultasActionPerformed
    MedicoDgonzalez md = new MedicoDgonzalez();
    md.setVisible(true);
    }//GEN-LAST:event_botonConsultasActionPerformed

    private void botonEnfermeriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEnfermeriaActionPerformed
    EnfermeriaDgonzalez ed = new EnfermeriaDgonzalez();
    ed.setVisible(true);
    }//GEN-LAST:event_botonEnfermeriaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPrincipalDgonzalez().setVisible(true);
                } catch (InvalidKeyException ex) {
                    Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                } catch (BadPaddingException ex) {
                    Logger.getLogger(MenuPrincipalDgonzalez.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelAgenciaCitas;
    private javax.swing.JLabel LabelFacultativo;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelNumeroCol;
    private javax.swing.JTable TablaPaciente;
    private javax.swing.JButton botonConsultas;
    private javax.swing.JButton botonEnfermeria;
    private javax.swing.JButton botonPaciente;
    private javax.swing.JButton botonPersonal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
      
   public void ActivarCamposSegunTipoDgonzalez(){
       String tipoUsuario = (String) (LoginDgonzalez.usuarioLogadoDgonzalez[2]);
       
   }
}
