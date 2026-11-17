package teretana;

public class Trening {

    private String naziv;
    private int trajanje;
    private Trener trener;

    public Trening(String naziv, int trajanje, Trener trener) {
        setNaziv(naziv);
        setTrajanje(trajanje);
        setTrener(trener);
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if (naziv == null || naziv.trim().isEmpty()) {
            throw new IllegalArgumentException("Naziv ne sme biti prazan!");
        }
        this.naziv = naziv;
    }

    public int getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(int trajanje) {
        if (trajanje <= 0) {
            throw new IllegalArgumentException("Trajanje mora biti vece od nule!");
        }
        this.trajanje = trajanje;
    }

    public Trener getTrener() {
        return trener;
    }

    public void setTrener(Trener trener) {
        if (trener == null) {
            throw new IllegalArgumentException("Trener ne sme biti null!");
        }
        this.trener = trener;
    }

    public void prikaziTrening() {
        System.out.println("Naziv treninga: " + naziv);
        System.out.println("Trajanje: " + trajanje + " minuta");
        System.out.println("Trener: " + trener.getIme() + " " + trener.getPrezime());
    }
}