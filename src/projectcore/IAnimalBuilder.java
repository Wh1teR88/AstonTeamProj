package projectcore;

interface IAnimalBuilder {
    IAnimalBuilder setAnimalType(String animalType);

    IAnimalBuilder setEyeColor(String eyeColor);

    IAnimalBuilder setHaveFur(boolean haveFur);

    Animal createAnimal();
}
