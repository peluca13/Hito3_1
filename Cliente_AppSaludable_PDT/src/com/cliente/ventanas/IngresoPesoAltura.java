package com.cliente.ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.controladores.ControladorUsuarios;
import com.entidades.Usuario;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class IngresoPesoAltura {

	private JFrame frmIngresoDePeso;
	private JTextField textFieldPeso;
	private JTextField textFieldAltura;
	private JDatePickerImpl datePicker;


	/**
	 * Create the application.
	 */
	public IngresoPesoAltura(Usuario usuario) {
		initialize(usuario);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Usuario usuario) {
		frmIngresoDePeso = new JFrame();
		frmIngresoDePeso.setTitle("Ingreso de Peso Altura para Usuario");
		frmIngresoDePeso.setBounds(100, 100, 450, 300);
		frmIngresoDePeso.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresoDePeso.setLocationRelativeTo(null);
		frmIngresoDePeso.getContentPane().setLayout(null);
		frmIngresoDePeso.setVisible(true);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos solicitados");
		lblIngreseLosDatos.setBounds(54, 11, 198, 14);
		frmIngresoDePeso.getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblPeso = new JLabel("Peso Kg");
		lblPeso.setBounds(10, 98, 75, 14);
		frmIngresoDePeso.getContentPane().add(lblPeso);
		
		textFieldPeso = new JTextField();
		textFieldPeso.setBounds(78, 95, 86, 20);
		frmIngresoDePeso.getContentPane().add(textFieldPeso);
		textFieldPeso.setColumns(10);
		
		JLabel lblAltura = new JLabel("Altura mts");
		lblAltura.setBounds(200, 98, 89, 14);
		frmIngresoDePeso.getContentPane().add(lblAltura);
		
		textFieldAltura = new JTextField();
		textFieldAltura.setBounds(284, 95, 86, 20);
		frmIngresoDePeso.getContentPane().add(textFieldAltura);
		textFieldAltura.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(10, 150, 46, 14);
		frmIngresoDePeso.getContentPane().add(lblFecha);
		
		this.datePicker = this.createDatePicker();
		datePicker.setBounds(78, 150, 130, 20);
		frmIngresoDePeso.getContentPane().add(this.datePicker);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ingresoDatos(usuario);
			}
		});
		btnGuardar.setBounds(48, 207, 89, 23);
		frmIngresoDePeso.getContentPane().add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmIngresoDePeso.dispose();
			}
		});
		btnCancelar.setBounds(230, 207, 89, 23);
		frmIngresoDePeso.getContentPane().add(btnCancelar);
		frmIngresoDePeso.setVisible(true);
		
		
	}
	private JDatePickerImpl createDatePicker() {

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		return datePicker;
	}
	
	protected void ingresoDatos(Usuario user){
		float altura=0;
		float peso=0;
		try {
		altura=Float.parseFloat(this.textFieldAltura.getText());
		peso=Float.parseFloat(this.textFieldPeso.getText());
		}
		catch (NumberFormatException e){
			JOptionPane.showMessageDialog(frmIngresoDePeso, "Debe ingresar un valor numerico. Para decimal usar punto.", "Datos incompletos",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		Date fecha = (Date) this.datePicker.getModel().getValue();
		
		// check obligatorios
				if (altura==0|| peso==0 ||fecha==null) {
					JOptionPane.showMessageDialog(frmIngresoDePeso, "Debe completar todos los datos", "Datos incompletos",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
		
		//Validar que no exista dato para esa fecha
				if(ControladorUsuarios.validarPesoFecha(user,fecha)) {
					JOptionPane.showMessageDialog(frmIngresoDePeso, "Ya se encuentra un ingreso para esa fecha", "Fecha existente",
							JOptionPane.WARNING_MESSAGE);
					return;
				}else {
					if(ControladorUsuarios.ingresarIMC(user,altura,peso, fecha)) {
						JOptionPane.showMessageDialog(frmIngresoDePeso, "Se ingreso IMC correctamente", "Ingreso correcto",
								JOptionPane.WARNING_MESSAGE);
						return;
					}else {
						JOptionPane.showMessageDialog(frmIngresoDePeso, "Fallo al insertar imc. Intente mas tarde", "Ingreso fallido",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				
		
	}

}
