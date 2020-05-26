package pl.pjatk;

import lombok.Data;

@Data
public class Kozak extends Adidas implements Buciki {
    private int dlugi;
    private int krotki;
    private int naObcasie;
    private int plaski;

    public Kozak(int rozmiar, int cena, String marka, String kolor) {
        super (rozmiar, cena, marka, kolor);
        this.dlugi = dlugi;
        this.krotki = krotki;
        this.naObcasie = naObcasie;
        this.plaski = plaski;

    }

    @Override
    public void ściągnięcieZPóki() {

    }

    @Override
    public void pakowanie() {

    }

    @Override
    public void odłożenieNaPółke() {

    }
}
