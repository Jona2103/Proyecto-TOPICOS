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
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        m = (DefaultTableModel)tblAct.getModel();
        // Suponiendo que tienes un botón llamado "btnBorrar"
        btnBorrarAct.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        // Obtener la fila seleccionada en la tabla
        
        // Verificar si una fila está seleccionada
        if (tblAct.getSelectedRow() != -1) {
            // Obtener el ID de la actividad desde la tabla (asumiendo que el ID está en la primera columna)
            String nombre =  tblAct.getValueAt(tblAct.getSelectedRow(), tblAct.getSelectedColumn()).toString(); // Asumiendo que la primera columna es el ID
            
            // Mostrar confirmación para borrar la actividad
            int confirmacion = JOptionPane.showConfirmDialog(null, 
                "¿Estás seguro de que quieres borrar esta actividad?", 
                "Confirmación de borrado", JOptionPane.YES_NO_OPTION);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                // Llamar al método para borrar la actividad
                borrarActividad(nombre);
                
                // Eliminar la fila de la tabla
                DefaultTableModel modelo = (DefaultTableModel) tblAct.getModel();
                modelo.removeRow(tblAct.getSelectedRow());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para borrar.");
        }
        }
         });
        
         pnlCrearGrupo.setVisible(false);
                pnlAdd.setVisible(false);
                pnlGrupos.setVisible(false);
        lblCrearGrup.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pnlCrearGrupo.setVisible(true);
                pnlAdd.setVisible(false);
                pnlGrupos.setVisible(false);
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
        
        lblAddAct.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pnlCrearGrupo.setVisible(false);
                pnlAdd.setVisible(true);
                pnlGrupos.setVisible(false);
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
        
        lblVerGrupo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pnlGrupos.setVisible(true);
                pnlAdd.setVisible(false);
                pnlCrearGrupo.setVisible(false);
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
        
        
        
        
        
        cargarActividades();
               barraArriba2.setParentFrame(this);
        btnAgregaract1.addActionListener(new Interna());

    }
    
    public void borrarActividad(String Nombre) {
    try {
        // Crear la sentencia SQL para eliminar la actividad
        String query = "DELETE FROM ActividadExtraescolar WHERE Nombre = ?";
        
        // Preparar la sentencia SQL
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, Nombre);  // Establecer el ID de la actividad como parámetro
        
        // Ejecutar la actualización (borrar)
        int filasAfectadas = stmt.executeUpdate();
        
        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Actividad eliminada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la actividad.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al borrar la actividad: " + e.getMessage());
    }
}
    
    private DefaultTableModel m;

    public void cargarActividades() {
        // Configurar el modelo de la tabla
 
        m.addColumn("Nombre");
        m.addColumn("Descripcion");
        m.addColumn("Tipo de crédito");
        
        // Conectar y obtener los datos
         try {
            // Crear la sentencia SQL para obtener las actividades
            String query = "SELECT A.Nombre, A.Descripcion, C.Tipo FROM ActividadExtraescolar A "
              + "INNER JOIN Credito C ON C.CreditoID = A.CreditoID";

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
    
    class Interna implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = txtNombre1.getText();
        String desc = TxtDescripcion1.getText();
        String tC = CmbCreditos1.getSelectedItem().toString();
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
        jPanel3 = new javax.swing.JPanel();
        lblTigre1 = new javax.swing.JLabel();
        flechaPaAbajo1 = new javax.swing.JLabel();
        lblCrearGrup = new javax.swing.JLabel();
        lblAddAct = new javax.swing.JLabel();
        lblVerGrupo = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        in = new javax.swing.JPanel();
        pnlGrupos = new javax.swing.JPanel();
        btnBorrarAct = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAct = new javax.swing.JTable();
        pnlCrearGrupo = new javax.swing.JPanel();
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
        pnlAdd = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        TxtDescripcion1 = new javax.swing.JTextField();
        CmbCreditos1 = new javax.swing.JComboBox<>();
        btnAgregaract1 = new javax.swing.JButton();
        btnCancelarGru = new javax.swing.JButton();

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

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setText(".");
        fondo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 115, -1, -1));
        fondo.add(barraArriba2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        contenido.setBackground(new java.awt.Color(255, 255, 255));
        contenido.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblTigre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/tigreExtraescCy.png"))); // NOI18N

        flechaPaAbajo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flechaPaAbajo.png"))); // NOI18N

        lblCrearGrup.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCrearGrup.setText("Crear grupo");

        lblAddAct.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAddAct.setText("Agregar una Actividades");

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
                .addComponent(lblCrearGrup)
                .addGap(35, 35, 35)
                .addComponent(lblAddAct)
                .addGap(61, 61, 61)
                .addComponent(lblVerGrupo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 344, Short.MAX_VALUE)
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
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblCrearGrup)
                                        .addComponent(lblAddAct)
                                        .addComponent(lblVerGrupo))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(34, 34, 34))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(flechaPaAbajo1)
                        .addGap(13, 13, 13)))
                .addGap(24, 24, 24))
        );

        contenido.add(jPanel3);
        jPanel3.setBounds(0, 0, 1061, 120);

        in.setBackground(new java.awt.Color(255, 255, 255));
        in.setLayout(null);

        pnlGrupos.setBackground(new java.awt.Color(255, 255, 255));
        pnlGrupos.setLayout(null);

        btnBorrarAct.setText("Borrar");
        pnlGrupos.add(btnBorrarAct);
        btnBorrarAct.setBounds(-31776, -32300, 75, 23);

        tblAct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAct);

        pnlGrupos.add(jScrollPane1);
        jScrollPane1.setBounds(850, 170, 381, 244);

        pnlCrearGrupo.setBackground(new java.awt.Color(255, 255, 255));
        pnlCrearGrupo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        pnlCrearGrupo.setToolTipText("");
        pnlCrearGrupo.setLayout(null);

        jLabel13.setText("Horario");
        pnlCrearGrupo.add(jLabel13);
        jLabel13.setBounds(170, 23, 40, 16);

        jLabel14.setText("Actividad");
        pnlCrearGrupo.add(jLabel14);
        jLabel14.setBounds(170, 63, 93, 16);

        jLabel15.setText("Intructor");
        pnlCrearGrupo.add(jLabel15);
        jLabel15.setBounds(170, 103, 75, 16);

        jLabel16.setText("Instalacion");
        pnlCrearGrupo.add(jLabel16);
        jLabel16.setBounds(170, 179, 75, 16);

        jLabel17.setText("Capacidad");
        pnlCrearGrupo.add(jLabel17);
        jLabel17.setBounds(170, 141, 56, 16);

        cmbHorario1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "08hrs-10hrs", "17hrs-19hrs", "19hrs-21hrs" }));
        cmbHorario1.setBorder(null);
        pnlCrearGrupo.add(cmbHorario1);
        cmbHorario1.setBounds(269, 20, 93, 20);

        cmbActividad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbActividad1.setBorder(null);
        pnlCrearGrupo.add(cmbActividad1);
        cmbActividad1.setBounds(269, 60, 88, 20);

        cmbInstructor1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbInstructor1.setBorder(null);
        pnlCrearGrupo.add(cmbInstructor1);
        cmbInstructor1.setBounds(269, 100, 88, 20);

        cmbInstalacion1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        cmbInstalacion1.setBorder(null);
        pnlCrearGrupo.add(cmbInstalacion1);
        cmbInstalacion1.setBounds(269, 176, 88, 20);

        txtCapacidad1.setBorder(null);
        pnlCrearGrupo.add(txtCapacidad1);
        txtCapacidad1.setBounds(269, 140, 90, 16);

        btnGrupo1.setText("Agregar");
        btnGrupo1.setBorder(null);
        pnlCrearGrupo.add(btnGrupo1);
        btnGrupo1.setBounds(300, 210, 60, 16);

        btnCancelarAct.setText("Cancelar");
        btnCancelarAct.setBorder(null);
        pnlCrearGrupo.add(btnCancelarAct);
        btnCancelarAct.setBounds(170, 210, 60, 16);

        pnlAdd.setBackground(new java.awt.Color(255, 255, 255));
        pnlAdd.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        pnlAdd.setLayout(null);

        jLabel20.setText("Nombre Actividad ");
        pnlAdd.add(jLabel20);
        jLabel20.setBounds(0, 0, 0, 0);

        jLabel21.setText("Descripcion ");
        pnlAdd.add(jLabel21);
        jLabel21.setBounds(0, 0, 0, 0);

        jLabel22.setText("Tipo de Credito ");
        pnlAdd.add(jLabel22);
        jLabel22.setBounds(0, 0, 0, 0);

        txtNombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlAdd.add(txtNombre1);
        txtNombre1.setBounds(0, 0, 0, 0);

        TxtDescripcion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlAdd.add(TxtDescripcion1);
        TxtDescripcion1.setBounds(0, 0, 0, 0);

        CmbCreditos1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona" }));
        CmbCreditos1.setBorder(null);
        pnlAdd.add(CmbCreditos1);
        CmbCreditos1.setBounds(0, 0, 0, 0);

        btnAgregaract1.setText("Agregar");
        btnAgregaract1.setBorder(null);
        pnlAdd.add(btnAgregaract1);
        btnAgregaract1.setBounds(0, 0, 0, 0);

        btnCancelarGru.setText("Cancelar");
        btnCancelarGru.setBorder(null);
        pnlAdd.add(btnCancelarGru);
        btnCancelarGru.setBounds(0, 0, 0, 0);

        pnlCrearGrupo.add(pnlAdd);
        pnlAdd.setBounds(30, 50, 430, 340);

        pnlGrupos.add(pnlCrearGrupo);
        pnlCrearGrupo.setBounds(30, -130, 430, 340);

        in.add(pnlGrupos);
        pnlGrupos.setBounds(10, 180, 460, 340);

        contenido.add(in);
        in.setBounds(370, 140, 510, 470);

        fondo.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 1380, 740));

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
    private javax.swing.JPanel Añadir;
    private javax.swing.JComboBox<String> CmbCreditos;
    private javax.swing.JComboBox<String> CmbCreditos1;
    private javax.swing.JLabel Crear;
    private javax.swing.JPanel CrearGrupo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtDescripcion1;
    private Componentes.BarraArriba barraArriba1;
    private Componentes.BarraArriba barraArriba2;
    private javax.swing.JButton btnAgregaract;
    private javax.swing.JButton btnAgregaract1;
    private javax.swing.JButton btnBorrarAct;
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
    private javax.swing.JPanel in;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddAct;
    private javax.swing.JLabel lblCrearGrup;
    private javax.swing.JLabel lblNovedades;
    private javax.swing.JLabel lblTigre;
    private javax.swing.JLabel lblTigre1;
    private javax.swing.JLabel lblVerGrupo;
    private javax.swing.JPanel pnlAdd;
    private javax.swing.JPanel pnlCrearGrupo;
    private javax.swing.JPanel pnlGrupos;
    private javax.swing.JTable tblAct;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JTextField txtCapacidad1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    // End of variables declaration//GEN-END:variables
}
