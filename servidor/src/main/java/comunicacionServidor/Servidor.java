package comunicacionServidor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Servidor {

	ServerSocket servidor = null;
	Socket socket = null;
	BufferedReader reader = null;
	PrintWriter writer = null;
	Map <Integer, Sala> salas = new HashMap<Integer,Sala>();
	

	public Servidor() {
		this.salas.put(1, new Sala());
		this.salas.put(2, new Sala());
		this.salas.put(3, new Sala());
		this.correr();
	}

public void correr(){

	try {
		servidor = new ServerSocket(10000);
		while(true){
			socket = servidor.accept();
			Sala sala = salas.get(1);
			sala.agregar(socket);
			new AtencionAlCliente(socket,sala).start();
							
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public static void main (String args[] ){

	new Servidor();
}
}
