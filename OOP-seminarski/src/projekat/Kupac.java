package projekat;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Kupac extends Korisnik {

	private String adresa;
	private String grad;
	private String drzava;
	private String postanskiBroj;
	public static ArrayList<Kupac> kupci;

	public Kupac(int id, String korisnicko_ime, String ime, String prezime, String lozinka, String telefon,
			String adresa, String grad, String drzava, String postanski_broj, String pol, String email) {
		this.id = id;
		this.korisnickoIme = korisnicko_ime;
		this.ime = ime;
		this.prezime = prezime;
		this.lozinka = lozinka;
		this.telefon = "";
		if (telefon != null)
			this.telefon = telefon;
		this.adresa = "";
		if (adresa != null)
			this.adresa = adresa;
		this.grad = grad;
		this.drzava = "";
		if (drzava != null)
			this.drzava = drzava;
		this.postanskiBroj = "";
		if (postanski_broj != null)
			this.postanskiBroj = postanski_broj;
		this.pol = "";
		if (pol != null)
			this.pol = pol;
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getPostanskiBroj() {
		return postanskiBroj;
	}

	public void setPostanskiBroj(String postanskiBroj) {
		this.postanskiBroj = postanskiBroj;
	}

	public String toString() {
		String res = "Kupac:\n";
		res += " Ime i prezime: " + ime + " " + prezime + "\n";
		res += " Jedinstveno korisnicko ime: " + korisnickoIme + "\n";
		res += " Identifikacioni kod: " + id + "\n";
		if (!telefon.equals(""))
			res += " Broj telefona: " + telefon + "\n";
		if (!adresa.equals(""))
			res += " Adresa :" + adresa + "\n";
		res += " Grad: " + grad + "\n";
		if (!drzava.equals(""))
			res += " Drzava: " + drzava + "\n";
		if (!postanskiBroj.equals(""))
			res += " Postanski broj:" + postanskiBroj + "\n";
		if (!pol.equals(""))
			res += " Pol: " + (pol.equals("M") ? "Muski" : "Zenski") + "\n";
		res += " Email: " + email + "\n";
		return res;
	}

	public static int generisiId() {
		return (int) ((kupci.get(kupci.size() - 1).id) + (Math.random() * 10));
	}

	private static String kreirajMejl(String korisnicko_ime) {
		return korisnicko_ime + "@webshop-yu.org";
	}

	public static Kupac kreirajKupca(String korisnicko_ime, String ime, String prezime, String lozinka, String telefon,
			String adresa, String grad, String drzava, String postanski_broj, String pol) {
		if (telefon.equals(""))
			telefon = null;
		if (adresa.equals(""))
			adresa = null;
		if (drzava.equals(""))
			drzava = null;
		if (postanski_broj.equals(""))
			postanski_broj = null;
		if (pol.equals("null"))
			pol = null;
		return new Kupac(generisiId(), korisnicko_ime, ime, prezime, lozinka, telefon, adresa, grad, drzava,
				postanski_broj, pol, kreirajMejl(korisnicko_ime));
	}

	public static boolean postojiKupac(String korisnicko_ime) {
		for (Kupac k : kupci)
			if (k.getKorisnickoIme().equals(korisnicko_ime))
				return true;
		return false;
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

	public static boolean vertifikacijaKupca(String korisnicko_ime, String lozinka) {
		for (Kupac k : kupci)
			if (k.getKorisnickoIme().equals(korisnicko_ime) && k.getLozinka().equals(getMd5(lozinka))) {
				GUI.privaljenKupac = k;
				return true;
			}
		return false;
	}

	public static Kupac porucilac(Narudzba n) {
		for (Kupac k : kupci)
			if (k.getId() == n.getKupacId())
				return k;
		return null;
	}

}