package Sorting.Patterns.Strategy;

import Sorting.SortStrategy;

import java.util.List;

public class SortingPlan<T extends Comparable<T>> {

    private SortStrategy<T> strategy;

    public SortingPlan() {
    }

    public SortingPlan(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(List<T> list) {
        if (list != null){
            strategy.sort(list);
        }
    }
}
