package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import entidades.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controladores.ControladorUsuarios;

import javax.swing.JButton;

public class NuevaPass implements ActionListener{

	private JFrame frmNuevaContrasea;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDocumento;
	private JTextField textFieldFecha;
	private JTextField textFieldGenero;
	private JTextField textFieldEmail;
	private JTextField textFieldUsername;
	private JTextField textFieldPass;
	private JButton btnGuardar;
	private JButton btnCancelar;

	

	/**
	 * Create the application.
	 */
	public NuevaPass(int identificador) {
		initialize(identificador);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int id) {
		frmNuevaContrasea = new JFrame();
		frmNuevaContrasea.setTitle("Nueva Contrase\u00F1a");
		frmNuevaContrasea.setBounds(100, 100, 450, 411);
		frmNuevaContrasea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNuevaContrasea.setLocationRelativeTo(null);
		frmNuevaContrasea.getContentPane().setLayout(null);
		frmNuevaContrasea.setVisible(true);
		Usuario user=controladores.ControladorUsuarios.ObtenerUsuario(id);
		
		JLabel lblDatos = new JLabel("Datos :");
		lblDatos.setBounds(79, 11, 46, 14);
		frmNuevaContrasea.getContentPane().add(lblDatos);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(144, 35, 113, 20);
		frmNuevaContrasea.getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.setText(user.getNombre());
		textFieldNombre.setEditable(false);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(143, 66, 114, 20);
		frmNuevaContrasea.getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		textFieldApellido.setText(user.getApellido());
		textFieldApellido.setEditable(false);
		
		textFieldDocumento = new JTextField();
		textFieldDocumento.setBounds(143, 94, 114, 20);
		frmNuevaContrasea.getContentPane().add(textFieldDocumento);
		textFieldDocumento.setColumns(10);
		textFieldDocumento.setText(user.getDocumento());
		textFieldDocumento.setEditable(false);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setBounds(144, 125, 113, 20);
		frmNuevaContrasea.getContentPane().add(textFieldFecha);
		textFieldFecha.setColumns(10);
		textFieldFecha.setText(user.getFecNac().toString());
		textFieldFecha.setEditable(false);
		
		textFieldGenero = new JTextField();
		textFieldGenero.setEditable(false);
		textFieldGenero.setBounds(144, 156, 113, 20);
		frmNuevaContrasea.getContentPane().add(textFieldGenero);
		textFieldGenero.setColumns(10);
		String genero = "";
		if(user.getGenero()==1) {genero="MASCULINO";}
		if(user.getGenero()==2) {genero="FEMENINO";}
		textFieldGenero.setText(genero);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(144, 187, 113, 20);
		frmNuevaContrasea.getContentPane().add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setText(user.getCorreoElec());
		textFieldEmail.setEditable(false);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(143, 218, 114, 20);
		frmNuevaContrasea.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		textFieldUsername.setText(user.getNomUsuario());
		textFieldUsername.setEditable(false);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(143, 249, 114, 20);
		frmNuevaContrasea.getContentPane().add(textFieldPass);
		textFieldPass.setColumns(10);
		textFieldPass.setText(user.getContrasena());
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NuevaPassword(textFieldPass.getText(),user.getIdUsuario());
			}
		});
		btnGuardar.setBounds(28, 326, 89, 23);
		frmNuevaContrasea.getContentPane().add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNuevaContrasea.dispose();
			}
		});
		btnCancelar.setBounds(281, 326, 89, 23);
		frmNuevaContrasea.getContentPane().add(btnCancelar);

		
		
	}

	protected void NuevaPassword(String pass,int identifica) {
		if(pass.length()<8 || pass.length()>=16) {
			JOptionPane.showMessageDialog(frmNuevaContrasea, "El campo contraseña debe tener como minimo 8 caracteres y como máximo 16",
					"Cantidad caracteres!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
	boolean cambioDePass= ControladorUsuarios.cambiarPass(pass, identifica);
	
	if(cambioDePass) {
		JOptionPane.showMessageDialog(frmNuevaContrasea, "El Usuario se ha creado con éxito.",
				"Usuario Agregado!", JOptionPane.INFORMATION_MESSAGE);
		
		// cerramos la ventanta
		frmNuevaContrasea.dispose();
	}
	else{
		JOptionPane.showMessageDialog(frmNuevaContrasea, "Hubo un error al cambiar el password. Intente nuevamente más tarde",
				"Error al actualizar!", JOptionPane.ERROR_MESSAGE);
	}	
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
