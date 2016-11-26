package login;

import java.awt.Color;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.json.JSONException;
import javax.swing.JComboBox;

public class PantallaPersonaje extends JFrame  {
	
	private JPanel contentPane;
	private Menu pantallaMenu;
	Pers pers;
	private MensajeJSON mensajeJSON;
	private JTextField textNombre;
	private String nickname;
	
	
	public PantallaPersonaje(Menu menu, String nickname) {
		this.pantallaMenu = menu;
		this.nickname=nickname;
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				abreDialogSalida();
			}
		});
		setTitle("Creacion de personaje");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 400, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		JLabel lblNombre = new JLabel("Nombre Personaje");
		lblNombre.setBounds(31, 37, 154, 14);
		contentPane.add(lblNombre);

		JLabel lblNickname = new JLabel("Personaje");
		lblNickname.setBounds(31, 115, 114, 14);
		contentPane.add(lblNickname);

		JLabel lblMail = new JLabel("Casta");
		lblMail.setBounds(31, 78, 46, 14);
		contentPane.add(lblMail);
		
		textNombre = new JTextField();
		textNombre.setBounds(195, 34, 147, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		String[] casta = new String[] {"Mago", "Guerrero","Explorador"};
		JComboBox comboBox = new JComboBox(casta);
		comboBox.setBounds(195, 75, 147, 20);
		contentPane.add(comboBox);
		
		String[] personaje = new String[] {"Humano", "Orco","Elfo"};
		JComboBox comboBox_1 = new JComboBox(personaje);
		comboBox_1.setBounds(195, 112, 147, 20);
		contentPane.add(comboBox_1);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textNombre.getText().equals("")){
						pers = new Pers(textNombre.getText());
						pers.setCasta((String)comboBox.getSelectedItem());
						pers.setPersonaje((String)comboBox_1.getSelectedItem());
						mensajeJSON=new MensajeJSON(); 
						try {
							mensajeJSON.agregarPersonaje(pers.getNombrepers(), pers.getCasta(), pers.getPersonaje(),nickname);
						} catch (JSONException e1) {
							JOptionPane.showMessageDialog(null, "Ocurrió un error al crear el personaje.");
						}
				}	
						dispose();
			}
		});
		btnAceptar.setBounds(139, 169, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(253, 169, 89, 23);
		contentPane.add(btnCancelar);
		
		
	}
	
	public void abreDialogSalida() {
		int res = JOptionPane.showConfirmDialog(this, "Desea Salir?",
				"Salida", JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
}