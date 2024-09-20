package projectcore;

public class Barrel {
    private int barrelVolume;
    private String barrelContent;
    private String barrelMaterial;

    public Barrel() {
        barrelVolume = 0;
        barrelContent = "Unknown";
        barrelMaterial = "Unknown";
    }

    public Barrel(int barrelVolume, String barrelContent, String barrelMaterial) {
        this.barrelVolume = barrelVolume;
        this.barrelContent = barrelContent;
        this.barrelMaterial = barrelMaterial;
    }

    public int getBarrelVolume() {
        return barrelVolume;
    }
    public void setBarrelVolume(int barrelVolume) {
        this.barrelVolume = barrelVolume;
    }
    public String getBarrelContent() {
        return barrelContent;
    }
    public void setBarrelContent(String barrelContent) {
        this.barrelContent = barrelContent;
    }
    public String getBarrelMaterial() {
        return barrelMaterial;
    }
    public void setBarrelMaterial(String barrelMaterial) {
        this.barrelMaterial = barrelMaterial;
    }

    @Override
    public String toString() {
        return "Barrel{" + barrelVolume + ":" + barrelContent + ":" + barrelMaterial + '}';
    }
}
