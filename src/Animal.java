import java.util.ArrayList;

public abstract class Animal {
    private String name;
    private double weight;
    private String favoriteFood;

    //Constructor for each animal creation
    public Animal(String name, double weight, String favoriteFood) {
        this.name = name;
        this.weight = weight;
        this.favoriteFood = favoriteFood;
    }


    /**
     *  This method overrides the java defines method and
     *  helps display the data for each animal in the list
     *
     */
    @Override
    public String toString() {
        return "Animal " +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", favoriteFood='" + favoriteFood + '\'' +
                '!';
    }

    /**Each instance of animal (lion,zebra,snake,monkey) has a get all method implementation/definition which handles
     * populating the list of that animals we have and using that to display on the GUI */
    public abstract ArrayList<String> getAll();
}
