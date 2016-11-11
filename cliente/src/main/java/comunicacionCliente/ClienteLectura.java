package comunicacionCliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;

import login.MensajeJSON;
import login.Menu;

public class ClienteLectura extends Thread {
	private Socket socket;
	private DataInputStream entrada;
	JSONObject obj;
	String nickname=null;
	public ClienteLectura(Socket socket) {
		this.socket = socket;
		//this.obj = json;		
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			String line= reader.readLine();
			JSONObject json= new JSONObject(line);
			String name = json.getString("error");
			nickname = json.getString("nickname");
			switch (name){
				case "logincorrecto":
					loginCorrecto(nickname);
					break;
			
				case "loginincorrecto":
					loginIncorrecto(socket);
					break;
					
				case "isConnect":
					isConnect(socket);
					break;

				case "nicknameError":
					nicknameExistente(socket);
					break;
				
				case "nicknameOk":{
					nicknameOk(socket);
					break;
					
				}
			} 			
			
		} catch (IOException e) {
			
		} catch (JSONException e) {
			
		}
	}
	
	public void loginCorrecto(String nickname) {
		JOptionPane.showMessageDialog(null, "El usuario ha ingresado correctamente", "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
		Menu menu= new Menu(nickname);
		menu.setVisible(true);
	}
	
	public void nicknameExistente(Socket socket) throws IOException {
		JOptionPane.showMessageDialog(null, "El nickname ya existe seleccione otro", "Error",
                JOptionPane.ERROR_MESSAGE);
		socket.close();
	}
	
	
	public void loginIncorrecto(Socket socket) throws IOException {
		JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta", "Error",
                JOptionPane.ERROR_MESSAGE);
		socket.close();
	}
	
	public void isConnect(Socket socket) throws IOException {
		JOptionPane.showMessageDialog(null, "El usuario ya se encuentra logueado", "Error",
                JOptionPane.ERROR_MESSAGE);
		socket.close();
	}
	
	public void nicknameOk(Socket socket) throws IOException {
		JOptionPane.showMessageDialog(null, "El usuario se ha registrado correctamente", "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
		socket.close();
	}
	


}