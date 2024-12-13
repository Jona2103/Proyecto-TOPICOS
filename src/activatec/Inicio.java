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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jonathan Viera
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private JFrame ventana;
    private JPanel contenedor;
    private CardLayout apilar;
    private boolean esVisible = false;
    private Connection con;
    private Statement stm;
    
    
    
    
    DefaultTableModel m;
    DefaultTableModel mm;
    
 
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
    
    public void ConsultarAlumno(){
     
         //try {
          //      String query = "SELECT P.Nombre, P.ApellidoP, NoControl, C.Nombre FROM Persona WHERE NoControl = '"+s+"' FROM Persona P"+
           //         "INNER JOIN Carrera C ON C.CarreraID = P.CarreraID";
           // stm = con.createStatement();
          //  ResultSet rs = stm.executeQuery(query);
          //  lblNombreA.setText( rs.getString("Nombre") +  rs.getString("ApellidoP"));
          //  lblControl.setText(rs.getString("NoControl"));   
           // lblCarrera.setText(rs.getString("Nombre"));

            
            
            
       // } catch (SQLException ex) {
       //     Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
       // }
        
         
        
        //String query2 = "SELECT * FROM Persona WHERE"
        
    }
    
    
    
     public void llenarAct(){
        
        mm.addColumn("Nombre");
        mm.addColumn("Descripcion");
        mm.addColumn("Tipo de crédito");
        
        // Conectar y obtener los datos
         try {
            // Crear la sentencia SQL para obtener las actividades
           String query = "SELECT A.Nombre, A.Descripcion, C.Tipo FROM ActividadExtraescolar A "
                   + "INNER JOIN Credito C ON C.CreditoID = A.CreditoID ";



            // Ejecutar la consulta
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Recorrer el ResultSet y agregar los resultados al modelo de la tabla
            while (rs.next()) {
                // Crear un arreglo con los datos de cada fila
                Object[] fila = new Object[3];
                fila[0] = rs.getString("Nombre");
                fila[1] = rs.getString("Descripcion");
                fila[2] = rs.getString("Tipo");

                // Añadir la fila al modelo de la tabla
                mm.addRow(fila);
            }

            // Establecer el modelo de datos al JTable
           

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar las actividades: " + e.getMessage());
        }
    
    }
    
    public void llenarmisAct(){
        
        m.addColumn("Nombre");
        m.addColumn("Descripcion");
        m.addColumn("Tipo de crédito");
        
        // Conectar y obtener los datos
         try {
            // Crear la sentencia SQL para obtener las actividades
           String query = "SELECT A.Nombre, A.Descripcion, C.Tipo "
              + "FROM ActividadExtraescolar A "
              + "INNER JOIN Credito C ON C.CreditoID = A.CreditoID "
              + "INNER JOIN Estudiante_Actividad EA ON EA.ActividadID = A.ActividadID "
              + "WHERE EA.PersonaID = 1";



            // Ejecutar la consulta
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Recorrer el ResultSet y agregar los resultados al modelo de la tabla
            while (rs.next()) {
                // Crear un arreglo con los datos de cada fila
                Object[] fila = new Object[3];
                fila[0] = rs.getString("Nombre");
                fila[1] = rs.getString("Descripcion");
                fila[2] = rs.getString("Tipo");

                // Añadir la fila al modelo de la tabla
                m.addRow(fila);
            }

            // Establecer el modelo de datos al JTable
           

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar las actividades: " + e.getMessage());
        }
    
    }
    
    
    
   
    
    
    
    
    public Inicio() {
        initComponents();
        Login l = new Login();
        Conectar();
        ConsultarAlumno();
        m= (DefaultTableModel)jTable1.getModel();
        mm= (DefaultTableModel)tblActividadess.getModel();
        llenarmisAct();
        llenarAct();
        barraArriba1.setParentFrame(this);
        panelAjustes.setVisible(false);
        Actividades.setVisible(false);
        misActividades.setVisible(false);
        

                
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
        
        lblExtenderMis.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                misActividades.setVisible(true);
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
        
        lblExtenderAct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Actividades.setVisible(true);
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
        
        lblCerrarMisAct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                misActividades.setVisible(false);
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
        
        lblCerrarAct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Actividades.setVisible(false);
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
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        Actividades = new PanelRedondo(30);
        lblNombre4 = new javax.swing.JLabel();
        lblCerrarAct = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblActividadess = new javax.swing.JTable();
        misActividades = new PanelRedondo(30);
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblNombre3 = new javax.swing.JLabel();
        lblCerrarMisAct = new javax.swing.JLabel();
        panelActividades = new PanelRedondo(30);
        lblNombre = new javax.swing.JLabel();
        lblExtenderMis = new javax.swing.JLabel();
        iconConfig = new javax.swing.JLabel();
        panelAjustes = new PanelRedondo(65);
        salir = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        modoNigth = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        barraArriba1 = new Componentes.BarraArriba();
        tigerGrande = new javax.swing.JLabel();
        tecTepic = new PanelRedondo(100);
        jLabel3 = new javax.swing.JLabel();
        jPanel9 = new PanelRedondo(100);
        jLabel5 = new javax.swing.JLabel();
        lblTigre = new javax.swing.JLabel();
        jPanel11 = new PanelRedondo(30);
        panelCarrusel = new PanelRedondo(100);
        jLabel2 = new javax.swing.JLabel();
        Carrusel4 = new PanelRedondo(30);
        Carrusel5 = new PanelRedondo(100);
        avisos1 = new javax.swing.JLabel();
        lblNombreA = new javax.swing.JLabel();
        lblControl = new javax.swing.JLabel();
        avisos = new javax.swing.JLabel();
        panelActividades2 = new PanelRedondo(30);
        lblNombre8 = new javax.swing.JLabel();
        lblExtenderAct = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondo.setBackground(new java.awt.Color(233, 233, 233));
        fondo.setToolTipText("");
        fondo.setMaximumSize(new java.awt.Dimension(62, 62));
        fondo.setMinimumSize(new java.awt.Dimension(62, 62));
        fondo.setLayout(null);

        Actividades.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre4.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblNombre4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre4.setText("Actividades");

        lblCerrarAct.setFont(new java.awt.Font("SF Pro Display", 0, 36)); // NOI18N
        lblCerrarAct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCerrarAct.setText("-");
        lblCerrarAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tblActividadess.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblActividadess);

        javax.swing.GroupLayout ActividadesLayout = new javax.swing.GroupLayout(Actividades);
        Actividades.setLayout(ActividadesLayout);
        ActividadesLayout.setHorizontalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ActividadesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrarAct)
                .addGap(16, 16, 16))
            .addGroup(ActividadesLayout.createSequentialGroup()
                .addGroup(ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ActividadesLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblNombre4))
                    .addGroup(ActividadesLayout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(192, Short.MAX_VALUE))
        );
        ActividadesLayout.setVerticalGroup(
            ActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ActividadesLayout.createSequentialGroup()
                .addComponent(lblCerrarAct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(lblNombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );

        fondo.add(Actividades);
        Actividades.setBounds(290, 40, 830, 660);

        misActividades.setBackground(new java.awt.Color(255, 255, 255));
        misActividades.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        lblNombre3.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblNombre3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre3.setText("Mis Actividades");

        lblCerrarMisAct.setFont(new java.awt.Font("SF Pro Display", 0, 36)); // NOI18N
        lblCerrarMisAct.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblCerrarMisAct.setText("-");
        lblCerrarMisAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout misActividadesLayout = new javax.swing.GroupLayout(misActividades);
        misActividades.setLayout(misActividadesLayout);
        misActividadesLayout.setHorizontalGroup(
            misActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(misActividadesLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
            .addGroup(misActividadesLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblNombre3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCerrarMisAct)
                .addGap(16, 16, 16))
        );
        misActividadesLayout.setVerticalGroup(
            misActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, misActividadesLayout.createSequentialGroup()
                .addGroup(misActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(misActividadesLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(lblNombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblCerrarMisAct, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(72, Short.MAX_VALUE))
        );

        fondo.add(misActividades);
        misActividades.setBounds(290, 40, 830, 660);

        panelActividades.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre.setText("Mis Actividades");

        lblExtenderMis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        lblExtenderMis.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelActividadesLayout = new javax.swing.GroupLayout(panelActividades);
        panelActividades.setLayout(panelActividadesLayout);
        panelActividadesLayout.setHorizontalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(lblExtenderMis)
                .addContainerGap())
        );
        panelActividadesLayout.setVerticalGroup(
            panelActividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActividadesLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(panelActividadesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExtenderMis)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fondo.add(panelActividades);
        panelActividades.setBounds(250, 640, 380, 70);

        iconConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/configNegro.png"))); // NOI18N
        iconConfig.setText("jLabel3");
        fondo.add(iconConfig);
        iconConfig.setBounds(1280, 40, 50, 48);

        panelAjustes.setBackground(new java.awt.Color(255, 255, 255));

        salir.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        salir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir.setText("Salir");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));

        modoNigth.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        modoNigth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        modoNigth.setText("Modo Oscuro");

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout panelAjustesLayout = new javax.swing.GroupLayout(panelAjustes);
        panelAjustes.setLayout(panelAjustesLayout);
        panelAjustesLayout.setHorizontalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator3)
            .addGroup(panelAjustesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAjustesLayout.createSequentialGroup()
                        .addComponent(modoNigth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(13, 13, 13))
                    .addGroup(panelAjustesLayout.createSequentialGroup()
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelAjustesLayout.setVerticalGroup(
            panelAjustesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAjustesLayout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modoNigth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir)
                .addGap(18, 18, 18))
        );

        fondo.add(panelAjustes);
        panelAjustes.setBounds(1200, 40, 130, 160);
        fondo.add(barraArriba1);
        barraArriba1.setBounds(0, 6, 1366, 20);

        tigerGrande.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreGrande.png"))); // NOI18N
        fondo.add(tigerGrande);
        tigerGrande.setBounds(400, 90, 500, 500);

        tecTepic.setBackground(new java.awt.Color(255, 255, 255));
        tecTepic.setMinimumSize(new java.awt.Dimension(62, 64));
        tecTepic.setPreferredSize(new java.awt.Dimension(62, 64));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tpc-m (1).png"))); // NOI18N

        javax.swing.GroupLayout tecTepicLayout = new javax.swing.GroupLayout(tecTepic);
        tecTepic.setLayout(tecTepicLayout);
        tecTepicLayout.setHorizontalGroup(
            tecTepicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tecTepicLayout.setVerticalGroup(
            tecTepicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tecTepicLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        fondo.add(tecTepic);
        tecTepic.setBounds(1260, 240, 60, 60);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setMinimumSize(new java.awt.Dimension(62, 64));
        jPanel9.setPreferredSize(new java.awt.Dimension(62, 64));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tecnmB.png"))); // NOI18N
        jLabel5.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        fondo.add(jPanel9);
        jPanel9.setBounds(1260, 330, 62, 60);

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

        panelCarrusel.setMinimumSize(new java.awt.Dimension(62, 64));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/torneo (2).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout panelCarruselLayout = new javax.swing.GroupLayout(panelCarrusel);
        panelCarrusel.setLayout(panelCarruselLayout);
        panelCarruselLayout.setHorizontalGroup(
            panelCarruselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCarruselLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelCarruselLayout.setVerticalGroup(
            panelCarruselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        fondo.add(panelCarrusel);
        panelCarrusel.setBounds(50, 110, 320, 430);

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

        avisos1.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        avisos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        avisos1.setText("Carrera");
        Carrusel4.add(avisos1);
        avisos1.setBounds(0, 160, 260, 30);

        lblNombreA.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblNombreA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombreA.setText("Nombre Apellido");
        Carrusel4.add(lblNombreA);
        lblNombreA.setBounds(0, 40, 260, 30);

        lblControl.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblControl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblControl.setText("No Control");
        Carrusel4.add(lblControl);
        lblControl.setBounds(0, 100, 260, 30);

        fondo.add(Carrusel4);
        Carrusel4.setBounds(950, 120, 260, 280);

        avisos.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        avisos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        avisos.setText("Avisos");
        fondo.add(avisos);
        avisos.setBounds(160, 60, 140, 30);

        panelActividades2.setBackground(new java.awt.Color(255, 255, 255));

        lblNombre8.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        lblNombre8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNombre8.setText("Actividades");

        lblExtenderAct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/zoom.png"))); // NOI18N
        lblExtenderAct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panelActividades2Layout = new javax.swing.GroupLayout(panelActividades2);
        panelActividades2.setLayout(panelActividades2Layout);
        panelActividades2Layout.setHorizontalGroup(
            panelActividades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividades2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(lblExtenderAct)
                .addContainerGap())
        );
        panelActividades2Layout.setVerticalGroup(
            panelActividades2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelActividades2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(lblNombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(panelActividades2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblExtenderAct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fondo.add(panelActividades2);
        panelActividades2.setBounds(670, 640, 380, 70);

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
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Actividades;
    private javax.swing.JPanel Carrusel4;
    private javax.swing.JPanel Carrusel5;
    private javax.swing.JLabel avisos;
    private javax.swing.JLabel avisos1;
    private Componentes.BarraArriba barraArriba1;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel iconConfig;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCerrarAct;
    private javax.swing.JLabel lblCerrarMisAct;
    private javax.swing.JLabel lblControl;
    private javax.swing.JLabel lblExtenderAct;
    private javax.swing.JLabel lblExtenderMis;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre3;
    private javax.swing.JLabel lblNombre4;
    private javax.swing.JLabel lblNombre8;
    private javax.swing.JLabel lblNombreA;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JPanel misActividades;
    private javax.swing.JLabel modoNigth;
    private javax.swing.JPanel panelActividades;
    private javax.swing.JPanel panelActividades2;
    private javax.swing.JPanel panelAjustes;
    private javax.swing.JPanel panelCarrusel;
    private javax.swing.JLabel salir;
    private javax.swing.JTable tblActividadess;
    private javax.swing.JPanel tecTepic;
    private javax.swing.JLabel tigerGrande;
    // End of variables declaration//GEN-END:variables
}
