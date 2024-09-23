package Entity;

import Validating.Validate;

public class Animal implements Comparable<Animal> {
    private final String species; // или type, вроде переводит "вид животного -> animal species"
    private final String eyeColor;
    private final boolean wool;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.wool = builder.wool;
    }

    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean wool;

        public Builder setSpecies(String species) {
            if (!Validate.validateString(species)) {
                throw new IllegalArgumentException("Вид пустой");
            }
            this.species = species;
            return this;
        }

        public Builder setEyeColor(String eyeColor) {
            if (!Validate.validateString(eyeColor)) {
                throw new IllegalArgumentException("Цвет глаз пустой");
            }
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder setWool(boolean wool) {
            this.wool = wool;
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

    @Override
    public int compareTo(Animal other) {
        return this.species.compareTo(other.species);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hasFur=" + wool +
                '}';
    }
}
