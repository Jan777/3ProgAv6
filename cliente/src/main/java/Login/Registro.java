package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Registro extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtNombreUsuario;
	private JTextField txtMailUsuario;
	private JTextField txtNickname;
	private JPasswordField txtPassword1;
	private JPasswordField txtPassword2;
	private Loggin pantallaLoggin;
	JLabel lblMensaje;
	Usuario uss;
	private ServidorSQL servidorSQL;
	
	
	
	public Registro(Loggin l) {
		this.pantallaLoggin = l;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//abreDialogSalida();
			}
		});
		setTitle("Registro");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 398, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(31, 37, 46, 14);
		contentPane.add(lblNombre);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(87, 34, 255, 20);
		contentPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(31, 115, 46, 14);
		contentPane.add(lblNickname);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(31, 78, 46, 14);
		contentPane.add(lblMail);

		txtMailUsuario = new JTextField();
		txtMailUsuario.setBounds(87, 75, 255, 20);
		contentPane.add(txtMailUsuario);
		txtMailUsuario.setColumns(10);

		txtNickname = new JTextField();
		txtNickname.setBounds(87, 112, 255, 20);
		contentPane.add(txtNickname);
		txtNickname.setColumns(10);

		JLabel lblPassword1 = new JLabel("Contrase\u00F1a");
		lblPassword1.setBounds(31, 157, 62, 14);
		contentPane.add(lblPassword1);

		txtPassword1 = new JPasswordField();
		txtPassword1.setBounds(115, 154, 227, 20);
		contentPane.add(txtPassword1);

		JLabel lblPassword2 = new JLabel("Contrase\u00F1a");
		lblPassword2.setBounds(31, 197, 62, 14);
		contentPane.add(lblPassword2);

		txtPassword2 = new JPasswordField();
		txtPassword2.setBounds(115, 194, 227, 20);
		contentPane.add(txtPassword2);

		JLabel lblAsterisco1 = new JLabel("*");
		lblAsterisco1.setBounds(344, 37, 22, 14);
		contentPane.add(lblAsterisco1);

		JLabel lblAsterisco2 = new JLabel("*");
		lblAsterisco2.setBounds(344, 157, 22, 14);
		contentPane.add(lblAsterisco2);

		JLabel label = new JLabel("*");
		label.setBounds(344, 197, 22, 14);
		contentPane.add(label);

		JLabel lblCampoObligatorio = new JLabel("* Campos Obligatorios.");
		lblCampoObligatorio.setBounds(10, 272, 257, 36);
		contentPane.add(lblCampoObligatorio);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (!txtMailUsuario.getText().equals("")
						&& !txtNombreUsuario.getText().equals("")
						&& !txtPassword1.getText().equals(""))
					if (txtPassword1.getText().equals(txtPassword2.getText())) {
						uss = new Usuario(txtNickname.getText());
						uss.setNombre(txtNombreUsuario.getText());
						uss.setMail(txtMailUsuario.getText());
						uss.setPassword(txtPassword1.getText());
						servidorSQL=new ServidorSQL(); 
						servidorSQL.agregarUsuario(uss.getMail(), uss.getNombre(),uss.getNickname(),uss.getPassword());
						dispose();
						//pantallaLoggin.getCliente().usuarioDisponible(txtMailUsuario.getText());
					} else
						lblMensaje.setText("Las contraseñas deben coincidir.");
				else
					lblMensaje.setText("Campos obligatorios, incompletos.");
			}
		});
		btnAceptar.setBounds(277, 255, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(277, 285, 89, 23);
		contentPane.add(btnCancelar);

		lblMensaje = new JLabel("...");
		lblMensaje.setBounds(10, 222, 332, 39);
		contentPane.add(lblMensaje);

		JLabel lblAsterisco4 = new JLabel("*");
		lblAsterisco4.setBounds(344, 78, 22, 14);
		contentPane.add(lblAsterisco4);
	}
	
}
