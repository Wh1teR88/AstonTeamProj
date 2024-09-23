package Sorting.Patterns.Strategy;

import Sorting.SortStrategy;

import java.util.List;

public class SortingPlan<T extends Comparable<T>> {
    //https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial
    private SortStrategy<T> strategy;

    public SortingPlan(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(List<T> list) {
        strategy.sort(list);
    }
}
