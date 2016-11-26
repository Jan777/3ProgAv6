package comunicacionServidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import org.json.JSONException;
import org.json.JSONObject;

public class AtencionAlCliente extends Thread {
	
	private Socket clienteSocket;
	
	public AtencionAlCliente(Socket socket) {
		this.clienteSocket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream(), "UTF-8"));
			String line= reader.readLine();
			JSONObject json= new JSONObject(line);
			String name = json.getString("name");
			ConsultasSQL consulta= new ConsultasSQL();
			switch (name){
				case "registro":
					consulta.grabarRegistro(json, clienteSocket);
					break;
				case "login":
					int respuesta = consulta.validarUsuario(json, clienteSocket);
					//System.out.println(respuesta);
					if(respuesta == 1){
						String raza;
						raza=consulta.raza(json.getString("nickname"));
						enviarRespuestaLoginCorrecto(json.getString("nickname"), raza);
					}
						
					if(respuesta == 0)
						enviarRespuestaLogueado(clienteSocket, json.getString("nickname"));
					if(respuesta == -1 || respuesta == 2)
						enviarRespuestaLoginIncorrecta(clienteSocket, json.getString("nickname"));
					break;					
				case "personaje":
					int respuesta1 = consulta.crearPers(json, clienteSocket);
					if(respuesta1 == 3){
						String raza1;
						raza1=consulta.raza(json.getString("nickname"));
						enviarRespuestaPersonajeCorrecto(json.getString("nickname"), raza1);
					}
					enviarRespuestaPersonajeIncorrecto(json.getString("nickname"));
					break;
				case "cerrarSesion":
					consulta.cerrarSesion(json, clienteSocket);
					break;		
			} 		
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al hacer la lectura del cliente.");
		} catch (JSONException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error en la mensajer�a JSON.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error de base de datos.");
		}
	}
	
	public void enviarRespuestaRegistroError(Socket socket, String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "nicknameError");		
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de registro err�neo.");
		}
		
	}
	
	public void enviarRespuestaPersonajeCorrecto (String nickname, String raza) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "personajeCorrecto");	
		json.put("nickname", nickname);
		json.put("raza", raza);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(clienteSocket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de personaje correcto.");
		}
	}
	
	public void enviarRespuestaPersonajeIncorrecto (String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "personajeIncorrecto");	
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(clienteSocket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de personaje incorrecto.");
		}
	}
	
	public void enviarRespuestaRegistro(Socket socket, String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "nicknameOk");
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de registro correcto.");
		}
		
	}
	
	public void enviarRespuestaLoginIncorrecta (Socket socket, String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "loginincorrecto");
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de login err�neo.");
		}
	}
	
	public void enviarRespuestaLoginCorrecto(String nickname, String raza) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "logincorrecto");	
		json.put("nickname", nickname);
		json.put("raza", raza);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(clienteSocket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de login correcto.");
		}
	}
	
	public void enviarRespuestaLogueado(Socket socket, String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "isConnect");		
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de usuario logueado.");
		}
	}
	
	public void enviarRespuestaPersonajeError (Socket socket , String nickname)throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "errorPers");
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de creaci�n de personaje err�neo.");
		}
	}
	
	public void enviarRespuestaPersonaje(Socket socket, String nickname)throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "persOK");		
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocurri� un error al enviar la respuesta de creaci�n de personaje correcto.");
		}
	}
	
}
