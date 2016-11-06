package servidor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Loggin extends JFrame {
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;
	private Registro pantallaRegistro = null;
	
	private ServidorSQL servidorSQL;
	
	Connection conn=null;
	
	public Loggin() {
		conn=SQLConnection.dbConnector();
		addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent arg0) {
					abreDialogSalida();
				}
			});
			setTitle("Loggin WorldWar");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setBounds(100, 100, 319, 251);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JButton btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent arg0) {
					instanciarPR();
					pantallaRegistro.show();
				}
			});
			contentPane.add(btnRegistrarse, BorderLayout.SOUTH);

			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.CENTER);

			JLabel label = new JLabel("");
			label.setBounds(27, 16, 0, 0);

			JLabel label_3 = new JLabel("");
			label_3.setBounds(73, 16, 0, 0);

			txtUsuario = new JTextField();
			txtUsuario.setBounds(92, 40, 166, 20);
			txtUsuario.setColumns(10);

			JLabel label_2 = new JLabel("");
			label_2.setBounds(321, 16, 0, 0);

			JLabel label_1 = new JLabel("");
			label_1.setBounds(326, 16, 0, 0);

			JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					if (!txtUsuario.getText().equals("")
							&& !txtPassword.getText().equals("")) {
						Usuario u = new Usuario(txtUsuario.getText());
						u.setPassword(txtPassword.getText());				
						servidorSQL=new ServidorSQL(); 
						servidorSQL.validarUsuario(u);
					}
				}
			});
			btnAceptar.setBounds(27, 126, 231, 20);
			panel.setLayout(null);
			panel.add(label);

			JLabel lblUsuario = new JLabel("Usuario");
			lblUsuario.setBounds(26, 43, 56, 14);
			panel.add(lblUsuario);
			panel.add(label_3);
			panel.add(txtUsuario);

			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setBounds(27, 86, 77, 14);
			panel.add(lblContrasea);
			panel.add(label_2);
			panel.add(label_1);
			panel.add(btnAceptar);

			txtPassword = new JPasswordField();
			txtPassword.setBounds(114, 83, 146, 20);
			panel.add(txtPassword);
		}
	
	public void instanciarPR() {
		this.pantallaRegistro = new Registro(this);
	}
	
	public void abreDialogSalida() {
		int res = JOptionPane.showConfirmDialog(this, "¿Desea Salir?",
				"Salida", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			//getCliente().cerrarComunicacion();
			System.exit(0);
		}
	}
	
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loggin frame = new Loggin();
					frame.setVisible(true);
				} catch (Exception e) {
					System.err.println("Loggin fallido");
					System.exit(1);
				}
			}
		});
		
	}
	}

