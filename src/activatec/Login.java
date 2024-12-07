/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activatec;
import CodigosPersonalizados.*;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;

/**
 *
 * @author Jonathan Viera
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    int cont=0;
    public Login() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblIngresar.addMouseListener(new Interna());
        PanelRedondo panel = new PanelRedondo(20); // Radio de 20 píxeles para los bordes
        panel.setBackground(Color.LIGHT_GRAY); // Color de fondo del panel
        txtPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                boolean d = (c>='0' && c<='9');
                if(!d || cont==4){
                e.consume();
                }else{
                cont++;
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {}
        });
        txtNc.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtNc.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtNc.setText("Ingrese su No. Control");
            }
        });
        
    }
    
    class Interna implements MouseListener{

        @Override
        public void mouseClicked(MouseEvent e) {
            String s = txtNc.getText();
            if (s.charAt(0) == '2') {
                showMessageDialog(null, "ES ESTUDIANTE");
            } else {
                if (s.charAt(0) == '3') {
                    showMessageDialog(null, "ES INSTRUCTOR");
                } else {
                    if (s.charAt(0) == '4') {
                        showMessageDialog(null, "ES ADMINSTRATIVO");
                    } else {
                        showMessageDialog(null, "NUMERO DE CONTROL INCORRECTO");
                    }
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoGris = new javax.swing.JPanel();
        contenedorBlanco = new PanelRedondo(100);
        NoCtrl = new javax.swing.JLabel();
        txtNc = new javax.swing.JTextField();
        jspNc = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        jspNip = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        iniSes = new javax.swing.JLabel();
        OlvNip = new javax.swing.JLabel();
        tigre = new javax.swing.JLabel();
        jpnlIngresar = new PanelRedondo(40);
        lblIngresar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);

        fondoGris.setBackground(new java.awt.Color(245, 245, 245));
        fondoGris.setForeground(new java.awt.Color(255, 255, 255));
        fondoGris.setPreferredSize(new java.awt.Dimension(1366, 768));

        contenedorBlanco.setBackground(new java.awt.Color(255, 255, 255));

        NoCtrl.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        NoCtrl.setText("No.Control:");

        txtNc.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        txtNc.setForeground(new java.awt.Color(204, 204, 204));
        txtNc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNc.setText("Ingrese su No. Control");
        txtNc.setBorder(null);
        txtNc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNcActionPerformed(evt);
            }
        });

        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPassword.setText("HOLA");
        txtPassword.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel4.setText("NIP:");

        iniSes.setFont(new java.awt.Font("Roboto Black", 0, 28)); // NOI18N
        iniSes.setText("Iniciar Sesión");

        OlvNip.setFont(new java.awt.Font("Roboto Light", 3, 14)); // NOI18N
        OlvNip.setText("¿Olvidaste tu NIP?");
        OlvNip.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tigre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/niu.png"))); // NOI18N

        jpnlIngresar.setBackground(new java.awt.Color(255, 102, 0));
        jpnlIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblIngresar.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblIngresar.setForeground(new java.awt.Color(255, 255, 255));
        lblIngresar.setText("Ingresar");

        javax.swing.GroupLayout jpnlIngresarLayout = new javax.swing.GroupLayout(jpnlIngresar);
        jpnlIngresar.setLayout(jpnlIngresarLayout);
        jpnlIngresarLayout.setHorizontalGroup(
            jpnlIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlIngresarLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(lblIngresar)
                .addGap(17, 17, 17))
        );
        jpnlIngresarLayout.setVerticalGroup(
            jpnlIngresarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlIngresarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblIngresar)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout contenedorBlancoLayout = new javax.swing.GroupLayout(contenedorBlanco);
        contenedorBlanco.setLayout(contenedorBlancoLayout);
        contenedorBlancoLayout.setHorizontalGroup(
            contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBlancoLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createSequentialGroup()
                        .addComponent(tigre)
                        .addGap(174, 174, 174))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createSequentialGroup()
                        .addComponent(iniSes)
                        .addGap(211, 211, 211))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createSequentialGroup()
                        .addGroup(contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(contenedorBlancoLayout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(OlvNip, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(107, 107, 107))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(contenedorBlancoLayout.createSequentialGroup()
                                    .addComponent(NoCtrl)
                                    .addGap(19, 19, 19)
                                    .addComponent(txtNc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(contenedorBlancoLayout.createSequentialGroup()
                                    .addGap(150, 150, 150)
                                    .addComponent(jspNc, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createSequentialGroup()
                                .addGroup(contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(contenedorBlancoLayout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(22, 22, 22)
                                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(contenedorBlancoLayout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jspNip, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(42, 42, 42)))
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorBlancoLayout.createSequentialGroup()
                        .addComponent(jpnlIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(224, 224, 224))))
        );
        contenedorBlancoLayout.setVerticalGroup(
            contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBlancoLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(iniSes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tigre)
                .addGap(33, 33, 33)
                .addGroup(contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NoCtrl)
                    .addComponent(txtNc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jspNc, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(contenedorBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(contenedorBlancoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jspNip, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpnlIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(OlvNip, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout fondoGrisLayout = new javax.swing.GroupLayout(fondoGris);
        fondoGris.setLayout(fondoGrisLayout);
        fondoGrisLayout.setHorizontalGroup(
            fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoGrisLayout.createSequentialGroup()
                .addGap(364, 364, 364)
                .addComponent(contenedorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(409, Short.MAX_VALUE))
        );
        fondoGrisLayout.setVerticalGroup(
            fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoGrisLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(contenedorBlanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        getContentPane().add(fondoGris, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNcActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NoCtrl;
    private javax.swing.JLabel OlvNip;
    private javax.swing.JPanel contenedorBlanco;
    private javax.swing.JPanel fondoGris;
    private javax.swing.JLabel iniSes;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpnlIngresar;
    private javax.swing.JSeparator jspNc;
    private javax.swing.JSeparator jspNip;
    private javax.swing.JLabel lblIngresar;
    private javax.swing.JLabel tigre;
    private javax.swing.JTextField txtNc;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
