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
			if (name.equals("registro")){
				ConsultasSQL consulta= new ConsultasSQL();
				consulta.grabarRegistro(json, clienteSocket);
			}else if (name.equals("login")){
				ConsultasSQL consulta= new ConsultasSQL();
				consulta.validarUsuario(json, clienteSocket);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void enviarRespuestaRegistro(Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "nickname");		
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void enviarRespuestaUsuarioInexistente (Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "usuarioinexistente");		
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void enviarRespuestaPasswordIncorrecta (Socket socket) throws JSONException{
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
	
	public void enviarRespuestaCorrecto (Socket socket) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "logincorrecto");		
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
