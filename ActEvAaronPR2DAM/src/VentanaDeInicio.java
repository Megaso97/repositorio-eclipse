import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class VentanaDeInicio extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
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
	private JLabel lblNewLabel;
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
		
		JLabel lbNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lbNombre = new GridBagConstraints();
		gbc_lbNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lbNombre.gridx = 1;
		gbc_lbNombre.gridy = 1;
		contentPane.add(lbNombre, gbc_lbNombre);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 3;
		gbc_tfNombre.gridy = 1;
		contentPane.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaDeInicio.class.getResource("/imagenes/foto escudo.jpg")));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 3;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
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
		return tfNombre;
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
		/*Si nuesto objeto e = btnsalir sale de la pantalla con EXIT_ON_CLOSE*/
		if(e.getSource().equals(btnSalir)) {
			System.exit(EXIT_ON_CLOSE);
		}
		if (e.getSource().equals(btnEntrar)) {
		    if ((tfNombre.getText().equals(nombre) || tfNombre.getText().equals(nombreProfesor)) && 
		        pfContraseña.getText().equals(Contraseña)) {
		        
		        if (cbCargo.getSelectedItem().equals("Alumno")) {
		            sv = new SegundaVentana(nombre, contentPane);
		            sv.setVisible(true);
		            dispose();
		        } else if (cbCargo.getSelectedItem().equals("Profesor") && 
		                   tfNombre.getText().equals(nombreProfesor) && 
		                   pfContraseña.getText().equals(ContraseñaProfesor)) {
		            sv = new SegundaVentana(nombreProfesor, contentPane);
		            sv.setVisible(true);
		            dispose();
		        } else {
		            JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		        }
		    } else {
		        JOptionPane.showMessageDialog(null, "Datos Incorrectos");
		    }
		}
		if(e.getSource().equals(btnLimpiar)) {
			tfNombre.setText("");
			pfContraseña.setText("");
			cbCargo.setSelectedIndex(0);
		}
}
}

