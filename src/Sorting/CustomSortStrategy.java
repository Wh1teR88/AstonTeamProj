package Sorting;

import Entity.*;

import java.util.List;
import java.util.ArrayList;

public class CustomSortStrategy<T extends Comparable<T>> implements SortStrategy<T> {
    private final InsertionSortStrategy<T> insertionSortStrategy = new InsertionSortStrategy<>();

    @Override
    public void sort(List<T> list) {
        List<Integer> evenIndices = new ArrayList<>(); // Четные индексы
        List<T> evenElements = new ArrayList<>(); // Четные елементы

        // Цикл проходит поп списку и отбирает только четные елементы
        for (int i = 0; i < list.size(); i++) {
            T element = list.get(i);
            int numericValue = extractNumericField(element);
            if (numericValue % 2 == 0) {
                evenIndices.add(i);
                evenElements.add(element);
            }
        }

        //Сортируем четные элементы
        insertionSortStrategy.sort(evenElements);

        //Возвращение отсортированных чётных элементов на начальные позиции
        for (int i = 0; i < evenIndices.size(); i++) {
            int index = evenIndices.get(i);
            list.set(index, evenElements.get(i));
        }
    }

    //Достает числовое значение из объекта, и определяет, четное или нет.
    private int extractNumericField(T element) {
        if (element instanceof Animal animal) {
            return (int) animal.getWeight();
        } else if (element instanceof Barrel barrel) {
            return (int) barrel.getVolume();
        } else if (element instanceof Person person) {
            return person.getAge();
        } else {
            throw new IllegalArgumentException("Данный тип не поддерживается.");
        }
    }
}
