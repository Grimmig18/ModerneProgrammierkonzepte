package app;

import java.util.ArrayList;
import java.util.Map;

import functional.linearsearch.index.FunctionalLinearSearchIndex;
import functional.linearsearch.list.FunctionalLinearSearchList;
import multithreaded.linearsearch.index.MultithreadedIndexLinearSearch;
import multithreaded.linearsearch.list.MultithreadedListLinearSearch;
import oo.linearsearch.index.OOLinearSearchIndex;
import oo.linearsearch.list.OOLinearSearchList;
import oo.quicksort.OOQuicksort;


public class TestAlgorithms {
    public static ArrayList<Map<String, Long>> runTest() {
        int[] arr = new int[6000];
        int search = (int) Math.random() * arr.length;
        final int iterations = 1000;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.random() * arr.length;
        }

        Map<String, Long> results1 = FunctionalLinearSearchIndex.test(arr, search, iterations, FunctionalLinearSearchIndex.findTest);
        Map<String, Long> results2 = FunctionalLinearSearchList.test(arr, search, iterations, FunctionalLinearSearchList.findFunctional);

        Map<String, Long> results4 = MultithreadedIndexLinearSearch.test(arr, iterations, new SearchObject(10, 10), MultithreadedIndexLinearSearch.searchTest);
        Map<String, Long> results5 = MultithreadedListLinearSearch.test(arr, iterations, new SearchObject(10, 10), MultithreadedListLinearSearch.searchTest);

        Map<String, Long> results6 = OOLinearSearchIndex.test(arr, search, iterations, OOLinearSearchIndex.searchTest);
        Map<String, Long> results7 = OOLinearSearchList.test(arr, search, iterations, OOLinearSearchList.searchTest);

        Map<String, Long> results3 = OOQuicksort.test(arr, iterations, OOQuicksort.quicksortTest);

        ArrayList<Map<String, Long>> list = new ArrayList<>();
        list.add(results1);
        list.add(results2);
        list.add(results3);
        list.add(results4);
        list.add(results5);
        list.add(results6);
        list.add(results7);

        return list;
    }
}