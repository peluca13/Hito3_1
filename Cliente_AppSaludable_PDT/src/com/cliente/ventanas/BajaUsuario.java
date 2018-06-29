package com.cliente.ventanas;



import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.controladores.ControladorUsuarios;
import com.entidades.Usuario;

import javax.swing.JButton;
import javax.swing.JTable;

public class BajaUsuario implements ActionListener {

	private JTable table;
	private JFrame frame;
	private long idUsuario=0;
	private String nombreUsu="";
	private String apeUsu="";
	private String usernameUsu="";
	private JFrame frmBorrarUsuario;
	private JTextField textFieldApellido;
	private JTextField textFieldUsuario;




	/**
	 * Create the application.
	 */
	public BajaUsuario(VentanaPrincipal framePadre) {
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		
		frmBorrarUsuario = new JFrame();
		frmBorrarUsuario.setTitle("Borrar Usuario");
		frmBorrarUsuario.setBounds(100, 100, 450, 300);
		frmBorrarUsuario.setLocationRelativeTo(null);
		frmBorrarUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmBorrarUsuario.getContentPane().setLayout(null);
		frmBorrarUsuario.setVisible(true);
		this.frame=frmBorrarUsuario;
		
		JLabel lblIngreseLosDatos = new JLabel("Ingrese los datos de busqueda");
		lblIngreseLosDatos.setBounds(47, 11, 194, 14);
		frmBorrarUsuario.getContentPane().add(lblIngreseLosDatos);
		
		JLabel lblNewLabel = new JLabel("Apellido");
		lblNewLabel.setBounds(25, 67, 61, 14);
		frmBorrarUsuario.getContentPane().add(lblNewLabel);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setBounds(96, 64, 104, 20);
		frmBorrarUsuario.getContentPane().add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(225, 67, 61, 14);
		frmBorrarUsuario.getContentPane().add(lblUsuario);
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(286, 64, 119, 20);
		frmBorrarUsuario.getContentPane().add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
				

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarTabla();
			}
		});
		btnBuscar.setBounds(172, 95, 89, 23);
		frmBorrarUsuario.getContentPane().add(btnBuscar);
		
		table = new JTable();
		table.setBounds(47, 150, 358, 62);
		frmBorrarUsuario.getContentPane().add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(47, 150, 358, 62);		 
		frmBorrarUsuario.getContentPane().add(scrollPane);
		
		JButton btnBorrar = new JButton("BORRAR");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idUsuario!=0) {borrarUsuario(idUsuario);}
			}
		});
		btnBorrar.setBounds(47, 223, 89, 23);
		frmBorrarUsuario.getContentPane().add(btnBorrar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBorrarUsuario.dispose();
			}
		});
		btnCancelar.setBounds(316, 223, 89, 23);
		frmBorrarUsuario.getContentPane().add(btnCancelar);
		
		
		table.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
	        Point p = arg0.getPoint();
	        int row = table.rowAtPoint(p);
	        idUsuario = Long.parseLong( table.getModel().getValueAt(row, 0).toString() );
	        nombreUsu = table.getModel().getValueAt(row, 1).toString();
	        apeUsu = table.getModel().getValueAt(row, 2).toString();
	        usernameUsu = table.getModel().getValueAt(row, 3).toString();
	        
	        }
	});
								
	}
	
	
	
	
	
	public void borrarUsuario(long idUsuario) {
		
		int input=JOptionPane.showConfirmDialog(frame, "Esta seguro de que desea borrar el usuario:\nNombre: "+nombreUsu+"\nApellido: "+apeUsu+"\nUsername: "+usernameUsu);
		if(input==0) {
			System.out.println(idUsuario);
			boolean borrado = ControladorUsuarios.borrarUsuario(idUsuario);

			if (borrado) {
				idUsuario=0;
				JOptionPane.showMessageDialog(frame, "El Usuario se ha borrado con éxito.",
						"Usuario Borrado!", JOptionPane.INFORMATION_MESSAGE);
				// cerramos la ventanta
				this.frame.dispose();				
			}
			else{
				idUsuario=0;
				JOptionPane.showMessageDialog(frame, "Hubo un error al borrar.",
						"Error al Borrar!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(input==1) {
			idUsuario=0;
			return;
		}
		if(input==2) {
			idUsuario=0;
			return;
		}	

	}

	public void cargarTabla(){
		//Nombre de las columnas de la tabla
        String[] columnas = new String[] { "ID", "Nombre", "Apellido", "Username", "Documento"};
            
        //Se obtienen los usuarios para llenar la tabla
        ArrayList<Usuario> usuarios = ControladorUsuarios.obtenerInfoUsuarios(textFieldApellido.getText(),textFieldUsuario.getText());
        if(usuarios.isEmpty()) {
        	idUsuario=0;
        	JOptionPane.showMessageDialog(frame, "El usuario solicitado, no fue encontrado en el sistema. Por favor realice nuevamente la búsqueda", "Buqueda",
					JOptionPane.WARNING_MESSAGE);
			return;
        }
        /*Los datos de una tabla se pueden ver como una matriz o un doble array de objetos 
         * (ya que los campos son o numero o caraceres se especifica que el tipo de datos es un objeto genérico)*/
        Object[][] datosTabla = new Object[usuarios.size()][5];
        int fila = 0;
        for(Usuario u : usuarios){
        	datosTabla[fila][0] = u.getIdUsuario();
        	datosTabla[fila][1] = u.getNombre();
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


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
