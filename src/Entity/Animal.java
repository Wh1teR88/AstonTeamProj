package Entity;

import java.util.Comparator;

public class Animal implements Comparable<Animal> {
    private final String species; // или type, вроде переводит "вид животного -> animal species"
    private final String eyeColor;
    private final boolean wool;
    private final int weight;

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
        private int weight;

        public Builder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public Builder setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder setWool(boolean wool) {
            this.wool = wool;
            return this;
        }

        public Builder setWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public int getWeight() {
        return weight;
    }

    private String normalizeString(String string) {
        return string.toLowerCase().trim().replace('ё', 'е');
    }

    @Override
    public int compareTo(Animal other) {
        return Comparator.comparing((Animal a) -> normalizeString(a.species))
                .thenComparing(a -> normalizeString(a.eyeColor))
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

    public String prepareToWrite(){
        StringBuilder sbAnimal = new StringBuilder();
        sbAnimal.append(species + "\n");
        sbAnimal.append(eyeColor + "\n");
        sbAnimal.append(wool + "\n");
        sbAnimal.append(weight + "\n");
        return sbAnimal.toString();
    }
}
