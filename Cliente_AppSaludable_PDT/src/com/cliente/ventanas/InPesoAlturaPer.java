package com.cliente.ventanas;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.controladores.ControladorUsuarios;
import com.entidades.Usuario;

public class InPesoAlturaPer implements ActionListener {

	private JFrame frmIngresoPesoaltura;
	private JTable table;
	private int idUsuario=0;
	private JTextField textFieldApellido;
	private JTextField textFieldUsuario;
	private Usuario user;


	/**
	 * Create the application.
	 */
	public InPesoAlturaPer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIngresoPesoaltura = new JFrame();
		frmIngresoPesoaltura.setTitle("Ingreso Peso/Altura");
		frmIngresoPesoaltura.setBounds(100, 100, 450, 300);
		frmIngresoPesoaltura.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIngresoPesoaltura.setLocationRelativeTo(null);
		frmIngresoPesoaltura.getContentPane().setLayout(null);
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos de busqueda:");
		lblIngreseLosDatos.setBounds(76, 11, 255, 14);
		frmIngresoPesoaltura.getContentPane().add(lblIngreseLosDatos);
		frmIngresoPesoaltura.setVisible(true);
		
		JLabel lblBuscarUsuario = new JLabel("Buscar Usuario:");
		lblBuscarUsuario.setBounds(10, 48, 134, 14);
		frmIngresoPesoaltura.getContentPane().add(lblBuscarUsuario);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(47, 85, 64, 14);
		frmIngresoPesoaltura.getContentPane().add(lblApellido);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(227, 85, 76, 14);
		frmIngresoPesoaltura.getContentPane().add(lblNewLabel);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(110, 82, 86, 20);
		frmIngresoPesoaltura.getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(300, 82, 86, 20);
		frmIngresoPesoaltura.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		btnBuscar.setBounds(171, 116, 89, 23);
		frmIngresoPesoaltura.getContentPane().add(btnBuscar);
		
		table = new JTable();
		table.setBounds(47, 150, 358, 62);
		frmIngresoPesoaltura.getContentPane().add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(47, 150, 358, 62);		 
		frmIngresoPesoaltura.getContentPane().add(scrollPane);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmIngresoPesoaltura.dispose();
			}
		});
		btnCancelar.setBounds(316, 223, 89, 23);
		frmIngresoPesoaltura.getContentPane().add(btnCancelar);
		
		JButton btnIngPesoAltura = new JButton("Ingresar Peso/Altura");
		btnIngPesoAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresoPesoAltura(user);
			}
		});
		btnIngPesoAltura.setBounds(47, 223, 178, 23);
		frmIngresoPesoaltura.getContentPane().add(btnIngPesoAltura);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
		        Point p = arg0.getPoint();
		        int row = table.rowAtPoint(p);
		        user =(Usuario) table.getModel().getValueAt(row, 1);
		        		//Integer.parseInt( table.getModel().getValueAt(row, 0).toString() ); 
		        }
		});
		


		
	}
	public void cargarTabla(){
		//Nombre de las columnas de la tabla
        String[] columnas = new String[] { "ID", "Nombre", "Apellido", "Username", "Documento"};
            
        //Se obtienen los usuarios para llenar la tabla
        ArrayList<Usuario> usuarios = ControladorUsuarios.obtenerInfoUsuarios(textFieldApellido.getText(),textFieldUsuario.getText());
        if(usuarios.isEmpty()) {
        	idUsuario=0;
        	JOptionPane.showMessageDialog(frmIngresoPesoaltura, "El usuario solicitado, no fue encontrado en el sistema. Por favor realice nuevamente la búsqueda", "Buqueda",
					JOptionPane.WARNING_MESSAGE);
			return;
        }
        /*Los datos de una tabla se pueden ver como una matriz o un doble array de objetos 
         * (ya que los campos son o numero o caraceres se especifica que el tipo de datos es un objeto genérico)*/
        Object[][] datosTabla = new Object[usuarios.size()][5];
        int fila = 0;
        for(Usuario u : usuarios){
        	datosTabla[fila][0] = u.getIdUsuario();
        	datosTabla[fila][1] = u;
        	datosTabla[fila][2] = u.getApellido();
        	datosTabla[fila][3] = u.getNomUsuario();
        	datosTabla[fila][4] = u.getDocumento();
			fila++;
        }
        
		//Se crea un modelo para setearle a la tabla, de esta forma se indica los datos y las columnas
		DefaultTableModel model = new DefaultTableModel(datosTabla, columnas) {
			/*
			 * Este codigo indica que las celdas no son editables y que son todas
			 * del tipos String
			 */
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return String.class;
			}
		};
		

		table.setModel(model);


	}
	
	public void ingresoPesoAltura(Usuario user) {
		new IngresoPesoAltura(user);
		
	}
		
		

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
