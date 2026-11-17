package teretana;

import java.util.ArrayList;

public class Teretana {

    private ArrayList<Osoba> osobe;
    private ArrayList<Trening> treninzi;
    private ArrayList<Clanarina> clanarine;

    public Teretana() {
        osobe = new ArrayList<>();
        treninzi = new ArrayList<>();
        clanarine = new ArrayList<>();
    }

    public void dodajOsobu(Osoba osoba) {
        if (osoba == null) {
            throw new IllegalArgumentException("Osoba ne sme biti null!");
        }
        osobe.add(osoba);
    }
    
    public ArrayList<Clanarina> getSveClanarine() {
        return clanarine;
    }
    
    public ArrayList<Osoba> getSveOsobe() {
        return osobe;
    }

    public void dodajTrening(Trening trening) {
        if (trening == null) {
            throw new IllegalArgumentException("Trening ne sme biti null!");
        }
        treninzi.add(trening);
    }

    public void prikaziSveOsobe() {
        for (Osoba osoba : osobe) {
            osoba.prikaziPodatke();
            System.out.println("--------------------");
        }
    }

    public void prikaziSveTreninge() {
        for (Trening trening : treninzi) {
            trening.prikaziTrening();
            System.out.println("--------------------");
        }
    }
    public void dodajClanarinu(Clanarina clanarina) {
        if (clanarina == null) {
            throw new IllegalArgumentException("Clanarina ne sme biti null!");
        }
        clanarine.add(clanarina);
    }

    public void prikaziSveClanarine() {
        for (Clanarina clanarina : clanarine) {
            clanarina.prikaziClanarinu();
            System.out.println("--------------------");
        }
    }
    
    public void obrisiClana(int brojKarte) {
        for (int i = 0; i < osobe.size(); i++) {
            Osoba osoba = osobe.get(i);

            if (osoba instanceof Clan) {
                Clan clan = (Clan) osoba;

                if (clan.getBrojClanskeKarte() == brojKarte) {
                    osobe.remove(i);
                    System.out.println("Clan je uspesno obrisan!");
                    return;
                }
            }
        }

        System.out.println("Clan nije pronadjen!");
    }
}