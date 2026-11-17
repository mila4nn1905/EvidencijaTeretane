package teretana;

public abstract class Osoba {

    private String ime;
    private String prezime;

    public Osoba(String ime, String prezime) {
        setIme(ime);
        setPrezime(prezime);
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        if (ime == null || ime.trim().isEmpty()) {
            throw new IllegalArgumentException("Ime ne sme biti prazno!");
        }
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        if (prezime == null || prezime.trim().isEmpty()) {
            throw new IllegalArgumentException("Prezime ne sme biti prazno!");
        }
        this.prezime = prezime;
    }

    public abstract void prikaziPodatke();
}