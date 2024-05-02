import java.util.ArrayList;

public class Zebra extends Animal {
    public Zebra(String name, double weight, String favoriteFood) {
        super(name, weight, favoriteFood);
    }

    @Override
    public ArrayList<String> getAll() {
        ArrayList<String> zebras = new ArrayList<>();
        Zebra zebra0 = new Zebra("Stripes", 300, "Grass");
        Zebra zebra1 = new Zebra("Donut", 350, "Frosting");
        Zebra zebra2 = new Zebra("Lavender", 309, "Leaves");

        zebras.add(zebra0.toString());
        zebras.add(zebra1.toString());
        zebras.add(zebra2.toString());

        return zebras;
    }
}
