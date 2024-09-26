package ArrayCreation;

import java.util.ArrayList;

@FunctionalInterface
public interface InputManager<T> {
    ArrayList<T> createArray(ObjectType objectType, int length);
}