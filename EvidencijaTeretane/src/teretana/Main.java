package teretana;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner unos = new Scanner(System.in);
        Teretana teretana = new Teretana();

        int izbor;

        do {
            System.out.println("\n===== EVIDENCIJA TERETANE =====");
            System.out.println("1. Dodaj clana");
            System.out.println("2. Dodaj trenera");
            System.out.println("3. Prikazi sve osobe");
            System.out.println("4. Dodaj trening");
            System.out.println("5. Prikazi sve treninge");
            System.out.println("6. Plati clanarinu");
            System.out.println("7. Prikazi sve clanarine");
            System.out.println("8. Obrisi clana");
            System.out.println("0. Izlaz");
            System.out.print("Izaberite opciju: ");

            izbor = unos.nextInt();
            unos.nextLine();

            switch (izbor) {

            case 1:
                System.out.print("Ime clana: ");
                String ime = unos.nextLine();

                System.out.print("Prezime clana: ");
                String prezime = unos.nextLine();

                System.out.print("Broj clanske karte: ");
                int broj = unos.nextInt();
                unos.nextLine();

                Clan clan = new Clan(ime, prezime, broj);
                teretana.dodajOsobu(clan);

                System.out.println("Clan je uspesno dodat!");
                break;


case 2:
    System.out.print("Ime trenera: ");
    ime = unos.nextLine();

    System.out.print("Prezime trenera: ");
    prezime = unos.nextLine();

    System.out.println("Izaberite specijalnost trenera:");
    System.out.println("1. Fitness");
    System.out.println("2. Bodybuilding");
    System.out.println("3. Kardio");
    System.out.println("4. Funkcionalni trening");
    System.out.print("Izbor: ");

    int izborSpecijalnosti = unos.nextInt();
    unos.nextLine();

    String specijalnost="";

    switch (izborSpecijalnosti) {
        case 1:
            specijalnost = "Fitness";
            break;
        case 2:
            specijalnost = "Bodybuilding";
            break;
        case 3:
            specijalnost = "Kardio";
            break;
        case 4:
            specijalnost = "Funkcionalni trening";
            break;
        default:
            System.out.println("Nepostojeca specijalnost!");
            break;
    }

    if (izborSpecijalnosti < 1 || izborSpecijalnosti > 4) {
        break;
    }

    Trener trener = new Trener(ime, prezime, specijalnost);
    teretana.dodajOsobu(trener);

    System.out.println("Trener je uspesno dodat!");
    break;

            case 3:
                teretana.prikaziSveOsobe();
                break;



case 4:
    ArrayList<Trener> treneri = new ArrayList<>();

    for (Osoba osoba : teretana.getSveOsobe()) {
        if (osoba instanceof Trener) {
            treneri.add((Trener) osoba);
        }
    }

    if (treneri.isEmpty()) {
        System.out.println("Nema dodatih trenera! Prvo dodajte trenera.");
        break;
    }

    System.out.println("Izaberite vrstu treninga:");
    System.out.println("1. Trening grudi");
    System.out.println("2. Trening ledja");
    System.out.println("3. Trening nogu");
    System.out.println("4. Trening ramena");
    System.out.println("5. Trening ruku");
    System.out.println("6. Kardio trening");
    System.out.println("7. Full Body trening");
    System.out.print("Izbor: ");

    int izborTreninga = unos.nextInt();
    unos.nextLine();

    String naziv="";

    switch (izborTreninga) {
        case 1:
            naziv = "Trening grudi";
            break;
        case 2:
            naziv = "Trening ledja";
            break;
        case 3:
            naziv = "Trening nogu";
            break;
        case 4:
            naziv = "Trening ramena";
            break;
        case 5:
            naziv = "Trening ruku";
            break;
        case 6:
            naziv = "Kardio trening";
            break;
        case 7:
            naziv = "Full Body trening";
            break;
        default:
            System.out.println("Nepostojeca vrsta treninga!");
            break;
    }

    if (izborTreninga < 1 || izborTreninga > 7) {
        break;
    }

    System.out.print("Trajanje treninga u minutima: ");
    int trajanje = unos.nextInt();
    unos.nextLine();

    System.out.println("Izaberite trenera:");

    for (int i = 0; i < treneri.size(); i++) {
        System.out.println((i + 1) + ". " +
            treneri.get(i).getIme() + " " +
            treneri.get(i).getPrezime());
    }

    System.out.print("Izbor trenera: ");
    int izborTrenera = unos.nextInt();
    unos.nextLine();

    if (izborTrenera < 1 || izborTrenera > treneri.size()) {
        System.out.println("Pogresan izbor trenera!");
        break;
    }

    Trener izabraniTrener = treneri.get(izborTrenera - 1);

    Trening trening = new Trening(naziv, trajanje, izabraniTrener);
    teretana.dodajTrening(trening);

    System.out.println("Trening je uspesno dodat!");
    break;



            case 5:
                teretana.prikaziSveTreninge();
                break;



            case 6:
            		System.out.print("Unesite broj clanske karte: ");
            		int brojKarte = unos.nextInt();
            			Clan izabraniClan = null;

            			for (Osoba osoba : teretana.getSveOsobe()) {
            				if (osoba instanceof Clan) {
            					Clan c = (Clan) osoba;

            					if (c.getBrojClanskeKarte() == brojKarte) {
            						izabraniClan = c;
                break;
            }
        }
    }

            			if (izabraniClan == null) {
            				System.out.println("Clan nije pronadjen!");
    } 	else {
        boolean vecPlatio = false;

        for (Clanarina c : teretana.getSveClanarine()) {
            if (c.getClan() == izabraniClan && c.isPlacena()) {
                vecPlatio = true;
                break;
            }
        }

        	if (vecPlatio) {
        		System.out.println("Ovaj clan vec ima placenu clanarinu!");
        } else {
            	System.out.print("Unesite iznos clanarine: ");
            double iznos = unos.nextDouble();

            Clanarina clanarina = new Clanarina(iznos, izabraniClan);

            	System.out.print("Unesite iznos koji placate: ");
            double uplata = unos.nextDouble();

            clanarina.izvrsiPlacanje(uplata);

            if (uplata >= iznos) {
                teretana.dodajClanarinu(clanarina);
                clanarina.prikaziClanarinu();
            } else {
                System.out.println("Uplata nije dovoljna! Clanarina nije evidentirana.");
            }
        }
    }

    break;


            	
            case 7:
                teretana.prikaziSveClanarine();
                break;
                
            case 8:
                System.out.print("Unesite broj clanske karte: ");
                int brojZaBrisanje = unos.nextInt();

                teretana.obrisiClana(brojZaBrisanje);
                break;

            case 0:
                System.out.println("Hvala na koriscenju aplikacije!");
                break;

            default:
                System.out.println("Nepostojeca opcija!");
            }

        } while (izbor != 0);

        unos.close();
    }

   
}