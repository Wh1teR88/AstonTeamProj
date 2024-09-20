package projectcore;

public class BarrelBuilder implements IBarrelBuilder {
    private Barrel currentBarrel = new Barrel();

    @Override
    public IBarrelBuilder setBarrelVolume(int volume) {
        currentBarrel.setBarrelVolume(volume);
        return this;
    }

    @Override
    public IBarrelBuilder setBarrelContent(String content) {
        currentBarrel.setBarrelContent(content);
        return this;
    }

    @Override
    public IBarrelBuilder setBarrelMaterial(String material) {
        currentBarrel.setBarrelMaterial(material);
        return this;
    }

    @Override
    public Barrel createBarrel() {
        return currentBarrel;
    }
}
