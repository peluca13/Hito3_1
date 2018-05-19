package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controladores.ControladorUsuarios;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSplitPane;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AltaUsuario implements ActionListener{

	private JFrame frame;
	private JFrame frame_1;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldDoc;
	private JTextField textFieldCorreo;
	private JTextField textFieldUsuario;
	private JTextField textFieldPass;
	private JComboBox comboBoxGenero;



	/**
	 * Create the application.
	 * @param frame 
	 */
	public AltaUsuario(VentanaPrincipal framePadre) {
		this.initialize(framePadre);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(JFrame framePadre) {
		frame_1 = new JFrame("Nuevo Usuario");
		frame_1.setLocationRelativeTo(framePadre);
		frame_1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame_1.setSize(482, 475);
		

		frame_1.setVisible(true);

		this.frame = frame_1;
		frame_1.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 25, 433, 411);
		frame_1.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(new Color(0, 0, 0));
		lblNombre.setBounds(10, 21, 53, 14);
		panel.add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(10, 56, 46, 14);
		panel.add(lblApellido);
		
		JLabel lblNewLabel_1 = new JLabel("Documento");
		lblNewLabel_1.setBounds(10, 91, 68, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(10, 126, 83, 14);
		panel.add(lblFechaNacimiento);
		
		JLabel lblNewLabel_2 = new JLabel("Genero");
		lblNewLabel_2.setBounds(10, 161, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblCorreoElectrnico = new JLabel("Correo electr\u00F3nico");
		lblCorreoElectrnico.setBounds(10, 196, 109, 14);
		panel.add(lblCorreoElectrnico);
		
		JLabel lblNombreUsuario = new JLabel("Nombre Usuario");
		lblNombreUsuario.setBounds(10, 231, 109, 14);
		panel.add(lblNombreUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(10, 266, 83, 14);
		panel.add(lblContrasea);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(135, 18, 130, 20);
		panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(135, 53, 130, 20);
		panel.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldDoc = new JTextField();
		textFieldDoc.setBounds(135, 88, 130, 20);
		panel.add(textFieldDoc);
		textFieldDoc.setColumns(10);
		
		comboBoxGenero = new JComboBox();
		comboBoxGenero.setBounds(135, 158, 91, 20);
		panel.add(comboBoxGenero);
		comboBoxGenero.addItem("masculino");
		comboBoxGenero.addItem("femenino");
		
		textFieldCorreo = new JTextField();
		textFieldCorreo.setBounds(135, 193, 130, 20);
		panel.add(textFieldCorreo);
		textFieldCorreo.setColumns(10);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(135, 228, 130, 20);
		panel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(135, 263, 130, 20);
		panel.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(93, 363, 89, 23);
		panel.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cancelar();
			}
		});
		btnCancelar.setBounds(301, 363, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblDatosObligatorios = new JLabel("Datos Obligatorios *");
		lblDatosObligatorios.setBounds(10, 323, 109, 14);
		panel.add(lblDatosObligatorios);
		
		JLabel label = new JLabel("(*)");
		label.setBounds(277, 21, 46, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("(*)");
		label_1.setBounds(275, 56, 46, 14);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("(*)");
		label_3.setBounds(275, 231, 46, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("(*)");
		label_4.setBounds(275, 266, 46, 14);
		panel.add(label_4);
		
		JLabel lblNewLabel = new JLabel("Ingrese los datos del Usuario");
		lblNewLabel.setBounds(132, 0, 179, 29);
		frame_1.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 51, 153));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	private JDatePickerImpl creareDatePicker() {

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		return datePicker;
	}
	
	//Cancelar
	private void Cancelar() {
		this.frame.dispose();
	}
	
	
	
	//Alta
	
	private void Alta() {


		String fieldNombre = this.textFieldNombre.getText();
		String fieldApellido = this.textFieldApellido.getText();
		String fieldDoc = this.textFieldDoc.getText();
		int fieldGenero;
		if(comboBoxGenero.getSelectedItem().equals("masculino"))fieldGenero=1;
		if(comboBoxGenero.getSelectedItem().equals("femenino"))fieldGenero=2;
		String fieldCorreo= this.textFieldCorreo.getText();
		String fieldUsuario=this.textFieldUsuario.getText();
		String fieldPass=this.textFieldPass.getText();
		

		// check obligatorios
		if (fieldNombre.equals("") || fieldApellido.equals("") ||fieldUsuario.equals("")|| fieldPass.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos obligatorios.", "Datos incompletos",
					JOptionPane.WARNING_MESSAGE);

			return;
		}
/*            FALTA COMPLETAR VALIDACIONES
		// Valiamos ahora, que no exista un cliente con dicha CI
		boolean existe = ControladorClientes.existeCliente(fieldCi);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "El cliente con dicha CI ya se ecuentra registrado.",
					"Cliente Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}

		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// cliente y volvemos al menu
		boolean almacenado = ControladorClientes.ingresarNuevoCliente(fieldNombre, fieldApellido, fieldCi);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El cliente ha sido registrado con éxito.",
					"Cliente Registrado!", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos la ventanta
			this.frame.dispose();

			
		}
		else{
			JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente más tarde",
					"Error al registrar!", JOptionPane.ERROR_MESSAGE);
		}
*/
	}
	
	
	
	
	
	
	
}
