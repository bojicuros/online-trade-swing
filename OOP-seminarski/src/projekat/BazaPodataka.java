package projekat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BazaPodataka {

	public static Connection konekcija;
	private static Statement izjava;
	public static String bazaInformacije = "jdbc:mysql://localhost:3306/seminarski_ors1"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public static void pokreniBazu() {
		Kupac.kupci = new ArrayList<>();
		ArtikalNarudzbe.artikli = new ArrayList<>();
		Narudzba.narudzbe = new ArrayList<>();
		ProdajnoMjesto.mjesta = new ArrayList<>();
		Proizvod.proizvodi = new ArrayList<>();
		Trgovac.trgovci = new ArrayList<>();
		try {
			konekcija = DriverManager.getConnection(bazaInformacije, "root", "admin");
			izjava = konekcija.createStatement();
			ResultSet pokupi = izjava.executeQuery("select * from kupac");
			while (pokupi.next())
				Kupac.kupci.add(new Kupac(pokupi.getInt("id"), pokupi.getString("korisnicko_ime"),
						pokupi.getString("ime"), pokupi.getString("prezime"), pokupi.getString("lozinka"),
						pokupi.getString("telefon"), pokupi.getString("adresa"), pokupi.getString("grad"),
						pokupi.getString("drzava"), pokupi.getString("postanski_broj"), pokupi.getString("pol"),
						pokupi.getString("email")));
			pokupi = izjava.executeQuery("select * from artikal_narudzbe");
			while (pokupi.next())
				ArtikalNarudzbe.artikli
						.add(new ArtikalNarudzbe(pokupi.getInt("narudzba_id"), pokupi.getInt("proizvod_id"),
								pokupi.getInt("kolicina"), pokupi.getDouble("cijena_po_komadu"), pokupi.getInt("id")));
			pokupi = izjava.executeQuery("select * from narudzba");
			while (pokupi.next())
				Narudzba.narudzbe.add(new Narudzba(pokupi.getInt("id"), pokupi.getInt("kupac_id"),
						pokupi.getInt("trgovac_id"), pokupi.getString("datum_narudzbe"),
						pokupi.getString("datum_isporuke"), pokupi.getString("napomena")));
			pokupi = izjava.executeQuery("select * from prodajno_mjesto");
			while (pokupi.next())
				ProdajnoMjesto.mjesta.add(new ProdajnoMjesto(pokupi.getInt("id"), pokupi.getString("grad"),
						pokupi.getString("drzava"), pokupi.getString("adresa"), pokupi.getString("telefon")));
			pokupi = izjava.executeQuery("select * from proizvod");
			while (pokupi.next())
				Proizvod.proizvodi.add(new Proizvod(pokupi.getInt("id"), pokupi.getString("naziv"),
						pokupi.getString("opis"), pokupi.getDouble("cijena")));
			pokupi = izjava.executeQuery("select * from trgovac");
			while (pokupi.next())
				Trgovac.trgovci.add(new Trgovac(pokupi.getInt("id"), pokupi.getString("korisnicko_ime"),
						pokupi.getString("ime"), pokupi.getString("prezime"), pokupi.getString("lozinka"),
						pokupi.getString("pol"), pokupi.getString("telefon"), pokupi.getString("email"),
						pokupi.getInt("prodajno_mjesto_id")));
			izjava.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean dodajArtikal(ArtikalNarudzbe a) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "insert into artikal_narudzbe values('" + a.getNarudzbaId() + "', '" + a.getProizvodId()
					+ "', '" + a.getKolicina() + "', '" + a.getCijenaPoKomadu() + "','" + a.getId() + "')";
			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dodajKupca(Kupac b) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "insert into kupac values('" + b.getId() + "','" + b.getKorisnickoIme() + "','" + b.getIme()
					+ "','" + b.getPrezime() + "','" + b.getLozinka() + "','" + b.getTelefon() + "','" + b.getAdresa()
					+ "','" + b.getGrad() + "','" + b.getDrzava() + "','" + b.getPostanskiBroj() + "','" + b.getPol()
					+ "','" + b.getEmail() + "')";
			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dodajTrgovca(Trgovac t) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "insert into trgovac values('" + t.getId() + "','" + t.getKorisnickoIme() + "','" + t.getIme()
					+ "','" + t.getPrezime() + "','" + t.getLozinka() + "','" + t.getPol() + "','" + t.getTelefon()
					+ "','" + t.getEmail() + "','" + t.getProdajnoMjestoId() + "')";

			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dodajMjesto(ProdajnoMjesto p) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "insert into prodajno_mjesto values('" + p.getId() + "', '" + p.getGrad() + "', '"
					+ p.getDrzava() + "', '" + p.getAdresa() + "','" + p.getTelefon() + "')";

			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dodajProizvod(Proizvod p) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "insert into proizvod values('" + p.getId() + "', '" + p.getNaziv() + "', '" + p.getOpis()
					+ "', '" + p.getCijena() + "')";

			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean dodajNarudzbu(Narudzba n) {
		try {
			izjava = konekcija.createStatement();
			String sql = "insert into narudzba values(?,?,?,?,?,?) ";
			PreparedStatement pst = konekcija.prepareStatement(sql);

			pst.setString(1, "" + n.getId());
			pst.setString(2, "" + n.getKupacId());
			pst.setString(3, "" + n.getTrgovacId());
			pst.setString(4, n.getDatumNarudzbe());
			if (n.getDatumIsporuke().length() != 10)
				pst.setNull(5, java.sql.Types.TIMESTAMP);
			else
				pst.setString(5, n.getDatumIsporuke());
			if (n.getNapomena().equals(null))
				pst.setString(6, null);
			else
				pst.setString(6, n.getNapomena());

			int x = pst.executeUpdate();
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean brisiNarudzbu(Narudzba izabranaNarudzba) {
		try {
			izjava = konekcija.createStatement();
			String q1 = "delete from narudzba where id=" + izabranaNarudzba.getId() + "";
			int x = izjava.executeUpdate(q1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean azurirajProizvod(Proizvod p, String naziv, String cijena) {
		try {
			izjava = konekcija.createStatement();

			String query1 = "update proizvod set naziv='" + naziv + "' " + "where id=" + p.getId();
			String query2 = "update proizvod set cijena='" + cijena + "' " + "where id=" + p.getId();

			int x = izjava.executeUpdate(query1);
			int y = izjava.executeUpdate(query2);
			izjava.close();
			if (x > 0 && y > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean azurirajNarudzbu(Narudzba n, String datumIsporuke) {
		try {
			izjava = konekcija.createStatement();
			String query1 = "update narudzba set datum_isporuke='" + datumIsporuke + "' " + "where id=" + n.getId();

			int x = izjava.executeUpdate(query1);
			izjava.close();
			if (x > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}