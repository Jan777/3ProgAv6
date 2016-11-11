package comunicacionCliente;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.json.JSONException;
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
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

}
