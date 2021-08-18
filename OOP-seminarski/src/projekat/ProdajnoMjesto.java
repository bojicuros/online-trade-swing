package projekat;
import java.util.ArrayList;

public class ProdajnoMjesto {

	private int id;
	private String grad;
	private String drzava;
	private String adresa;
	private String telefon;
	public static ArrayList<ProdajnoMjesto> mjesta;

	public ProdajnoMjesto(int id, String grad, String drzava, String adresa, String telefon) {
		this.id = id;
		this.grad = grad;
		this.drzava = drzava;
		this.adresa = "";
		if (adresa != null)
			this.adresa = adresa;
		this.telefon = "";
		if (telefon != null)
			this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public String getGrad() {
		return grad;
	}

	public String getDrzava() {
		return drzava;
	}

	public String getAdresa() {
		return adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public static int generisiId() {
		return mjesta.get(mjesta.size() - 1).id + 1;
	}

	public String toString() {
		String res = "Porodajno mjesto:\n";
		res += " Grad: " + grad + "\n";
		res += " Drzava: " + drzava + "\n";
		if (!adresa.equals(""))
			res += " Adresa: " + adresa + "\n";
		if (!telefon.equals(""))
			res += " Telefon: " + telefon + "\n";
		return res;
	}

	public static String[] idProdajnihMjesta() {
		String[] niz = new String[mjesta.size() + 1];
		niz[0] = null;
		for (int i = 0; i < mjesta.size(); i++)
			niz[i + 1] = mjesta.get(i).id + "";
		return niz;
	}

	public static ProdajnoMjesto prodajnoMjestoNarudzbe(Narudzba n) {
		for (Trgovac t : Trgovac.trgovci)
			if (n.getTrgovacId() == t.getId())
				for (ProdajnoMjesto p : mjesta)
					if (p.getId() == t.getProdajnoMjestoId())
						return p;
		return null;
	}

	public static ProdajnoMjesto prodajnoMjestoTrgovca(Trgovac t) {
		for (ProdajnoMjesto p : mjesta)
			if (p.getId() == t.getProdajnoMjestoId())
				return p;
		return null;
	}

	public static String[] prodajnaMjestaHint() {
		String[] niz = new String[mjesta.size() + 1];
		niz[0] = null;
		for (int i = 0; i < mjesta.size(); i++)
			niz[i + 1] = (mjesta.get(i).getAdresa().equals("") ? "" : mjesta.get(i).getAdresa() + ", ")
					+ mjesta.get(i).grad + ", " + mjesta.get(i).drzava;
		return niz;
	}

}
