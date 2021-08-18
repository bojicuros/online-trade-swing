package projekat;
import java.util.ArrayList;

public class Proizvod {

	private int id;
	private String naziv;
	private String opis;
	private double cijena;
	public static ArrayList<Proizvod> proizvodi;

	public Proizvod(int id, String naziv, String opis, double cijena) {
		this.id = id;
		this.naziv = naziv;
		this.opis = "";
		if (opis != null)
			this.opis = opis;
		this.cijena = cijena;
	}

	public int getId() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public String getOpis() {
		return opis;
	}

	public double getCijena() {
		return cijena;
	}

	public String toString() {
		String res = "Proizvod " + naziv + " kosta " + cijena + "\n";
		if (!opis.equals(""))
			res += "Opis: " + opis + "\n";
		return res;
	}

	public static Proizvod proizvodNarudzbe(ArtikalNarudzbe a) {
		for (Proizvod p : proizvodi)
			if (a.getProizvodId() == p.getId())
				return p;
		return null;
	}

	public static int generisiId() {
		return proizvodi.get(proizvodi.size() - 1).id + 1;
	}

}