package se.hig.aod.lab1;

/**
 * A static heap implementation of a priority queue for elements of type T.
 *
 * @author xxxx
 *
 * @param <T> Data type of elements stored in the queue.
 */
public class HeapPriorityQueue<T extends Comparable<? super T>> implements PriorityQueue<T> {

    private T[] heap;
    private int size;
    private final int maxSize;

    public HeapPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        clear();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        heap = (T[]) (new Comparable[maxSize]); // Create empty array of size maxSize
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Method that is specific for a static implementation of the heap, checks if
     * the underlying array is full.
     *
     * @return true if the underlying array is full
     */
    public boolean isFull() {
        return size == maxSize;
    }

    @Override
    public int size() {
        return size;
    }

    private int parent(int currentIndex) {

        return (currentIndex - 1) / 2;
    }

    private int leftChild(int currentIndex) {

        return 2 * currentIndex + 1;
    }

    private int rightChild(int currentIndex) {
        return 2 * currentIndex + 2;
    }

    private void reHeapUp(int currentIndex) {

        if (heap[currentIndex].compareTo(heap[parent(currentIndex)]) > 0){
            T tmp = heap[currentIndex];
            heap[currentIndex] = heap[parent(currentIndex)];
            heap[parent(currentIndex)] = tmp;
            reHeapUp(parent(currentIndex));
        }
    }

    private void reHeapDown(int currentIndex) {
        int leftChild = leftChild(currentIndex);
        int rightChild = rightChild(currentIndex);
        if (leftChild >= size && rightChild >= size){
            return;
        }
        else if (rightChild >= size){
            if (heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) <= 0){
                T tmp =  heap[currentIndex];
                heap[currentIndex] = heap[leftChild(currentIndex)];
                heap[leftChild(currentIndex)] = tmp;
                reHeapDown(leftChild(currentIndex));
            }
        }
        else {
            if (heap[rightChild(currentIndex)].compareTo(heap[leftChild(currentIndex)]) >= 0) {
                if (heap[currentIndex].compareTo(heap[rightChild(currentIndex)]) <= 0) {
                    T temp = heap[currentIndex];
                    heap[currentIndex] = heap[rightChild(currentIndex)];
                    heap[rightChild(currentIndex)] = temp;
                    reHeapDown(rightChild(currentIndex));
                }

            } else {
                if (heap[currentIndex].compareTo(heap[leftChild(currentIndex)]) <= 0) {
                    T temp = heap[currentIndex];
                    heap[currentIndex] = heap[leftChild(currentIndex)];
                    heap[leftChild(currentIndex)] = temp;
                    reHeapDown(leftChild(currentIndex));
                }
            }
        }
    }

    @Override
    public void enqueue(T newElement) {
        if (isFull()) {
            throw new PriorityQueueFullException("Heap is full!");
        }
        size++;
        heap[size -1] = newElement;
        reHeapUp(size -1);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new PriorityQueueEmptyException("Cannot dequeue empty Queue!");
        } else {
            T dequeuedElement = heap[0];// the root element of the heap

            heap[0] = heap[size -1];
            size--;
            reHeapDown(0);
            return dequeuedElement;
        }
    }

    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new PriorityQueueEmptyException("Cannot get front of empty Queue!");
        } else {
            return heap[0];
        }
    }

    @Override
    public String toString() {
        String stringRepresentation = "";
        for (int i = 0; i < size; i++) {
            stringRepresentation = stringRepresentation + heap[i] + " ";
        }
        return stringRepresentation;
    }
}
