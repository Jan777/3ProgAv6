package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONObject;

import comunicacionCliente.Cliente;
import comunicacionCliente.ClienteLectura;

import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MensajeJSON extends JFrame {
	
	public MensajeJSON() {
	
	}

	public void agregarUsuario(String mail, String nombre, String nickname, String password) throws JSONException {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "registro");
		obj.put("email",  mail);
		obj.put("nombre", nombre);
		obj.put("nickname",  nickname);
		obj.put("password",  password);
		obj.put("isConect",  0);
		new Cliente(obj);
		
	}
	
	
	public static void validarUsuario(String nickname, String password) throws JSONException {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "login");
		obj.put("nickname",  nickname);
		obj.put("password",  password);
		new Cliente(obj);
	}
	
}
