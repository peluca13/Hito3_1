package interfaz;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class VentanaPrincipal extends JFrame {

	
	private JPanel contentPane;
	private JMenu mnAbm;
	private JMenuItem mntmAltas;
	private JMenuItem mntmBajas;
	private JMenuItem mntmModificaciones;
	private JMenu mnMenuUsuario;
	private JMenuItem mntmVerModDatos;
	private JMenuItem mntmVerIMC;
	

	
	static VentanaPrincipal frame = new VentanaPrincipal();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					frame.setVisible(true);
					Login miLogin=new Login(frame,true);
					miLogin.setVisible(true);
					
					
					

			}
		});
	}
	
	public static VentanaPrincipal getFrame() {
		return frame;
	}
	
	
	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("App Saludable");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1, 1, 700, 650);
		setLocationRelativeTo(null);		
		
		
		//Menu Admin
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		//BOTON ALTAS BAJAS MODIFICACIONES
		mnAbm = new JMenu("ABM");
		menuBar.add(mnAbm);
		mnAbm.setVisible(false);
		
		mntmAltas = new JMenuItem("Altas");
		mnAbm.add(mntmAltas);
		mntmAltas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new AltaUsuario(frame);
            	
            }
        });
		
		mntmBajas = new JMenuItem("Bajas");
		mnAbm.add(mntmBajas);
		mntmBajas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new BajaUsuario(frame);

            	
            }
        });           	
           
		
		mntmModificaciones = new JMenuItem("Modificaciones");
		mnAbm.add(mntmModificaciones);
		mntmModificaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new ModificarPass();

            	
            }
        }); 
		
		
		//Menu Usuario

		mnMenuUsuario = new JMenu("Opciones de Usuario");
		menuBar.add(mnMenuUsuario);
		mnMenuUsuario.setVisible(false);
		
		// Bot�n Ver/modificar datos usuario.
		mntmVerModDatos = new JMenuItem("Ver/modificar datos");
		mnMenuUsuario.add(mntmVerModDatos);
		mntmVerModDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new ModDatosUsuario(frame);

            	
            }
        }); 
		
		// Bot�n Ver evoluci�n IMC.
		mntmVerIMC = new JMenuItem("Ver evoluci�n de IMC");
		mnMenuUsuario.add(mntmVerIMC);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	}
	public void menuRol(String rol) {
		if(rol.equals("Administrador")) {
			mnAbm.setVisible(true);
		}
		if(rol.equals("Usuario")) {
			mnMenuUsuario.setVisible(true);
		}
	}
	
}
