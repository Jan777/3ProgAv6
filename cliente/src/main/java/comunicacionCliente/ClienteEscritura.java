package comunicacionCliente;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class ClienteEscritura extends Thread {
	private Socket socket;
	JSONObject obj;

	public ClienteEscritura(Socket socket, JSONObject obj ) {

		this.socket = socket;
		this.obj = obj;
	}

	public void run() {
		OutputStreamWriter writer;
		try {
			writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
			writer.write (obj.toString() + "\n");
			writer.flush();
			
		} catch (IOException e) {
			try {
				this.socket.close();
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Ocurrió un error al querer cerrar el socket.");
			}
			
		}
		
	}

}
