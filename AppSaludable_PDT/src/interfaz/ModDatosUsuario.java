package interfaz;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorUsuarios;
import entidades.Usuario;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.SpringLayout;

public class ModDatosUsuario extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDoc;
	private JTextField txtCorreo;
	private JTextField txtPass;
	private JComboBox comboBoxGenero;
	private JTextField textFieldSegApe;
	private JDatePickerImpl datePicker;
	private JComboBox comboBoxRol;
	private JFrame frame;
	private int fieldRol;

	

	/**
	 * Create the frame.
	 */
	public ModDatosUsuario(Usuario usuario) {
		setResizable(false);
		this.initialize(usuario);
		}
	
	private void initialize(Usuario user) {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(482, 535);
		setLocationRelativeTo(null);
		setVisible(true);
			
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDatosUsuario = new JLabel("Datos del Usuario");
		lblDatosUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosUsuario.setBounds(133, 11, 179, 18);
		getContentPane().add(lblDatosUsuario);
		lblDatosUsuario.setForeground(new Color(0, 51, 153));
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(31, 42, 53, 14);
		contentPane.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblApellido.setBounds(31, 83, 68, 14);
		contentPane.add(lblApellido);
		
		JLabel lblDocumento = new JLabel("Documento");
		lblDocumento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDocumento.setBounds(31, 120, 83, 14);
		contentPane.add(lblDocumento);
		
		JLabel lblFecNac = new JLabel("Fecha nacimiento");
		lblFecNac.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecNac.setBounds(31, 173, 109, 14);
		contentPane.add(lblFecNac);
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGenero.setBounds(31, 214, 46, 14);
		contentPane.add(lblGenero);
		
		JLabel lblCorreoElec = new JLabel("Correo electr\u00F3nico");
		lblCorreoElec.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCorreoElec.setBounds(31, 258, 130, 14);
		contentPane.add(lblCorreoElec);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a");
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasena.setBounds(31, 350, 83, 14);
		contentPane.add(lblContrasena);
		
		JLabel lblDatosObligatorios = new JLabel("Datos Obligatorios *");
		lblDatosObligatorios.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDatosObligatorios.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosObligatorios.setBounds(22, 390, 142, 14);
		contentPane.add(lblDatosObligatorios);
		
		JLabel label1 = new JLabel("(*)");
		label1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setBounds(347, 42, 46, 14);
		contentPane.add(label1);
		
		JLabel label2 = new JLabel("(*)");
		label2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setBounds(347, 83, 46, 14);
		contentPane.add(label2);
		
		JLabel label6 = new JLabel("(*)");
		label6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label6.setHorizontalAlignment(SwingConstants.CENTER);
		label6.setBounds(347, 350, 46, 14);
		contentPane.add(label6);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(150, 40, 193, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.setText(user.getNombre());
		
		txtApellido = new JTextField();
		txtApellido.setBounds(150, 81, 193, 20);
		contentPane.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.setText(user.getApellido());
		
		txtDoc = new JTextField();
		txtDoc.setBounds(150, 118, 130, 20);
		contentPane.add(txtDoc);
		txtDoc.setColumns(10);
		txtDoc.setText(user.getDocumento());
		
		this.datePicker = this.createDatePicker();
		datePicker.setBounds(150, 167, 130, 20);
		contentPane.add(this.datePicker);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(150, 212, 91, 20);
		contentPane.add(comboBoxGenero);
		comboBoxGenero.addItem("masculino");
		comboBoxGenero.addItem("femenino");
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(150, 256, 193, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		txtCorreo.setText(user.getCorreoElec());
		
		txtPass = new JTextField();
		txtPass.setBounds(150, 347, 193, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		txtPass.setText(user.getContrasena());
		
		JLabel label4 = new JLabel("(*)");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label4.setBounds(251, 214, 46, 14);
		contentPane.add(label4);
		
			
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(302, 437, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnGuardar = new JButton("Guardar cambios");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModificarDatos(user);
			}
		});
		btnGuardar.setBounds(89, 437, 152, 23);
		contentPane.add(btnGuardar);
	}
	
	
	



	public void cambiarPass(int id) {
		new NuevaPass(id);
		
		
	}
	
		@Override
		public void actionPerformed(ActionEvent e) {
		}
		
		
	private JDatePickerImpl createDatePicker() {

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePickerFecNac = new JDatePickerImpl(datePanel);
		SpringLayout sl_datePickerFecNac = (SpringLayout) datePickerFecNac.getLayout();
		sl_datePickerFecNac.putConstraint(SpringLayout.WEST, datePickerFecNac.getJFormattedTextField(), 10, SpringLayout.WEST, datePickerFecNac);
		return datePickerFecNac;
	}
		
		//Modificación datos
		
		private void ModificarDatos(Usuario user) {


			String fieldNombre = this.txtNombre.getText();
			String fieldApellido = this.txtApellido.getText();
			Date fecha = (Date) this.datePicker.getModel().getValue();
			String fieldDoc = this.txtDoc.getText();
			int fieldGenero = 0;
			if(comboBoxGenero.getSelectedItem().equals("masculino"))fieldGenero=1;
			if(comboBoxGenero.getSelectedItem().equals("femenino"))fieldGenero=2;
			String fieldCorreo= this.txtCorreo.getText();
			String fieldPass=this.txtPass.getText();
			

			// check obligatorios
			if (fieldNombre.equals("") || fieldApellido.equals("") || fieldPass.equals("")) {
				JOptionPane.showMessageDialog(frame, "Debe completar todos los datos obligatorios.", "Datos incompletos",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			
			//Dejo fecha usuario
			if(fecha==null) {fecha=user.getFecNac();}
			
	        		
			// Valida que usuario no exista con mismo documento
			if(fieldDoc!="") {
			boolean existeCi = ControladorUsuarios.existeCi(fieldDoc);

			if (existeCi) {
				JOptionPane.showMessageDialog(frame, "El documento se encuentra ingresado para otro usuario.",
						"Documento Existente.", JOptionPane.WARNING_MESSAGE);

				return;
			}
			}
			

			//Largo caracteres		
			if(fieldNombre.length()>=50) {
				JOptionPane.showMessageDialog(frame, "El campo nombre debe ser igual o menor a 50 caracteres",
						"Máximo caracteres excedido.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(fieldApellido.length()>=50) {
				JOptionPane.showMessageDialog(frame, "El campo apellido debe ser igual o menor a 50 caracteres",
						"Máximo caracteres excedido.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(fieldDoc!="") {
			if(fieldDoc.length()>=20) {
				JOptionPane.showMessageDialog(frame, "El campo documento debe ser igual o menor a 20 caracteres",
						"Máximo caracteres excedido.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			}
			if(fieldCorreo.length()>=200) {
				JOptionPane.showMessageDialog(frame, "El campo correo debe ser igual o menor a 200 caracteres",
						"Máximo caracteres excedido.", JOptionPane.WARNING_MESSAGE);
				return;
			}		
			if(fieldPass.length()>=16 ||fieldPass.length()<=8) {
				JOptionPane.showMessageDialog(frame, "El campo contraseña debe tener como minimo 8 caracteres y como máximo 16",
						"Máximo caracteres excedido.", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			

			// Almacenamos Usuario
			Usuario usermod=new Usuario(user.getIdUsuario(),fieldDoc,fieldNombre,fieldApellido,fecha,fieldGenero,fieldCorreo,user.getTipoPublico(),user.getTipoReceta(),user.getRol(),fieldPass,user.getNomUsuario());
			boolean almacenado = ControladorUsuarios.ActualizarUsuario(usermod);

			if (almacenado) {
				JOptionPane.showMessageDialog(frame, "El Usuario se ha actualizado con éxito.",
						"Usuario Agregado!", JOptionPane.INFORMATION_MESSAGE);
				
				// cerramos la ventanta
				dispose();

				
			}
			else{
				JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente más tarde",
						"Error al registrar!", JOptionPane.ERROR_MESSAGE);
			}

		}
	}

