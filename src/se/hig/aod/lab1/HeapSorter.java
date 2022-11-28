package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;

public class HeapSorter {

    public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) {

        HeapPriorityQueue<T> heap = new HeapPriorityQueue<>(inputList.size());
        List<T> sortedList = new ArrayList<>();

        for (T t : inputList) {
            heap.enqueue(t);
        }
        while(!heap.isEmpty()) {
            sortedList.add(heap.dequeue());
        }
        return sortedList;
    }
}
