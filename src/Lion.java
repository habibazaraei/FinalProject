import java.util.ArrayList;

public class Lion extends Animal {
    public Lion(String name, double weight, String favoriteFood) {
        super(name, weight, favoriteFood);
    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> lions = new ArrayList<>();
        Lion lion0 = new Lion("Liony", 300, "Zebras");
        Lion lion1 = new Lion("Richie", 350, "Salad");
        Lion lion2 = new Lion("Glitter", 309, "Fish");

        lions.add(lion0.toString());
        lions.add(lion1.toString());
        lions.add(lion2.toString());

        return lions;
    }
}
