package projekat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

@SuppressWarnings("serial")
public class GUI extends JFrame {

	private JFrame korisnik = new JFrame();
	private JFrame prijava, registracija, sveNarudzbe, narudzba, proizvodi, novoMjesto;
	private JButton izbor1, izbor2, prijavi, registruj;
	private int odabrano;
	private Color svijetloSiva = new Color(200, 200, 200);
	private Color tamnoSiva = new Color(50, 50, 50);
	private Color bojaKupca = new Color(210, 70, 20);
	private Color bojaTrgovca = new Color(30, 120, 150);
	public static Kupac privaljenKupac = null;
	public static Trgovac prijavljenTrgovac = null;

	public GUI() {
		setTitle("Izbor vrste korisnika");
		setSize(670, 500);
		setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setResizable(false);

		JPanel nosac1 = new JPanel();
		nosac1.setSize(654, 462);
		nosac1.setBackground(svijetloSiva);
		nosac1.setLocation(0, 0);
		nosac1.setLayout(null);
		add(nosac1);

		ImageIcon img1 = new ImageIcon("img\\buyer-icon.png");
		ImageIcon img2 = new ImageIcon("img\\trader-icon.png");
		ImageIcon img3 = new ImageIcon("img\\female-buyer-icon.png");
		ImageIcon img4 = new ImageIcon("img\\female-trader-icon.png");
		ImageIcon right = new ImageIcon("img\\slide-right.png");
		ImageIcon left = new ImageIcon("img\\slide-left.png");

		JLabel korisnik, trgovac, prijava;
		JPanel pozadina_prijave = new JPanel();
		korisnik = new JLabel(img1);
		korisnik.setSize(250, 250);
		korisnik.setLocation(50, 100);

		MouseListener kupacListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}
				
			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (korisnik.getIcon().equals(img1)) {
					korisnik.setIcon(img3);
					bojaKupca = new Color(220, 140, 0);
					izbor1.setBackground(bojaKupca);
				} else {
					korisnik.setIcon(img1);
					bojaKupca = new Color(210, 70, 20);
					izbor1.setBackground(bojaKupca);
				}

			}
		};
		JLabel slideR = new JLabel(right);
		slideR.setSize(30, 45);
		slideR.setLocation(280, 200);
		slideR.addMouseListener(kupacListener);
		nosac1.add(slideR);
		JLabel slideL = new JLabel(left);
		slideL.setSize(30, 45);
		slideL.setLocation(40, 200);
		slideL.addMouseListener(kupacListener);
		nosac1.add(slideL);

		trgovac = new JLabel(img2);
		trgovac.setSize(250, 250);
		trgovac.setLocation(350, 100);

		MouseListener trgovacListener = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (trgovac.getIcon().equals(img2)) {
					trgovac.setIcon(img4);
					bojaTrgovca = new Color(80, 60, 230);
					izbor2.setBackground(bojaTrgovca);
				} else {
					trgovac.setIcon(img2);
					bojaTrgovca = new Color(30, 120, 150);
					izbor2.setBackground(bojaTrgovca);
				}

			}
		};
		JLabel sliderR = new JLabel(right);
		sliderR.setSize(30, 45);
		sliderR.setLocation(580, 200);
		sliderR.addMouseListener(trgovacListener);
		nosac1.add(sliderR);
		JLabel sliderL = new JLabel(left);
		sliderL.setSize(30, 45);
		sliderL.setLocation(340, 200);
		sliderL.addMouseListener(trgovacListener);
		nosac1.add(sliderL);

		prijava = new JLabel("Prijavite se kao:");
		prijava.setLocation(220, 15);
		prijava.setSize(400, 50);
		prijava.setForeground(Color.white);
		prijava.setFont(new Font("Ariel", Font.BOLD, 30));
		pozadina_prijave.setSize(684, 80);
		pozadina_prijave.setBackground(tamnoSiva);
		pozadina_prijave.setLocation(0, 0);
		nosac1.add(prijava);
		nosac1.add(korisnik);
		nosac1.add(trgovac);
		nosac1.add(pozadina_prijave);

		izbor1 = new JButton("Kupac");
		izbor1.setSize(150, 50);
		izbor1.setLocation(100, 370);
		izbor1.setBackground(bojaKupca);
		izbor1.setFont(new Font("Ariel", Font.BOLD, 20));
		izbor1.setForeground(Color.white);
		izbor1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				odabrano = 1;
				prijavi_se();

			}
		});
		nosac1.add(izbor1);
		izbor2 = new JButton("Trgovac");
		izbor2.setSize(150, 50);
		izbor2.setLocation(400, 370);
		izbor2.setBackground(bojaTrgovca);
		izbor2.setFont(new Font("Ariel", Font.BOLD, 20));
		izbor2.setForeground(Color.white);
		izbor2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				odabrano = 2;
				prijavi_se();

			}
		});
		nosac1.add(izbor2);
		repaint();
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(null, "Da li zelite da zatvorite aplikaciju?", "Zatvori aplikaciju?",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Narudzba.pamtiNaruceno();
					System.exit(0);
				}
			}
		});
	}

	private void prijavi_se() {
		if (isActive())
			dispose();
		prijava = new JFrame("Prijava");
		prijava.setSize(450, 350);
		prijava.setLayout(null);
		prijava.setVisible(true);
		prijava.setLocationRelativeTo(null);
		prijava.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		prijava.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(prijava, "Da li zelite da zatvorite aplikaciju?",
						"Zatvori aplikaciju?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Narudzba.pamtiNaruceno();
					System.exit(0);
				}
			}
		});
		prijava.setResizable(false);

		JPanel glava, tijelo;
		glava = new JPanel();
		glava.setLayout(null);
		glava.setBackground(tamnoSiva);
		glava.setLocation(0, 0);
		glava.setSize(434, 70);
		prijava.add(glava);
		tijelo = new JPanel();
		tijelo.setLayout(null);
		tijelo.setLocation(0, 70);
		tijelo.setBackground(svijetloSiva);
		tijelo.setSize(434, 311);
		prijava.add(tijelo);

		JLabel naziv = new JLabel("Prijavi se:");
		naziv.setFont(new Font("Ariel", Font.BOLD, 28));
		naziv.setForeground(Color.white);
		naziv.setLocation(10, 10);
		naziv.setSize(200, 40);
		glava.add(naziv);

		ImageIcon img1 = new ImageIcon("img\\back-arrow.png");
		JButton back = new JButton(img1);
		back.setSize(44, 36);
		back.setLocation(372, 15);
		back.setBackground(Color.gray);
		glava.add(back);
		back.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				prijava.dispose();
				odabrano = 0;
				new GUI();
			}
		});

		JLabel ime, lozinka;
		ime = new JLabel("Korisnicko ime:");
		ime.setLocation(15, 40);
		ime.setSize(160, 20);
		ime.setFont(new Font("Ariel", Font.BOLD, 18));
		ime.setForeground(Color.black);
		tijelo.add(ime);
		lozinka = new JLabel("Lozinka:");
		lozinka.setLocation(15, 90);
		lozinka.setSize(120, 20);
		lozinka.setFont(new Font("Ariel", Font.BOLD, 18));
		lozinka.setForeground(Color.black);
		tijelo.add(lozinka);
		lozinka = new JLabel("Lozinka");

		JTextField korisnicno_ime = new JTextField();
		korisnicno_ime.setSize(180, 25);
		korisnicno_ime.setLocation(180, 40);
		korisnicno_ime.setFont(new Font("Ariel", Font.BOLD, 14));
		korisnicno_ime.setHorizontalAlignment(JTextField.CENTER);
		korisnicno_ime.setForeground(Color.black);
		tijelo.add(korisnicno_ime);
		JPasswordField sifra = new JPasswordField();
		sifra.setSize(180, 25);
		sifra.setLocation(180, 90);
		sifra.setFont(new Font("Ariel", Font.BOLD, 14));
		sifra.setHorizontalAlignment(JTextField.CENTER);
		sifra.setForeground(Color.black);
		tijelo.add(sifra);

		prijavi = new JButton("Prijava");
		prijavi.setBackground(new Color(4, 147, 90));
		prijavi.setForeground(Color.white);
		prijavi.setSize(120, 50);
		prijavi.setLocation(230, 160);
		prijavi.setFont(new Font("Ariel", Font.BOLD, 18));
		prijavi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = korisnicno_ime.getText();
				String password = "";
				for (int i = 0; i < sifra.getPassword().length; i++)
					password += sifra.getPassword()[i];

				if (user_name.equals(""))
					JOptionPane.showMessageDialog(prijava, "Molimo Vas da unesete korisnicko ime", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
				else if (password.equals(""))
					JOptionPane.showMessageDialog(prijava, "Molimo Vas da unesete lozinku", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
				else {
					if (odabrano == 1) {
						if (Kupac.vertifikacijaKupca(user_name, password))
							prikaziKupca();
						else {
							JOptionPane.showMessageDialog(prijava, "Korisnicko ime ili lozinka nisu tacni",
									"Obavjestenje", JOptionPane.WARNING_MESSAGE);
							korisnicno_ime.setText("");
							sifra.setText("");
						}
					} else if (odabrano == 2) {
						if (Trgovac.vertifikacijaTrgovca(user_name, password))
							prikaziTrgovca();
						else {
							JOptionPane.showMessageDialog(prijava, "Korisnicko ime ili lozinka nisu tacni",
									"Obavjestenje", JOptionPane.WARNING_MESSAGE);
							korisnicno_ime.setText("");
							sifra.setText("");
						}
					}
				}

			}
		});
		tijelo.add(prijavi);

		if (odabrano == 1) {
			registruj = new JButton("Registruj se");
			registruj.setBackground(new Color(217, 30, 24));
			registruj.setForeground(Color.white);
			registruj.setSize(150, 50);
			registruj.setLocation(50, 160);
			registruj.setFont(new Font("Ariel", Font.BOLD, 18));
			registruj.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					registruj_se();
				}
			});
			prijavi.setLocation(250, 160);
			tijelo.add(registruj);
		}

		prijava.repaint();
	}

	private void registruj_se() {
		prijava.dispose();
		registracija = new JFrame("Registracija");
		registracija.setSize(450, 600);
		registracija.setLayout(null);
		registracija.setVisible(true);
		registracija.setResizable(false);
		registracija.setLocationRelativeTo(null);
		registracija.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		registracija.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				registracija.dispose();
				prijavi_se();
			}
		});

		JPanel glava, tijelo;
		glava = new JPanel();
		glava.setLayout(null);
		glava.setBackground(tamnoSiva);
		glava.setLocation(0, 0);
		glava.setSize(434, 70);
		registracija.add(glava);
		tijelo = new JPanel();
		tijelo.setLayout(null);
		tijelo.setLocation(0, 70);
		tijelo.setBackground(svijetloSiva);
		tijelo.setSize(434, 491);
		registracija.add(tijelo);

		ImageIcon img1 = new ImageIcon("img\\back-arrow.png");
		JButton back = new JButton(img1);
		back.setSize(44, 36);
		back.setLocation(372, 15);
		back.setBackground(Color.gray);
		glava.add(back);
		back.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				registracija.dispose();
				odabrano = 0;
				new GUI();
			}
		});

		JLabel naziv = new JLabel("Registruj se:");
		naziv.setFont(new Font("Ariel", Font.BOLD, 28));
		naziv.setForeground(Color.white);
		naziv.setLocation(10, 15);
		naziv.setSize(200, 40);
		glava.add(naziv);

		JLabel korisnicko_ime, ime, prezime, lozinka, telefon, adresa, grad, drzava, postanski_broj, pol;
		korisnicko_ime = new JLabel("Korisnicko ime*:");
		korisnicko_ime.setLocation(15, 20);
		korisnicko_ime.setSize(160, 20);
		korisnicko_ime.setFont(new Font("Ariel", Font.BOLD, 18));
		korisnicko_ime.setForeground(Color.black);
		tijelo.add(korisnicko_ime);
		ime = new JLabel("Ime*:");
		ime.setLocation(15, 60);
		ime.setSize(100, 20);
		ime.setFont(new Font("Ariel", Font.BOLD, 18));
		ime.setForeground(Color.black);
		tijelo.add(ime);
		prezime = new JLabel("Prezime*:");
		prezime.setLocation(15, 100);
		prezime.setSize(100, 20);
		prezime.setFont(new Font("Ariel", Font.BOLD, 18));
		prezime.setForeground(Color.black);
		tijelo.add(prezime);
		lozinka = new JLabel("Lozinka:*");
		lozinka.setLocation(15, 140);
		lozinka.setSize(100, 20);
		lozinka.setFont(new Font("Ariel", Font.BOLD, 18));
		lozinka.setForeground(Color.black);
		tijelo.add(lozinka);
		telefon = new JLabel("Telefon:");
		telefon.setLocation(15, 180);
		telefon.setSize(100, 20);
		telefon.setFont(new Font("Ariel", Font.BOLD, 18));
		telefon.setForeground(Color.black);
		tijelo.add(telefon);
		adresa = new JLabel("Adresa:");
		adresa.setLocation(15, 220);
		adresa.setSize(100, 20);
		adresa.setFont(new Font("Ariel", Font.BOLD, 18));
		adresa.setForeground(Color.black);
		tijelo.add(adresa);
		grad = new JLabel("Grad*:");
		grad.setLocation(15, 260);
		grad.setSize(100, 20);
		grad.setFont(new Font("Ariel", Font.BOLD, 18));
		grad.setForeground(Color.black);
		tijelo.add(grad);
		drzava = new JLabel("Drzava:");
		drzava.setLocation(15, 300);
		drzava.setSize(100, 20);
		drzava.setFont(new Font("Ariel", Font.BOLD, 18));
		drzava.setForeground(Color.black);
		tijelo.add(drzava);
		postanski_broj = new JLabel("Postanski broj:");
		postanski_broj.setLocation(15, 340);
		postanski_broj.setSize(180, 20);
		postanski_broj.setFont(new Font("Ariel", Font.BOLD, 18));
		postanski_broj.setForeground(Color.black);
		tijelo.add(postanski_broj);
		pol = new JLabel("Pol:");
		pol.setLocation(15, 380);
		pol.setSize(60, 20);
		pol.setFont(new Font("Ariel", Font.BOLD, 18));
		pol.setForeground(Color.black);
		tijelo.add(pol);
		JLabel oznaka = new JLabel("* obavezna polja");
		oznaka.setLocation(15, 430);
		oznaka.setSize(160, 20);
		oznaka.setFont(new Font("Ariel", Font.BOLD, 16));
		oznaka.setForeground(Color.black);
		tijelo.add(oznaka);

		JTextField korisnicko_ime_unos, ime_unos, prezime_unos, telefon_unos, adresa_unos, grad_unos, drzava_unos,
				postanski_broj_unos;
		korisnicko_ime_unos = new JTextField();
		korisnicko_ime_unos.setLocation(170, 20);
		korisnicko_ime_unos.setSize(180, 28);
		korisnicko_ime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		korisnicko_ime_unos.setForeground(Color.black);
		korisnicko_ime_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(korisnicko_ime_unos);
		ime_unos = new JTextField();
		ime_unos.setLocation(170, 60);
		ime_unos.setSize(180, 28);
		ime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		ime_unos.setForeground(Color.black);
		ime_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(ime_unos);
		prezime_unos = new JTextField();
		prezime_unos.setLocation(170, 100);
		prezime_unos.setSize(180, 28);
		prezime_unos.setHorizontalAlignment(JTextField.CENTER);
		prezime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		prezime_unos.setForeground(Color.black);
		tijelo.add(prezime_unos);
		JPasswordField sifra = new JPasswordField();
		sifra.setSize(180, 28);
		sifra.setLocation(170, 140);
		sifra.setFont(new Font("Ariel", Font.BOLD, 14));
		sifra.setHorizontalAlignment(JTextField.CENTER);
		sifra.setForeground(Color.black);
		tijelo.add(sifra);
		telefon_unos = new JTextField();
		telefon_unos.setLocation(170, 180);
		telefon_unos.setSize(180, 28);
		telefon_unos.setHorizontalAlignment(JTextField.CENTER);
		telefon_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		telefon_unos.setForeground(Color.black);
		tijelo.add(telefon_unos);
		adresa_unos = new JTextField();
		adresa_unos.setLocation(170, 220);
		adresa_unos.setSize(180, 28);
		adresa_unos.setHorizontalAlignment(JTextField.CENTER);
		adresa_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		adresa_unos.setForeground(Color.black);
		tijelo.add(adresa_unos);
		grad_unos = new JTextField();
		grad_unos.setLocation(170, 260);
		grad_unos.setSize(180, 28);
		grad_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		grad_unos.setForeground(Color.black);
		grad_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(grad_unos);
		drzava_unos = new JTextField();
		drzava_unos.setLocation(170, 300);
		drzava_unos.setSize(180, 28);
		drzava_unos.setHorizontalAlignment(JTextField.CENTER);
		drzava_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		drzava_unos.setForeground(Color.black);
		tijelo.add(drzava_unos);
		postanski_broj_unos = new JTextField();
		postanski_broj_unos.setLocation(170, 340);
		postanski_broj_unos.setSize(180, 28);
		postanski_broj_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		postanski_broj_unos.setForeground(Color.black);
		postanski_broj_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(postanski_broj_unos);
		String[] polovi = { null, "M", "Z" };
		JComboBox<String> pol_unos = new JComboBox<String>(polovi);
		pol_unos.setLocation(170, 380);
		pol_unos.setSize(60, 25);
		pol_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		pol_unos.setForeground(Color.black);
		tijelo.add(pol_unos);

		JButton potvrdi = new JButton("Registracija");
		potvrdi.setBackground(new Color(4, 147, 90));
		potvrdi.setForeground(Color.white);
		potvrdi.setSize(150, 50);
		potvrdi.setLocation(50, 160);
		potvrdi.setFont(new Font("Ariel", Font.BOLD, 18));
		potvrdi.setLocation(250, 410);
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = korisnicko_ime_unos.getText();
				String name = ime_unos.getText();
				String last_name = prezime_unos.getText();
				String password = "";
				for (int i = 0; i < sifra.getPassword().length; i++)
					password += sifra.getPassword()[i];
				String city = grad_unos.getText();

				if (user_name.equals("") || name.equals("") || last_name.equals("") || name.equals("")
						|| password.equals("") || city.equals(""))
					JOptionPane.showMessageDialog(registracija, "Molimo Vas da popunite obavezna polja", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
				else if (Kupac.postojiKupac(user_name))
					JOptionPane.showMessageDialog(registracija, "U sistemu vec postoji kupac sa tim korisnickim imenom",
							"Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
				else {
					if (BazaPodataka.dodajKupca(Kupac.kreirajKupca(korisnicko_ime_unos.getText(), ime_unos.getText(),
							prezime_unos.getText(), Kupac.getMd5(password), telefon_unos.getText(),
							adresa_unos.getText(), grad_unos.getText(), drzava_unos.getText(),
							postanski_broj_unos.getText(), pol_unos.getSelectedItem() + ""))) {
						JOptionPane.showMessageDialog(null, "Upravo ste postali kupac, cestitamo :)");
						registracija.dispose();
						BazaPodataka.pokreniBazu();
						prijavi_se();
					} else
						JOptionPane.showMessageDialog(registracija, "Greska pri konekciji sa bazom", "Greska",
								JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tijelo.add(potvrdi);
		registracija.repaint();

	}

	private void prikaziKupca() {
		if (prijava.isActive())
			prijava.dispose();
		korisnik = new JFrame("Prikaz kupca");
		korisnik.setSize(670, 500);
		korisnik.setLayout(null);
		korisnik.setVisible(true);
		korisnik.setLocationRelativeTo(null);
		korisnik.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		korisnik.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(korisnik, "Da li zelite da zatvorite aplikaciju?",
						"Zatvori aplikaciju?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Narudzba.pamtiNaruceno();
					System.exit(0);
				}
			}
		});
		korisnik.setResizable(false);

		JPanel pomocniPanel = new JPanel();
		pomocniPanel.setSize(654, 382);
		pomocniPanel.setBackground(svijetloSiva);
		pomocniPanel.setLocation(0, 80);
		pomocniPanel.setLayout(null);
		korisnik.add(pomocniPanel);

		JPanel pozadina_prijave = new JPanel();
		pozadina_prijave.setSize(654, 80);
		pozadina_prijave.setBackground(tamnoSiva);
		pozadina_prijave.setLocation(0, 0);
		pozadina_prijave.setLayout(null);
		korisnik.add(pozadina_prijave);
		JButton odjavi_se = new JButton("Odjavi se");
		odjavi_se.setBackground(new Color(160, 30, 40));
		odjavi_se.setForeground(Color.white);
		odjavi_se.setSize(100, 30);
		odjavi_se.setLocation(500, 25);
		odjavi_se.setFont(new Font("Ariel", Font.BOLD, 16));
		odjavi_se.setHorizontalAlignment(JTextField.CENTER);
		odjavi_se.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (odjavi_se == e.getSource()) {
					int result = JOptionPane.showConfirmDialog(korisnik, "Da li zelite da se odjavite?", "Potvrdite",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if (result == JOptionPane.YES_OPTION) {
						privaljenKupac = null;
						korisnik.dispose();
						new GUI();
					}
				}

			}
		});
		pozadina_prijave.add(odjavi_se);
		JLabel opis = new JLabel("Kupac:");
		opis.setLocation(15, 15);
		opis.setSize(400, 50);
		opis.setForeground(Color.white);
		opis.setFont(new Font("Ariel", Font.BOLD, 30));
		pozadina_prijave.add(opis);

		JLabel podaci = new JLabel("Podaci:");
		podaci.setLocation(10, 10);
		podaci.setSize(180, 20);
		podaci.setFont(new Font("Ariel", Font.BOLD, 22));
		podaci.setForeground(Color.black);
		pomocniPanel.add(podaci);
		JLabel ime = new JLabel("Ime: " + privaljenKupac.getIme());
		ime.setLocation(10, 45);
		ime.setSize(180, 22);
		ime.setFont(new Font("Ariel", Font.BOLD, 18));
		ime.setForeground(Color.black);
		pomocniPanel.add(ime);
		JLabel prezime = new JLabel("Prezime: " + privaljenKupac.getPrezime());
		prezime.setLocation(10, 75);
		prezime.setSize(180, 22);
		prezime.setFont(new Font("Ariel", Font.BOLD, 18));
		prezime.setForeground(Color.black);
		pomocniPanel.add(prezime);
		int yPosljednjeg = 75;
		if (!privaljenKupac.getAdresa().equals("")) {
			JLabel adresa = new JLabel("Adresa: " + privaljenKupac.getAdresa());
			adresa.setLocation(10, yPosljednjeg += 35);
			adresa.setSize(400, 22);
			adresa.setFont(new Font("Ariel", Font.BOLD, 18));
			adresa.setForeground(Color.black);
			pomocniPanel.add(adresa);
		}
		JLabel grad = new JLabel("Grad: " + privaljenKupac.getGrad());
		grad.setLocation(10, yPosljednjeg += 35);
		grad.setSize(180, 22);
		grad.setFont(new Font("Ariel", Font.BOLD, 18));
		grad.setForeground(Color.black);
		pomocniPanel.add(grad);
		if (!privaljenKupac.getDrzava().equals("")) {
			JLabel drzava = new JLabel("Drzava: " + privaljenKupac.getDrzava());
			drzava.setLocation(10, yPosljednjeg += 35);
			drzava.setSize(280, 22);
			drzava.setFont(new Font("Ariel", Font.BOLD, 18));
			drzava.setForeground(Color.black);
			pomocniPanel.add(drzava);
		}
		if (!privaljenKupac.getPostanskiBroj().equals("")) {
			JLabel postanskiBroj = new JLabel("Postanski broj: " + privaljenKupac.getPostanskiBroj());
			postanskiBroj.setLocation(10, yPosljednjeg += 35);
			postanskiBroj.setSize(290, 22);
			postanskiBroj.setFont(new Font("Ariel", Font.BOLD, 18));
			postanskiBroj.setForeground(Color.black);
			pomocniPanel.add(postanskiBroj);
		}
		if (!privaljenKupac.getTelefon().equals("")) {
			JLabel telefon = new JLabel("Broj telefona: " + privaljenKupac.getTelefon());
			telefon.setLocation(10, yPosljednjeg += 35);
			telefon.setSize(290, 22);
			telefon.setFont(new Font("Ariel", Font.BOLD, 18));
			telefon.setForeground(Color.black);
			pomocniPanel.add(telefon);
		}
		ArrayList<Narudzba> obavljene = Narudzba.obavljenjeNarudzbe();
		ArrayList<Narudzba> neisporucene = Narudzba.neispruceneNarudzbe();
		JLabel obavljeneNarudzbe = new JLabel("Broj obavljenih narudzbi: " + obavljene.size());
		obavljeneNarudzbe.setLocation(10, yPosljednjeg += 35);
		obavljeneNarudzbe.setSize(400, 20);
		obavljeneNarudzbe.setFont(new Font("Ariel", Font.BOLD, 18));
		obavljeneNarudzbe.setForeground(Color.black);
		pomocniPanel.add(obavljeneNarudzbe);
		JLabel neisporuceneNarudzbe = new JLabel("Broj narudzbi cija se isporuka ceka: " + neisporucene.size());
		neisporuceneNarudzbe.setLocation(10, yPosljednjeg += 35);
		neisporuceneNarudzbe.setSize(400, 20);
		neisporuceneNarudzbe.setFont(new Font("Ariel", Font.BOLD, 18));
		neisporuceneNarudzbe.setForeground(Color.black);
		pomocniPanel.add(neisporuceneNarudzbe);
		JLabel cijenaNeisporucenihNarudzbi = new JLabel("Vrijednost narudzbi cija se isporuka ceka: "
				+ Math.round(Narudzba.cijenaNarudzbi(neisporucene) * 100.0) / 100.0);
		cijenaNeisporucenihNarudzbi.setLocation(10, yPosljednjeg += 35);
		cijenaNeisporucenihNarudzbi.setSize(450, 20);
		cijenaNeisporucenihNarudzbi.setFont(new Font("Ariel", Font.BOLD, 18));
		cijenaNeisporucenihNarudzbi.setForeground(Color.black);
		pomocniPanel.add(cijenaNeisporucenihNarudzbi);

		JLabel opcije = new JLabel("Opcije:");
		opcije.setLocation(410, 10);
		opcije.setSize(180, 30);
		opcije.setFont(new Font("Ariel", Font.BOLD, 22));
		opcije.setForeground(Color.black);
		pomocniPanel.add(opcije);

		JButton narudzbe1 = new JButton("Spisak narudzbi");
		narudzbe1.setBackground(bojaKupca);
		narudzbe1.setForeground(Color.white);
		narudzbe1.setSize(200, 50);
		narudzbe1.setLocation(410, 50);
		narudzbe1.setFont(new Font("Ariel", Font.BOLD, 15));
		narudzbe1.setSelected(false);
		narudzbe1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (obavljene.size() > 0)
					prikaziNarudzbe(obavljene);
				else
					JOptionPane.showMessageDialog(korisnik, "Trenutno nemate narudzbi", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
		pomocniPanel.add(narudzbe1);
		JButton narudzbe2 = new JButton("Neisporucene narudzbe");
		narudzbe2.setBackground(bojaKupca);
		narudzbe2.setForeground(Color.white);
		narudzbe2.setSize(200, 50);
		narudzbe2.setLocation(410, 110);
		narudzbe2.setFont(new Font("Ariel", Font.BOLD, 15));
		narudzbe2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (neisporucene.size() > 0)
					prikaziNarudzbe(neisporucene);
				else
					JOptionPane.showMessageDialog(korisnik, "Nemate neisporucenih naruzbi", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);

			}
		});
		narudzbe2.setSelected(false);
		pomocniPanel.add(narudzbe2);
		JButton proizvodi = new JButton("Naruci proizvod");
		proizvodi.setBackground(bojaKupca);
		proizvodi.setForeground(Color.white);
		proizvodi.setSize(200, 50);
		proizvodi.setLocation(410, 170);
		proizvodi.setFont(new Font("Ariel", Font.BOLD, 15));
		proizvodi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == proizvodi)
					naruciProizvode();

			}
		});
		proizvodi.setSelected(false);
		pomocniPanel.add(proizvodi);
	}

	private void prikaziNarudzbe(ArrayList<Narudzba> listaNarudzbi) {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		sveNarudzbe = new JFrame("Narudzbe");
		sveNarudzbe.setSize(670, 560);
		sveNarudzbe.setLayout(null);
		sveNarudzbe.setVisible(true);
		sveNarudzbe.setLocationRelativeTo(null);
		sveNarudzbe.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		sveNarudzbe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				sveNarudzbe.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});
		int sirina = 670 - 8 - 8;
		int visina = 521;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(tamnoSiva);
		sveNarudzbe.add(oznake);
		JLabel[] kolone = new JLabel[4];
		for (int i = 0; i < 4; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 4, 30);
			kolone[i].setLocation((sirina / 4) * i, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Datum narudzbe");
		kolone[1].setText("Datum isporuke");
		kolone[2].setText("Vrijednost");
		kolone[3].setText("Izaberi");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, sirina, visina - 40);
		scrollPane.setBackground(svijetloSiva);
		sveNarudzbe.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(svijetloSiva);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setBackground(svijetloSiva);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		JButton[] izaberi = new JButton[listaNarudzbi.size()];
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		for (int i = 0; i < listaNarudzbi.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			red.setBackground(svijetloSiva);
			red.setBorder(lineBorder);
			kolona.add(red);
			red.setLayout(null);
			izaberi[i] = new JButton("Detalji");
			izaberi[i].setSize(sirina / 5, 30);
			izaberi[i].setLocation((3 * sirina) / 4 + 15, 10);
			izaberi[i].setFont(new Font("Ariel", Font.BOLD, 16));
			izaberi[i].setHorizontalAlignment(JTextField.CENTER);
			if (prijavljenTrgovac == null)
				izaberi[i].setBackground(bojaKupca);
			else
				izaberi[i].setBackground(bojaTrgovca);
			izaberi[i].setForeground(Color.white);
			izaberi[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < listaNarudzbi.size(); i++)
						if (izaberi[i] == e.getSource())
							prikaziDetaljeNarudzbe(listaNarudzbi.get(i));
				}
			});
			JLabel narudzba = new JLabel();
			narudzba.setText(listaNarudzbi.get(i).getDatumNarudzbe());
			narudzba.setSize(sirina / 4, 30);
			narudzba.setLocation(0, 10);
			narudzba.setFont(new Font("Ariel", Font.BOLD, 20));
			narudzba.setHorizontalAlignment(JTextField.CENTER);
			narudzba.setForeground(Color.black);
			red.add(narudzba);
			JLabel isporuka = new JLabel();
			isporuka.setText(listaNarudzbi.get(i).getDatumIsporuke());
			isporuka.setSize(sirina / 4, 30);
			isporuka.setLocation(sirina / 4, 10);
			isporuka.setFont(new Font("Ariel", Font.BOLD, 20));
			isporuka.setHorizontalAlignment(JTextField.CENTER);
			isporuka.setForeground(Color.black);
			red.add(isporuka);
			JLabel cijena = new JLabel();
			cijena.setText("" + Math.round(Narudzba.cijenaNarudzbe(listaNarudzbi.get(i)) * 100.0) / 100.0);
			cijena.setSize(sirina / 4, 30);
			cijena.setLocation(sirina / 2, 10);
			cijena.setFont(new Font("Ariel", Font.BOLD, 20));
			cijena.setHorizontalAlignment(JTextField.CENTER);
			cijena.setForeground(Color.black);
			red.add(cijena);
			red.add(izaberi[i]);
		}

	}

	private void prikaziDetaljeNarudzbe(Narudzba izabranaNarudzba) {
		narudzba = new JFrame("Detalji narudzbe");
		narudzba.setSize(670, 560);
		narudzba.setLayout(null);
		narudzba.setVisible(true);
		narudzba.setLocationRelativeTo(null);
		narudzba.setResizable(false);

		int sirina = 670 - 8 - 8;
		int visina = 521;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(Color.darkGray);
		narudzba.add(oznake);
		JLabel[] kolone = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 4, 30);
			kolone[i].setLocation((sirina / 3) * i + 15, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Naruceni artikli");
		kolone[1].setText("Iznos");
		kolone[2].setText("Prodajno mjesto");

		JPanel pozadina = new JPanel();
		pozadina.setBounds(0, 40, sirina, visina - 40);
		pozadina.setBackground(Color.gray);
		pozadina.setLayout(null);
		narudzba.add(pozadina);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, 0, sirina - 240, visina - 37);
		pozadina.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(Color.gray);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		kolona.setBackground(Color.gray);
		ArrayList<ArtikalNarudzbe> spisakArtikala = ArtikalNarudzbe.listaArtikala(izabranaNarudzba);
		Border lineBorder = BorderFactory.createLineBorder(Color.white);
		for (int i = 0; i < spisakArtikala.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			kolona.add(red);
			red.setLayout(null);
			red.setBorder(lineBorder);
			red.setBackground(Color.gray);
			JLabel naziv = new JLabel();
			naziv.setText(Proizvod.proizvodNarudzbe(spisakArtikala.get(i)).getNaziv());
			naziv.setSize(sirina / 3 + 20, 30);
			naziv.setLocation(15, 10);
			naziv.setFont(new Font("Ariel", Font.BOLD, 20));
			naziv.setHorizontalAlignment(JTextField.LEFT);
			naziv.setForeground(Color.black);
			red.add(naziv);
			JLabel vrijednost = new JLabel();
			vrijednost.setText(
					(spisakArtikala.get(i).getKolicina() > 1 ? spisakArtikala.get(i).getKolicina() + " x " : "") + ""
							+ Math.round(spisakArtikala.get(i).getCijenaPoKomadu() * 100.0) / 100.0);
			vrijednost.setSize(sirina / 3, 30);
			vrijednost.setLocation(sirina / 3-10, 10);
			vrijednost.setFont(new Font("Ariel", Font.BOLD, 20));
			vrijednost.setHorizontalAlignment(JTextField.CENTER);
			vrijednost.setForeground(Color.black);
			red.add(vrijednost);
		}
		narudzba.setSize(669, 560);
		narudzba.setSize(670, 560);
		JLabel[] adresa = new JLabel[3];
		for (int i = 0; i < adresa.length; i++) {
			adresa[i] = new JLabel();
			adresa[i].setSize(sirina / 3, 30);
			adresa[i].setLocation((2 * sirina) / 3 - 20, i * 40 + 10);
			adresa[i].setFont(new Font("Ariel", Font.BOLD, 20));
			adresa[i].setHorizontalAlignment(JTextField.CENTER);
			adresa[i].setForeground(Color.black);
			pozadina.add(adresa[i]);
		}
		ProdajnoMjesto mjesto = ProdajnoMjesto.prodajnoMjestoNarudzbe(izabranaNarudzba);
		adresa[0].setText(mjesto.getGrad());
		adresa[1].setText(mjesto.getDrzava());
		adresa[2].setText(mjesto.getAdresa());

		if (odabrano == 2 && izabranaNarudzba.getTrgovacId() != -1) {
			System.out.println(odabrano);
			JButton azuriraj = new JButton("Novi datum isporuke");
			azuriraj.setBackground(bojaTrgovca);
			azuriraj.setForeground(Color.white);
			azuriraj.setSize(200, 50);
			azuriraj.setLocation(435, 370);
			azuriraj.setFont(new Font("Ariel", Font.BOLD, 16));
			pozadina.add(azuriraj);
			azuriraj.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String s = JOptionPane.showInputDialog(narudzba, "Unesite novi datum narudzbe(yyyy-mm-dd)",
							"Azuriranje datuma isporuke", JOptionPane.INFORMATION_MESSAGE);
					if(!s.equals(null)) {
						try {
							LocalDate d1 = LocalDate.parse(izabranaNarudzba.getDatumNarudzbe(),
									DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
							LocalDate d2 = LocalDate.parse(s,
									DateTimeFormatter.ofPattern("uuuu-M-d").withResolverStyle(ResolverStyle.STRICT));
							if (d1.compareTo(d2) > 0) {
								JOptionPane.showMessageDialog(narudzba, "Isporuke ne moze da se desi prije narudzbe",
										"Greska", JOptionPane.ERROR_MESSAGE);
							} else {
								if (BazaPodataka.azurirajNarudzbu(izabranaNarudzba, s)) {
									JOptionPane.showMessageDialog(narudzba, "Narudzba azurirana", "Uspjesno azuriranje",
											JOptionPane.INFORMATION_MESSAGE);
									azuriraj();
									narudzba.dispose();
									korisnik.setState(JFrame.ICONIFIED);
								} else
									JOptionPane.showMessageDialog(narudzba, "Greska prilikom povezivanja sa bazom",
											"Greska", JOptionPane.ERROR_MESSAGE);
							}
						} catch (DateTimeParseException e2) {
							JOptionPane.showMessageDialog(narudzba, "Neispravan unos datuma", "Obavjestenje",
									JOptionPane.WARNING_MESSAGE);

						}

					}
					

				}

			});
		}
		if (izabranaNarudzba.getDatumIsporuke().equals("") && odabrano == 1) {
			JButton otkazi = new JButton("Otkazi naruzbu");
			otkazi.setBackground(bojaKupca);
			otkazi.setForeground(Color.white);
			otkazi.setSize(200, 50);
			otkazi.setLocation(435, 370);
			otkazi.setFont(new Font("Ariel", Font.BOLD, 20));
			otkazi.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (otkazi == e.getSource()) {
						int result = JOptionPane.showConfirmDialog(narudzba, "Da li zelite da otkazete narudzbu?",
								"Potvrdite", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							if (BazaPodataka.brisiNarudzbu(izabranaNarudzba))
								JOptionPane.showMessageDialog(narudzba, "Uspjesno ste otkazali narudzbu",
										"Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
							narudzba.dispose();
							azuriraj();
						}
					}

				}
			});
			pozadina.add(otkazi);
		}
	}

	private void naruciProizvode() {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		ArrayList<Proizvod> listaProizvoda = Proizvod.proizvodi;
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		proizvodi = new JFrame("Naruci proizvode");
		proizvodi.setSize(560, 585);
		proizvodi.setLayout(null);
		proizvodi.setResizable(false);
		proizvodi.setVisible(true);
		proizvodi.setLocationRelativeTo(null);
		proizvodi.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		proizvodi.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				proizvodi.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});
		int sirina = 560 - 8 - 8;
		int visina = 545;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(tamnoSiva);
		proizvodi.add(oznake);
		JLabel[] kolone = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 3, 30);
			kolone[i].setLocation((sirina / 3) * i, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Proizvod");
		kolone[1].setText("Cijena");
		kolone[2].setText("Izaberi");
		JPanel pozadina = new JPanel();
		pozadina.setBounds(0, 40, sirina, visina - 40);
		pozadina.setBackground(Color.gray);
		pozadina.setLayout(null);
		proizvodi.add(pozadina);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, -1, sirina, visina - 85);
		scrollPane.setBackground(svijetloSiva);
		pozadina.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(svijetloSiva);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setBackground(svijetloSiva);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		ArrayList<Proizvod> korpa = new ArrayList<>();
		JLabel cijenaNarudzbe = new JLabel("Cijena vase narudzbe je:");
		cijenaNarudzbe.setSize(240, 30);
		cijenaNarudzbe.setLocation(10, pozadina.getHeight() - 40);
		cijenaNarudzbe.setFont(new Font("Ariel", Font.BOLD, 18));
		cijenaNarudzbe.setHorizontalAlignment(JTextField.LEFT);
		cijenaNarudzbe.setForeground(Color.black);
		pozadina.add(cijenaNarudzbe);
		JLabel cijena = new JLabel();
		cijena.setSize(60, 30);
		cijena.setLocation(240, pozadina.getHeight() - 40);
		cijena.setText("0.0");
		cijena.setFont(new Font("Ariel", Font.BOLD, 18));
		cijena.setHorizontalAlignment(JTextField.CENTER);
		cijena.setForeground(Color.black);
		pozadina.add(cijena);
		JButton[] izaberi = new JButton[listaProizvoda.size()];
		JLabel[][] podaci = new JLabel[2][listaProizvoda.size()];
		int[] brojac = new int[2];
		kolone[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				class KomparatorPoNazivu implements Comparator<Proizvod> {

					@Override
					public int compare(Proizvod o1, Proizvod o2) {
						return o1.getNaziv().compareTo(o2.getNaziv());
					}
				}
				listaProizvoda.sort(new KomparatorPoNazivu());
				if (brojac[0] == 0)
					brojac[0] = 1;
				else {
					brojac[0] = 0;
					Collections.reverse(listaProizvoda);
				}
				for (int i = 0; i < listaProizvoda.size(); i++) {
					podaci[0][i].setText(listaProizvoda.get(i).getNaziv());
					podaci[1][i].setText("" + Math.round(listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
				}

			}
		});
		kolone[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				class KomparatorPoCijeni implements Comparator<Proizvod> {
					@Override
					public int compare(Proizvod o1, Proizvod o2) {
						return (int) (o2.getCijena() - o1.getCijena());
					}
				}
				listaProizvoda.sort(new KomparatorPoCijeni());
				if (brojac[1] == 0)
					brojac[1] = 1;
				else {
					brojac[1] = 0;
					Collections.reverse(listaProizvoda);
				}
				for (int i = 0; i < listaProizvoda.size(); i++) {
					podaci[0][i].setText(listaProizvoda.get(i).getNaziv());
					podaci[1][i].setText("" + Math.round(listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
				}
			}
		});
		for (int i = 0; i < listaProizvoda.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			red.setBackground(svijetloSiva);
			red.setBorder(lineBorder);
			red.setLayout(null);
			kolona.add(red);
			izaberi[i] = new JButton();
			izaberi[i].setText("Naruci");
			izaberi[i].setSize(sirina / 4, 30);
			izaberi[i].setLocation((2 * sirina) / 3 + 15, 10);
			izaberi[i].setFont(new Font("Ariel", Font.BOLD, 16));
			izaberi[i].setHorizontalAlignment(JTextField.CENTER);
			izaberi[i].setBackground(bojaKupca);
			izaberi[i].setForeground(Color.white);
			red.add(izaberi[i]);
			izaberi[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < izaberi.length; i++) {
						if (izaberi[i] == e.getSource()) {
							int result = JOptionPane.showConfirmDialog(proizvodi,
									"Da li zelite da dodate ovaj artikal u korpu", "Potvrdite",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
							if (result == JOptionPane.YES_OPTION) {
								korpa.add(listaProizvoda.get(i));
								JOptionPane.showMessageDialog(proizvodi, "Proizvod dodat u korpu", "Obavjestenje",
										JOptionPane.INFORMATION_MESSAGE);
								cijena.setText(
										"" + Math.round(Narudzba.cijenaNarudzbeProizvoda(korpa) * 100.0) / 100.0);
							}
						}
					}

				}
			});

			podaci[0][i] = new JLabel();
			podaci[0][i].setText(listaProizvoda.get(i).getNaziv());
			podaci[0][i].setSize(sirina / 3 + 40, 30);
			podaci[0][i].setLocation(0, 10);
			podaci[0][i].setFont(new Font("Ariel", Font.BOLD, 19));
			podaci[0][i].setHorizontalAlignment(JTextField.CENTER);
			podaci[0][i].setForeground(Color.black);
			red.add(podaci[0][i]);
			podaci[1][i] = new JLabel();
			podaci[1][i].setText("" + Math.round(listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
			podaci[1][i].setSize(sirina / 4, 30);
			podaci[1][i].setLocation(sirina / 3 + 25, 10);
			podaci[1][i].setFont(new Font("Ariel", Font.BOLD, 19));
			podaci[1][i].setHorizontalAlignment(JTextField.CENTER);
			podaci[1][i].setForeground(Color.black);
			red.add(podaci[1][i]);
		}
		proizvodi.setSize(559, 584);
		proizvodi.setSize(560, 585);
		JButton potvrdi = new JButton("Poruci");
		potvrdi.setSize(sirina / 4, 35);
		potvrdi.setLocation((2 * sirina) / 3 + 15, pozadina.getHeight() - 40);
		potvrdi.setFont(new Font("Ariel", Font.BOLD, 20));
		potvrdi.setHorizontalAlignment(JTextField.CENTER);
		potvrdi.setForeground(Color.white);
		potvrdi.setBackground(bojaKupca);
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == potvrdi) {
					if (korpa.isEmpty())
						JOptionPane.showMessageDialog(proizvodi, "Prvo izaberite proizvod da izvrsite narudzbu",
								"Obavjestenje", JOptionPane.WARNING_MESSAGE);
					else {
						int result = JOptionPane.showConfirmDialog(narudzba, "Da li zelite da izvrsite narudzbu?",
								"Potvrdite", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
						if (result == JOptionPane.YES_OPTION) {
							String date = "" + java.time.LocalDate.now();
							String n = null;
							Narudzba nova = new Narudzba(Narudzba.generisiId(), GUI.privaljenKupac.getId(), -1, date, n,
									n);
							Narudzba.naruceno.add(new AbstractMap.SimpleEntry<>(nova, korpa));
							JOptionPane.showMessageDialog(prijava, "Narudzba je uspjesno izvrsena", "Obavjestenje",
									JOptionPane.INFORMATION_MESSAGE);
							proizvodi.dispose();
							korisnik.setExtendedState(JFrame.NORMAL);
						}
					}
				}

			}
		});
		pozadina.add(potvrdi);
	}

	private void prikaziProizvode() {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		ArrayList<Proizvod> listaProizvoda = Proizvod.proizvodi;
		proizvodi = new JFrame("Prikazi proizvode");
		proizvodi.setSize(560, 585);
		proizvodi.setLayout(null);
		proizvodi.setResizable(false);
		proizvodi.setVisible(true);
		proizvodi.setLocationRelativeTo(null);
		proizvodi.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				proizvodi.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});
		int sirina = 560 - 8 - 8;
		int visina = 545;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(tamnoSiva);
		proizvodi.add(oznake);
		JLabel[] kolone = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 3, 30);
			kolone[i].setLocation((sirina / 3) * i + 20, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Proizvod");
		kolone[1].setText("Cijena");
		kolone[1].setLocation(kolone[1].getX() + 15, 5);
		kolone[2].setText("Izaberi");
		kolone[2].setLocation(kolone[2].getX() - 30, 5);
		JPanel pozadina = new JPanel();
		pozadina.setBounds(0, 40, sirina, visina - 40);
		pozadina.setBackground(Color.gray);
		pozadina.setLayout(null);
		proizvodi.add(pozadina);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, -1, sirina, visina - 85);
		scrollPane.setBackground(svijetloSiva);
		pozadina.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(svijetloSiva);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setBackground(svijetloSiva);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		JTextField naziv = new JTextField();
		naziv.setSize(250, 30);
		naziv.setLocation(5, pozadina.getHeight() - 40);
		naziv.setFont(new Font("Ariel", Font.BOLD, 18));
		naziv.setHorizontalAlignment(JTextField.CENTER);
		naziv.setForeground(Color.black);
		naziv.setToolTipText("Unesite naziv proizvoda");
		pozadina.add(naziv);
		JTextField cijena = new JTextField();
		cijena.setSize(70, 30);
		cijena.setLocation(275, pozadina.getHeight() - 40);
		cijena.setFont(new Font("Ariel", Font.BOLD, 18));
		cijena.setHorizontalAlignment(JTextField.CENTER);
		cijena.setForeground(Color.black);
		cijena.setToolTipText("Unesite cijenu proizvoda");
		pozadina.add(cijena);
		JButton potvrdi = new JButton("Dodaj");
		potvrdi.setSize(sirina / 5 + 10, 35);
		potvrdi.setLocation((2 * sirina) / 3 + 25, pozadina.getHeight() - 40);
		potvrdi.setFont(new Font("Ariel", Font.BOLD, 20));
		potvrdi.setHorizontalAlignment(JTextField.CENTER);
		potvrdi.setForeground(Color.white);
		potvrdi.setBackground(bojaTrgovca);
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cijena.getText().equals("") || naziv.getText().equals("")) {
					JOptionPane.showMessageDialog(proizvodi, "Unesite naziv i cijenu proizvoda", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					String s = JOptionPane.showInputDialog(proizvodi, "Po zelji dodajte opis proizvoda. \nOpis:",
							"Opis", JOptionPane.INFORMATION_MESSAGE);
					try {
						if (BazaPodataka.dodajProizvod(new Proizvod(Proizvod.generisiId(), naziv.getText(), s,
								Double.parseDouble(cijena.getText()))))
							JOptionPane.showMessageDialog(proizvodi, "Uspjesno ste dodali proizvod", "Obavjestenje",
									JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(proizvodi, "Greska prilikom povezivanja sa bazom", "Greksa",
									JOptionPane.ERROR_MESSAGE);
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Dodavanje opisa otkazano", "Otkazano",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		});
		pozadina.add(potvrdi);
		JButton[] izaberi = new JButton[20];
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		JTextField[][] podaci = new JTextField[listaProizvoda.size()][2];
		for (int i = 0; i < listaProizvoda.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			red.setBackground(svijetloSiva);
			red.setBorder(lineBorder);
			kolona.add(red);
			red.setLayout(null);
			izaberi[i] = new JButton();
			izaberi[i].setText("Uredi");
			izaberi[i].setSize(sirina / 5, 30);
			izaberi[i].setLocation((2 * sirina) / 3 + 28, 10);
			izaberi[i].setFont(new Font("Ariel", Font.BOLD, 16));
			izaberi[i].setHorizontalAlignment(JTextField.CENTER);
			izaberi[i].setBackground(bojaTrgovca);
			izaberi[i].setForeground(Color.white);
			String[] polja = new String[2];
			izaberi[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < izaberi.length; i++)
						if (izaberi[i] == e.getSource() && izaberi[i].getText().equals("Uredi")) {
							podaci[i][0].setEditable(true);
							podaci[i][1].setEditable(true);
							podaci[i][0].setBackground(Color.white);
							podaci[i][1].setBackground(Color.white);
							izaberi[i].setText("Azuriraj");
							polja[0] = podaci[i][0].getText();
							polja[1] = podaci[i][1].getText();
						} else if (izaberi[i] == e.getSource() && izaberi[i].getText().equals("Azuriraj")) {
							String s1 = podaci[i][0].getText();
							String s2 = podaci[i][1].getText();
							if (s1.equals("") || s2.equals("")) {
								JOptionPane.showMessageDialog(proizvodi, "Unesite naziv i cijenu proizvoda", "Greska",
										JOptionPane.ERROR_MESSAGE);
							} else if (s1.equals(listaProizvoda.get(i).getNaziv()) && s2.equals(listaProizvoda.get(i).getCijena()+"")) {
								JOptionPane.showMessageDialog(proizvodi, "Novi naziv i cijena su isti kao i prethodni",
										"Upozorenje", JOptionPane.WARNING_MESSAGE);
								podaci[i][0].setEditable(false);
								podaci[i][1].setEditable(false);
								podaci[i][0].setBackground(svijetloSiva);
								podaci[i][1].setBackground(svijetloSiva);
								izaberi[i].setText("Uredi");
							} else {
								proizvodi.dispose();
								if (BazaPodataka.azurirajProizvod(listaProizvoda.get(i), podaci[i][0].getText(),
										podaci[i][1].getText())) {
									JOptionPane.showMessageDialog(proizvodi, "Uspjesno azuriran proizvod",
											"Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
									azuriraj();
									prikaziProizvode();
								} else
									JOptionPane.showMessageDialog(proizvodi,
											"Greska prilikom povezivanja sa bazom podataka", "Greska",
											JOptionPane.ERROR_MESSAGE);
							}

						}
				}
			});
			red.add(izaberi[i]);
			for (int j = 0; j < 2; j++) {
				podaci[i][j] = new JTextField();
				podaci[i][j].setFont(new Font("Ariel", Font.BOLD, 19));
				podaci[i][j].setHorizontalAlignment(JTextField.CENTER);
				podaci[i][j].setForeground(Color.black);
				podaci[i][j].setEditable(false);
				podaci[i][j].setBackground(svijetloSiva);
				if (j == 0) {
					podaci[i][j].setLocation(5, 10);
					podaci[i][j].setText(listaProizvoda.get(i).getNaziv());
					podaci[i][j].setSize(sirina / 3 + 50, 36);
				} else if (j == 1) {
					podaci[i][j].setLocation(sirina / 2, 10);
					podaci[i][j].setText("" + (listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
					podaci[i][j].setSize(70, 36);
				}
				red.add(podaci[i][j]);
			}
		}
		int[] brojac = new int[2];
		kolone[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				class KomparatorPoNazivu implements Comparator<Proizvod> {

					@Override
					public int compare(Proizvod o1, Proizvod o2) {
						return o1.getNaziv().compareTo(o2.getNaziv());
					}
				}
				listaProizvoda.sort(new KomparatorPoNazivu());
				if (brojac[0] == 0)
					brojac[0] = 1;
				else {
					Collections.reverse(listaProizvoda);
					brojac[0] = 0;
				}
				for (int i = 0; i < listaProizvoda.size(); i++) {
					for (int j = 0; j < 2; j++) {
						if (j == 0)
							podaci[i][j].setText(listaProizvoda.get(i).getNaziv());
						else if (j == 1)
							podaci[i][j].setText("" + (listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
					}
				}

			}
		});
		kolone[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseClicked(MouseEvent e) {
				class KomparatorPoCijeni implements Comparator<Proizvod> {

					@Override
					public int compare(Proizvod o1, Proizvod o2) {
						return (int) (o2.getCijena() - o1.getCijena());
					}
				}
				listaProizvoda.sort(new KomparatorPoCijeni());
				if (brojac[0] == 0)
					brojac[0] = 1;
				else {
					Collections.reverse(listaProizvoda);
					brojac[0] = 0;
				}
				for (int i = 0; i < listaProizvoda.size(); i++) {
					for (int j = 0; j < 2; j++) {
						if (j == 0)
							podaci[i][j].setText(listaProizvoda.get(i).getNaziv());
						else if (j == 1)
							podaci[i][j].setText("" + (listaProizvoda.get(i).getCijena() * 100.0) / 100.0);
					}
				}

			}
		});
		proizvodi.setSize(559, 584);
		proizvodi.setSize(560, 585);
	}

	private void prikaziTrgovca() {
		if (prijava.isActive())
			prijava.dispose();
		korisnik = new JFrame("Prikaz trgovca");
		korisnik.setSize(670, 500);
		korisnik.setLayout(null);
		korisnik.setVisible(true);
		korisnik.setLocationRelativeTo(null);
		korisnik.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		korisnik.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				if (JOptionPane.showConfirmDialog(korisnik, "Da li zelite da zatvorite aplikaciju?",
						"Zatvori aplikaciju?", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
					Narudzba.pamtiNaruceno();
					System.exit(0);
				}
			}
		});
		korisnik.setResizable(false);

		JPanel pomocniPanel = new JPanel();
		pomocniPanel.setSize(654, 382);
		pomocniPanel.setBackground(svijetloSiva);
		pomocniPanel.setLocation(0, 80);
		pomocniPanel.setLayout(null);
		korisnik.add(pomocniPanel);

		JPanel pozadina_prijave = new JPanel();
		pozadina_prijave.setSize(654, 80);
		pozadina_prijave.setBackground(tamnoSiva);
		pozadina_prijave.setLocation(0, 0);
		pozadina_prijave.setLayout(null);
		korisnik.add(pozadina_prijave);
		JButton odjavi_se = new JButton("Odjavi se");
		odjavi_se.setBackground(new Color(160, 30, 40));
		odjavi_se.setForeground(Color.white);
		odjavi_se.setSize(100, 30);
		odjavi_se.setLocation(500, 25);
		odjavi_se.setFont(new Font("Ariel", Font.BOLD, 16));
		odjavi_se.setHorizontalAlignment(JTextField.CENTER);
		odjavi_se.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(korisnik, "Da li zelite da se odjavite?", "Potvrdite",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					prijavljenTrgovac = null;
					korisnik.dispose();
					new GUI();
				}
			}
		});
		pozadina_prijave.add(odjavi_se);
		JLabel opis = new JLabel("Trgovac:");
		opis.setLocation(15, 15);
		opis.setSize(400, 50);
		opis.setForeground(Color.white);
		opis.setFont(new Font("Ariel", Font.BOLD, 30));
		pozadina_prijave.add(opis);

		JLabel podaci = new JLabel("Podaci:");
		podaci.setLocation(10, 10);
		podaci.setSize(180, 22);
		podaci.setFont(new Font("Ariel", Font.BOLD, 22));
		podaci.setForeground(Color.black);
		pomocniPanel.add(podaci);
		JLabel ime = new JLabel("Ime: " + prijavljenTrgovac.getIme());
		ime.setLocation(10, 45);
		ime.setSize(180, 22);
		ime.setFont(new Font("Ariel", Font.BOLD, 18));
		ime.setForeground(Color.black);
		pomocniPanel.add(ime);
		JLabel prezime = new JLabel("Prezime: " + prijavljenTrgovac.getPrezime());
		prezime.setLocation(10, 75);
		prezime.setSize(180, 20);
		prezime.setFont(new Font("Ariel", Font.BOLD, 18));
		prezime.setForeground(Color.black);
		pomocniPanel.add(prezime);
		int yPosljednjeg = 75;
		if (!prijavljenTrgovac.getTelefon().equals("")) {
			JLabel telefon = new JLabel("Broj telefona: " + prijavljenTrgovac.getTelefon());
			telefon.setLocation(10, yPosljednjeg += 30);
			telefon.setSize(290, 20);
			telefon.setFont(new Font("Ariel", Font.BOLD, 18));
			telefon.setForeground(Color.black);
			pomocniPanel.add(telefon);
		}
		JLabel pol = new JLabel("Pol: " + (prijavljenTrgovac.getPol().equals("M") ? "Muski" : "Zenski"));
		pol.setLocation(10, yPosljednjeg += 30);
		pol.setSize(300, 20);
		pol.setFont(new Font("Ariel", Font.BOLD, 18));
		pol.setForeground(Color.black);
		pomocniPanel.add(pol);
		ProdajnoMjesto radnoMjesto = ProdajnoMjesto.prodajnoMjestoTrgovca(prijavljenTrgovac);
		JLabel prodajno_mjesto = new JLabel("Prodajno mjesto: ");
		prodajno_mjesto.setLocation(10, yPosljednjeg += 30);
		prodajno_mjesto.setSize(180, 22);
		prodajno_mjesto.setFont(new Font("Ariel", Font.BOLD, 18));
		prodajno_mjesto.setForeground(Color.black);
		pomocniPanel.add(prodajno_mjesto);
		JLabel drzava = new JLabel(radnoMjesto.getDrzava());
		drzava.setLocation(20, yPosljednjeg += 30);
		drzava.setSize(280, 22);
		drzava.setFont(new Font("Ariel", Font.BOLD, 18));
		drzava.setForeground(Color.black);
		pomocniPanel.add(drzava);
		JLabel grad = new JLabel(radnoMjesto.getGrad());
		grad.setLocation(20, yPosljednjeg += 30);
		grad.setSize(180, 22);
		grad.setFont(new Font("Ariel", Font.BOLD, 18));
		grad.setForeground(Color.black);
		pomocniPanel.add(grad);
		if (!radnoMjesto.getAdresa().equals("")) {
			JLabel adresa = new JLabel(radnoMjesto.getAdresa());
			adresa.setLocation(20, yPosljednjeg += 30);
			adresa.setSize(350, 22);
			adresa.setFont(new Font("Ariel", Font.BOLD, 18));
			adresa.setForeground(Color.black);
			pomocniPanel.add(adresa);
		}

		JLabel opcije = new JLabel("Opcije:");
		opcije.setLocation(380, 10);
		opcije.setSize(180, 30);
		opcije.setFont(new Font("Ariel", Font.BOLD, 22));
		opcije.setForeground(Color.black);
		pomocniPanel.add(opcije);

		ArrayList<Narudzba> listaObavjestenja = Narudzba.obavjestenja(prijavljenTrgovac);
		JButton obavjestenja = new JButton("Pogledaj obavjestenja");
		obavjestenja.setBackground(bojaTrgovca);
		obavjestenja.setForeground(Color.white);
		obavjestenja.setSize(200, 50);
		obavjestenja.setLocation(400, 50);
		obavjestenja.setFont(new Font("Ariel", Font.BOLD, 15));
		obavjestenja.setSelected(false);
		obavjestenja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (listaObavjestenja.size() > 0)
					prikaziObavjestenja(listaObavjestenja);
				else
					JOptionPane.showMessageDialog(korisnik, "Trenutno nemate obavjestenja", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
			}

		});
		pomocniPanel.add(obavjestenja);
		JButton narudzbe2 = new JButton("Sve narudzbe");
		narudzbe2.setBackground(bojaTrgovca);
		narudzbe2.setForeground(Color.white);
		narudzbe2.setSize(200, 50);
		narudzbe2.setLocation(400, 110);
		narudzbe2.setFont(new Font("Ariel", Font.BOLD, 15));
		narudzbe2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziNarudzbe(Narudzba.sveNarudzbeTrgovca(prijavljenTrgovac));
			}
		});
		narudzbe2.setSelected(false);
		pomocniPanel.add(narudzbe2);
		JButton novoMjesto = new JButton("Dodaj prodajno mjesto");
		novoMjesto.setBackground(bojaTrgovca);
		novoMjesto.setForeground(Color.white);
		novoMjesto.setSize(200, 50);
		novoMjesto.setLocation(400, 170);
		novoMjesto.setFont(new Font("Ariel", Font.BOLD, 15));
		novoMjesto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dodajProdajnoMjesto();
			}
		});
		novoMjesto.setSelected(false);
		pomocniPanel.add(novoMjesto);
		JButton noviTrgovac = new JButton("Dodaj novog trgovca");
		noviTrgovac.setBackground(bojaTrgovca);
		noviTrgovac.setForeground(Color.white);
		noviTrgovac.setSize(200, 50);
		noviTrgovac.setLocation(400, 230);
		noviTrgovac.setFont(new Font("Ariel", Font.BOLD, 15));
		noviTrgovac.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dodajTrgovca();
			}
		});
		noviTrgovac.setSelected(false);
		pomocniPanel.add(noviTrgovac);
		JButton artikl = new JButton("Dodaj / azuriraj prozvod");
		artikl.setBackground(bojaTrgovca);
		artikl.setForeground(Color.white);
		artikl.setSize(200, 50);
		artikl.setLocation(400, 290);
		artikl.setFont(new Font("Ariel", Font.BOLD, 15));
		artikl.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziProizvode();
			}
		});
		pomocniPanel.add(artikl);
	}

	private void prikaziObavjestenja(ArrayList<Narudzba> listaObavjestenja) {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		sveNarudzbe = new JFrame("Narudzbe");
		sveNarudzbe.setSize(670, 540);
		sveNarudzbe.setLayout(null);
		sveNarudzbe.setVisible(true);
		sveNarudzbe.setLocationRelativeTo(null);
		sveNarudzbe.setResizable(false);
		sveNarudzbe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				sveNarudzbe.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});
		int sirina = 670 - 8 - 8;
		int visina = 540 - 35;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(tamnoSiva);
		sveNarudzbe.add(oznake);
		JLabel[] kolone = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 3, 30);
			kolone[i].setLocation((sirina / 3) * i, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Datum narudzbe");
		kolone[1].setText("Vrijednost");
		kolone[2].setText("Izaberi");

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 40, sirina, visina - 40);
		sveNarudzbe.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(svijetloSiva);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setBackground(svijetloSiva);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		JButton[] izaberi = new JButton[listaObavjestenja.size()];
		Border lineBorder = BorderFactory.createLineBorder(Color.BLACK);
		for (int i = 0; i < listaObavjestenja.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			red.setBackground(svijetloSiva);
			red.setBorder(lineBorder);
			kolona.add(red);
			red.setLayout(null);
			izaberi[i] = new JButton("Detalji");
			izaberi[i].setSize(sirina / 4, 30);
			izaberi[i].setLocation((2 * sirina) / 3 + 30, 10);
			izaberi[i].setFont(new Font("Ariel", Font.BOLD, 16));
			izaberi[i].setHorizontalAlignment(JTextField.CENTER);
			izaberi[i].setBackground(bojaTrgovca);
			izaberi[i].setForeground(Color.white);
			izaberi[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					for (int i = 0; i < listaObavjestenja.size(); i++)
						if (izaberi[i] == e.getSource())
							prikaziDetaljeObavjestenja(i);
				}
			});
			JLabel narudzba = new JLabel();
			narudzba.setText(listaObavjestenja.get(i).getDatumNarudzbe());
			narudzba.setSize(sirina / 3, 30);
			narudzba.setLocation(0, 10);
			narudzba.setFont(new Font("Ariel", Font.BOLD, 20));
			narudzba.setHorizontalAlignment(JTextField.CENTER);
			narudzba.setForeground(Color.black);
			red.add(narudzba);
			JLabel cijena = new JLabel();
			cijena.setText("" + Math.round(Narudzba.cijenaNarudzbe(i) * 100.0) / 100.0);
			cijena.setSize(sirina / 3, 30);
			cijena.setLocation(sirina / 3, 10);
			cijena.setFont(new Font("Ariel", Font.BOLD, 20));
			cijena.setHorizontalAlignment(JTextField.CENTER);
			cijena.setForeground(Color.black);
			red.add(cijena);
			red.add(izaberi[i]);
		}
	}

	private void prikaziDetaljeObavjestenja(int index) {
		sveNarudzbe.dispose();
		narudzba = new JFrame("Detalji narudzbe");
		narudzba.setSize(550, 510);
		narudzba.setLayout(null);
		narudzba.setVisible(true);
		narudzba.setResizable(false);
		narudzba.setLocationRelativeTo(null);
		narudzba.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				narudzba.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});
		int sirina = 550 - 8 - 8;
		int visina = 500 - 21 - 8;
		JPanel oznake = new JPanel();
		oznake.setSize(sirina, 40);
		oznake.setLayout(null);
		oznake.setLocation(0, 0);
		oznake.setBackground(tamnoSiva);
		narudzba.add(oznake);
		JLabel[] kolone = new JLabel[2];
		for (int i = 0; i < 2; i++) {
			kolone[i] = new JLabel();
			kolone[i].setSize(sirina / 2, 30);
			kolone[i].setLocation((sirina / 2) * i + 10, 5);
			kolone[i].setFont(new Font("Ariel", Font.BOLD, 18));
			kolone[i].setHorizontalAlignment(JTextField.CENTER);
			kolone[i].setForeground(Color.white);
			oznake.add(kolone[i]);
		}
		kolone[0].setText("Naruceni artikli");
		kolone[1].setText("Iznos");
		JPanel pozadina = new JPanel();
		pozadina.setBounds(0, 40, sirina, visina - 40);
		pozadina.setBackground(svijetloSiva);
		pozadina.setLayout(null);
		narudzba.add(pozadina);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(-1, 0, sirina, visina - 110);
		pozadina.add(scrollPane);
		JPanel nosacPodataka = new JPanel();
		scrollPane.setViewportView(nosacPodataka);
		nosacPodataka.setLayout(new BorderLayout(0, 0));
		nosacPodataka.setBackground(svijetloSiva);
		JPanel kolona = new JPanel();
		nosacPodataka.add(kolona, BorderLayout.NORTH);
		kolona.setLayout(new GridLayout(0, 1, 0, 1));
		kolona.setBackground(svijetloSiva);
		Border lineBorder = BorderFactory.createLineBorder(Color.white);
		ArrayList<Proizvod> proizvodiNarudzbe = Narudzba.naruceniProizvodi(Narudzba.naruceno.get(index).getValue());
		ArrayList<Integer> kolicina = Narudzba.kolicina(Narudzba.naruceno.get(index).getValue(), proizvodiNarudzbe);
		for (int i = 0; i < proizvodiNarudzbe.size(); i++) {
			JPanel red = new JPanel();
			red.setPreferredSize(new Dimension(300, 50));
			kolona.add(red);
			red.setLayout(null);
			red.setBorder(lineBorder);
			red.setBackground(svijetloSiva);
			JLabel naziv = new JLabel();
			naziv.setText("" + proizvodiNarudzbe.get(i).getNaziv());
			naziv.setSize(sirina / 2, 30);
			naziv.setLocation(15, 10);
			naziv.setFont(new Font("Ariel", Font.BOLD, 20));
			naziv.setHorizontalAlignment(JTextField.CENTER);
			naziv.setForeground(Color.black);
			red.add(naziv);
			JLabel vrijednost = new JLabel();
			vrijednost.setText((kolicina.get(i) > 1 ? kolicina.get(i) + " x " : "")
					+ (proizvodiNarudzbe.get(i).getCijena() * 100.0) / 100.0);
			vrijednost.setSize(sirina / 2 - 20, 30);
			vrijednost.setLocation(sirina / 2 + 15, 10);
			vrijednost.setFont(new Font("Ariel", Font.BOLD, 20));
			vrijednost.setHorizontalAlignment(JTextField.CENTER);
			vrijednost.setForeground(Color.black);
			red.add(vrijednost);
		}
		JButton prihvati = new JButton("Prihvati naruzbu");
		prihvati.setBackground(bojaTrgovca);
		prihvati.setForeground(Color.white);
		prihvati.setSize(200, 50);
		prihvati.setLocation(315, 370);
		prihvati.setFont(new Font("Ariel", Font.BOLD, 20));
		prihvati.setHorizontalAlignment(JTextField.CENTER);
		prihvati.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(narudzba, "Da li zelite da prihvatite ovu narudzbu?",
						"Potvrdite", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(narudzba, "Narudzba je dodata u vase narudzbe", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
					Narudzba.naruceno.get(index).getKey().setTrgovacId(prijavljenTrgovac.getId());
					ArtikalNarudzbe.dodajArtikleNarudzbe(Narudzba.naruceno.get(index).getKey(), proizvodiNarudzbe,
							kolicina);
					BazaPodataka.dodajNarudzbu(Narudzba.naruceno.get(index).getKey());
					Narudzba.naruceno.remove(index);
					narudzba.dispose();
					azuriraj();
				}
			}

		});
		pozadina.add(prihvati);
		pozadina.repaint();
	}

	private void dodajProdajnoMjesto() {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		novoMjesto = new JFrame("Registracija");
		novoMjesto.setSize(380, 380);
		novoMjesto.setLayout(null);
		novoMjesto.setVisible(true);
		novoMjesto.setLocationRelativeTo(null);
		novoMjesto.setResizable(false);
		novoMjesto.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				novoMjesto.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});

		JPanel glava, tijelo;
		glava = new JPanel();
		glava.setLayout(null);
		glava.setBackground(tamnoSiva);
		glava.setLocation(0, 0);
		glava.setSize(364, 70);
		novoMjesto.add(glava);
		tijelo = new JPanel();
		tijelo.setLayout(null);
		tijelo.setLocation(0, 70);
		tijelo.setBackground(svijetloSiva);
		tijelo.setSize(364, 271);
		novoMjesto.add(tijelo);

		JLabel naziv = new JLabel("Novo prodajno mjesto");
		naziv.setFont(new Font("Ariel", Font.BOLD, 26));
		naziv.setForeground(Color.white);
		naziv.setLocation(10, 15);
		naziv.setSize(300, 40);
		glava.add(naziv);

		JLabel telefon, adresa, grad, drzava;
		telefon = new JLabel("Telefon:");
		telefon.setLocation(15, 140);
		telefon.setSize(100, 20);
		telefon.setFont(new Font("Ariel", Font.BOLD, 18));
		telefon.setForeground(Color.black);
		tijelo.add(telefon);
		adresa = new JLabel("Adresa:");
		adresa.setLocation(15, 100);
		adresa.setSize(100, 20);
		adresa.setFont(new Font("Ariel", Font.BOLD, 18));
		adresa.setForeground(Color.black);
		tijelo.add(adresa);
		grad = new JLabel("Grad*:");
		grad.setLocation(15, 20);
		grad.setSize(100, 20);
		grad.setFont(new Font("Ariel", Font.BOLD, 18));
		grad.setForeground(Color.black);
		tijelo.add(grad);
		drzava = new JLabel("Drzava*:");
		drzava.setLocation(15, 60);
		drzava.setSize(100, 20);
		drzava.setFont(new Font("Ariel", Font.BOLD, 18));
		drzava.setForeground(Color.black);
		tijelo.add(drzava);

		JLabel oznaka = new JLabel("* obavezna polja");
		oznaka.setLocation(10, 215);
		oznaka.setSize(160, 20);
		oznaka.setFont(new Font("Ariel", Font.BOLD, 16));
		oznaka.setForeground(Color.black);
		tijelo.add(oznaka);

		JTextField telefon_unos, adresa_unos, grad_unos, drzava_unos;
		telefon_unos = new JTextField();
		telefon_unos.setLocation(120, telefon.getY());
		telefon_unos.setSize(180, 28);
		telefon_unos.setHorizontalAlignment(JTextField.CENTER);
		telefon_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		telefon_unos.setForeground(Color.black);
		tijelo.add(telefon_unos);
		adresa_unos = new JTextField();
		adresa_unos.setLocation(120, adresa.getY());
		adresa_unos.setSize(180, 28);
		adresa_unos.setHorizontalAlignment(JTextField.CENTER);
		adresa_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		adresa_unos.setForeground(Color.black);
		tijelo.add(adresa_unos);
		grad_unos = new JTextField();
		grad_unos.setLocation(120, grad.getY());
		grad_unos.setSize(180, 28);
		grad_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		grad_unos.setForeground(Color.black);
		grad_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(grad_unos);
		drzava_unos = new JTextField();
		drzava_unos.setLocation(120, drzava.getY());
		drzava_unos.setSize(180, 28);
		drzava_unos.setHorizontalAlignment(JTextField.CENTER);
		drzava_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		drzava_unos.setForeground(Color.black);
		tijelo.add(drzava_unos);

		JButton dodaj = new JButton("Dodaj");
		dodaj.setBackground(bojaTrgovca);
		dodaj.setForeground(Color.white);
		dodaj.setSize(120, 45);
		dodaj.setFont(new Font("Ariel", Font.BOLD, 18));
		dodaj.setLocation(210, 200);
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String state = drzava_unos.getText();
				String city = grad_unos.getText();
				if (state.equals("") || city.equals(""))
					JOptionPane.showMessageDialog(novoMjesto, "Molimo Vas da popunite sva obavezna polja",
							"Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
				else {
					String adress = null;
					if (!adresa_unos.getText().equals(""))
						adress = adresa_unos.getText();
					String phone = null;
					if (!telefon_unos.getText().equals(""))
						phone = telefon_unos.getText();
					if (BazaPodataka
							.dodajMjesto(new ProdajnoMjesto(ProdajnoMjesto.generisiId(), city, state, adress, phone))) {
						JOptionPane.showMessageDialog(novoMjesto, "Uspjesno ste dodali novo prodajno mjesto",
								"Obavjestenje", JOptionPane.INFORMATION_MESSAGE);
						novoMjesto.dispose();
						azuriraj();
					} else {
						JOptionPane.showMessageDialog(novoMjesto, "Greska pri konekcije sa bazom", "Obavjestenje",
								JOptionPane.ERROR_MESSAGE);
						novoMjesto.dispose();
					}
				}

			}
		});
		tijelo.add(dodaj);
	}

	private void dodajTrgovca() {
		korisnik.setExtendedState(JFrame.ICONIFIED);
		registracija = new JFrame("Dodavanje trgovca");
		registracija.setSize(450, 500);
		registracija.setLayout(null);
		registracija.setVisible(true);
		registracija.setLocationRelativeTo(null);
		registracija.setResizable(false);
		registracija.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				registracija.dispose();
				korisnik.setExtendedState(JFrame.NORMAL);
			}
		});

		JPanel glava, tijelo;
		glava = new JPanel();
		glava.setLayout(null);
		glava.setBackground(tamnoSiva);
		glava.setLocation(0, 0);
		glava.setSize(434, 70);
		registracija.add(glava);
		tijelo = new JPanel();
		tijelo.setLayout(null);
		tijelo.setLocation(0, 70);
		tijelo.setBackground(svijetloSiva);
		tijelo.setSize(434, 391);
		registracija.add(tijelo);

		JLabel naziv = new JLabel("Novi trgovac:");
		naziv.setFont(new Font("Ariel", Font.BOLD, 28));
		naziv.setForeground(Color.white);
		naziv.setLocation(10, 15);
		naziv.setSize(200, 40);
		glava.add(naziv);

		JLabel korisnicko_ime, ime, prezime, lozinka, telefon, pol, prodajno_mjesto;
		korisnicko_ime = new JLabel("Korisnicko ime*:");
		korisnicko_ime.setLocation(15, 20);
		korisnicko_ime.setSize(160, 20);
		korisnicko_ime.setFont(new Font("Ariel", Font.BOLD, 18));
		korisnicko_ime.setForeground(Color.black);
		tijelo.add(korisnicko_ime);
		ime = new JLabel("Ime*:");
		ime.setLocation(15, 60);
		ime.setSize(100, 20);
		ime.setFont(new Font("Ariel", Font.BOLD, 18));
		ime.setForeground(Color.black);
		tijelo.add(ime);
		prezime = new JLabel("Prezime*:");
		prezime.setLocation(15, 100);
		prezime.setSize(100, 20);
		prezime.setFont(new Font("Ariel", Font.BOLD, 18));
		prezime.setForeground(Color.black);
		tijelo.add(prezime);
		lozinka = new JLabel("Lozinka:*");
		lozinka.setLocation(15, 140);
		lozinka.setSize(100, 20);
		lozinka.setFont(new Font("Ariel", Font.BOLD, 18));
		lozinka.setForeground(Color.black);
		tijelo.add(lozinka);
		pol = new JLabel("Pol:");
		pol.setLocation(15, 180);
		pol.setSize(60, 20);
		pol.setFont(new Font("Ariel", Font.BOLD, 18));
		pol.setForeground(Color.black);
		tijelo.add(pol);
		telefon = new JLabel("Telefon:");
		telefon.setLocation(15, 220);
		telefon.setSize(100, 20);
		telefon.setFont(new Font("Ariel", Font.BOLD, 18));
		telefon.setForeground(Color.black);
		tijelo.add(telefon);
		prodajno_mjesto = new JLabel("Prodajno mjesto*:");
		prodajno_mjesto.setLocation(15, 260);
		prodajno_mjesto.setSize(180, 20);
		prodajno_mjesto.setFont(new Font("Ariel", Font.BOLD, 18));
		prodajno_mjesto.setForeground(Color.black);
		tijelo.add(prodajno_mjesto);

		JLabel oznaka = new JLabel("* obavezna polja");
		oznaka.setLocation(15, 330);
		oznaka.setSize(160, 20);
		oznaka.setFont(new Font("Ariel", Font.BOLD, 16));
		oznaka.setForeground(Color.black);
		tijelo.add(oznaka);

		JTextField korisnicko_ime_unos, ime_unos, prezime_unos, telefon_unos;
		korisnicko_ime_unos = new JTextField();
		korisnicko_ime_unos.setLocation(180, 20);
		korisnicko_ime_unos.setSize(180, 28);
		korisnicko_ime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		korisnicko_ime_unos.setForeground(Color.black);
		korisnicko_ime_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(korisnicko_ime_unos);
		ime_unos = new JTextField();
		ime_unos.setLocation(180, 60);
		ime_unos.setSize(180, 28);
		ime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		ime_unos.setForeground(Color.black);
		ime_unos.setHorizontalAlignment(JTextField.CENTER);
		tijelo.add(ime_unos);
		prezime_unos = new JTextField();
		prezime_unos.setLocation(180, 100);
		prezime_unos.setSize(180, 28);
		prezime_unos.setHorizontalAlignment(JTextField.CENTER);
		prezime_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		prezime_unos.setForeground(Color.black);
		tijelo.add(prezime_unos);
		JPasswordField sifra = new JPasswordField();
		sifra.setSize(180, 28);
		sifra.setLocation(180, 140);
		sifra.setFont(new Font("Ariel", Font.BOLD, 14));
		sifra.setHorizontalAlignment(JTextField.CENTER);
		sifra.setForeground(Color.black);
		tijelo.add(sifra);
		String[] polovi = { null, "M", "Z" };
		JComboBox<String> pol_izbor = new JComboBox<String>(polovi);
		pol_izbor.setLocation(180, 180);
		pol_izbor.setSize(60, 28);
		pol_izbor.setFont(new Font("Ariel", Font.BOLD, 14));
		pol_izbor.setForeground(Color.black);
		tijelo.add(pol_izbor);
		telefon_unos = new JTextField();
		telefon_unos.setLocation(180, 220);
		telefon_unos.setSize(180, 28);
		telefon_unos.setHorizontalAlignment(JTextField.CENTER);
		telefon_unos.setFont(new Font("Ariel", Font.BOLD, 14));
		telefon_unos.setForeground(Color.black);
		tijelo.add(telefon_unos);
		String[] prodajnaMjesta = ProdajnoMjesto.idProdajnihMjesta();
		JComboBox<String> prodajna_mjesta_izbor = new JComboBox<String>(prodajnaMjesta);
		class MyComboBoxRenderer extends BasicComboBoxRenderer {
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				String[] tooltips = ProdajnoMjesto.prodajnaMjestaHint();
				if (isSelected) {
					setBackground(new Color(57, 105, 138));
					setForeground(Color.white);
					if (-1 < index) {
						list.setToolTipText(tooltips[index]);
					}
				} else {
					setBackground(Color.white);
					setForeground(Color.black);
				}
				setFont(list.getFont());
				setText((value == null) ? "" : value.toString());
				return this;
			}
		}
		prodajna_mjesta_izbor.setRenderer(new MyComboBoxRenderer());
		prodajna_mjesta_izbor.setLocation(180, 260);
		prodajna_mjesta_izbor.setSize(60, 28);
		prodajna_mjesta_izbor.setFont(new Font("Ariel", Font.BOLD, 14));
		prodajna_mjesta_izbor.setForeground(Color.black);
		tijelo.add(prodajna_mjesta_izbor);

		JButton potvrdi = new JButton("Dodaj trgovca");
		potvrdi.setBackground(bojaTrgovca);
		potvrdi.setForeground(Color.white);
		potvrdi.setSize(150, 50);
		potvrdi.setFont(new Font("Ariel", Font.BOLD, 18));
		potvrdi.setLocation(250, 310);
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String user_name = korisnicko_ime_unos.getText();
				String name = ime_unos.getText();
				String last_name = prezime_unos.getText();
				String password = "";
				for (int i = 0; i < sifra.getPassword().length; i++)
					password += sifra.getPassword()[i];
				if (user_name.equals("") || name.equals("") || last_name.equals("") || name.equals("")
						|| password.equals("") || prodajna_mjesta_izbor.getSelectedIndex() == -1)
					JOptionPane.showMessageDialog(registracija, "Molimo Vas da popunite obavezna polja", "Obavjestenje",
							JOptionPane.INFORMATION_MESSAGE);
				else if (Trgovac.vecPostojiTrgovac(user_name))
					JOptionPane.showMessageDialog(registracija,
							"U sistemu vec postoji trgovac sa tim korisnickim imenom", "Obavjestenje",
							JOptionPane.WARNING_MESSAGE);
				else {
					int id = Integer
							.parseInt(ProdajnoMjesto.idProdajnihMjesta()[prodajna_mjesta_izbor.getSelectedIndex()]);
					String pol = null;
					if (pol_izbor.getSelectedIndex() != -1)
						pol = polovi[pol_izbor.getSelectedIndex()];
					String mail = ime_unos.getText() + "." + prezime_unos.getText() + "@webshop-yu.org";
					if (BazaPodataka.dodajTrgovca(new Trgovac(Trgovac.generisiId(), user_name, name, last_name,
							Trgovac.getMd5(password), pol, telefon_unos.getText(), mail, id)))
						JOptionPane.showMessageDialog(registracija, "Novi trgovac je uspjesno kreiran", "Obavjestenje",
								JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(registracija, "Greska prilikom povezivanja sa bazom",
								"Obavjestenje", JOptionPane.ERROR_MESSAGE);
					registracija.dispose();
					azuriraj();
				}

			}
		});
		tijelo.add(potvrdi);

	}

	private void azuriraj() {
		BazaPodataka.pokreniBazu();
		korisnik.dispose();
		if (odabrano == 1)
			prikaziKupca();
		else if (odabrano == 2)
			prikaziTrgovca();
	}

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		} // Ukoliko nam look and feel nije uspio GUI se automatski bez njega, nema
			// potrebe da
			// hvatamo izuzetke
		Narudzba.citajZapamceneNarudzbe();
		BazaPodataka.pokreniBazu();
		new GUI();
	}

}