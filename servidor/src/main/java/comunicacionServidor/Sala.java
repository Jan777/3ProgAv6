package comunicacionServidor;


import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Sala {
	List <Socket> sala = new LinkedList<Socket> ();
	
	public void agregar(Socket socket){
		sala.add(socket);
	}
}

