package edu.grinnell.sortingvisualizer.sorts;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sorts.Sorts;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.JUnitCore;

public class SortsTest {
    //These look dumb but they are constants and have a verified input. In addition all sorting algorithms can use these and we can later modify this test suite by comparing algorithms to each other.
    private Integer [] sorted    = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
    private Integer [] testCase1 = {6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59, 62, 65, 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 85, 88, 91, 94, 97, 0, 3};
    private Integer [] testCase2 = {12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 0, 2, 4, 6, 8, 10};
    private Integer [] allTheSame = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
    private Integer [] reverseSorted = {99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; 
    private Integer [] sortedResult =    {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
    private Integer [] testCase1Result = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
    private Integer [] testCase2Result = {0, 0, 2, 2, 4, 4, 6, 6, 8, 8, 10, 10, 12, 12, 14, 14, 16, 16, 18, 18, 20, 20, 22, 22, 24, 24, 26, 26, 28, 28, 30, 30, 32, 32, 34, 34, 36, 36, 38, 38, 40, 40, 42, 42, 44, 44, 46, 46, 48, 48, 50, 50, 52, 52, 54, 54, 56, 56, 58, 58, 60, 60, 62, 62, 64, 64, 66, 66, 68, 68, 70, 70, 72, 72, 74, 74, 76, 76, 78, 78, 80, 80, 82, 82, 84, 84, 86, 86, 88, 88, 90, 90, 92, 92, 94, 94, 96, 96, 98, 98};
    //And, round 2.
    private Integer [] sorteda    = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
    private Integer [] testCase1a = {6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 2, 5, 8, 11, 14, 17, 20, 23, 26, 29, 32, 35, 38, 41, 44, 47, 50, 53, 56, 59, 62, 65, 68, 71, 74, 77, 80, 83, 86, 89, 92, 95, 98, 1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34, 37, 40, 43, 46, 49, 52, 55, 58, 61, 64, 67, 70, 73, 76, 79, 82, 85, 88, 91, 94, 97, 0, 3};
    private Integer [] testCase2a = {12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 0, 2, 4, 6, 8, 10};
    private Integer [] allTheSamea = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
    private Integer [] reverseSorteda = {99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88, 87, 86, 85, 84, 83, 82, 81, 80, 79, 78, 77, 76, 75, 74, 73, 72, 71, 70, 69, 68, 67, 66, 65, 64, 63, 62, 61, 60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    @Test
    public void insertionTest() {
        //Run the arrays through testing
        Sorts.insertionSort(sorted);
        Sorts.insertionSort(testCase1);
        Sorts.insertionSort(testCase2);
        Sorts.insertionSort(allTheSame);
        Sorts.insertionSort(reverseSorted);

        assertArrayEquals(sorted, sortedResult);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1Result);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2Result);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSame);//Edge case: all the same
        assertArrayEquals(reverseSorted, sortedResult);//Edge case: reverse
    }

