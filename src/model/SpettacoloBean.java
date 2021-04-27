package model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SpettacoloBean {
	private int idSpettacolo;
	private int idFilm;
	private int idSala;
	private Timestamp timeStamp;

	public SpettacoloBean() {
		idSpettacolo = 0;
		idFilm = 0;
		idSala = 0;
		timeStamp = null;
	}

	public int getIdSpettacolo() {
		return idSpettacolo;
	}

	public void setIdSpettacolo(int idSpettacolo) {
		this.idSpettacolo = idSpettacolo;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public int getIdSala() {
		return idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public Date getDataOra() {
		return new Date(timeStamp.getTime());
	}

	public void setDataOra(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getData() {
		Date date = new Date(this.getTimeStamp().getTime());
		SimpleDateFormat df = new SimpleDateFormat("dd MMMM yyyy");
		return df.format(date);
	}

	public String getOra() {
		Date date = new Date(this.getTimeStamp().getTime().);
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		return df.format(date);
	}
}
