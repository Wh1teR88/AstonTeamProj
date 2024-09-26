package Entity;

import Validating.Validate;

import java.util.Comparator;

public class Animal implements Comparable<Animal> {
    private final String species; // или type, вроде переводит "вид животного -> animal species"
    private final String eyeColor;
    private final boolean wool;
    private final double weight;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.wool = builder.wool;
        this.weight = builder.weight;
    }

    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean wool;
        private double weight;

        public Builder setSpecies(String species) {
//            if (!Validate.validateString(species)) {
//                throw new IllegalArgumentException("Вид пустой");
//            }
            this.species = species;
            return this;
        }

        public Builder setEyeColor(String eyeColor) {
//            if (!Validate.validateString(eyeColor)) {
//                throw new IllegalArgumentException("Цвет глаз пустой");
//            }
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder setWool(boolean wool) {
            this.wool = wool;
            return this;
        }

        public Builder setWeight(double weight) {
//            if(!Validate.validatePositiveDouble(weight)) {
//                throw new IllegalArgumentException("Вес меньше нуля");
//            }
            this.weight = weight;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    // Геттеры
    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isWool() {
        return wool;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Animal other) {
        return Comparator.comparing((Animal a) -> a.species)
                .thenComparing(a -> a.eyeColor)
                .thenComparing(a -> a.wool)
                .thenComparing(a -> a.weight)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "Животное: вид \"" + species
                + "\", цвет глаз \"" + eyeColor + "\", "
                + (wool ? "есть мех" : "без меха") +
                ", вес " + weight + " кг.";
    }
}
