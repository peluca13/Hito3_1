package interfaz;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorUsuarios;
import entidades.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import java.awt.Color;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;


	/**
	 * Create the dialog.
	 */
	public Login(JFrame parent,boolean modal) {
		super(parent,modal);
		setTitle("Inicio de sesi\u00F3n");
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel labelIniciarSesion = new JLabel("Iniciar sesi\u00F3n");
		labelIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
		labelIniciarSesion.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		labelIniciarSesion.setBounds(97, 27, 222, 14);
		contentPanel.add(labelIniciarSesion);
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelUsuario.setBounds(97, 77, 56, 19);
		contentPanel.add(labelUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(185, 76, 134, 20);
		contentPanel.add(txtUsuario);
		
		JLabel labelContrasena = new JLabel("Contrase\u00F1a");
		labelContrasena.setHorizontalAlignment(SwingConstants.CENTER);
		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelContrasena.setBounds(97, 108, 76, 19);
		contentPanel.add(labelContrasena);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(185, 107, 134, 20);
		contentPanel.add(txtContrasena);
		
		JLabel lblErrorlogin = new JLabel("Datos Incorrectos");
		lblErrorlogin.setVerticalAlignment(SwingConstants.TOP);
		lblErrorlogin.setForeground(Color.RED);
		lblErrorlogin.setBounds(48, 138, 152, 23);
		contentPanel.add(lblErrorlogin);
		lblErrorlogin.setVisible(false);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean valido=ControladorUsuarios.loginUsuario(txtUsuario.getText(),txtContrasena.getText());
				if(valido==false) {
					lblErrorlogin.setVisible(true);
				}else {
					dispose();
					
				}
			}
		});
		btnIngresar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIngresar.setBounds(210, 138, 89, 23);
		contentPanel.add(btnIngresar);
		
		JLabel labelIngDatos = new JLabel("Ingrese su usuario y contrase\u00F1a");
		labelIngDatos.setHorizontalAlignment(SwingConstants.CENTER);
		labelIngDatos.setBounds(97, 52, 222, 14);
		contentPanel.add(labelIngDatos);
		
		JLabel labelRegistrarse = new JLabel("Si no est\u00E1 registrado, click aqu\u00ED");
		labelRegistrarse.setHorizontalAlignment(SwingConstants.CENTER);
		labelRegistrarse.setBounds(33, 202, 204, 23);
		contentPanel.add(labelRegistrarse);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarse.setBounds(247, 202, 108, 23);
		contentPanel.add(btnRegistrarse);
		
		
	
	}
}
