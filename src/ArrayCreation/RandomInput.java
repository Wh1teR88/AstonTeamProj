package ArrayCreation;

import java.util.ArrayList;

public class RandomInput<T> implements InputManager<T> {
    @Override
    public ArrayList<T> createArray(ObjectType objectType, int length) {
        return switch (objectType) {
            case ANIMAL -> createAnimalArray(length);
            case BARREL -> createBarrelArray(length);
            case PERSON -> createPersonArray(length);
        };
    }

    private ArrayList<T> createAnimalArray(int length) {
        return null;
    }

    private ArrayList<T> createBarrelArray(int length) {
        return null;
    }

    private ArrayList<T> createPersonArray(int length) {
        return null;
    }
}
