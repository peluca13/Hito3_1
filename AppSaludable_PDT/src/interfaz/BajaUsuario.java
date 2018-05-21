package interfaz;



import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controladores.ControladorUsuarios;
import entidades.Usuario;

import javax.swing.JButton;
import javax.swing.JTable;

public class BajaUsuario implements ActionListener {

	private JTable table;
	private JFrame frame;
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
				
	}
	
	
	
	
	
	public void cargarTabla(){
		//Nombre de las columnas de la tabla
        String[] columnas = new String[] { "Nombre", "Apellido", "Username", "Documento"};
            
        //Se obtienen los usuarios para llenar la tabla
        ArrayList<Usuario> usuarios = ControladorUsuarios.obtenerInfoUsuarios(textFieldApellido.getText(),textFieldUsuario.getText());
        /*Los datos de una tabla se pueden ver como una matriz o un doble array de objetos 
         * (ya que los campos son o numero o caraceres se especifica que el tipo de datos es un objeto genérico)*/
        Object[][] datosTabla = new Object[usuarios.size()][4];
        int fila = 0;
        for(Usuario u : usuarios){
        	datosTabla[fila][0] = u.getNombre();
        	datosTabla[fila][1] = u.getApellido();
        	datosTabla[fila][2] = u.getNomUsuario();
        	datosTabla[fila][3] = u.getDocumento();
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
