package comunicacionCliente;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	
	public Cliente(){
		this.correr();
	}
	public void correr() {
		try {
			Socket socket = new Socket("localHost", 10000);
			new ClienteLectura(socket).start();
			new ClienteEscritura(socket).start();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		new Cliente();
		
	}
}
