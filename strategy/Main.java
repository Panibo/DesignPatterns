import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = generateRandomArray(smallSize);
        int[] largeArray = generateRandomArray(largeSize);

        Sorter sorter = new Sorter();

        System.out.println("===== SMALL DATASET (" + smallSize + " elements) =====");
        testSorting(sorter, new BubbleSort(), smallArray);
        testSorting(sorter, new MergeSort(), smallArray);
        testSorting(sorter, new QuickSort(), smallArray);

        System.out.println("\n===== LARGE DATASET (" + largeSize + " elements) =====");
        testSorting(sorter, new BubbleSort(), largeArray);
        testSorting(sorter, new MergeSort(), largeArray);
        testSorting(sorter, new QuickSort(), largeArray);
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }

    private static void testSorting(Sorter sorter, SortStrategy strategy, int[] originalArray) {

        int[] arrayCopy = Arrays.copyOf(originalArray, originalArray.length);

        sorter.setStrategy(strategy);

        long startTime = System.nanoTime();
        sorter.sort(arrayCopy);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println(strategy.getClass().getSimpleName()
                + ": " + duration + " nanoseconds");
    }
}
