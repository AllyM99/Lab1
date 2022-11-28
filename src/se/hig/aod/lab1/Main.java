package se.hig.aod.lab1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(4);
        inputList.add(5);
        inputList.add(2);
        inputList.add(10);
        inputList.add(9);

        System.out.println(inputList);
        System.out.println(HeapSorter.sort(inputList));
    }
}
