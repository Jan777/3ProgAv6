package comunicacionServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.text.html.HTMLDocument.Iterator;

public class AtencionAlCliente extends Thread {
	private Socket clienteSocket;
	private Sala sala;
	private DataOutputStream salida;
	private DataInputStream entrada;

	public AtencionAlCliente(Socket socket, Sala sala) {
		this.clienteSocket = socket;
		this.sala = sala;
	}

	public void run() {
		try {
			while (true) {
				entrada = new DataInputStream(this.clienteSocket.getInputStream());
				String msj = entrada.readUTF();
				java.util.Iterator<Socket> it = sala.sala.iterator();
				while (it.hasNext()) {
					salida = new DataOutputStream(it.next().getOutputStream());
					salida.writeUTF(msj);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
