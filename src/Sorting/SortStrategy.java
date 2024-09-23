package Sorting;

import java.util.List;

//Общий вид
public interface SortStrategy<T extends Comparable<T>> {
    void sort(List<T> list);
}
