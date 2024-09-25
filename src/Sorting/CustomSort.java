package Sorting;

import java.util.List;
import java.util.function.Function;
import java.util.ArrayList;
import java.util.Collections;

public class CustomSort<T extends Comparable<T>> implements SortStrategy<T> {
    private final Function<T, Integer> numericFieldExtractor;

    public CustomSort(Function<T, Integer> numericFieldExtractor) {
        this.numericFieldExtractor = numericFieldExtractor;
    }

    @Override
    public void sort(List<T> list) {
        // Индексов и элементы с четными значениями
        List<Integer> evenIndices = new ArrayList<>();
        List<T> evenElements = new ArrayList<>();

        // Сбор четныз элементов
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            int numericValue = numericFieldExtractor.apply(element);
            if (numericValue % 2 == 0) {
                evenIndices.add(i);
                evenElements.add(element);
            }
        }

        // Сортировка четныз елементов
        Collections.sort(evenElements);

        // Четные элемекнты на своих местах
        for (int i = 0; i < evenIndices.size(); i++) {
            int index = evenIndices.get(i);
            list.set(index, evenElements.get(i));
        }
    }
}
