package ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.VerificacionDao;
import moldes.Alumno;
import moldes.Profesor;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VentanaDeInicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfIdUsuario;
	private JPasswordField pfContraseña;
	private JComboBox<String> cbCargo;
	private JButton btnLimpiar;
	private JButton btnEntrar;
	private JButton btnSalir;
	private String nombre="Aaron";
	private String nombreProfesor="AaronProfesor";
	private String Contraseña="Uem";
	private String ContraseñaProfesor="Uem";
	//creamos objetos de las ventanas para poder usarlas
	private SegundaVentana sv;
	private VentanaAlumno va;
	private VentanaProfesor vp;
	private JLabel lblFotoEscudo;
	/**
	 * Launch the application.
	 */
	//segunda ventana 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDeInicio frame = new VentanaDeInicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaDeInicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaDeInicio.class.getResource("/imagenes/UE_Logo_Positive_RGB_8886cecf-afc9-4280-aa69-8615676d1d03_1513x-2-e1635163959405.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{68, 0, 0, 31, 74, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{63, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lbIdUsuario = new JLabel("Id de Usuario");
		GridBagConstraints gbc_lbIdUsuario = new GridBagConstraints();
		gbc_lbIdUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lbIdUsuario.gridx = 1;
		gbc_lbIdUsuario.gridy = 1;
		contentPane.add(lbIdUsuario, gbc_lbIdUsuario);
		
		tfIdUsuario = new JTextField();
		GridBagConstraints gbc_tfIdUsuario = new GridBagConstraints();
		gbc_tfIdUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tfIdUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfIdUsuario.gridx = 3;
		gbc_tfIdUsuario.gridy = 1;
		contentPane.add(tfIdUsuario, gbc_tfIdUsuario);
		tfIdUsuario.setColumns(10);
		
		lblFotoEscudo = new JLabel("");
		lblFotoEscudo.setIcon(new ImageIcon(VentanaDeInicio.class.getResource("/imagenes/foto escudo.jpg")));
		GridBagConstraints gbc_lblFotoEscudo = new GridBagConstraints();
		gbc_lblFotoEscudo.gridheight = 3;
		gbc_lblFotoEscudo.gridwidth = 2;
		gbc_lblFotoEscudo.insets = new Insets(0, 0, 5, 5);
		gbc_lblFotoEscudo.gridx = 4;
		gbc_lblFotoEscudo.gridy = 1;
		contentPane.add(lblFotoEscudo, gbc_lblFotoEscudo);
		
		JLabel lbContraseña = new JLabel("Contraseña");
		GridBagConstraints gbc_lbContraseña = new GridBagConstraints();
		gbc_lbContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_lbContraseña.gridx = 1;
		gbc_lbContraseña.gridy = 2;
		contentPane.add(lbContraseña, gbc_lbContraseña);
		
		pfContraseña = new JPasswordField();
		pfContraseña.setEchoChar('$');
		GridBagConstraints gbc_pfContraseña = new GridBagConstraints();
		gbc_pfContraseña.insets = new Insets(0, 0, 5, 5);
		gbc_pfContraseña.fill = GridBagConstraints.HORIZONTAL;
		gbc_pfContraseña.gridx = 3;
		gbc_pfContraseña.gridy = 2;
		contentPane.add(pfContraseña, gbc_pfContraseña);
		
		JLabel lbCargo = new JLabel("Cargo");
		GridBagConstraints gbc_lbCargo = new GridBagConstraints();
		gbc_lbCargo.insets = new Insets(0, 0, 5, 5);
		gbc_lbCargo.gridx = 1;
		gbc_lbCargo.gridy = 3;
		contentPane.add(lbCargo, gbc_lbCargo);
		
		cbCargo = new JComboBox<String>();
		GridBagConstraints gbc_cbCargo = new GridBagConstraints();
		gbc_cbCargo.insets = new Insets(0, 0, 5, 5);
		gbc_cbCargo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbCargo.gridx = 3;
		gbc_cbCargo.gridy = 3;
		contentPane.add(cbCargo, gbc_cbCargo);
		cbCargo.addItem("Seleccione");
		cbCargo.addItem("Alumno");
		cbCargo.addItem("Profesor");
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		GridBagConstraints gbc_btnLimpiar = new GridBagConstraints();
		gbc_btnLimpiar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLimpiar.insets = new Insets(0, 0, 5, 5);
		gbc_btnLimpiar.gridx = 3;
		gbc_btnLimpiar.gridy = 4;
		contentPane.add(btnLimpiar, gbc_btnLimpiar);
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(this);
		GridBagConstraints gbc_btnEntrar = new GridBagConstraints();
		gbc_btnEntrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEntrar.gridx = 4;
		gbc_btnEntrar.gridy = 4;
		contentPane.add(btnEntrar, gbc_btnEntrar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 5;
		gbc_btnSalir.gridy = 4;
		contentPane.add(btnSalir, gbc_btnSalir);
		
	}

	public JTextField getTfNombre() {
		return tfIdUsuario;
	}
	public JPasswordField getPfContraseña() {
		return pfContraseña;
	}
	public JComboBox getCbCargo() {
		return cbCargo;
	}
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}
	public JButton getBtnEntrar() {
		return btnEntrar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JPanel getContentPane() {
		return contentPane;
	}
//AQUI LOS BOTONES LOS ESCUCHAMOS Y HACEN ALGO CUNADO HAGO CLICK
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource().equals(btnSalir)) {
	        System.exit(0); // Corregido EXIT_ON_CLOSE
	    }

	    if (e.getSource().equals(btnEntrar)) {
	        // Obtener los valores de los campos de texto
	        String id = tfIdUsuario.getText();
	        int idUsuario=Integer.parseInt(id);
	        String contraseniaUsuario = new String(pfContraseña.getPassword()); // Corregido

	        // Obtener el cargo seleccionado
	        String cargoSeleccionado = cbCargo.getSelectedItem().toString();

	        switch (cargoSeleccionado) {
	            case "Alumno":
	                Alumno alumnoV = new Alumno(idUsuario, contraseniaUsuario);
	                try {
	                    if (VerificacionDao.verificarAlumno(alumnoV)) {
	                    
	                        va = new VentanaAlumno(alumnoV);
	                        va.setVisible(true);
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Credenciales no válidas");
	                    }
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	                break;

	            case "Profesor":
	                Profesor profesorV = new Profesor(idUsuario, contraseniaUsuario);
	                try {
	                    if (VerificacionDao.verificarProfesor(profesorV)) {
	                        vp = new VentanaProfesor(profesorV);
	                        vp.setVisible(true);
	                        dispose();
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Credenciales no válidas");
	                    }
	                } catch (SQLException e1) {
	                    e1.printStackTrace();
	                }
	                break;

	            default:
	                JOptionPane.showMessageDialog(null, "Seleccione un cargo válido.");
	        }
	    }

	    if (e.getSource().equals(btnLimpiar)) {
	        tfIdUsuario.setText("");
	        pfContraseña.setText("");
	        cbCargo.setSelectedIndex(0);
	    }
	}

}

