package Entity;

import java.util.Comparator;

public class Barrel implements Comparable<Barrel> {
    private final int volume;
    private final String storedMaterial;
    private final String material;

    private Barrel(Builder builder) {
        this.volume = builder.volume;
        this.storedMaterial = builder.storedMaterial;
        this.material = builder.material;
    }

    public static class Builder {
        private int volume;
        private String storedMaterial;
        private String material;

        public Builder setVolume(int volume) {
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

    public int getVolume() {
        return volume;
    }

    public String getStoredMaterial() {
        return storedMaterial;
    }

    public String getMaterial() {
        return material;
    }

    private String normalizeString(String string) {
        return string.toLowerCase().trim().replace('ё', 'е');
    }

    @Override
    public int compareTo(Barrel other) {
        return Comparator.comparing((Barrel b) -> b.volume)
                .thenComparing(b -> normalizeString(b.storedMaterial))
                .thenComparing(b -> normalizeString(b.material))
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "Бочка " +
                "объемом " + volume +
                " л., из материала \"" + material +
                "\", внутри " + storedMaterial;
    }

    public String prepareToWrite(){
        StringBuilder sbBarrel = new StringBuilder();
        sbBarrel.append(volume + "\n");
        sbBarrel.append(storedMaterial + "\n");
        sbBarrel.append(material + "\n");
        return sbBarrel.toString();
    }
}
