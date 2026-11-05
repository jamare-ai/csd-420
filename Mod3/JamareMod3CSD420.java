import java.util.ArrayList;
import java.util.Random;

public class JamareMod3CSD420 {

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {

        ArrayList<E> newList = new ArrayList<>();

        for (E item : list) {
            if (!newList.contains(item)) {
                newList.add(item);
            }
        }

        return newList;
    }

    public static void main(String[] args) {

        ArrayList<Integer> originalList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < 50; i++) {
            originalList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Original List:");
        System.out.println(originalList);

        ArrayList<Integer> noDuplicates =
                removeDuplicates(originalList);

        System.out.println("\nList With No Duplicates:");
        System.out.println(noDuplicates);
    }
}
