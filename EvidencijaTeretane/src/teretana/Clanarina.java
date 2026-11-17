package teretana;

public class Clanarina implements Placanjem {

    private double iznos;
    private boolean placena;
    private Clan clan;

    public Clanarina(double iznos, Clan clan) {
        setIznos(iznos);
        setClan(clan);
        this.placena = false;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        if (iznos <= 0) {
            throw new IllegalArgumentException("Iznos mora biti veci od nule!");
        }
        this.iznos = iznos;
    }

    public boolean isPlacena() {
        return placena;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        if (clan == null) {
            throw new IllegalArgumentException("Clan ne sme biti null!");
        }
        this.clan = clan;
    }


    @Override
    public void izvrsiPlacanje(double iznos) {
    	if (placena) {
    		System.out.println("Clanarina je vec placena!");
    } else if (iznos < this.iznos) {
        	System.out.println("Nemate dovoljno novca za placanje!");
    } else {
        	placena = true;
        	System.out.println("Clanarina je uspesno placena!");
    }
}


    public void prikaziClanarinu() {
        System.out.println("Clan: " + clan.getIme() + " " + clan.getPrezime());
        System.out.println("Iznos: " + iznos + " dinara");
        System.out.println("Status: " + (placena ? "Placena" : "Nije placena"));
    }
}