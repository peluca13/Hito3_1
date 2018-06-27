package com.cliente.ventanas;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entidades.Usuario;

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
	private JMenu mnAlturaPeso;
	private JMenuItem mntmVerModDatos;
	private JMenuItem mntmAlturaPeso;
	private JMenuItem mntmVerIMC;
	private Usuario user;
	

	
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
		
		// Botón Ver/modificar datos usuario.
		mntmVerModDatos = new JMenuItem("Ver/modificar datos");
		mnMenuUsuario.add(mntmVerModDatos);
		mntmVerModDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new ModDatosUsuario(user);            	
            	
            }
        }); 
		
		// Botón Ver evolución IMC.
		mntmVerIMC = new JMenuItem("Agregar Peso Altura");
		mnMenuUsuario.add(mntmVerIMC);
		mntmVerIMC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new IngresoPesoAltura(user.getIdUsuario());
            	
            }
        });
		
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Menu Personal Institución

				
				//BOTON ALTAS BAJAS MODIFICACIONES
				mnAlturaPeso = new JMenu("Ingreso de Datos");
				menuBar.add(mnAlturaPeso);
				mnAlturaPeso.setVisible(false);
				
				mntmAlturaPeso = new JMenuItem("Altura Peso");
				mnAlturaPeso.add(mntmAlturaPeso);
				mntmAlturaPeso.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent event) {
		                
		            	new InPesoAlturaPer();
		            	
		            }
		        });
		
		
		
		
	}
	public void menuRol(String rol,Usuario usuario) {
		if(rol.equals("ADMINISTRADOR")) {
			mnAbm.setVisible(true);
		}
		if(rol.equals("USUARIO")) {
			mnMenuUsuario.setVisible(true);
		}
		if(rol.equals("PERSONAL_INSTITUCION")) {
			mnAlturaPeso.setVisible(true);
			
		}
		
		user=usuario;
	}
	
}
