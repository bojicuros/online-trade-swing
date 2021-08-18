package projekat;

public abstract class Korisnik {

	protected int id;
	protected String korisnickoIme;
	protected String ime;
	protected String prezime;
	protected String lozinka;
	protected String pol;
	protected String telefon;
	protected String email;

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public String getPol() {
		return pol;
	}

	public String getTelefon() {
		return telefon;
	}

	public String getEmail() {
		return email;
	}

	protected int getId() {
		return id;
	}

	public abstract String toString();

}