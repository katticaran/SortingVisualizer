package edu.grinnell.sortingvisualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import edu.grinnell.sortingvisualizer.sortevents.CompareEvent;
import edu.grinnell.sortingvisualizer.sortevents.CopyEvent;
import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
import edu.grinnell.sortingvisualizer.sortevents.SwapEvent;

//import java.util.List;
//
//import edu.grinnell.sortingvisualizer.sortevents.SortEvent;
//
//public class Sorts {
//    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {
//        // TODO: implement instrumented selectionSort
//        return null;
//    }
//
//    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {
//        // TODO: implement instrumented insertionSort
//        return null;
//    }
//
//    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
//        // TODO: implement instrumented mergeSort
//        return null;
//    }
//
//    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
//        // TODO: implement instrumented quickSort
//        return null;
//    }
//
//    public static <T extends Comparable<T>> List<SortEvent<T>> customSort(T[] arr) {
//        // TODO: implement your own custom sort
//        return null;
//    }
//}

public class Sorts {

    //  public static <T extends Comparable<T>> void selectionSort(T[] arr) {
    //Precondition: arr is a list of objects
    //Returns: a list of sort events
    //Purpose: to sort arr and return a list of sort events
    public static <T extends Comparable<T>> List<SortEvent<T>> selectionSort(T[] arr) {

        List<SortEvent<T>> retList = new ArrayList<SortEvent<T>>();

        int toSwap ;
        int i;
        int length = arr.length;
        for( i=0;i<length-1;i++) {
            toSwap = i;
            for(int j=i+1;j<length;j++) {
                //if (arr[j]<arr[toSwap]) {
                //  if(arr[j].compareTo(arr[toSwap]) < 0) {
                if(lessThan(arr,j,toSwap,retList)) {
                    toSwap = j;
                }
            }
            swap(arr, i, toSwap, retList);
        }

        return retList;
    }



    //@param: arr is a list of objects
    //Returns: a list of sort events
    //Purpose: to sort arr and return a list of sort events
    public static <T extends Comparable<T>> List<SortEvent<T>> insertionSort(T[] arr) {

        List<SortEvent<T>> retList = new ArrayList<SortEvent<T>>();

        int length = arr.length;
        for (int i=0; i< length-1; i++) {
            int j=i+1;
            int counter = i;
            while (j >= 0 && counter >= 0 && lessThan(arr,j,counter,retList)){
                //while (j >= 0 && counter >= 0 && arr[j]<arr[counter]) {
                swap(arr,j,counter, retList);
                j--;
                counter--;
            }
        }
        return retList;
    }

    //@param: arr is a list of objects
    //Returns: a list of sort events
    //Purpose: to sort arr and return a list of sort events
    public static <T extends Comparable<T>> List<SortEvent<T>> mergeSort(T[] arr) {
        //public static void mergeSort(int[] arr) {
        List<SortEvent<T>> retList = new ArrayList<SortEvent<T>>();
        mergeSortDoer(arr, 0, (arr.length-1)/2, arr.length-1, retList);
        return retList;
    }

    //Helper function, check mergeSort
    public static <T extends Comparable<T>> void mergeSortDoer(T[] arr, int low, int mid, int high, List<SortEvent<T>> retList) {
        //public static void mergeSortDoer(int[] arr,int low,int mid,int high) {        
        if (low < high)
        {   
            mergeSortDoer(arr, low, (low+(mid-low)/2) , mid, retList);
            mergeSortDoer(arr , mid +1, ((mid+1)+(high-mid+1)/2) , high, retList);
            merge(arr, low, mid, high, retList);
        }
    }

