package comunicacionServidor;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.SQLException;

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
					int respuesta = consulta.validarUsuario(json, clienteSocket);
					System.out.println(respuesta);
					if(respuesta == 1)
						enviarRespuestaLoginCorrecto(json.getString("nickname"));
					if(respuesta == 0)
						enviarRespuestaLogueado(clienteSocket, json.getString("nickname"));
					if(respuesta == -1 || respuesta == 2)
						enviarRespuestaLoginIncorrecta(clienteSocket, json.getString("nickname"));
					break;					
				case "personaje":
					consulta.crearPers(json, clienteSocket);
					break;
				case "cerrarSesion":
					consulta.cerrarSesion(json, clienteSocket);
					break;		
			} 		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
	public void enviarRespuestaLoginCorrecto(String nickname) throws JSONException{
		JSONObject json = new JSONObject();
		json.put("error", "logincorrecto");	
		json.put("nickname", nickname);
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(clienteSocket.getOutputStream(), "UTF-8");
			writer.write (json.toString() + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
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
			e.printStackTrace();
		}
	}
	
}
