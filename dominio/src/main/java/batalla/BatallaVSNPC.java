package batalla;

import personaje.Atacable;
import personaje.NPC;
import personaje.Personaje;

public class BatallaVSNPC {

	public void ataqueNPC(Personaje p ,NPC npc ) {
		while (npc.getSalud() > 0){
			p.atacar(npc);
		}
		npc.morir();
	}

}
