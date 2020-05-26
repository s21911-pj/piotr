package pl.pjatk;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@NoArgsConstructor // tworzy bezargumentowe puste konstruktory
public class Obuwniczy {

    private List<Obuwniczy> obuwie = new ArrayList<Obuwniczy> ();
    public List<Obuwniczy> findAll() {

        return this.obuwie;

    }
    public void addObuwie(int rozmiar,int cena, String marka, String kolor) {

        obuwie.add(new Obuwniczy ());

    }
    public void podajObuwie(int rozmiar,String klientNazwa) {

        Optional<Obuwniczy> optionalBut = findById(rozmiar);

        if (optionalBut.isPresent()) {

            System.out.println("Podaje " + optionalBut.get() + " klientowi " + klientNazwa);

            usunButy (rozmiar);

        } else {

            System.out.println("Niema takiego rozmiaru");

        }

    }
    public Optional<Obuwniczy> findById(int rozmiar) {

        return Obuwniczy.stream().filter(obuwniczy -> obuwie.get(rozmiar) == obuwie).findFirst();

    }
    public void usunButy(int rozmiar) {

        findById(rozmiar).ifPresentOrElse(

                obuwniczy -> obuwie.remove(obuwie),

                () -> System.out.println("Przykro nam nie posiadamy takiego rozmiaru")

        );

    }
    public void zlozZamowienie(List<Integer> ids, String customer) {

        List<Optional<Obuwniczy>> listOfButy = ids.stream().map(this::findById).collect(Collectors.toList());

        zamowButy(listOfButy, customer);

    }
    public void zamowButy(List<Optional<Obuwniczy>> zamowioneButy, String imieKlienta) {

        if (zamowioneButy.size() >= 47) {

            System.out.println("Sklep z kajakami dwie alejki dalej");

        } else {



            zamowioneButy.forEach(obuwniczy -> {

                if (obuwniczy.isPresent()) {

                    System.out.println("Podaj obuwie " + obuwie.get() + " dla " + imieKlienta);



                    usunButy (obuwniczy.get().getId()) ;

                } else {

                    System.out.println("Panie gdzie z takimi kopytami niema takich kajakow");

                }




            });

        }

    }

}

