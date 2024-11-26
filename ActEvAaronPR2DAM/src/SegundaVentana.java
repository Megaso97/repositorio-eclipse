import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class SegundaVentana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String nombre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					SegundaVentana frame = new SegundaVentana();
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
	//genero constructor vacio
	public SegundaVentana() {}
	/*genero un constructor pasandole el String nombre asi puedo generar el mensaje con esa variable 
	 * desde la otra clase cuando creo esta clase lo unico que eclipse me obliga a pasarle el
	 * String nombre y el panel */
	public SegundaVentana(String nombre, JPanel contentPane) throws HeadlessException {
		this.contentPane = contentPane;
		this.nombre = nombre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblMsgBienvenida = new JLabel("Bienvenido de nuevo "+nombre);
		contentPane.add(lblMsgBienvenida);
	}

}
