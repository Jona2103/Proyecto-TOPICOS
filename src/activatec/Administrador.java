/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activatec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Jonathan Viera
 */
public class Administrador extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    
    private JFrame ventana;
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
    
    
    public Administrador() {
        initComponents();
        Conectar();
        llenarTipoCredito();
        llenarInstructor();
        llenarActividad();
        llenarInstalacion();
        barraArriba1.setParentFrame(this);
        btnAgregaract.addActionListener(new Interna());
        CrearGrupo.setVisible(false);
        btnGrupo.addActionListener(
        new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                insertarGrupo();
            }
        
        }
        );
Añadir.setVisible(false);

Crear.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Cambiar la visibilidad del panel "CrearGrupo" cuando se haga clic en el JLabel "Crear"
        CrearGrupo.setVisible(true);  // Mostrar el panel CrearGrupo
        Añadir.setVisible(false);     // Ocultar el panel Añadir
    }
});

Agregar.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Cambiar la visibilidad del panel "Añadir" cuando se haga clic en el JLabel "Agregar"
        Añadir.setVisible(true);
       // Mostrar el panel Añadir
        CrearGrupo.setVisible(false); // Ocultar el panel CrearGrupo
    }
});


    }
    
    class Interna implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = txtNombre.getText();
        String desc = TxtDescripcion.getText();
        String tC = CmbCreditos.getSelectedItem().toString();
        String[] C = tC.split("-");
        String nc = C[0]; // CreditoID

        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO ActividadExtraescolar (Nombre, Descripcion, CreditoID) VALUES (?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, nombre); 
            ps.setString(2, desc);   
            ps.setInt(3, Integer.parseInt(nc));

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Registro insertado correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException closeEx) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, closeEx);
                }
            }
        }
    }
}
    
        
    
    public void llenarTipoCredito(){
        try {
            stm = con.createStatement();
            String query = "SELECT * FROM Credito";
            ResultSet res = stm.executeQuery(query);
            String tipo = ""; int id = 0;
            while(res.next()){
                id = res.getInt("CreditoID"); tipo = res.getString("Tipo");
                CmbCreditos.addItem(id+"-"+tipo);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
 
    
    public void llenarInstructor(){
        try {
            stm = con.createStatement();
            String query = "SELECT * FROM Persona WHERE RolID=3 ";
            ResultSet res = stm.executeQuery(query);
            String nam = ""; int id=0;
            while(res.next()){
                id = res.getInt("PersonaID"); nam = res.getString("Nombre");
                cmbInstructor.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void llenarActividad(){
        try {
            stm = con.createStatement();
            String query = "SELECT * FROM ActividadExtraescolar";
            ResultSet res = stm.executeQuery(query);
            String nam = ""; int id=0;
            while(res.next()){
                nam = res.getString("Nombre"); id = res.getInt("ActividadID");
                cmbActividad.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void insertarGrupo(){
        
        String tC = cmbHorario.getSelectedItem().toString();
        
        
        String iC = cmbInstalacion.getSelectedItem().toString();
        String[] I = iC.split("-");
        String ic = I[0]; 
        
        String aC = cmbActividad.getSelectedItem().toString();
        String[] A = aC.split("-");
        String nc = A[0]; 
        
        
        String inC = cmbInstructor.getSelectedItem().toString();
        String[] IN = inC.split("-");
        String nin = IN[0]; 
        
        int cap = Integer.parseInt(txtCapacidad.getText());

        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO Grupo (Horario, Capacidad, ActividadID, InstalacionID, PersonaID) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            
            ps.setString(1, tC); 
            ps.setInt(2, cap);   
            ps.setInt(3, Integer.parseInt(nc));
            ps.setInt(4, Integer.parseInt(ic));
            ps.setInt(5, Integer.parseInt(nin));

            int filasInsertadas = ps.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Registro insertado correctamente.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException closeEx) {
                    Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, closeEx);
                }
            }
        }
   
    
    }
    
    
     public void llenarInstalacion(){
        try {
            stm = con.createStatement();
            String query = "SELECT * FROM Instalacion";
            ResultSet res = stm.executeQuery(query);
            String nam = ""; int id=0;
            while(res.next()){
                nam = res.getString("Nombre");
                id = res.getInt("InstalacionID");
                cmbInstalacion.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
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
        lblTigre = new javax.swing.JLabel();
        iconBuscar = new javax.swing.JLabel();
        flechaPaAbajo = new javax.swing.JLabel();
        Crear = new javax.swing.JLabel();
        Agregar = new javax.swing.JLabel();
        lblNovedades = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barraArriba1 = new Componentes.BarraArriba();
        Añadir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        CmbCreditos = new javax.swing.JComboBox<>();
        btnAgregaract = new javax.swing.JButton();
        CrearGrupo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        cmbActividad = new javax.swing.JComboBox<>();
        cmbIntructor = new javax.swing.JComboBox<>();
        cmbInstalacion = new javax.swing.JComboBox<>();
        txtCapacidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblTigre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreExtraescCy.png"))); // NOI18N

        iconBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lupa3.png"))); // NOI18N

        flechaPaAbajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaPaAbajo.png"))); // NOI18N

        Crear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Crear.setText("Crear grupo");

        Agregar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Agregar.setText("Agregar una Actividades");

        lblNovedades.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNovedades.setText("Ver Grupo");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notfayer_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblTigre, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flechaPaAbajo)
                .addGap(76, 76, 76)
                .addComponent(Crear)
                .addGap(35, 35, 35)
                .addComponent(Agregar)
                .addGap(61, 61, 61)
                .addComponent(lblNovedades)
                .addGap(207, 207, 207)
                .addComponent(iconBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 534, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(49, 49, 49))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTigre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Crear)
                                    .addComponent(Agregar)
                                    .addComponent(lblNovedades))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(iconBuscar))
                                .addGap(26, 26, 26))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(flechaPaAbajo)
                        .addGap(13, 13, 13)))
                .addGap(24, 24, 24))
        );

        Añadir.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre Actividad ");

        jLabel8.setText("Descripcion ");

        jLabel9.setText("Tipo de Credito ");

        CmbCreditos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        btnAgregaract.setText("Agregar");

        javax.swing.GroupLayout AñadirLayout = new javax.swing.GroupLayout(Añadir);
        Añadir.setLayout(AñadirLayout);
        AñadirLayout.setHorizontalGroup(
            AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AñadirLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AñadirLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AñadirLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AñadirLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnAgregaract))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AñadirLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(CmbCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))
                            .addGroup(AñadirLayout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        AñadirLayout.setVerticalGroup(
            AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AñadirLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(AñadirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CmbCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnAgregaract)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        CrearGrupo.setBackground(new java.awt.Color(255, 255, 255));
        CrearGrupo.setToolTipText("");

        jLabel4.setText("Horario");

        jLabel5.setText("Actividad");

        jLabel6.setText("Intructor");

        jLabel7.setText("Instalacion");

        jLabel2.setText("Capacidad");

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "08hrs-10hrs", "17hrs-19hrs", "19hrs-21hrs" }));

        cmbActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        cmbIntructor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        cmbInstalacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        javax.swing.GroupLayout CrearGrupoLayout = new javax.swing.GroupLayout(CrearGrupo);
        CrearGrupo.setLayout(CrearGrupoLayout);
        CrearGrupoLayout.setHorizontalGroup(
            CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearGrupoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CrearGrupoLayout.createSequentialGroup()
                        .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CrearGrupoLayout.createSequentialGroup()
                        .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(24, 24, 24)
                        .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbIntructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 160, Short.MAX_VALUE))
        );
        CrearGrupoLayout.setVerticalGroup(
            CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CrearGrupoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmbIntructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barraArriba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 28, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153)
                .addComponent(CrearGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barraArriba1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Añadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CrearGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(323, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 new MenuDesplegable().setVisible(true);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrador().setVisible(true);
                 new MenuDesplegable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agregar;
    private javax.swing.JPanel Añadir;
    private javax.swing.JComboBox<String> CmbCreditos;
    private javax.swing.JLabel Crear;
    private javax.swing.JPanel CrearGrupo;
    private javax.swing.JTextField TxtDescripcion;
    private Componentes.BarraArriba barraArriba1;
    private javax.swing.JButton btnAgregaract;
    private javax.swing.JComboBox<String> cmbActividad;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbInstalacion;
    private javax.swing.JComboBox<String> cmbIntructor;
    private javax.swing.JLabel flechaPaAbajo;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblNovedades;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
