
package model;

public class FilmBean {
	private int idFilm;
	private int idGenere;
	private String titolo; // max size: 100
	private int durata; // durata in minuti
	private String urlTrailer; // max size: 255
	private String uriLocandina; // max size: 255
	private String trama; // max size 1000
	private boolean isInSlider;
	private int anno;
	private String regista;
	private String fotoslide;

	public FilmBean() {
		idFilm = 0;
		idGenere = 0;
		titolo = null;
		durata = 0;
		urlTrailer = null;
		uriLocandina = null;
		trama = null;
		isInSlider = false;
		anno = 0;
		regista = null;
		fotoslide = null;
	}

	public int getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(int idFilm) {
		this.idFilm = idFilm;
	}

	public int getIdGenere() {
		return idGenere;
	}

	public String getGenere() {
		String gen = null;
		if (idGenere == 1)
			gen = "Comico";
		if (idGenere == 2)
			gen = "Azione";
		if (idGenere == 3)
			gen = "Commedia";
		if (idGenere == 4)
			gen = "Drammatico";
		if (idGenere == 5)
			gen = "Thriller";
		if (idGenere == 6)
			gen = "Catastrofico";
		if (idGenere == 7)
			gen = "Fantascienza";
		if (idGenere == 8)
			gen = "Animazione";
		return gen;
	}

	public void setGenere(String genere) {
		if (genere.equalsIgnoreCase("Comico"))
			idGenere = 1;
		if (genere.equalsIgnoreCase("Azione"))
			idGenere = 2;
		if (genere.equalsIgnoreCase("Commedia"))
			idGenere = 3;
		if (genere.equalsIgnoreCase("Drammatico"))
			idGenere = 4;
		if (genere.equalsIgnoreCase("Thriller"))
			idGenere = 5;
		if (genere.equalsIgnoreCase("Catastrofico"))
			idGenere = 6;
		if (genere.equalsIgnoreCase("Fantascienza"))
			idGenere = 7;
		if (genere.equalsIgnoreCase("Animazione"))
			idGenere = 8;
	}

	public void setIdGenere(int idGenere) {
		this.idGenere = idGenere;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public String getUrlTrailer() {
		return urlTrailer;
	}

	public void setUrlTrailer(String urlTrailer) {
		// watch?v= -> embed/
		this.urlTrailer = urlTrailer.replace("watch?v=", "embed/");
	}

	public String getUriLocandina() {
		return uriLocandina;
	}

	public void setUriLocandina(String uriLocandina) {
		this.uriLocandina = uriLocandina;
	}

	public String getFotoSlide() {
		return fotoslide;
	}

	public void setFotoSlide(String fotoslide) {
		this.fotoslide = fotoslide;
	}

	public String getTrama() {
		return trama;
	}

	public String getMetaTrama() {
		int n = trama.length();
		String tr = trama.substring(0, n / 6);
		return tr;
	}

	public void setTrama(String trama) {
		this.trama = trama;
	}

	public boolean isInSlider() {
		return isInSlider;
	}

	public void setisInSlider(boolean isInSlider) {
		this.isInSlider = isInSlider;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}
}
