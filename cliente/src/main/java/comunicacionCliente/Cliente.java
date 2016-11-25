package comunicacionCliente;

import java.net.Socket;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class Cliente {

	public Cliente(JSONObject obj) {
		this.correr(obj);
	}

	public Cliente correr(JSONObject obj) {

		Socket socket;
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
