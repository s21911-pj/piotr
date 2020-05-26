package pl.pjatk;
import lombok.Data;


@Data  //lombok - @Data - wszystkie gettey, settery, konstruktory (defaultowy i z argumentami) są "w tle"
 public class Adidas implements Buciki {
    private int rozmiar;
    private int cena;
    private String marka;
    private String kolor;

    public Adidas(int rozmiar, int cena, String marka, String kolor) {
        this.rozmiar = rozmiar;
        this.cena = cena;
        this.marka = marka;
        this.kolor = kolor;
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
