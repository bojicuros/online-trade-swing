package projekat;
import java.util.ArrayList;

public class ArtikalNarudzbe {

	private int narudzba_id;
	private int proizvod_id;
	private int kolicina;
	private double cijena_po_komadu;
	private int id;
	public static ArrayList<ArtikalNarudzbe> artikli;

	public ArtikalNarudzbe(int narudzba_id, int proizvod_id, int kolicina, double cijena_po_komadu, int id) {
		this.narudzba_id = narudzba_id;
		this.proizvod_id = proizvod_id;
		this.kolicina = kolicina;
		this.cijena_po_komadu = cijena_po_komadu;
		this.id = id;
	}

	public int getNarudzbaId() {
		return narudzba_id;
	}

	public int getProizvodId() {
		return proizvod_id;
	}

	public int getKolicina() {
		return kolicina;
	}

	public double getCijenaPoKomadu() {
		return cijena_po_komadu;
	}

	public int getId() {
		return id;
	}

	public String toString() {
		String res = "Artikal " + proizvod_id + " je narucen tokom narudzbe " + narudzba_id + "\n";
		res += "Kolicina artikla: " + kolicina + "\n";
		res += "Cijena po komadu: " + cijena_po_komadu + "\n";
		return res;
	}

	public static int generisiId() {
		return artikli.get(artikli.size() - 1).id + 1;
	}

	public static ArrayList<ArtikalNarudzbe> listaArtikala(Narudzba n) {
		ArrayList<ArtikalNarudzbe> l = new ArrayList<>();
		for (ArtikalNarudzbe a : artikli)
			if (a.getNarudzbaId() == n.getId())
				l.add(a);
		return l;
	}

	public static void dodajArtikleNarudzbe(Narudzba nova, ArrayList<Proizvod> proizvodi, ArrayList<Integer> kolicina) {
		if (kolicina.size() == proizvodi.size()) {
			for (int i = 0; i < proizvodi.size(); i++) {
				BazaPodataka.dodajArtikal(new ArtikalNarudzbe(nova.getId(), proizvodi.get(i).getId(), kolicina.get(i),
						proizvodi.get(i).getCijena(), generisiId()));
				BazaPodataka.pokreniBazu();
			}
		}
	}

}
