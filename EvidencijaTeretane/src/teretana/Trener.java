package teretana;

public class Trener extends Osoba {

    private String specijalnost;

    public Trener(String ime, String prezime, String specijalnost) {
        super(ime, prezime);
        setSpecijalnost(specijalnost);
    }

    public String getSpecijalnost() {
        return specijalnost;
    }

    public void setSpecijalnost(String specijalnost) {
        if (specijalnost == null || specijalnost.trim().isEmpty()) {
            throw new IllegalArgumentException("Specijalnost ne sme biti prazna!");
        }
        this.specijalnost = specijalnost;
    }

    @Override
    public void prikaziPodatke() {
        System.out.println("Trener: " + getIme() + " " + getPrezime());
        System.out.println("Specijalnost: " + specijalnost);
    }
}