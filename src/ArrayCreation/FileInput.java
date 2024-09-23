package ArrayCreation;

import java.util.ArrayList;

public class FileInput<T> implements InputManager<T> {
    @Override
    public ArrayList<T> createArray(ObjectType objectType, int length) {
        return switch (objectType) {
            case ANIMAL -> createAnimalArray();
            case BARREL -> createBarrelArray();
            case PERSON -> createPersonArray();
        };
    }

    private ArrayList<T> createAnimalArray() {
        return null;
    }

    private ArrayList<T> createBarrelArray() {
        return null;
    }

    private ArrayList<T> createPersonArray() {
        return null;
    }
}