    @Test
    public void selectionTest() {
        //Run the arrays through testing
        Sorts.selectionSort(sorted);
        Sorts.selectionSort(testCase1);
        Sorts.selectionSort(testCase2);
        Sorts.selectionSort(allTheSame);
        Sorts.selectionSort(reverseSorted);

        assertArrayEquals(sorted, sortedResult);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1Result);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2Result);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSame);//Edge case: all the same
        assertArrayEquals(reverseSorted, sortedResult);//Edge case: reverse
    }

    @Test
    public void mergeTest() {
        //Run the arrays through testing
        Sorts.mergeSort(sorted);
        Sorts.mergeSort(testCase1);
        Sorts.mergeSort(testCase2);
        Sorts.mergeSort(allTheSame);
        Sorts.mergeSort(reverseSorted);

        assertArrayEquals(sorted, sortedResult);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1Result);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2Result);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSame);//Edge case: all the same
        assertArrayEquals(reverseSorted, sortedResult);//Edge case: reverse
    }

    @Test
    public void quickTest() {
        //Run the arrays through testing
        Sorts.quickSort(sorted);
        Sorts.quickSort(testCase1);
        Sorts.quickSort(testCase2);
        Sorts.quickSort(allTheSame);
        Sorts.quickSort(reverseSorted);

        assertArrayEquals(sorted, sortedResult);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1Result);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2Result);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSame);//Edge case: all the same
        assertArrayEquals(reverseSorted, sortedResult);//Edge case: reverse
    }

    @Test
    public void bubbleTest() {
        //Run the arrays through testing
        Sorts.bubbleSort(sorted);
        Sorts.bubbleSort(testCase1);
        Sorts.bubbleSort(testCase2);
        Sorts.bubbleSort(allTheSame);
        Sorts.bubbleSort(reverseSorted);

        assertArrayEquals(sorted, sortedResult);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1Result);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2Result);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSame);//Edge case: all the same
        assertArrayEquals(reverseSorted, sortedResult);//Edge case: reverse
    }
    //OOH, Look now for event sort testing.
    @Test
    public void insertionEventTest() {
        //Run the arrays through testing
        Sorts.eventSort(sorteda, Sorts.insertionSort(sorted));
        Sorts.eventSort(testCase1a, Sorts.insertionSort(testCase1));
        Sorts.eventSort(testCase2a, Sorts.insertionSort(testCase2));
        Sorts.eventSort(allTheSamea, Sorts.insertionSort(allTheSame));
        Sorts.eventSort(reverseSorteda, Sorts.insertionSort(reverseSorted));

        assertArrayEquals(sorted, sorteda);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1a);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2a);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSamea);//Edge case: all the same
        assertArrayEquals(reverseSorted, reverseSorteda);//Edge case: reverse
    }

    @Test
    public void selectionEventTest() {
        //Run the arrays through testing
        Sorts.eventSort(sorteda, Sorts.selectionSort(sorted));
        Sorts.eventSort(testCase1a, Sorts.selectionSort(testCase1));
        Sorts.eventSort(testCase2a, Sorts.selectionSort(testCase2));
        Sorts.eventSort(allTheSamea, Sorts.selectionSort(allTheSame));
        Sorts.eventSort(reverseSorteda, Sorts.selectionSort(reverseSorted));

        assertArrayEquals(sorted, sorteda);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1a);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2a);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSamea);//Edge case: all the same
        assertArrayEquals(reverseSorted, reverseSorteda);//Edge case: reverse
    }

    @Test
    public void mergeEventTest() {
        //Run the arrays through testing
        Sorts.eventSort(sorteda, Sorts.mergeSort(sorted));
        Sorts.eventSort(testCase1a, Sorts.mergeSort(testCase1));
        Sorts.eventSort(testCase2a, Sorts.mergeSort(testCase2));
        Sorts.eventSort(allTheSamea, Sorts.mergeSort(allTheSame));
        Sorts.eventSort(reverseSorteda, Sorts.mergeSort(reverseSorted));

        assertArrayEquals(sorted, sorteda);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1a);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2a);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSamea);//Edge case: all the same
        assertArrayEquals(reverseSorted, reverseSorteda);//Edge case: reverse
    }

    @Test
    public void quickEventTest() {
        //Run the arrays through testing
        Sorts.eventSort(sorteda, Sorts.quickSort(sorted));
        Sorts.eventSort(testCase1a, Sorts.quickSort(testCase1));
        Sorts.eventSort(testCase2a, Sorts.quickSort(testCase2));
        Sorts.eventSort(allTheSamea, Sorts.quickSort(allTheSame));
        Sorts.eventSort(reverseSorteda, Sorts.quickSort(reverseSorted));

        assertArrayEquals(sorted, sorteda);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1a);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2a);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSamea);//Edge case: all the same
        assertArrayEquals(reverseSorted, reverseSorteda);//Edge case: reverse
    }

    @Test
    public void bubbleEventTest() {
        //Run the arrays through testing
        Sorts.eventSort(sorteda, Sorts.bubbleSort(sorted));
        Sorts.eventSort(testCase1a, Sorts.bubbleSort(testCase1));
        Sorts.eventSort(testCase2a, Sorts.bubbleSort(testCase2));
        Sorts.eventSort(allTheSamea, Sorts.bubbleSort(allTheSame));
        Sorts.eventSort(reverseSorteda, Sorts.bubbleSort(reverseSorted));

        assertArrayEquals(sorted, sorteda);//Edge case: already sorted array
        assertArrayEquals(testCase1, testCase1a);//Standard "random" but repeatable
        assertArrayEquals(testCase2, testCase2a);//Standard "random" but repeatable 2
        assertArrayEquals(allTheSame, allTheSamea);//Edge case: all the same
        assertArrayEquals(reverseSorted, reverseSorteda);//Edge case: reverse
    }


}
