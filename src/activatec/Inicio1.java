/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activatec;
import CodigosPersonalizados.*;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan Viera
 */
public class Inicio1 extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private JFrame ventana;
    private JPanel contenedor;
    private int contador=0;
    private CardLayout apilar;
    private boolean esVisible = false;
    
    private Connection con;
    private Statement stm;
    
    public void Conectar(){
        
        String url = "jdbc:sqlserver://OswaldoDiaz:1433;databaseName=TAP;encrypt=true;trustServerCertificate=true;";
        
        try {
            con = DriverManager.getConnection(url, "UsuarioTAP", "123");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al conectar");
        }
        System.out.println("Conexión exitosa");
    }
    
    public Inicio1() {
        initComponents();
        Conectar();
        barraArriba1.setParentFrame(this);
        panelAjustes.setVisible(false);
                
        iconConfig.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (esVisible) {
                    panelAjustes.setVisible(false);
                    esVisible = false;
                } else {
                    panelAjustes.setVisible(true);
                    esVisible = true;
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
        });
        
            
        /*apilar = new CardLayout();
        contenedor = new JPanel(apilar);
        add(contenedor,BorderLayout.CENTER);
        
        contenedor.add(Carrusel1,"Panel 1");
        contenedor.add(Carrusel3,"Panel 3");
        
        new Thread(new CarouselRunnable()).start();
        setVisible(true);*/
    }
    
    /*private class CarouselRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(2000);  
                    contador = (contador + 1) % 3; 
                    apilar.show(contenedor, "Panel " + (contador + 1));  
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        iconConfig = new javax.swing.JLabel();
        panelAjustes = new PanelRedondo(65);
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barraArriba1 = new Componentes.BarraArriba();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new PanelRedondo(100);
        jPanel8 = new PanelRedondo(100);
        jPanel9 = new PanelRedondo(100);
        lblTigre = new javax.swing.JLabel();
        jPanel11 = new PanelRedondo(100);
        jPanel13 = new PanelRedondo(100);
        jLabel2 = new javax.swing.JLabel();
        Carrusel4 = new PanelRedondo(100);
        Carrusel5 = new PanelRedondo(100);
        lblNombre = new javax.swing.JLabel();
        panelActividades = new PanelRedondo(30);
        panelActividades1 = new PanelRedondo(30);
        panelActividades2 = new PanelRedondo(30)
        ;
        lblNombreAjuste = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(245, 245, 245));
        fondo.setToolTipText("");
        fondo.setMaximumSize(new java.awt.Dimension(62, 62));
        fondo.setMinimumSize(new java.awt.Dimension(62, 62));
        fondo.setLayout(null);

        iconConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/config (3).png"))); // NOI18N
        iconConfig.setText("jLabel3");
        fondo.add(iconConfig);
        iconConfig.setBounds(1280, 40, 50, 48);

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("jLabel3");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("jLabel3");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelAjustesLayout = new javax.swing.GroupLayout(panelAjustes);
        panelAjustes.setLayout(panelAjustesLayout);
        panelAjustesLayout.setHorizontalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelAjustesLayout.setVerticalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fondo.add(panelAjustes);
        panelAjustes.setBounds(1220, 40, 110, 150);
        fondo.add(barraArriba1);
        barraArriba1.setBounds(0, 6, 1366, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreGrande.png"))); // NOI18N
        fondo.add(jLabel1);
        jLabel1.setBounds(400, 90, 500, 500);

        jPanel1.setMinimumSize(new java.awt.Dimension(62, 64));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        fondo.add(jPanel1);
        jPanel1.setBounds(1260, 180, 62, 64);

        jPanel8.setMinimumSize(new java.awt.Dimension(62, 64));
        jPanel8.setPreferredSize(new java.awt.Dimension(62, 64));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        fondo.add(jPanel8);
        jPanel8.setBounds(1260, 280, 62, 64);

        jPanel9.setMinimumSize(new java.awt.Dimension(62, 64));
        jPanel9.setPreferredSize(new java.awt.Dimension(62, 64));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 64, Short.MAX_VALUE)
        );

        fondo.add(jPanel9);
        jPanel9.setBounds(1260, 380, 62, 64);

        lblTigre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreExtraescCy.png"))); // NOI18N
        fondo.add(lblTigre);
        lblTigre.setBounds(80, 50, 70, 76);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        fondo.add(jPanel11);
        jPanel11.setBounds(950, 430, 260, 120);

        jPanel13.setMinimumSize(new java.awt.Dimension(62, 64));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/torneo (2).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fondo.add(jPanel13);
        jPanel13.setBounds(50, 110, 320, 430);

        Carrusel4.setBackground(new java.awt.Color(255, 255, 255));
        Carrusel4.setMinimumSize(new java.awt.Dimension(1366, 768));
        Carrusel4.setName(""); // NOI18N
        Carrusel4.setLayout(null);

        Carrusel5.setBackground(new java.awt.Color(255, 255, 255));
        Carrusel5.setMinimumSize(new java.awt.Dimension(1366, 768));
        Carrusel5.setName(""); // NOI18N
        Carrusel5.setLayout(null);
        Carrusel4.add(Carrusel5);
        Carrusel5.setBounds(950, 120, 260, 280);

        fondo.add(Carrusel4);
        Carrusel4.setBounds(950, 120, 260, 280);

        lblNombre.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Avisos");
        fondo.add(lblNombre);
        lblNombre.setBounds(160, 60, 140, 30);

        javax.swing.GroupLayout panelActividadesLayout = new javax.swing.GroupLayout(panelActividades);
        panelActividades.setLayout(panelActividadesLayout);
        panelActividadesLayout.setHorizontalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );
        panelActividadesLayout.setVerticalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        fondo.add(panelActividades);
        panelActividades.setBounds(40, 590, 380, 160);

        javax.swing.GroupLayout panelActividades1Layout = new javax.swing.GroupLayout(panelActividades1);
        panelActividades1.setLayout(panelActividades1Layout);
        panelActividades1Layout.setHorizontalGroup(
            panelActividades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        panelActividades1Layout.setVerticalGroup(
            panelActividades1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        fondo.add(panelActividades1);
        panelActividades1.setBounds(450, 590, 440, 160);

        javax.swing.GroupLayout panelActividades2Layout = new javax.swing.GroupLayout(panelActividades2);
        panelActividades2.setLayout(panelActividades2Layout);
        panelActividades2Layout.setHorizontalGroup(
            panelActividades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );
        panelActividades2Layout.setVerticalGroup(
            panelActividades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        fondo.add(panelActividades2);
        panelActividades2.setBounds(920, 590, 420, 160);

        lblNombreAjuste.setFont(new java.awt.Font("SF Pro Display", 1, 12)); // NOI18N
        lblNombreAjuste.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblNombreAjuste.setText("Nombre");
        fondo.add(lblNombreAjuste);
        lblNombreAjuste.setBounds(1130, 60, 140, 15);

        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

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
            java.util.logging.Logger.getLogger(Inicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio1().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Carrusel4;
    private javax.swing.JPanel Carrusel5;
    private Componentes.BarraArriba barraArriba1;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel iconConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreAjuste;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JPanel panelActividades;
    private javax.swing.JPanel panelActividades1;
    private javax.swing.JPanel panelActividades2;
    private javax.swing.JPanel panelAjustes;
    // End of variables declaration//GEN-END:variables
}
