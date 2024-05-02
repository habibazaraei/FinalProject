import java.util.ArrayList;

public class Monkey extends Animal {
    public Monkey(String name, double weight, String favoriteFood) {
        super(name, weight, favoriteFood);
    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> monkeys = new ArrayList<>();
        Monkey monkey0 = new Monkey("Obie", 300, "Everything");
        Monkey monkey1 = new Monkey("Officer", 350, "Bananas");
        Monkey monkey2 = new Monkey("King", 309, "Bananas");

        //add monkey0 to monkeys list
        monkeys.add(monkey0.toString());
        monkeys.add(monkey1.toString());
        monkeys.add(monkey2.toString());

        return monkeys;
    }
}
