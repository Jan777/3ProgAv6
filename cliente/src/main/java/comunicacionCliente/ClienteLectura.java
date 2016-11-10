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
			if (name.equals("logincorrecto")){
				loginCorrecto();
				
			} 
			if (name.equals("loginincorrecto")){
				loginIncorrecto();
				socket.close();
			}
			if (name.equals("isConnect")){
				isConnect();
				socket.close();
			}
			if (name.equals("nickname")){
				nicknameExistente();
				socket.close();
			} 
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loginCorrecto() {
		JOptionPane.showMessageDialog(null, "El usuario ha ingresado correctamente", "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE);
		Menu menu= new Menu();
		menu.setVisible(true);
	}
	
	public void nicknameExistente() {
		JOptionPane.showMessageDialog(null, "El nickname ya existe seleccione otro", "Error",
                JOptionPane.ERROR_MESSAGE);
	}
	
	
	public void loginIncorrecto() {
		JOptionPane.showMessageDialog(null, "Usuario o clave incorrecta", "Error",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void isConnect() {
		JOptionPane.showMessageDialog(null, "El usuario ya se encuentra logueado", "Error",
                JOptionPane.ERROR_MESSAGE);
	}
	


}