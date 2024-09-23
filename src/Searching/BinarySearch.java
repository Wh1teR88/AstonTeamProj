package Searching;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> {
    //https://stackoverflow.com/questions/5426316/generic-binary-search-java
    public int search(List<T> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            T midVal = list.get(mid);
            int result = midVal.compareTo(key);

            if (result == 0) {
                return mid;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // Если элемент не найдет вернем -1
    }
}

