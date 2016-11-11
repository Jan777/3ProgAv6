package comunicacionServidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.text.html.HTMLDocument.Iterator;
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
					consulta.validarUsuario(json, clienteSocket);
					break;
					
				case "personaje":
					consulta.crearPersonaje(json, clienteSocket);
					break;
			} 		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarRespuestaRegistroError(Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "nicknameError");		
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enviarRespuestaRegistro(Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "nicknameOk");
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void enviarRespuestaLoginIncorrecta (Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "loginincorrecto");		
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enviarRespuestaCorrecto (Socket socket , String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "logincorrecto");	
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enviarRespuestaLogueado (Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "isConnect");		
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
