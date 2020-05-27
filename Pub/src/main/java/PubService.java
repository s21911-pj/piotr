import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;




public class PubService {
    private List<Beer> beerList = new ArrayList<>();
    public PubService() {

    }
    public List<Beer> findAll() {   //metoda findall ma zwracac lsitebeerlsit

        return this.beerList;

    }
    public void addBeer(int id, String name, int size) {  //metoda addbear dodaje piwo do listy

        beerList.add(new Beer(id, name, size));

    }
    public void beerServe(int id, String custommerName) { //??beerServe daje piwo wyszukane z id?

        Optional<Beer> optionalBeer = findById(id);

        if (optionalBeer.isPresent()) {  // jezeli piwo jest to podaj

            System.out.println("Serving " + optionalBeer.get() + " to " + custommerName);

            deleteBeer(id);

        } else {   //jak nie no to nie

            System.out.println("Beer not found");

        }

    }
    public Optional<Beer> findById(int id) { //??klasa OptionalBeer oddaje co??
        beerList.stream().forEach(beer -> {
        });
        return beerList.stream().filter(beer -> beer.getId() == id).findFirst();

    }
    public void deleteBeer(int id) { //??metoda deleteBeer wyszukuje piwo po id i usuwa z listy?

        findById(id).ifPresentOrElse(

                beer -> beerList.remove(beer),

                () -> System.out.println("Beer not found")

        );

    }
    public void createOrder(List<Integer> ids, String customer) {//składanie zamówienia przeszukuje??

        List<Optional<Beer>> listOfBeers = ids.stream().map(this::findById).collect(Collectors.toList());

        orderBeers(listOfBeers, customer);// a to co to jest?

    }
    public void orderBeers(List<Optional<Beer>> beersToOrder, String custommerName) {

        if (beersToOrder.size() >= 5) {

            System.out.println("Panu juz dziekujemy");

        } else {

            Table table = new Table();

            beersToOrder.forEach(beer -> {

                if (beer.isPresent()) {

                    System.out.println("Serving " + beer.get() + " to " + custommerName);

                    table.setClean(false);

                    deleteBeer(beer.get().getId());

                } else {

                    System.out.println("Beer not found");

                }




            });

        }

    }




}


