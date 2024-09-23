package Sorting;

import java.util.List;

public class InsertionSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
    // https://stackoverflow.com/questions/64507683/how-do-i-implement-an-insertion-sort-method-for-a-generic-arraylist
    @Override
    public void sort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }
}
