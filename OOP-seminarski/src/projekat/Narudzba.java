package projekat;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;

public class Narudzba {

	private int id;
	private int kupac_id;
	private int trgovac_id;
	private String datum_narudzbe;
	private String datum_isporuke;
	private String napomena_tekst;
	public static ArrayList<Narudzba> narudzbe;
	public static ArrayList<AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>>> naruceno;

	public Narudzba(int id, int korisnik_id, int trgovac_id, String datum_narudzbe, String datum_isporuke,
			String napomena_tekst) {
		this.id = id;
		this.kupac_id = korisnik_id;
		this.trgovac_id = trgovac_id;
		this.datum_narudzbe = datum_narudzbe;
		this.datum_isporuke = "";
		if (datum_isporuke != null)
			this.datum_isporuke = datum_isporuke;
		this.napomena_tekst = "";
		if (napomena_tekst != null)
			this.napomena_tekst = napomena_tekst;
	}

	public int getId() {
		return id;
	}

	public int getKupacId() {
		return kupac_id;
	}

	public int getTrgovacId() {
		return trgovac_id;
	}

	public void setTrgovacId(int id) {
		this.trgovac_id = id;
	}

	public String getDatumNarudzbe() {
		return datum_narudzbe;
	}

	public String getDatumIsporuke() {
		return datum_isporuke;
	}

	public void setDatumIsporuke(String datum) {
		datum_isporuke = datum;
	}

	public String getNapomena() {
		return napomena_tekst;
	}

	public void setNapomena(String napomena) {
		napomena_tekst = napomena;
	}

	public String toString() {
		String res = "Korisnik " + kupac_id + " izvrsio je narudzbu datuma:" + datum_narudzbe + "\n";
		res += "Trgovac zaduzen za kupovinu je: " + trgovac_id + "\n";
		if (!datum_isporuke.equals(""))
			res += "Datum isporuke: " + datum_isporuke + "\n";
		if (!napomena_tekst.equals(""))
			res += "Napomena: " + napomena_tekst + "\n";
		return res;
	}

	public static int generisiId() {
		if (naruceno.isEmpty())
			return narudzbe.get(narudzbe.size() - 1).id + 1;
		else {
			if (narudzbe.isEmpty())
				return naruceno.get(naruceno.size() - 1).getKey().getId() + 1;
			else
				return naruceno.get(naruceno.size() - 1).getKey().getId() > narudzbe.get(narudzbe.size() - 1).id
						? (naruceno.get(naruceno.size() - 1).getKey().getId() + 1)
						: (narudzbe.get(narudzbe.size() - 1).id + 1);
		}
	}

	public static ArrayList<Narudzba> obavljenjeNarudzbe() {
		ArrayList<Narudzba> lista = new ArrayList<>();
		for (Narudzba n : narudzbe)
			if (n.getKupacId() == GUI.privaljenKupac.getId())
				lista.add(n);
		return lista;
	}

	public static ArrayList<Narudzba> neispruceneNarudzbe() {
		ArrayList<Narudzba> lista = new ArrayList<>();
		for (Narudzba n : narudzbe)
			if (n.getKupacId() == GUI.privaljenKupac.getId() && n.datum_isporuke.equals(""))
				lista.add(n);
		return lista;
	}

	public static double cijenaNarudzbi(ArrayList<Narudzba> listaNarudzbi) {
		double suma = 0;
		for (Narudzba n : listaNarudzbi)
			suma += cijenaNarudzbe(n);
		return suma;
	}

	public static double cijenaNarudzbe(Narudzba n) {
		double suma = 0;
		for (ArtikalNarudzbe a : ArtikalNarudzbe.artikli)
			if (a.getNarudzbaId() == n.getId())
				suma += a.getCijenaPoKomadu() * a.getKolicina();
		return suma;
	}

	public static ArrayList<Narudzba> sveNarudzbeTrgovca(Trgovac t) {
		ArrayList<Narudzba> lista = new ArrayList<>();
		for (Narudzba n : narudzbe)
			if (n.getTrgovacId() == t.getId())
				lista.add(n);
		return lista;
	}

	public static double cijenaNarudzbeProizvoda(ArrayList<Proizvod> lista) {
		double cijena = 0;
		for (Proizvod p : lista)
			cijena += p.getCijena();
		return cijena;
	}

