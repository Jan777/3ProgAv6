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
	
	Cliente cliente = null;
	
	public MensajeJSON() {
		
	}

	public void agregarUsuario(String mail, String nombre, String nickname, String password) throws JSONException{
		
		JSONObject obj = new JSONObject();
		obj.put("name", "registro");
		obj.put("email",  mail);
		obj.put("nombre", nombre);
		obj.put("nickname",  nickname);
		obj.put("password",  password);
		obj.put("isConect",  0);
		new Cliente(obj);
	}
	
	
	public void validarUsuario(String nickname, String password) throws JSONException {
		JSONObject obj = new JSONObject();
		obj.put("name", "login");
		obj.put("nickname",  nickname);
		obj.put("password",  password);
		this.cliente = new Cliente(obj);
	}
	
	public void agregarPersonaje(String nombre, String casta, String personaje, String nickname) throws JSONException {
		
		JSONObject obj = new JSONObject();
		obj.put("name", "personaje");
		obj.put("nickname", nickname);
		obj.put("nombre", nombre);
		obj.put("casta",  casta);
		obj.put("tipopers",  personaje);
		new Cliente(obj);
	}
	
	public void cerrarSesion (String nickname) throws JSONException{
		JSONObject obj = new JSONObject();
		obj.put("name", "cerrarSesion");
		obj.put("nickname", nickname);
		new Cliente(obj);
	}
	
	
}
