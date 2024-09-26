package Validating;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

public class Validate {
    public static boolean validateString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean validatePositiveDouble(double value) {
        return value > 0;
    }

    public static boolean validateNonNegativeInt(int value) {
        return value >= 0;
    }

    public static boolean validateBarrel(Barrel barrel) {return true;}

    public static boolean validatePerson(Person person) {return true;}

    public static boolean validateAnimal(Animal animal) {return true;}
}

