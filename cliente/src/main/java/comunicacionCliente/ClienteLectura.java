package comunicacionCliente;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteLectura extends Thread {
	private Socket socket;
	private DataInputStream entrada;

	public ClienteLectura(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	public void run() {
		try {
			while (true) {
				entrada = new DataInputStream(this.socket.getInputStream());
				String msj = entrada.readUTF();
				System.out.println("mensaje: " + msj);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}