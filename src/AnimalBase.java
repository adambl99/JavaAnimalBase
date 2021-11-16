import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class AnimalBase {

    private ArrayList<Animal> animals;

    public AnimalBase() {
        animals = new ArrayList<>();
    }

    public void start() {
        UserInterface ui = new UserInterface(this);

        // TEST - REMOVE LATER!
        createNewAnimal("Bertil", "cute", "cat", 10);
        createNewAnimal("Abelone", "large", "elephant", 15);
        createNewAnimal("Crystal", "alternate", "alligator", 7);

        ui.start();
    }

    public static void main(String[] args) {
        AnimalBase app = new AnimalBase();
        app.start();
    }

    public Iterable<Animal> getAllAnimals() {
        return animals;
    }

    public void sortBy(String sort) {
        if (Objects.equals(sort, "name")) {
            Collections.sort(animals, new SortByName());
        } else if (Objects.equals(sort, "type")) {
            Collections.sort(animals, new SortByType());
        } else if (Objects.equals(sort, "age")) {
            Collections.sort(animals, new SortByAge());
        }
    }

    public void createNewAnimal(String name, String description, String type, int age) {
        Animal animal = new Animal(name, description, type, age);
        animals.add(animal);
    }

    public void deleteAnimal(String name) throws NonExistingAnimalException {
        // find animal with this name
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            throw new NonExistingAnimalException();
        } else {
            animals.remove(animal);
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }


    public void loadDatabase() {
        System.err.println("LOAD not yet implemented!");
    }

    public void saveDatabase() {
        System.err.println("SAVE not yet implemented!");
    }

}
