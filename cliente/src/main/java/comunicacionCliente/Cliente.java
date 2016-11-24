package comunicacionCliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class Cliente {

	public Cliente(JSONObject obj) {
		this.correr(obj);
	}

	public Cliente correr(JSONObject obj) {

		Socket socket = new Socket();
		try {
			socket = new Socket("localHost", 10005);
			new ClienteLectura(socket).start();
			new ClienteEscritura(socket, obj).start();
			return this;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hubo un error al iniciar la aplicación. Revise la conexión con el servidor.");
			System.exit(0);
			return this;
		}

	}

}
