package comunicacionCliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteEscritura extends Thread {
	private Socket socket;

	public ClienteEscritura(Socket socket) {

		this.socket = socket;
	}

	public void run() {
		try {
			while (true) {
				DataOutputStream entrada = new DataOutputStream(socket.getOutputStream());
				entrada.writeUTF(new Scanner(System.in).nextLine());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
