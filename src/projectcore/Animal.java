package projectcore;

class Animal {
    private String animalType;
    private String eyeColor;
    private boolean haveFur;

    public Animal() {
        this.animalType = "None";
        this.eyeColor = "Unknown";
        this.haveFur = false;
    }

    public Animal(String animalType, String eyeColor, boolean haveFur) {
        this.animalType = animalType;
        this.eyeColor = eyeColor;
        this.haveFur = haveFur;
    }

    public String getAnimalType() {
        return animalType;
    }
    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }
    public String getEyeColor() {
        return eyeColor;
    }
    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }
    public boolean isHaveFur() {
        return haveFur;
    }
    public void setHaveFur(boolean haveFur) {
        this.haveFur = haveFur;
    }

    @Override
    public String toString() {
        return "Animal{" + animalType + ':' + eyeColor + ':' + haveFur + '}';
    }
}
