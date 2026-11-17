package teretana;

import java.util.Scanner;

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

                System.out.print("Specijalnost trenera: ");
                String specijalnost = unos.nextLine();

                Trener trener = new Trener(ime, prezime, specijalnost);
                teretana.dodajOsobu(trener);

                System.out.println("Trener je uspesno dodat!");
                break;

            case 3:
                teretana.prikaziSveOsobe();
                break;

            case 4:
                System.out.print("Naziv treninga: ");
                String naziv = unos.nextLine();

                System.out.print("Trajanje treninga u minutima: ");
                int trajanje = unos.nextInt();
                unos.nextLine();

                System.out.print("Ime trenera koji vodi trening: ");
                String imeTrenera = unos.nextLine();

                System.out.print("Prezime trenera: ");
                String prezimeTrenera = unos.nextLine();

                Trener izabraniTrener = null;

                for (Osoba osoba : getOsobe(teretana)) {
                    if (osoba instanceof Trener &&
                        osoba.getIme().equalsIgnoreCase(imeTrenera) &&
                        osoba.getPrezime().equalsIgnoreCase(prezimeTrenera)) {

                        izabraniTrener = (Trener) osoba;
                        break;
                    }
                }

                if (izabraniTrener != null) {
                    Trening trening = new Trening(naziv, trajanje, izabraniTrener);
                    teretana.dodajTrening(trening);
                    System.out.println("Trening je uspesno dodat!");
                } else {
                    System.out.println("Trener nije pronadjen!");
                }
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
            	} else {
            	    System.out.print("Unesite iznos clanarine: ");
            	    double iznos = unos.nextDouble();

            	    Clanarina clanarina = new Clanarina(iznos, izabraniClan);

            	    System.out.print("Unesite iznos koji placate: ");
            	    double uplata = unos.nextDouble();

            	    clanarina.izvrsiPlacanje(uplata);
            	    teretana.dodajClanarinu(clanarina);
            	    clanarina.prikaziClanarinu();
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

    private static java.util.ArrayList<Osoba> getOsobe(Teretana teretana) {
        return teretana.getSveOsobe();
    }
}