    //Helper Function check mergeSort
    public static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high, List<SortEvent<T>> retList) {
        //public static void merge(int[] arr, int low, int mid, int high) {
        int lSize = mid - low + 1;
        int rSize = high - mid;
        int mainSize = high - low +1;

        @SuppressWarnings("unchecked")
        T[] tempArr = (T[]) new Comparable[mainSize];


        int lArrIndex = low;
        int rArrIndex = mid+1;
        int mainArrIndex = 0;
        while (lArrIndex < low+lSize && rArrIndex < mid+1+rSize)
        {

            //if (lArr[lArrIndex] < rArr[rArrIndex])
            if ( lessThan(arr,lArrIndex,rArrIndex,retList)){
                //if (arr[lArrIndex].compareTo(arr[rArrIndex]) < 0){
                //   lessThan(arr,j,counter,retList)         
                tempArr[mainArrIndex] = arr[lArrIndex];
                lArrIndex++;
                mainArrIndex++;
            }
            else
            {
                tempArr[mainArrIndex] = arr[rArrIndex];
                rArrIndex++;
                mainArrIndex++;
            }
        }
        while (lArrIndex < low+lSize)
        {
            tempArr[mainArrIndex] = arr[lArrIndex];
            lArrIndex++;
            mainArrIndex++;
        }
        while (rArrIndex < mid+1+rSize)
        {
            tempArr[mainArrIndex] = arr[rArrIndex];
            rArrIndex++;
            mainArrIndex++;
        }

        for(int i=0;i<mainSize;i++) {
            CopyEvent<T> event = new CopyEvent<T>(tempArr[i], low+i);
            retList.add(event);
            arr[low+i] = tempArr[i];
        }
    }
    
    //@param: arr is a list of objects
    //Returns: a list of sort events
    //Purpose: to sort arr and return a list of sort events
    public static <T extends Comparable<T>> List<SortEvent<T>> quickSort(T[] arr) {
        //private static void quickSort(int[] arr) {
        List<SortEvent<T>> retList = new ArrayList<SortEvent<T>>();
        quickSortDoer(arr, 0, arr.length-1, retList);
        return retList;
    }

    //Helper function, check quickSort
    public static <T extends Comparable<T>> void quickSortDoer(T[] arr, int low, int high, List<SortEvent<T>> retList) {
        boolean lowFlag = false;
        boolean highFlag = false;
        //public static void quickSortDoer(int[] arr, int low, int high) {
        int pivotIndex = low+(high-low)/2;

        int lIndex = low;
        int rIndex = high;

        while(lIndex <= rIndex) {

            while( lessThan(arr,lIndex,pivotIndex,retList)) {
                //   while(arr[i].compareTo(arr[pivotIndex]) < 0 ) {
                lIndex++;
            }

            while(greaterThan(arr,rIndex,pivotIndex,retList)) {
                //    while(arr[j].compareTo(arr[pivotIndex]) > 0 )  {
                rIndex--;
            }

            if (lIndex <= rIndex ) {
                if (lIndex==pivotIndex) {
                    lowFlag = true;
                }
                if (rIndex == pivotIndex) {
                    highFlag = true;
                }
                swap(arr, lIndex, rIndex, retList);
                if (lowFlag) {
                    pivotIndex = rIndex;
                    lowFlag = false;
                }
                if (highFlag) {
                    pivotIndex = lIndex;
                    highFlag = false;
                }

                lIndex++;
                rIndex--;
            }
        }


        if (low < rIndex) {
            quickSortDoer(arr, low, rIndex, retList);
        }
        if (lIndex < high) {
            quickSortDoer(arr, lIndex, high, retList);
        }

    }

    public static <T extends Comparable<T>> List<SortEvent<T>> bubbleSort(T[] arr) {
        //public static void bubbleSort(int arr[]){
        List<SortEvent<T>> retList = new ArrayList<SortEvent<T>>();
        boolean swapFlag = true;
        int length = arr.length;
        for (int i = 0; i < length-1 && swapFlag; i++) {
            swapFlag = false;
            for (int j = 0; j < length-1; j++) {
                if(greaterThan(arr,j,j+1,retList)){
                    //if (arr[j] > arr[j+1])
                    swapFlag = true;
                    swap(arr, j, j+1, retList);
                }
            }
        }
        return retList;
    }

    public static <T extends Comparable<T>> boolean lessThan(T[] arr, int index1, int index2, List<SortEvent<T>> retList) {
        CompareEvent<T> event = new CompareEvent<T>(index1, index2);
        retList.add(event);
        return (arr[index1].compareTo(arr[index2]) < 0);

    }

    public static <T extends Comparable<T>> boolean greaterThan(T[] arr, int index1, int index2, List<SortEvent<T>> retList) {
        CompareEvent<T> event = new CompareEvent<T>(index1, index2);
        retList.add(event);
        return (arr[index1].compareTo(arr[index2]) > 0);

    }

    //    public static <T extends Comparable<T>> boolean greaterThan(T[] arr, int index1, int index2, List<SortEvent<T>> retList) {
    //        CompareEvent<T> event = new CompareEvent<T>(index1, index2);
    public static <T extends Comparable<T>> void swap(T[] arr, int index1, int index2, List<SortEvent<T>> retList) {
        SwapEvent<T> event = new SwapEvent<T>(index1, index2);
        retList.add(event);
        T temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return;
    }

    //Used to test the validity of sortevent lists. takes the list to be sorted and a sort function as input and returns the sorted element. Seems pretty dumb...
    public static <T extends Comparable<T>> void eventSort(T[] l, List<SortEvent<T>> events) {
        for (int i=0;i<events.size() ;i++) {
            events.get(i).apply(l);
        }
    }

    //Iterates through an array and prints it, Super useful, 5 stars.
    public static <T extends Comparable<T>> void printArray(T[] arr){
        //public static void printArray(int arr[])
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    //IGNORE ME, I'm used for testing.
    public static void main(String args[])
    {
        @SuppressWarnings("unused")
        Integer arr1[] = {64,25,12,22,11,44,91,0,12,2};
        Integer arr2[] = new Integer [100];//{-52, 5, 29, 123, 5, -14, 376, 34, 912, 9, 0, 13, 3, 4, 1, 2, 6, 8, 9, 19, 23, 54, 16, 23, 51};
        //Integer arr2[] = {-52, 5, 29, 123, 5, -14,  0};
        //insertionSort(arr);
        //System.out.println("Sorted array");
        //printArray(arr);
        for(int i = 0; i < 100; i++) {
            arr2[i] = i;
        }
        mergeSort(arr2);
        System.out.println("Sorted array");
        printArray(arr2);
    }
}


