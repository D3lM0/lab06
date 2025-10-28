package it.unibo.collections;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100000;
    private static final int TIMES = 1000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> integerArrayList = new ArrayList<>();
        for (int i = 1000; i <= 2000; i++) {
            integerArrayList.add(i);
        }       
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> integerLinkedList = new LinkedList<>(integerArrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int firstIndex = 0;
        int firstElementArrayList = integerArrayList.getFirst();
        int lastElementArrayList = integerArrayList.getLast();

        integerArrayList.set(firstIndex, lastElementArrayList);
        integerArrayList.set(integerArrayList.size() - 1, firstElementArrayList);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int elem : integerArrayList) {
            System.out.println(elem);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long startAL = System.nanoTime();
         
        for (int i = 0; i <= ELEMS; i++) {
            int ranNumber = new Random().nextInt();
            integerArrayList.addFirst(ranNumber);
        }

        long deltaAL = System.nanoTime() - startAL;
        final var millisAL = TimeUnit.NANOSECONDS.toMillis(deltaAL);
        System.out.println(
            "Inserting "
                + ELEMS
                + "elements in an ArrayList took"
                + deltaAL
                + "ns ("
                + millisAL
                + "ms)"
        );
        long startLL = System.nanoTime();

        for (int i = 0; i <= ELEMS; i++) {
            int ranNumber = new Random().nextInt();
            integerArrayList.addFirst(ranNumber);
            integerLinkedList.addFirst(ranNumber);
        }

        long deltaLL = System.nanoTime() - startLL;
        final var millisLL = TimeUnit.NANOSECONDS.toMillis(deltaLL);
        System.out.println(
            "Inserting "
                + ELEMS
                + "elements in a LinkedList took"
                + deltaLL
                + "ns ("
                + millisLL
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        int middleIndexAL = integerArrayList.size() / 2;
        int middleIndexLL = integerLinkedList.size() / 2;
        
        long startAL2 = System.nanoTime();
        for (int i = 0; i < TIMES; i++) {
            integerArrayList.get(middleIndexAL);
        }
        
        long deltaAL2 = System.nanoTime() - startAL2;
        final var millisAL2 = TimeUnit.NANOSECONDS.toMillis(deltaAL2);
          System.out.println(
            "Reading middle element in an ArrayList " + TIMES + "times took"
                + deltaAL2
                + "ns ("
                + millisAL2
                + "ms)"
          );

        long startLL2 = System.nanoTime();
        for (int i = 0; i < TIMES; i++) {
            integerLinkedList.get(middleIndexLL);
        }
        
        long deltaLL2 = System.nanoTime() - startLL2;
        final var millisLL2 = TimeUnit.NANOSECONDS.toMillis(deltaLL2);
          System.out.println(
            "Reading middle element in an ArrayList " + TIMES + "times took"
                + deltaLL
                + "ns ("
                + millisLL2
                + "ms)"
        );
        

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

        final Map<String, Long> continentsMap = new HashMap<>();

        continentsMap.put("Africa", 1_110_635_000L);
        continentsMap.put("Americas", 972_005_000L);
        continentsMap.put("Antarctica", 0L);
        continentsMap.put("Asia", 4_298_723_000L);
        continentsMap.put("Europe", 742_452_000L);
        continentsMap.put("Oceania", 38_304_000L);

        /*
         * 8) Compute the population of the world
         */
        final long worldPopulation = 0;

        for (Long continentPopulation : continentsMap) {
            
        }
    }
}
