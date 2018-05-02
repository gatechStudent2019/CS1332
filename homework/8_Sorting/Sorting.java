import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author gatechStudent
 * @userid none01
 * @GTID 903000000
 * @version 1
 */
public class Sorting {

    /**
     * Implement bubble sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("error: cannot use null "
                + "Comparator");
        }
        int i = 0;
        int j = arr.length - 1;
        boolean swapped = true;
        while (i < j && swapped) {
            swapped = false;
            for (int k = i; k < j; k++) {
                if (comparator.compare(arr[k], arr[k + 1]) > 0) {
                    T temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                    swapped = true;
                }
            }
            j--;
            if (swapped) {
                swapped = false;
                for (int k = j; k > i; k--) {
                    if (comparator.compare(arr[k], arr[k - 1]) < 0) {
                        T temp = arr[k];
                        arr[k] = arr[k - 1];
                        arr[k - 1] = temp;
                        swapped = true;
                    }
                }
            }
            i++;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     *  in-place
     *  stable
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("error: cannot use null "
                + "Comparator");
        }
        T temp;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(arr[j], arr[j - 1]) < 0) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    j = -1;
                }
            }
        }
    }

    /**
     * Implement selection sort.
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n^2)
     *
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * Note that there may be duplicates in the array.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("error: cannot use null "
                + "Comparator");
        }
        int minInd;
        for (int i = 0; i < arr.length; i++) {
            minInd = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minInd]) < 0) {
                    minInd = j;
                }
            }
            T temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * Implement quick sort.
     *
     * Use the provided random object to select your pivots.
     * For example if you need a pivot between a (inclusive)
     * and b (exclusive) where b > a, use the following code:
     *
     * int pivotIndex = rand.nextInt(b - a) + a;
     *
     * It should be:
     *  in-place
     *
     * Have a worst case running time of:
     *  O(n^2)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * Note that there may be duplicates in the array.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not use the one we have taught you!
     *
     * @throws IllegalArgumentException if the array or comparator or rand is
     * null
     * @param <T> data type to sort
     * @param arr the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @param rand the Random object used to select pivots
     */
    public static <T> void quickSort(T[] arr, Comparator<T> comparator,
                                     Random rand) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("error: cannont use null "
                + "Comparator");
        }
        if (rand == null) {
            throw new IllegalArgumentException("error: cannot use null Random");
        }
        quickSort(arr, 0, arr.length - 1, comparator, rand);
    }

    /**
     * QuickSort helper method, actually does the sorting
     *
     * @param  arr        the array that must be sorted after the method runs
     * @param  left       index for left T
     * @param  right      index for right T
     * @param  comparator the Comparator used to compare the data in arr
     * @param  rand       the Random object used to select pivots
     * @param  <T>        this is only for checkstyle
     */
    private static <T> void quickSort(T[] arr, int left, int right,
                                        Comparator<T> comparator, Random rand) {
        if (left >= right) {
            return;
        }
        int leftindex = left + 1;
        int rightindex = right;

        int pivotIndex = rand.nextInt(right - left) + left;

        T pivot = arr[pivotIndex];
        arr[pivotIndex] = arr[left];
        arr[left] = pivot;

        while (leftindex <= rightindex) {
            while (leftindex <= rightindex
                    && comparator.compare(arr[leftindex], pivot) <= 0) {
                leftindex++;
            }
            while (leftindex <= rightindex
                    && comparator.compare(arr[rightindex], pivot) >= 0) {
                rightindex--;
            }
            if (leftindex <= rightindex) {
                T temp = arr[leftindex];
                arr[leftindex] = arr[rightindex];
                arr[rightindex] = temp;
                leftindex++;
                rightindex--;
            }
        }
        T temp = arr[rightindex];
        arr[rightindex] = arr[left];
        arr[left] = temp;
        // if (left<rightindex) {
        quickSort(arr, left, rightindex - 1, comparator, rand);
        // }

        //if (right>leftindex) {
        quickSort(arr, rightindex + 1, right, comparator, rand);
        // }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(n log n)
     *
     * And a best case running time of:
     *  O(n log n)
     *
     * You may assume that the array doesn't contain any null elements.
     *
     * You can create more arrays to run mergesort, but at the end,
     * everything should be merged back into the original T[]
     * which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * @throws IllegalArgumentException if the array or comparator is null
     * @param <T> data type to sort
     * @param arr the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        if (comparator == null) {
            throw new IllegalArgumentException("error: cannont use null "
                + "Comparator");
        }
        if (arr.length > 1) {
            int middleindex = (int) (arr.length / 2);
            int leftsize = (int) (arr.length / 2);
            int rightsize = arr.length - leftsize;
            T[] leftarr = (T[]) new Object[leftsize];
            T[] rightarr = (T[]) new Object[rightsize];
            for (int i = 0; i < leftsize; i++) {
                leftarr[i] = arr[i];
            }
            for (int i = leftsize; i < arr.length; i++) {
                rightarr[i - leftsize] = arr[i];
            }
            mergeSort(leftarr, comparator);
            mergeSort(rightarr, comparator);
            int leftindex = 0;
            int rightindex = 0;
            int currentindex = 0;
            while (leftindex < middleindex
                    && rightindex < arr.length - middleindex) {
                if (comparator.compare(leftarr[leftindex],
                                       rightarr[rightindex]) <= 0) {
                    arr[currentindex] = leftarr[leftindex];
                    leftindex++;
                } else {
                    arr[currentindex] = rightarr[rightindex];
                    rightindex++;
                }
                currentindex++;
            }

            while (leftindex < middleindex) {
                arr[currentindex] = leftarr[leftindex];
                leftindex++;
                currentindex++;
            }
            while (rightindex < arr.length - middleindex) {
                arr[currentindex] = rightarr[rightindex];
                rightindex++;
                currentindex++;
            }
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     *  stable
     *
     * Have a worst case running time of:
     *  O(kn)
     *
     * And a best case running time of:
     *  O(kn)
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use {@code java.util.ArrayList} or {@code java.util.LinkedList}
     * if you wish, but it may only be used inside radix sort and any radix sort
     * helpers. Do NOT use these classes with other sorts.
     *
     * @throws IllegalArgumentException if the array is null
     * @param arr the array to be sorted
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("error: cannot sort null Array");
        }
        int maxNum = arr[0];
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > maxNum) {
                maxNum = Math.abs(arr[i]);
            }
        }
        while ((maxNum) >= 10) {
            maxLen++;
            maxNum = maxNum / 10;
        }
        List<Integer>[] buckets = new ArrayList[19];
        for (int i = 0; i < 19; i++) {
            buckets[i] = new ArrayList<>();
        }
        int divnumber = 1;

        for (int i = 0; i < maxLen; i++) {
            for (Integer num: arr) {
                buckets[((num / divnumber) % 10) + 9].add(num);
            }
            int index = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (Integer xx: buckets[j]) {
                    arr[index++] = xx;
                }
                buckets[j].clear();
            }
            divnumber = divnumber * 10;
        }
    }
}
