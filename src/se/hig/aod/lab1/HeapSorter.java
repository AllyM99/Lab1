package se.hig.aod.lab1;

public class HeapSorter {

    public static <T extends Comparable<? super T>> List<T> sort(List<T> inputList) {

        HeapPriorityQueue<T> heap = new HeapPriorityQueue<>(inputList.size());
        List<T> sortedList = new ArrayList<>();

        for(int i = 0; i< inputList.size(); i++) {
            heap.enqueue(inputList.size());
        }	while(!heap.isEmpty()) {
            sortedList.add(heap.dequeue());
        }
        return sortedList;
    }
}
