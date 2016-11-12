package personaje;

import casta.Casta;
import casta.Explorador;
import casta.Guerrero;
import casta.Mago;

public class CrearPersonajes {
		private Casta casta1;
		private Personaje personaje = null;
		
		public Personaje crearPersonajes(String casta, String tipoPers){
			if (casta.equals("Guerrero")){
				casta1 =new Guerrero ();
			}else if (casta.equals("Explorador")){
				casta1 =new Explorador ();
			}else {
				casta1 =new Mago ();
			}
			if(tipoPers.equals("Humano")){
				personaje= new Humano (casta1);
			}else if (tipoPers.equals("Orco")){
				personaje= new Orco (casta1);
			}else{
				personaje= new Elfo (casta1);
			}
		return personaje;
		}

		
}
