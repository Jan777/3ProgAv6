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

public class PantallaMapa extends JFrame  {
	
	private JPanel contentPane;
	private Menu pantallaMenu;
	Pers pers;
	private MensajeJSON mensajeJSON;
	private JTextField textNombre;
	
	public PantallaMapa(Menu menu) {
		this.pantallaMenu = menu;
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				abreDialogSalida();
			}
		});
		setTitle("Eleccion del mapa");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 320, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblMapa = new JLabel("Mapa");
		lblMapa.setBounds(50, 78, 46, 14);
		contentPane.add(lblMapa);
		
		String[] Mapas = new String[] {"Bosque nevado", "Desierto"};
		JComboBox comboBox = new JComboBox(Mapas);
		comboBox.setBounds(135, 75, 147, 20);
		contentPane.add(comboBox);

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//						pers.setCasta((String)comboBox.getSelectedItem());
//
//						mensajeJSON=new MensajeJSON(); 
//						try {
//							//mensajeJSON.agregarPersonaje(pers.getNombrepers(), pers.getCasta(), pers.getPersonaje());
//						} catch (JSONException e1) {
//							e1.printStackTrace();
//						}

						dispose();
			}
		});
		btnAceptar.setBounds(65, 169, 89, 23);
		contentPane.add(btnAceptar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(165, 169, 89, 23);
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