	public static ArrayList<Narudzba> obavjestenja(Trgovac t) {
		ArrayList<Narudzba> lista = new ArrayList<>();
		boolean izIsteDrzave = false;
		for (AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>> par : naruceno)
			if (ProdajnoMjesto.prodajnoMjestoTrgovca(t).getDrzava().equals(Kupac.porucilac(par.getKey()).getDrzava())) {
				lista.add(par.getKey());
			}
		for (AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>> par : naruceno)
			for (Trgovac trg : Trgovac.trgovci)
				if (ProdajnoMjesto.prodajnoMjestoTrgovca(trg).getDrzava()
						.equals(Kupac.porucilac(par.getKey()).getDrzava()))
					izIsteDrzave = true;
		if (!izIsteDrzave)
			for (AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>> par : naruceno)
				lista.add(par.getKey());
		return lista;

	}

	public static int indexNarudzbe(Narudzba izabranaNarudzba) {
		for (int i = 0; i < naruceno.size(); i++)
			if (naruceno.get(i).getKey().getId() == izabranaNarudzba.id)
				return i;
		return -1;
	}

	public static double cijenaNarudzbe(int index) {
		ArrayList<Proizvod> proizvodi = naruceno.get(index).getValue();
		double cijena = 0;
		for (Proizvod p : proizvodi) {
			cijena += p.getCijena();
		}
		return cijena;
	}

	public static void citajZapamceneNarudzbe() {
		naruceno = new ArrayList<>();
		Narudzba n = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader("naruceno.txt"));
			int brojac = -1;
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				if (line.charAt(0) != '-') {
					String split[] = line.split(",");
					int id = Integer.parseInt(split[0]);
					int korisnik_id = Integer.parseInt(split[1]);
					int trgovac_id = Integer.parseInt(split[2]);
					String datum_narudzbe = split[3];
					String datum_isporuke = split[4];
					if (datum_isporuke.equals("null"))
						datum_isporuke = null;
					String napomena = split[5];
					if (napomena.equals("null"))
						napomena = null;
					n = new Narudzba(id, korisnik_id, trgovac_id, datum_narudzbe, datum_isporuke, napomena);
					AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>> par = new SimpleEntry<>(n,
							new ArrayList<Proizvod>());
					naruceno.add(par);
					brojac++;
				} else {
					String split[] = line.substring(1, line.length()).split(",");
					int id = Integer.parseInt(split[0]);
					String naziv = split[1];
					String opis = split[2];
					if (opis.equals("null"))
						opis = null;
					double cijena = Double.parseDouble(split[3]);
					naruceno.get(brojac).getValue().add(new Proizvod(id, naziv, opis, cijena));
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static void pamtiNaruceno() {
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter("naruceno.txt"));
			for (AbstractMap.SimpleEntry<Narudzba, ArrayList<Proizvod>> par : naruceno) {
				String narudzba = "" + par.getKey().id + "," + par.getKey().kupac_id + "," + par.getKey().trgovac_id
						+ "," + par.getKey().datum_narudzbe + ","
						+ (par.getKey().datum_isporuke.equals("") ? "null" : par.getKey().datum_isporuke) + ","
						+ (par.getKey().napomena_tekst.equals("") ? "null" : par.getKey().napomena_tekst) + "\n";
				br.write(narudzba);
				for (Proizvod p : par.getValue()) {
					String proizvod = "-" + p.getId() + "," + p.getNaziv() + ","
							+ (p.getOpis().equals("") ? "null" : p.getOpis()) + "," + p.getCijena() + "\n";
					br.write(proizvod);
				}
			}
			br.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static ArrayList<Integer> kolicina(ArrayList<Proizvod> proizvodiNarudzbe, ArrayList<Proizvod> proizvodi) {
		ArrayList<Integer> kolicina = new ArrayList<>();
		for (Proizvod p : proizvodi) {
			int brojac = 0;
			for (Proizvod k : proizvodiNarudzbe) {
				if (p.getId() == k.getId())
					brojac++;
			}
			kolicina.add(brojac);
		}
		return kolicina;
	}

	public static ArrayList<Proizvod> naruceniProizvodi(ArrayList<Proizvod> proizvodiNarudzbe) {
		@SuppressWarnings("unchecked")
		ArrayList<Proizvod> proizvodi = (ArrayList<Proizvod>) proizvodiNarudzbe.clone();
		for (int i = proizvodi.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (proizvodi.get(i).getId() == proizvodi.get(j).getId()) {
					proizvodi.remove(i);
					break;
				}
			}
		}
		return proizvodi;
	}
}