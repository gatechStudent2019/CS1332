import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.DisableOnDebug;
import org.junit.rules.ExpectedException;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * JUnits for homework 8. Uses JUnit4, including hamcrest (a separate jar file
 * if you are running junit tests from the command line). Download here if you
 * only have junit-4.12.jar: goo.gl/iKsGhF
 * The hamcrest jar comes automatically with JUnit4 on Intellij so most people
 * don't need to worry about this.
 *
 * If you wish to test your own array, you can add your own String arrays inside
 * the setUp() method. If you do decide to use your own arrays, change the
 * COUNT_COMPS variable to false so that there won't be an IndexOutOfBounds
 * exception.
 *
 * From V3.0:
 * If you set OVERKILL to true and COUNT_COMPS to false, this will generate 1000
 * random arrays to test instead of the regular cases provided. Does not do
 * comparison checks in these cases.
 * (inspired by Sergey's tester)
 *
 * If you find an error with this, you can comment on my Piazza post so I can
 * fix it ASAP.
 * @author Shishir Bhat
 * @version 4.1
 * @since 3/30/18
 */
public final class ShishirSortingTests {

    private StringHolder[][][] arrays;
    private Map<String, List<Integer>> comparisons;
    private ComparatorPlus<StringHolder> comp;


    // Change this to false if you are testing a custom array to sort, or using
    // the OVERKILL option
    private static final boolean COUNT_COMPS = true;

    //Change this to true if you want to just test 1000 random arrays
    //If using this option, COUNT_COMPS must be false
    private static final boolean OVERKILL = false;

    private static final String ARRAYS_UNEQUAL = "Array was not sorted "
            + "correctly. ";
    private static final String INCORRECT_COUNT = "Comparisons count was off. "
            + "Make sure you are using the algorithm we learned in class. ";
    private static final String UNSTABLE = "Sort was detected to be unstable. "
            + "Make sure you are using the algorithm we learned in class. ";
    private static final String TOO_MANY_PIVOTS = "You tried to find a pivot "
            + "too often with your Random object. I don't think this is being "
            + "graded, but it could mean an underlying issue with the "
            + "efficiency of your algorithm. ";
    private static final String SORTING_MSG = "Tried to sort: ";
    private String currentArray;

    @Rule
    public TestRule globalTimeout = new DisableOnDebug(
            Timeout.builder().withTimeout(2, TimeUnit.SECONDS).build());

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setUp() {
        comp = StringHolder.getComparatorPlus();

        String[][] temp = {
                // Regular array, odd number of elements - 0
                {"T", "H", "E", "Q", "U", "I", "C", "K", "B", "R", "O", "W",
                        "N", "F", "O", "X", "T"},
                // Already sorted - 1
                {"A", "B", "C", "D", "E", "F", "G"},
                // Regular array, even number of elements - 2
                {"E", "V", "E", "N", "A", "R", "R", "A", "Y", "!"},
                // Single element - 3
                {"A"},
                // Empty array - 4
                {},
                // All the same value - 5
                {"M", "M", "M", "M", "M"},
                // Reverse order - 6
                {"G", "F", "E", "D", "C", "B", "A"}
        };
        if (OVERKILL) {
            assertThat("Set COUNT_COMPS to false if using OVERKILL",
                    COUNT_COMPS, is(false));
            temp = new String[1000][];
            Arrays.setAll(temp, i -> randomStringArray());
        }
        String[][] unsortedArrays = temp;
        // My approximate comparison counts
        List<Integer> bubble = Arrays.asList(120, 6, 45, 0, 0, 5, 20);
        List<Integer> insertion = Arrays.asList(65, 6, 30, 0, 0, 5, 20);
        List<Integer> selection = Arrays.asList(135, 20, 45, 0, 0, 10, 20);
        List<Integer> merge = Arrays.asList(50, 10, 25, 0, 0, 6, 10);
        List<Integer> quick = Arrays.asList(57, 15, 35, 0, 0, 10, 15);

        comparisons = new HashMap<>();
        comparisons.put("bubble", bubble);
        comparisons.put("insertion", insertion);
        comparisons.put("selection", selection);
        comparisons.put("merge", merge);
        comparisons.put("quick", quick);
        arrays = new StringHolder[unsortedArrays.length][2][];
        // Creates and places all the unsorted-sorted array pairs in arrays
        IntStream.range(0, unsortedArrays.length).forEach(i -> {
            StringHolder[] unsorted = toStringHolderArray(unsortedArrays[i]);
            StringHolder[] sorted = Arrays.copyOf(unsorted, unsorted.length);
            Arrays.sort(sorted, comp);
            arrays[i][0] = unsorted;
            arrays[i][1] = sorted;
        });
    }

    @Test
    public void testBubbleSort() {
        IntStream.range(0, arrays.length).forEach(i -> {
            comp = StringHolder.getComparatorPlus();
            StringHolder[] unsorted = arrays[i][0];
            StringHolder[] sorted = arrays[i][1];
            currentArray = Arrays.toString(unsorted);
            StabilityChecker<StringHolder> stability =
                    new StabilityChecker<>(unsorted);
            Sorting.bubbleSort(unsorted, comp);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
            if (COUNT_COMPS) {
                assertThat(INCORRECT_COUNT + SORTING_MSG + currentArray,
                        comp.count(),
                        is(around(comparisons.get("bubble").get(i))));
            }
            assertThat(UNSTABLE + SORTING_MSG + currentArray,
                    stability.remainsStable(unsorted), is(true));
        });
    }

    @Test
    public void testInsertionSort() {
        IntStream.range(0, arrays.length).forEach(i -> {
            comp = StringHolder.getComparatorPlus();
            StringHolder[] unsorted = arrays[i][0];
            StringHolder[] sorted = arrays[i][1];
            currentArray = Arrays.toString(unsorted);
            StabilityChecker<StringHolder> stability =
                    new StabilityChecker<>(unsorted);
            Sorting.insertionSort(unsorted, comp);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
            if (COUNT_COMPS) {
                assertThat(INCORRECT_COUNT + SORTING_MSG + currentArray,
                        comp.count(),
                        is(around(comparisons.get("insertion").get(i))));
            }
            assertThat(UNSTABLE + SORTING_MSG + currentArray,
                    stability.remainsStable(unsorted), is(true));
        });
    }

    @Test
    public void testSelectionSort() {
        IntStream.range(0, arrays.length).forEach(i -> {
            comp = StringHolder.getComparatorPlus();
            StringHolder[] unsorted = arrays[i][0];
            StringHolder[] sorted = arrays[i][1];
            currentArray = Arrays.toString(unsorted);
            Sorting.selectionSort(unsorted, comp);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
            if (COUNT_COMPS) {
                assertThat(INCORRECT_COUNT + SORTING_MSG + currentArray,
                        comp.count(),
                        is(around(comparisons.get("selection").get(i))));
            }
        });
    }

    @Test
    public void testQuickSort() {
        int[] pivotCounts = {11, 5, 7, 0, 0, 4, 4};
        IntStream.range(0, arrays.length).forEach(i -> {
            comp = StringHolder.getComparatorPlus();
            RandomCounter pivotCounter = new RandomCounter(0b10100110011L);
            StringHolder[] unsorted = arrays[i][0];
            StringHolder[] sorted = arrays[i][1];
            currentArray = Arrays.toString(unsorted);
            Sorting.quickSort(unsorted, comp, pivotCounter);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
            if (COUNT_COMPS) {
                assertThat(INCORRECT_COUNT + SORTING_MSG + currentArray,
                        comp.count(),
                        is(around(comparisons.get("quick").get(i))));
                assertThat(TOO_MANY_PIVOTS + SORTING_MSG + currentArray,
                        pivotCounter.count(),
                        is(around(pivotCounts[i])));
            }
        });
    }

    @Test
    public void testMergeSort() {
        IntStream.range(0, arrays.length).forEach(i -> {
            comp = StringHolder.getComparatorPlus();
            StringHolder[] unsorted = arrays[i][0];
            StringHolder[] sorted = arrays[i][1];
            currentArray = Arrays.toString(unsorted);
            StabilityChecker<StringHolder> stability =
                    new StabilityChecker<>(unsorted);
            Sorting.mergeSort(unsorted, comp);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
            if (COUNT_COMPS) {
                assertThat(INCORRECT_COUNT + SORTING_MSG + currentArray,
                        comp.count(),
                        is(around(comparisons.get("merge").get(i))));
            }
            assertThat(UNSTABLE + SORTING_MSG + currentArray,
                    stability.remainsStable(unsorted), is(true));
        });
    }

    @Test
    public void testRadixSort() {
        int[][] temp = {
                {4, 5, 123, 100000, 9999, 34, -2, -2000000},
                {1, 2, 3, 4, 5, 6},
                {100, 200, 3, 400, 500, 600},
                {6, 500, 4, 3, 2, 1},
                {123, 654, 789},
                {},
                {1},
                {1, 1, 1, 1, 1},
                {-300000, 1, -600000, 300, 10}
        };
        if (OVERKILL) {
            assertThat("Set COUNT_COMPS to false if using OVERKILL",
                    COUNT_COMPS, is(false));
            temp = new int[1000][];
            Arrays.setAll(temp, i -> randomIntArray());
        }
        int[][] intArrays = temp;
        IntStream.range(0, intArrays.length).forEach(i -> {
            int[] unsorted = intArrays[i];
            int[] sorted = Arrays.copyOf(unsorted, unsorted.length);
            Arrays.sort(sorted);
            currentArray = Arrays.toString(unsorted);
            Sorting.lsdRadixSort(unsorted);
            assertThat(ARRAYS_UNEQUAL + SORTING_MSG + currentArray,
                    unsorted, is(equalTo(sorted)));
        });
    }

    //-------------------------------------------------
    //---------------Exception Testing-----------------
    //-------------------------------------------------

    @Test
    public void testBubbleExceptions1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.bubbleSort(null, comp);
    }

    @Test
    public void testBubbleExceptions2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.bubbleSort(new String[]{"a"}, null);
    }

    @Test
    public void testInsertionExceptions1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.insertionSort(null, comp);
    }

    @Test
    public void testInsertionExceptions2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.insertionSort(new String[]{"a"}, null);
    }

    @Test
    public void testSelectionExceptions1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.selectionSort(null, comp);
    }

    @Test
    public void testSelectionExceptions2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.selectionSort(new String[]{"a"}, null);
    }

    @Test
    public void testQuickExceptions1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.quickSort(null, comp, new Random());
    }

    @Test
    public void testQuickExceptions2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.quickSort(new String[]{"a"}, null, new Random());
    }

    @Test
    public void testQuickExceptions3() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.quickSort(new String[]{"a"}, Comparator.naturalOrder(),
                null);
    }

    @Test
    public void testMergeExceptions1() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.mergeSort(null, comp);
    }

    @Test
    public void testMergeExceptions2() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.mergeSort(new String[]{"a"}, null);
    }

    @Test
    public void testRadixExceptions() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage(is(not(nullValue(String.class))));
        Sorting.lsdRadixSort(null);
    }

    //-------------------------------------------------
    //---------------Tests stop here-------------------
    //-------------------------------------------------


    /**
     * Creates a Matcher object that tests if a number is with 5 of the input
     * @param middle The number to compare to
     * @return A Matcher for approximations
     */
    private static Matcher<Integer> around(int middle) {
        return new BaseMatcher<Integer>() {
            @Override
            public boolean matches(Object o) {
                int x = (Integer) o;
                return x >= 0 && x <= middle + 5;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("around %d", middle));
            }
        };
    }

    /**
     * Used in {@code setUp()} to easily make an array to sort.
     * @param strings String values of the StringHolders
     * @return The StringHolder array
     */
    private StringHolder[] toStringHolderArray(String ... strings) {
        return Arrays.stream(strings)
                .map(StringHolder::new)
                .toArray(StringHolder[]::new);
    }

    /**
     * Generates a random string of size 0 - 9
     * @return The string
     */
    private String randomString() {
        Random rand = new Random();
        return IntStream.range(0, rand.nextInt(10))
                .mapToObj(i -> String.valueOf(Math.random() < 0.5
                        ? (char) (rand.nextInt('z' - 'a') + 'a')
                        : Character.toUpperCase(
                        (char) (rand.nextInt('z' - 'a') + 'a'))))
                .collect(Collectors.joining());
    }

    /**
     * Uses {@code randomString} to make a random array of strings
     * @return The array of Strings
     */
    private String[] randomStringArray() {
        return IntStream.range(0, 10)
                .mapToObj(i -> randomString())
                .toArray(String[]::new);
    }

    /**
     * Generates a random array of ints of size 20
     * @return The random int array
     */
    private int[] randomIntArray() {
        return new Random().ints(20).toArray();
    }

    private final class RandomCounter extends Random {
        private int count;

        /**
         * Gets the amount of time nextInt() has been called
         * @return the call count
         */
        private int count() {
            return count;
        }

        @Override
        public int nextInt(int a) {
            count++;
            return super.nextInt(a);
        }

        /**
         * Creates a new RandomCounter with a given seed
         * @param seed the seed onf the randomizer
         */
        private RandomCounter(long seed) {
            super(seed);
        }
    }

    /**
     * Class that checks the stability of an array being sorted. Constructor
     * takes in an unsorted array. {@code remainsStable()} can be called on any
     * sorted array to check if the equal elements in the original array are in
     * the same order in the sorted array.
     * @param <T> The type of the elements in the array
     */
    private static final class StabilityChecker<T extends Identifiable> {
        private Map<T, List<T>> map;

        /**
         * Populates a Map with {@code T} objects. The keys are the first
         * occurrences of the objects and the values are Lists that hold any
         * equal occurrence of the key (including the key) in the order they
         * appeared in the array.
         * @param input An unsorted array.
         */
        private StabilityChecker(T[] input) {
            map = new HashMap<>();
            Arrays.stream(input).forEachOrdered(x -> {
                if (!map.containsKey(x)) {
                    map.put(x, new LinkedList<>());
                }
                map.get(x).add(x);
            });
            filterMap();
        }

        /**
         * Removes from the map Objects that only appear once.
         */
        private void filterMap() {
            map = map.entrySet().stream()
                    .filter(x -> x.getValue().size() > 1)
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue));
        }

        /**
         * Checks if the parameter array has equal elements in the same order
         * as the initial array
         * @param sortedArray The array to check against the original
         * @return true if the equal elements stayed in the same order, false
         * otherwise
         */
        private boolean remainsStable(T[] sortedArray) {
            for (Map.Entry<T, List<T>> x: map.entrySet()) {
                int ind = -1;
                for (T val : x.getValue()) {
                    ind = getNextIndex(sortedArray, ind + 1, val);
                    if (val.id() != sortedArray[ind].id()) {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         * Finds the first occurrence of an object in the array
         * @param arr The array to search through
         * @param startIndex The index to start searching from
         * @param data The data to find
         * @return The index of the found data
         */
        private int getNextIndex(T[] arr, int startIndex, T data) {
            return IntStream.range(startIndex, arr.length)
                    .filter(i -> Objects.equals(arr[i], data))
                    .findFirst()
                    .orElseThrow(AssertionError::new);
        }
    }

    /**
     * Implement this interface to have a class that works with StabilityChecker
     */
    private interface Identifiable {
        /**
         * Any class that implements this interface should return a unique
         * id for any call to {@code id()} on a unique object. Object id should
         * remain the same during the same program session
         * @return the id of the object
         */
        int id();
    }

    /**
     * A class that wraps around a String and has a unique id. Used in place of
     * Strings because Strings are not extendable and because StringHolders have
     * no natural ordering.
     */
    private static final class StringHolder implements Identifiable {
        private final String s;
        private final int id;

        private static final Random RANDOMIZER = new Random();

        @Override
        public int id() {
            return id;
        }

        /**
         * Gets the string value of the StringHolder
         * @return The string value of the StringHolder
         */
        private String s() {
            return s;
        }

        /**
         * Creates a new StringHolder and assigns it a random id
         * @param s The String value of the StringHolder
         */
        private StringHolder(String s) {
            this.s = s;
            id = RANDOMIZER.nextInt();
        }

        /**
         * Gets the corresponding ComparatorPlus of StringHolder
         * @return A ComparatorPlus for StringHolders
         */
        private static ComparatorPlus<StringHolder> getComparatorPlus() {
            return new ComparatorPlus<>(Comparator.nullsFirst(
                    Comparator.comparing(StringHolder::s)));
        }

        @Override
        public boolean equals(Object other) {
            return this == other || other instanceof StringHolder
                    && Objects.equals(s, ((StringHolder) other).s);
        }

        @Override
        public String toString() {
            return Objects.toString(s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }

    /**
     * Wraps a comparator to provide a comparison count
     * @param <T> The type of the comparator
     */
    private static final class ComparatorPlus<T> implements Comparator<T> {
        private int count;

        private final Comparator<T> t;

        /**
         * Creates a new ComparatorPlus
         * @param compare The Comparator that this object wraps around
         */
        private ComparatorPlus(Comparator<T> compare) {
            this.t = compare;
        }

        @Override
        public int compare(T o1, T o2) {
            count++;
            return t.compare(o1, o2);
        }

        /**
         * Get the number of comparisons made.
         * @return number of comparisons made
         */
        private int count() {
            return count;
        }
    }
}