package projekat;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Trgovac extends Korisnik {

	private int prodajnoMjestoId;
	public static ArrayList<Trgovac> trgovci;

	public Trgovac(int id, String korisnicko_ime, String ime, String prezime, String lozinka, String pol,
			String telefon, String email, int prodajno_mjesto_id) {
		this.id = id;
		this.korisnickoIme = korisnicko_ime;
		this.ime = ime;
		this.prezime = prezime;
		this.lozinka = lozinka;
		this.pol = "";
		if (pol != null)
			this.pol = pol;
		this.telefon = "";
		if (telefon != null)
			this.telefon = telefon;
		this.email = email;
		this.prodajnoMjestoId = prodajno_mjesto_id;
	}

	public int getProdajnoMjestoId() {
		return prodajnoMjestoId;
	}

	public void setProdajnoMjestoId(int prodajno_mjesto_id) {
		this.prodajnoMjestoId = prodajno_mjesto_id;
	}

	public String toString() {
		String res = "Trgovac:\n";
		res += " Ime i prezime: " + ime + " " + prezime + "\n";
		res += " Jedinstveno korisnicko ime: " + korisnickoIme + "\n";
		res += " Identifikacioni kod: " + id + "\n";
		if (!pol.equals(""))
			res += " Pol: " + (pol.equals("M") ? "Muski" : "Zenski") + "\n";
		if (!telefon.equals(""))
			res += " Broj telefona: " + telefon + "\n";
		res += " Email: " + email + "\n";
		return res;
	}

	public static int generisiId() {
		return trgovci.get(trgovci.size() - 1).id + 1;
	}

	public static String getMd5(String input) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(input.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public static boolean vertifikacijaTrgovca(String korisnicko_ime, String lozinka) {
		for (Trgovac t : trgovci)
			if (t.getKorisnickoIme().equals(korisnicko_ime) && t.getLozinka().equals(getMd5(lozinka))) {
				GUI.prijavljenTrgovac = t;
				return true;
			}
		return false;
	}

	public static boolean vecPostojiTrgovac(String korisnicko_ime) {
		for (Trgovac t : trgovci)
			if (t.korisnickoIme.equals(korisnicko_ime))
				return true;
		return false;
	}
}