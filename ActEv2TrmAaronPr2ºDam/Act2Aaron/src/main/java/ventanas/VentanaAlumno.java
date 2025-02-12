package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.AlumnoDao;
import moldes.Nota;
import moldes.Alumno;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class VentanaAlumno extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablaNotas;
    private JComboBox<String> comboBoxModulo;
    private JButton btnBuscar;
    private Alumno alumnoActual; // Almacena el Alumno recibido

    /**
     * Constructor que recibe un Alumno
     */
    public VentanaAlumno(Alumno alumnoV) {
        this.alumnoActual = alumnoV; // Guarda el alumno
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 474, 431);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(114, 79, 217, 243);
        contentPane.add(scrollPane);

        tablaNotas = new JTable();
        tablaNotas.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Asignatura", "Nota"}
        ));
        scrollPane.setViewportView(tablaNotas);

        JLabel lblModulo = new JLabel("Seleccione Modulo");
        lblModulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModulo.setBounds(153, 10, 134, 28);
        contentPane.add(lblModulo);

        comboBoxModulo = new JComboBox<>();
        comboBoxModulo.setModel(new DefaultComboBoxModel<>(new String[] {
            "--MODULOS--", "Primero", "Segundo", "Tercero", "Cuarto"
        }));
        comboBoxModulo.setBounds(114, 48, 85, 21);
        contentPane.add(comboBoxModulo);

        btnBuscar = new JButton("Buscar");
        btnBuscar.setBounds(246, 48, 85, 21);
        btnBuscar.addActionListener(this); // Agregar evento al botón
        contentPane.add(btnBuscar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	 if (e.getSource().equals(btnBuscar)) {
             try {
                 DefaultTableModel modelo = (DefaultTableModel) tablaNotas.getModel();
                 modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevas filas
                 //igualo mi lista que es la que me da la bbdd
                 List<Nota> notas = AlumnoDao.cargarNotas(alumnoActual, comboBoxModulo);
                 
                 for (Nota nota : notas) {
                     modelo.addRow(new Object[]{
                         nota.getidAsignatura(), nota.getCalificacion()
                     });
                 }
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
        }
    }

    public JComboBox<String> getComboBox() {
        return comboBoxModulo;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
}

