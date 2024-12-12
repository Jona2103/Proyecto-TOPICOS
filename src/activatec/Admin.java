/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package activatec;

/**
 *
 * @author Jonathan Viera
 */



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Jonathan Viera
 */
public class Admin extends javax.swing.JFrame {

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
    
    
    public Admin() {
        initComponents();
        Conectar();
        llenarTipoCredito();
        llenarInstructor();
        llenarActividad();
        llenarInstalacion();
        barraArriba2.setParentFrame(this);
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
Añadir1.setVisible(false);
CrearGrupo1.setVisible(false);
Grupos.setVisible(false);
Crear1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Cambiar la visibilidad del panel "CrearGrupo" cuando se haga clic en el JLabel "Crear"
        CrearGrupo1.setVisible(true);  // Mostrar el panel CrearGrupo
        Añadir1.setVisible(false);     // Ocultar el panel Añadir
        Grupos.setVisible(false);
    }
});

Agregar1.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Cambiar la visibilidad del panel "Añadir" cuando se haga clic en el JLabel "Agregar"
        Añadir1.setVisible(true);
       // Mostrar el panel Añadir
        CrearGrupo1.setVisible(false); // Ocultar el panel CrearGrupo
        Grupos.setVisible(false);
    }
});

lblVerGrupo.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        // Cambiar la visibilidad del panel "CrearGrupo" cuando se haga clic en el JLabel "Crear"
        Grupos.setVisible(true);  // Mostrar el panel ver grupo
        Añadir1.setVisible(false);     // Ocultar el panel Añadir
        CrearGrupo1.setVisible(false);
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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException closeEx) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, closeEx);
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
                CmbCreditos1.addItem(id+"-"+tipo);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
                cmbInstructor1.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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
                cmbActividad1.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void insertarGrupo(){
        
        String tC = cmbHorario1.getSelectedItem().toString();
        
        
        String iC = cmbInstalacion1.getSelectedItem().toString();
        String[] I = iC.split("-");
        String ic = I[0]; 
        
        String aC = cmbActividad1.getSelectedItem().toString();
        String[] A = aC.split("-");
        String nc = A[0]; 
        
        
        String inC = cmbInstructor1.getSelectedItem().toString();
        String[] IN = inC.split("-");
        String nin = IN[0]; 
        
        int cap = Integer.parseInt(txtCapacidad1.getText());

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
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException closeEx) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, closeEx);
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
                cmbInstalacion1.addItem(id+"-"+nam);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
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

        barraArriba1 = new Componentes.BarraArriba();
        jLabel10 = new javax.swing.JLabel();
        CrearGrupo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbHorario = new javax.swing.JComboBox<>();
        cmbActividad = new javax.swing.JComboBox<>();
        cmbInstructor = new javax.swing.JComboBox<>();
        cmbInstalacion = new javax.swing.JComboBox<>();
        txtCapacidad = new javax.swing.JTextField();
        btnGrupo = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTigre = new javax.swing.JLabel();
        iconBuscar = new javax.swing.JLabel();
        flechaPaAbajo = new javax.swing.JLabel();
        Crear = new javax.swing.JLabel();
        Agregar = new javax.swing.JLabel();
        lblNovedades = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Añadir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        CmbCreditos = new javax.swing.JComboBox<>();
        btnAgregaract = new javax.swing.JButton();
        fondo = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        barraArriba2 = new Componentes.BarraArriba();
        contenido = new javax.swing.JPanel();
        Añadir1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        TxtDescripcion1 = new javax.swing.JTextField();
        CmbCreditos1 = new javax.swing.JComboBox<>();
        btnAgregaract1 = new javax.swing.JButton();
        btnCancelarGru = new javax.swing.JButton();
        CrearGrupo1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbHorario1 = new javax.swing.JComboBox<>();
        cmbActividad1 = new javax.swing.JComboBox<>();
        cmbInstructor1 = new javax.swing.JComboBox<>();
        cmbInstalacion1 = new javax.swing.JComboBox<>();
        txtCapacidad1 = new javax.swing.JTextField();
        btnGrupo1 = new javax.swing.JButton();
        btnCancelarAct = new javax.swing.JButton();
        Grupos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblTigre1 = new javax.swing.JLabel();
        flechaPaAbajo1 = new javax.swing.JLabel();
        Crear1 = new javax.swing.JLabel();
        Agregar1 = new javax.swing.JLabel();
        lblVerGrupo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setText("Bienvenido Administrativo");

        CrearGrupo.setBackground(new java.awt.Color(255, 255, 255));
        CrearGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        CrearGrupo.setToolTipText("");

        jLabel4.setText("Horario");

        jLabel5.setText("Actividad");

        jLabel6.setText("Intructor");

        jLabel7.setText("Instalacion");

        jLabel2.setText("Capacidad");

        cmbHorario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "08hrs-10hrs", "17hrs-19hrs", "19hrs-21hrs" }));

        cmbActividad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        cmbInstructor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        cmbInstalacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));

        btnGrupo.setText("Agregar");

        btnRegresar.setText("Cancelar");

        javax.swing.GroupLayout CrearGrupoLayout = new javax.swing.GroupLayout(CrearGrupo);
        CrearGrupo.setLayout(CrearGrupoLayout);
        CrearGrupoLayout.setHorizontalGroup(
            CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearGrupoLayout.createSequentialGroup()
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
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
                                    .addComponent(cmbInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(CrearGrupoLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGrupo)))
                .addGap(0, 326, Short.MAX_VALUE))
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
                    .addComponent(cmbInstructor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrupo)
                    .addComponent(btnRegresar))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jLabel11.setText(".");

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
        Añadir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, null));

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
                .addContainerGap(31, Short.MAX_VALUE))
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
                .addContainerGap(85, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 0, 0));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText(".");
        fondo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 115, -1, -1));
        fondo.add(barraArriba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setLayout(null);

        Añadir1.setBackground(new java.awt.Color(255, 255, 255));
        Añadir1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        Añadir1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setText("Nombre Actividad ");
        Añadir1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 47, -1, -1));

        jLabel21.setText("Descripcion ");
        Añadir1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 93, 80, -1));

        jLabel22.setText("Tipo de Credito ");
        Añadir1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 140, 92, -1));

        txtNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Añadir1.add(txtNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 131, -1));

        TxtDescripcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Añadir1.add(TxtDescripcion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 130, -1));

        CmbCreditos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        CmbCreditos1.setBorder(null);
        Añadir1.add(CmbCreditos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 107, -1));

        btnAgregaract1.setText("Agregar");
        btnAgregaract1.setBorder(null);
        Añadir1.add(btnAgregaract1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 80, -1));

        btnCancelarGru.setText("Cancelar");
        btnCancelarGru.setBorder(null);
        Añadir1.add(btnCancelarGru, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 60, -1));

        CrearGrupo1.setBackground(new java.awt.Color(255, 255, 255));
        CrearGrupo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        CrearGrupo1.setToolTipText("");
        CrearGrupo1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Horario");
        CrearGrupo1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 23, -1, -1));

        jLabel14.setText("Actividad");
        CrearGrupo1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 63, 93, -1));

        jLabel15.setText("Intructor");
        CrearGrupo1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 103, 75, -1));

        jLabel16.setText("Instalacion");
        CrearGrupo1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 179, 75, -1));

        jLabel17.setText("Capacidad");
        CrearGrupo1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 141, -1, -1));

        cmbHorario1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "08hrs-10hrs", "17hrs-19hrs", "19hrs-21hrs" }));
        cmbHorario1.setBorder(null);
        CrearGrupo1.add(cmbHorario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 20, -1, -1));

        cmbActividad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbActividad1.setBorder(null);
        CrearGrupo1.add(cmbActividad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 60, -1, -1));

        cmbInstructor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbInstructor1.setBorder(null);
        CrearGrupo1.add(cmbInstructor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 100, -1, -1));

        cmbInstalacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbInstalacion1.setBorder(null);
        CrearGrupo1.add(cmbInstalacion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 176, -1, -1));

        txtCapacidad1.setBorder(null);
        CrearGrupo1.add(txtCapacidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(269, 140, 90, -1));

        btnGrupo1.setText("Agregar");
        btnGrupo1.setBorder(null);
        CrearGrupo1.add(btnGrupo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, 60, -1));

        btnCancelarAct.setText("Cancelar");
        btnCancelarAct.setBorder(null);
        CrearGrupo1.add(btnCancelarAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 60, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout GruposLayout = new javax.swing.GroupLayout(Grupos);
        Grupos.setLayout(GruposLayout);
        GruposLayout.setHorizontalGroup(
            GruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        GruposLayout.setVerticalGroup(
            GruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GruposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        CrearGrupo1.add(Grupos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        Añadir1.add(CrearGrupo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 340));

        contenido.add(Añadir1);
        Añadir1.setBounds(440, 160, 430, 340);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblTigre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreExtraescCy.png"))); // NOI18N

        flechaPaAbajo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaPaAbajo.png"))); // NOI18N

        Crear1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Crear1.setText("Crear grupo");

        Agregar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Agregar1.setText("Agregar una Actividades");

        lblVerGrupo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblVerGrupo.setText("Ver Grupo");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/notfayer_1.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblTigre1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flechaPaAbajo1)
                .addGap(76, 76, 76)
                .addComponent(Crear1)
                .addGap(35, 35, 35)
                .addComponent(Agregar1)
                .addGap(61, 61, 61)
                .addComponent(lblVerGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 652, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTigre1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Crear1)
                                    .addComponent(Agregar1)
                                    .addComponent(lblVerGrupo))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(34, 34, 34))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(flechaPaAbajo1)
                        .addGap(13, 13, 13)))
                .addGap(24, 24, 24))
        );

        contenido.add(jPanel3);
        jPanel3.setBounds(0, 0, 1380, 106);

        fondo.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1370, 740));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agregar;
    private javax.swing.JLabel Agregar1;
    private javax.swing.JPanel Añadir;
    private javax.swing.JPanel Añadir1;
    private javax.swing.JComboBox<String> CmbCreditos;
    private javax.swing.JComboBox<String> CmbCreditos1;
    private javax.swing.JLabel Crear;
    private javax.swing.JLabel Crear1;
    private javax.swing.JPanel CrearGrupo;
    private javax.swing.JPanel CrearGrupo1;
    private javax.swing.JPanel Grupos;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtDescripcion1;
    private Componentes.BarraArriba barraArriba1;
    private Componentes.BarraArriba barraArriba2;
    private javax.swing.JButton btnAgregaract;
    private javax.swing.JButton btnAgregaract1;
    private javax.swing.JButton btnCancelarAct;
    private javax.swing.JButton btnCancelarGru;
    private javax.swing.JButton btnGrupo;
    private javax.swing.JButton btnGrupo1;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbActividad;
    private javax.swing.JComboBox<String> cmbActividad1;
    private javax.swing.JComboBox<String> cmbHorario;
    private javax.swing.JComboBox<String> cmbHorario1;
    private javax.swing.JComboBox<String> cmbInstalacion;
    private javax.swing.JComboBox<String> cmbInstalacion1;
    private javax.swing.JComboBox<String> cmbInstructor;
    private javax.swing.JComboBox<String> cmbInstructor1;
    private javax.swing.JPanel contenido;
    private javax.swing.JLabel flechaPaAbajo;
    private javax.swing.JLabel flechaPaAbajo1;
    private javax.swing.JPanel fondo;
    private javax.swing.JLabel iconBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblNovedades;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JLabel lblTigre1;
    private javax.swing.JLabel lblVerGrupo;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCapacidad1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    // End of variables declaration//GEN-END:variables
}
