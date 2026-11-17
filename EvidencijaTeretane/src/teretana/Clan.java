package teretana;

public class Clan extends Osoba {

    private int brojClanskeKarte;
    private boolean aktivan;

    public Clan(String ime, String prezime, int brojClanskeKarte) {
        super(ime, prezime);
        setBrojClanskeKarte(brojClanskeKarte);
        this.aktivan = true;
    }

    public int getBrojClanskeKarte() {
        return brojClanskeKarte;
    }

    public void setBrojClanskeKarte(int brojClanskeKarte) {
        if (brojClanskeKarte <= 0) {
            throw new IllegalArgumentException("Broj kartice mora biti pozitivan!");
        }
        this.brojClanskeKarte = brojClanskeKarte;
    }

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    @Override
    public void prikaziPodatke() {
        System.out.println("Clan: " + getIme() + " " + getPrezime());
        System.out.println("Broj kartice: " + brojClanskeKarte);
        System.out.println("Status: " + (aktivan ? "Aktivan" : "Neaktivan"));
    }
}