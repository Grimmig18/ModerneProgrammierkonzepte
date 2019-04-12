package app;

import functional.linearsearch.returnindex.FunctionalLinearSearchTest;
import oop.linearsearch.OOLinearSearchTest;
import oop.quicksort.QuickSortTest;

public class TestAlgorithms {
    private static FunctionalLinearSearchTest functionalLinearSearchTest = new FunctionalLinearSearchTest();
    private static QuickSortTest quicksortTets = new QuickSortTest();
    private static OOLinearSearchTest ooLinearSearchTest = new OOLinearSearchTest();


    public static void runTest() {
        int[] arr = new int[6000];
        int search = 10;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        double[] resultsFunctionalLinearSearch = functionalLinearSearchTest.test(arr, search);
        double[] resultsOOLinearSearch = ooLinearSearchTest.test(arr, search);
        double[] resultsQuickSort = quicksortTets.test(arr);

        System.out.println("Funktionale Lineare Suche: " + resultsFunctionalLinearSearch[0] + "ms");
        System.out.println("OO Lineare Suche: " + resultsOOLinearSearch[0] + "ms");
        System.out.println("OO QuickSort: " + resultsQuickSort[0] + "ms");

    }
}