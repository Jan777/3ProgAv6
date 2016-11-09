package comunicacionCliente;

import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MensajeJSON {
	

	public static void main(String[] args) throws JSONException {

		JSONObject obj = new JSONObject();
		obj.put("name", "mkyong.com");
		obj.put("age", new Integer(100));

		
			

		System.out.print(obj);

	     }

}



