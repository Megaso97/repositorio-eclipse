package ventanas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import DAO.ProfesorDao;
import moldes.Profesor;
import moldes.QueryInsertar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VentanaProfesor extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldIdAlumno;
    private JButton btnAplicar;
    private JComboBox<String> comboBoxModulo;
    private JComboBox<String> comboBoxAsginatura;
    private JSpinner spinner;
    private Profesor profesorV; // Variable para almacenar el profesor

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaProfesor frame = new VentanaProfesor(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param profesorV 
     * @throws SQLException 
     */
    public VentanaProfesor(Profesor profesorV) throws SQLException {
        this.profesorV = profesorV; // Guardar el profesor para usarlo en los eventos

        setTitle(profesorV.getNombre() + " " + profesorV.getApellido());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 408, 408);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblsuperior = new JLabel("Bienvenido a la ventana de selección de notas");
        lblsuperior.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblsuperior.setBounds(46, 10, 380, 23);
        contentPane.add(lblsuperior);

        JLabel lblModulo = new JLabel("Seleccione módulo");
        lblModulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblModulo.setBounds(10, 59, 135, 13);
        contentPane.add(lblModulo);

        JLabel lblAlumno = new JLabel("Seleccione el ID del alumno");
        lblAlumno.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAlumno.setBounds(10, 156, 201, 13);
        contentPane.add(lblAlumno);

        JLabel lblnota = new JLabel("Seleccione nota");
        lblnota.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblnota.setBounds(10, 211, 119, 13);
        contentPane.add(lblnota);

        JLabel lblSeleccioneAsignatura = new JLabel("Seleccione asignatura");
        lblSeleccioneAsignatura.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSeleccioneAsignatura.setBounds(10, 108, 159, 13);
        contentPane.add(lblSeleccioneAsignatura);

        comboBoxModulo = new JComboBox<>();
        comboBoxModulo.setFont(new Font("Tahoma", Font.ITALIC, 14));
        comboBoxModulo.setModel(new DefaultComboBoxModel<>(new String[]{"1", "2", "3", "4"}));
        comboBoxModulo.setBounds(247, 57, 112, 21);
        contentPane.add(comboBoxModulo);

        comboBoxAsginatura = new JComboBox<>();
        comboBoxAsginatura.setFont(new Font("Tahoma", Font.ITALIC, 14));
        comboBoxAsginatura.setBounds(247, 106, 112, 21);
        contentPane.add(comboBoxAsginatura);

        textFieldIdAlumno = new JTextField();
        textFieldIdAlumno.setBounds(247, 155, 116, 19);
        contentPane.add(textFieldIdAlumno);
        textFieldIdAlumno.setColumns(10);

        spinner = new JSpinner();
        spinner.setModel(new SpinnerNumberModel(1.0, 1.0, 10.0, 0.5));
        spinner.setBounds(303, 210, 56, 20);
        contentPane.add(spinner);

        btnAplicar = new JButton("Aplicar Nota");
        btnAplicar.addActionListener(this);
        btnAplicar.setBounds(10, 268, 349, 21);
        contentPane.add(btnAplicar);

        // Evento para actualizar asignaturas cuando se seleccione un módulo
        comboBoxModulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAsignaturas();
            }
        });

        // Cargar asignaturas del módulo inicial
        actualizarAsignaturas();
    }

    private void actualizarAsignaturas() {
        // Obtener el módulo seleccionado
        String moduloSeleccionado = (String) comboBoxModulo.getSelectedItem();

        int numeroModulo;
        try {
            numeroModulo = Integer.parseInt(moduloSeleccionado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Seleccione un módulo válido");
            return;
        }

        // Obtener las asignaturas correspondientes
        try {
            String[] asignaturas = ProfesorDao.cargarAsignaturas(profesorV, numeroModulo);
            comboBoxAsginatura.setModel(new DefaultComboBoxModel<>(asignaturas));
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar las asignaturas");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnAplicar)) {
            // Obtener el módulo seleccionado
            String modulo = (String) getComboBoxModulo().getSelectedItem();
            int numeroModulo = Integer.parseInt(modulo);

            // Obtener la asignatura seleccionada
            String modeloAsignatura = (String) getComboBoxAsginatura().getSelectedItem();
            int AsignaturaId = 0;

            // Asignar el ID correspondiente según la asignatura seleccionada
            switch (modeloAsignatura) {
                case "Matematicas":
                    AsignaturaId = 1;
                    break;
                case "Fisica":
                    AsignaturaId = 2;
                    break;
                case "Literatura":
                    AsignaturaId = 3;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Asignatura no válida");
                    return;
            }

            // Obtener el ID del alumno desde el campo de texto
            String tf = getTextField().getText();
            int idAlumno = Integer.parseInt(tf);

            // Obtener la nota del spinner
            double nota = (double) getSpinner().getValue();

            // Crear el objeto QueryInsertar con los parámetros
            QueryInsertar qi = new QueryInsertar(numeroModulo, AsignaturaId, idAlumno, nota);

            // Intentar insertar la nota en la base de datos
            try {
                boolean operacionExitosa = ProfesorDao.agregarNota(qi);
                JOptionPane.showMessageDialog(null, operacionExitosa ? "¡NOTA INTRODUCIDA!" : "La operación no ha sido realizada");
            } catch (SQLException e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al realizar la operación");
            }
        }
    }

    public JComboBox<String> getComboBoxModulo() {
        return comboBoxModulo;
    }

    public JComboBox<String> getComboBoxAsginatura() {
        return comboBoxAsginatura;
    }

    public JTextField getTextField() {
        return textFieldIdAlumno;
    }

    public JSpinner getSpinner() {
        return spinner;
    }

    public JButton getBtnAplicar() {
        return btnAplicar;
    }
}
