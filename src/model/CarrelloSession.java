package model;

import java.util.ArrayList;
import java.util.List;

public class CarrelloSession {
	
////////////////////////////////////////////////////////
	public static class Prenotazione{
		ArrayList<Posto> posti;
		SpettacoloBean spettacolo;
		String titolofilm;
		SalaBean sala;
		
		public String getTitolofilm() {
			return titolofilm;
		}
		public void setTitolofilm(String titolofilm) {
			this.titolofilm = titolofilm;
		}
		public SpettacoloBean getSpettacolo() {
			return spettacolo;
		}
		public void setSpettacolo(SpettacoloBean spettacolo) {
			this.spettacolo = spettacolo;
		}
		
		public SalaBean getSala() {
			return sala;
		}
		public void setSala(SalaBean sala) {
			this.sala = sala;
		}
		

		public ArrayList<Posto> getPosti() {
			return posti;
		}
		public void setPosti(ArrayList<Posto> posti) {
			this.posti = posti;
		}
		
		public int getPrezzo() {
			int tot = 0;
			for(Posto p : posti)
				tot += p.getPrezzo();
			return tot;
		}
	}
//////////////////////////////////////////////////////////	
	
	public static class Posto{
		String idposto;
		int prezzo;
		int sala;
		
		public String getIdposto() {
			return idposto;
		}
		public void setIdposto(String idposto) {
			this.idposto = idposto;
		}
		public int getSala() {
			return sala;
		}
		public void setSala(int sala) {
			this.sala = sala;
		}
		public int getPrezzo() {
			return prezzo;
		}
		public void setPrezzo(int prezzo) {
			this.prezzo = prezzo;
		}
	}
///////////////////////////////////////////////////////
	
	private ArrayList<Prenotazione> prenotazioni;
	
	public CarrelloSession() {
		prenotazioni=new ArrayList<>();
	}


	public ArrayList<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void addPrenotazione(Prenotazione p) {
		
		prenotazioni.add(p);
	}
	public void rimuoviPrenotazioe(int p) {
		
		prenotazioni.remove(p);
	}

	public int getPrezzoTot() {
		int tot = 0;
		for(Prenotazione p : prenotazioni)
			tot += p.getPrezzo();
		return tot;
	}
}
