/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activatec;
import Componentes.*;
import CodigosPersonalizados.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author Jonathan Viera
 */
public class Inicio extends javax.swing.JFrame{

    /**
     * Creates new form Login
     */
    
        
    public Inicio() {
        initComponents();
                      
        barraArriba1.setParentFrame(this);
        
        panelInicio.setPreferredSize(new Dimension(1010, 1789));
        cuadroDelScroll.setLayout(new GridLayout(0, 3, 10, 10));
        panelInicio.setVisible(true);
        panelNovedades.setVisible(false);
        panelMisActividades.setVisible(false);
       
        
        lblInicio.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Font negrita = new Font("Tahoma", Font.BOLD, 20);
                Font normal = new Font("Tahoma", Font.PLAIN, 18);

                lblInicio.setFont(negrita);
                lblNovedades.setFont (normal);
                lblMisActividades.setFont (normal);
                lblNovedades.setFont(normal);
                
                panelInicio.setVisible(true);
                panelNovedades.setVisible(false);
                panelMisActividades.setVisible(false);
                
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });//Fin inicio
        
        lblMisActividades.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Font negrita = new Font("Tahoma", Font.BOLD, 20);
                Font normal = new Font("Tahoma", Font.PLAIN, 18);

                lblInicio.setFont(normal);
                lblNovedades.setFont (normal);
                lblMisActividades.setFont (negrita);
                
                panelInicio.setVisible(false);
                panelNovedades.setVisible(false);
                panelMisActividades.setVisible(true);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });//finMisActvidades
        
        lblNovedades.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Font negrita = new Font("Tahoma", Font.BOLD, 20);
                Font normal = new Font("Tahoma", Font.PLAIN, 18);

                lblInicio.setFont(normal);
                lblNovedades.setFont (negrita);
                lblMisActividades.setFont (normal);
                lblNovedades.setFont(normal);
                
                panelInicio.setVisible(false);
                panelNovedades.setVisible(true);
                panelMisActividades.setVisible(false);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });//fin Activiidades
        
        lblNovedades.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Font negrita = new Font("Tahoma", Font.BOLD, 20);
                Font normal = new Font("Tahoma", Font.PLAIN, 18);

                lblInicio.setFont(normal);
                lblNovedades.setFont (normal);
                lblMisActividades.setFont (normal);
                lblNovedades.setFont(negrita);
            }
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });//fin Novedades
        
        lblZoom.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon zoom = new ImageIcon(originalIcon.getImage().getScaledInstance(zoomWidth, zoomHeight, Image.SCALE_SMOOTH));
                lblZoom.setIcon(zoom);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblZoom.setIcon(originalIcon);
            }
        });
        
        lblTigre.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                ImageIcon zoom = new ImageIcon(originalIcon.getImage().getScaledInstance(zoomWidth, zoomHeight, Image.SCALE_SMOOTH));
                lblTigre.setIcon(zoom);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblTigre.setIcon(originalIcon);
            }
        });
    
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
        BarraArriba = new javax.swing.JPanel();
        barraArriba1 = new Componentes.BarraArriba();
        jPanel1 = new javax.swing.JPanel();
        lblTigre = new javax.swing.JLabel();
        txtBuscar = new cajatxtRedondo(20, 20, 20);
        iconBuscar = new javax.swing.JLabel();
        flechaPaAbajo = new javax.swing.JLabel();
        lblInicio = new javax.swing.JLabel();
        lblMisActividades = new javax.swing.JLabel();
        lblNovedades = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelInicio = new PanelRedondo(40);
        jScrollPane1 = new javax.swing.JScrollPane();
        cuadroDelScroll = new javax.swing.JPanel();
        lblmnp = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        lblZoom = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jLabel224 = new javax.swing.JLabel();
        panelMisActividades = new PanelRedondo(40);
        lblcarrusel = new javax.swing.JLabel();
        panelNovedades = new PanelRedondo(40);
        ACT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        fondoGris.setBackground(new java.awt.Color(245, 245, 245));
        fondoGris.setPreferredSize(new java.awt.Dimension(1366, 768));

        BarraArriba.setPreferredSize(new java.awt.Dimension(1366, 37));
        BarraArriba.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        barraArriba1.setForeground(new java.awt.Color(227, 109, 30));
        BarraArriba.add(barraArriba1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblTigre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreExtraescCy.png"))); // NOI18N

        txtBuscar.setBackground(new java.awt.Color(245, 245, 245));
        txtBuscar.setFont(new java.awt.Font("Mongolian Baiti", 0, 18)); // NOI18N
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setBorder(BorderFactory.createEmptyBorder());
        txtBuscar.setCaretColor(new java.awt.Color(0, 0, 0));

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa3.png"))); // NOI18N

        flechaPaAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaPaAbajo.png"))); // NOI18N

        lblInicio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(0, 0, 0));
        lblInicio.setText("Inicio");

        lblMisActividades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMisActividades.setForeground(new java.awt.Color(0, 0, 0));
        lblMisActividades.setText("Mis Actividades");

        lblNovedades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNovedades.setForeground(new java.awt.Color(0, 0, 0));
        lblNovedades.setText("Novedades");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notfayer_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblTigre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flechaPaAbajo)
                .addGap(102, 102, 102)
                .addComponent(lblInicio)
                .addGap(45, 45, 45)
                .addComponent(lblMisActividades)
                .addGap(41, 41, 41)
                .addComponent(lblNovedades)
                .addGap(191, 191, 191)
                .addComponent(iconBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTigre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(flechaPaAbajo)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblInicio)
                            .addComponent(lblMisActividades)
                            .addComponent(lblNovedades))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(iconBuscar)))
                        .addGap(26, 26, 26)))
                .addGap(24, 24, 24))
        );

        BarraArriba.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, -1));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setMinimumSize(new java.awt.Dimension(1043, 614));
        panelInicio.setName(""); // NOI18N
        panelInicio.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(1010, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(1010, 600));

        cuadroDelScroll.setBackground(new java.awt.Color(255, 255, 255));
        cuadroDelScroll.setMaximumSize(new java.awt.Dimension(500, 3000));
        cuadroDelScroll.setMinimumSize(new java.awt.Dimension(0, 0));
        cuadroDelScroll.setPreferredSize(new java.awt.Dimension(500, 600));

        lblmnp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        jLabel220.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        lblZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Captura de pantalla 2024-08-30 2039320.png"))); // NOI18N

        javax.swing.GroupLayout cuadroDelScrollLayout = new javax.swing.GroupLayout(cuadroDelScroll);
        cuadroDelScroll.setLayout(cuadroDelScrollLayout);
        cuadroDelScrollLayout.setHorizontalGroup(
            cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuadroDelScrollLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(cuadroDelScrollLayout.createSequentialGroup()
                        .addComponent(jLabel222)
                        .addGap(76, 76, 76)
                        .addComponent(lblZoom))
                    .addGroup(cuadroDelScrollLayout.createSequentialGroup()
                        .addComponent(jLabel224)
                        .addGap(89, 89, 89)
                        .addComponent(lblmnp)))
                .addGap(121, 121, 121)
                .addGroup(cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel220)
                    .addComponent(jLabel223))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        cuadroDelScrollLayout.setVerticalGroup(
            cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cuadroDelScrollLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel220)
                    .addComponent(lblmnp)
                    .addComponent(jLabel224))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addGroup(cuadroDelScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel222, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel223)
                    .addComponent(lblZoom))
                .addGap(105, 105, 105))
        );

        // Almacena el ícono original
        originalIcon = (ImageIcon) lblZoom.getIcon();

        // Define el tamaño original de la imagen
        originalWidth = originalIcon.getIconWidth();
        originalHeight = originalIcon.getIconHeight();

        // Calcula el tamaño para el zoom (20% más grande)
        zoomWidth = (int) (originalWidth * 1.2);
        zoomHeight = (int) (originalHeight * 1.2);

        jScrollPane1.setViewportView(cuadroDelScroll);

        panelInicio.add(jScrollPane1);
        jScrollPane1.setBounds(130, 20, 870, 590);

        panelMisActividades.setBackground(new java.awt.Color(255, 255, 255));
        panelMisActividades.setMinimumSize(new java.awt.Dimension(1043, 614));
        panelMisActividades.setLayout(null);

        lblcarrusel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/inicioActivatec.jpg"))); // NOI18N
        panelMisActividades.add(lblcarrusel);
        lblcarrusel.setBounds(60, 10, 911, 312);

        panelNovedades.setBackground(new java.awt.Color(255, 255, 255));
        panelNovedades.setMinimumSize(new java.awt.Dimension(1043, 614));
        panelNovedades.setLayout(null);

        ACT.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        ACT.setText("ACTIVIDADES");
        panelNovedades.add(ACT);
        ACT.setBounds(280, 180, 340, 140);

        javax.swing.GroupLayout fondoGrisLayout = new javax.swing.GroupLayout(fondoGris);
        fondoGris.setLayout(fondoGrisLayout);
        fondoGrisLayout.setHorizontalGroup(
            fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraArriba, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoGrisLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelMisActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 1029, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169))
            .addGroup(fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoGrisLayout.createSequentialGroup()
                    .addContainerGap(172, Short.MAX_VALUE)
                    .addComponent(panelNovedades, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(171, Short.MAX_VALUE)))
            .addGroup(fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoGrisLayout.createSequentialGroup()
                    .addContainerGap(170, Short.MAX_VALUE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(170, Short.MAX_VALUE)))
        );
        fondoGrisLayout.setVerticalGroup(
            fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoGrisLayout.createSequentialGroup()
                .addComponent(BarraArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(panelMisActividades, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoGrisLayout.createSequentialGroup()
                    .addGap(0, 154, Short.MAX_VALUE)
                    .addComponent(panelNovedades, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(fondoGrisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fondoGrisLayout.createSequentialGroup()
                    .addGap(0, 153, Short.MAX_VALUE)
                    .addComponent(panelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoGris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoGris, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ACT;
    private javax.swing.JPanel BarraArriba;
    private Componentes.BarraArriba barraArriba1;
    private javax.swing.JPanel cuadroDelScroll;
    private javax.swing.JLabel flechaPaAbajo;
    private javax.swing.JPanel fondoGris;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblMisActividades;
    private javax.swing.JLabel lblNovedades;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JLabel lblZoom;
    private ImageIcon originalIcon;
    private int originalWidth, originalHeight, zoomWidth, zoomHeight;
    private javax.swing.JLabel lblcarrusel;
    private javax.swing.JLabel lblmnp;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelMisActividades;
    private javax.swing.JPanel panelNovedades;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
