package projectcore;

public interface IBarrelBuilder {
    IBarrelBuilder setBarrelVolume(int volume);

    IBarrelBuilder setBarrelContent(String content);

    IBarrelBuilder setBarrelMaterial(String material);

    Barrel createBarrel();
}
