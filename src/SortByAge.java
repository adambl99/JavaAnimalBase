import java.util.Comparator;

public class SortByAge implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2){
        Integer o1Age = o1.getAge();
        return o1Age.compareTo(o2.getAge());
    }
}
