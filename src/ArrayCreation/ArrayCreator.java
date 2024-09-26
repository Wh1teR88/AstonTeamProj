package ArrayCreation;

import java.util.ArrayList;

public class ArrayCreator<T> {
    private InputManager<T> inputManager;
    private ObjectType objectType;
    private int arrayLength = 0;

    public ArrayCreator(ObjectType objectType, int arrayLength) {
        this.objectType = objectType;
        this.arrayLength = arrayLength;
    }

    public void setInputManager(InputManager<T> inputManager) {
        this.inputManager = inputManager;
    }

    public ArrayList<T> createArray() {
        return inputManager.createArray(objectType, arrayLength);
    }
}
