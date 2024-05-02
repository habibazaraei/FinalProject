import java.util.ArrayList;

public class Snake extends Animal {
    public Snake(String name, double weight, String favoriteFood) {
        super(name, weight, favoriteFood);
    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> snakes = new ArrayList<>();
        Snake snake0 = new Snake("Snake", 300, "Flies");
        Snake snake1 = new Snake("Officer", 350, "Spiders");
        Snake snake2 = new Snake("King", 309, "Flies");

        snakes.add(snake0.toString());
        snakes.add(snake1.toString());
        snakes.add(snake2.toString());

        return snakes;
    }
}
