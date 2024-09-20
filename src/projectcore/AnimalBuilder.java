package projectcore;

class AnimalBuilder implements IAnimalBuilder {
    private Animal currentAnimal = new Animal();

    @Override
    public IAnimalBuilder setAnimalType(String animalType) {
        currentAnimal.setAnimalType(animalType);
        return this;
    }

    @Override
    public IAnimalBuilder setEyeColor(String eyeColor) {
        currentAnimal.setEyeColor(eyeColor);
        return this;
    }

    @Override
    public IAnimalBuilder setHaveFur(boolean haveFur) {
        currentAnimal.setHaveFur(haveFur);
        return this;
    }

    @Override
    public Animal createAnimal() {
        return currentAnimal;
    }
}
