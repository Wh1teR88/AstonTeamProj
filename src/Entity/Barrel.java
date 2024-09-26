package Entity;

import java.util.Comparator;

public class Barrel implements Comparable<Barrel> {
    private final double volume;
    private final String storedMaterial;
    private final String material;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;
    }

    public static class Builder {
        private double volume;
        private String storedMaterial;
        private String material;

        public Builder setVolume(double volume) {
            this.volume = volume;
            return this;
        }

        public Builder setStoredMaterial(String storedMaterial) {
            this.storedMaterial = storedMaterial;
            return this;
        }

        public Builder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    public double getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public int compareTo(Barrel other) {
        return Comparator.comparing((Barrel b) -> b.volume)
                .thenComparing(b -> b.storedMaterial)
                .thenComparing(b -> b.material)
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "Бочка " +
                "объемом " + volume +
                " л., из материала \"" + material +
                "\", внутри " + storedMaterial;
    }
}
