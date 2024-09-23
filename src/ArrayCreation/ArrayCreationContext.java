package ArrayCreation;

import java.util.ArrayList;

public class ArrayCreationContext<T> {
    private InputManager<T> inputManager;
    private ObjectType objectType;
    private int arrayLength = 0;

    public ArrayCreationContext() {}

    public ArrayCreationContext(InputManager<T> inputManager, ObjectType objectType, int arrayLength) {
        this.inputManager = inputManager;
        this.objectType = objectType;
        this.arrayLength = arrayLength;
    }

    public ArrayCreationContext(InputManager<T> inputManager, ObjectType objectType) {
        this.inputManager = inputManager;
        this.objectType = objectType;
    }

    public void setInputManager(InputManager<T> inputManager) {
        this.inputManager = inputManager;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }

    public void setArrayLength(int arrayLength) {
        this.arrayLength = arrayLength;
    }

    public ArrayList<T> createArray() {
        return inputManager.createArray(objectType, arrayLength);
    }
}
