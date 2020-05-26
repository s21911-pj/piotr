package pl.pjatk;

import lombok.Data;

@Data
public class Sandal extends Adidas implements Buciki {
    private String skorzane;
    private String taniocha;


    public Sandal(int rozmiar, int cena, String marka, String kolor) {
        super (rozmiar, cena, marka, kolor);
        this.skorzane = skorzane;
        this.taniocha = taniocha;

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
