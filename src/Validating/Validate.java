package Validating;

import Entity.*;

public class Validate {

    public static boolean validateString(String value, int minLength, int maxLength) {
        return value != null
                && !value.trim().isEmpty()
                && value.length() >= minLength
                && value.length() <= maxLength
                && !value.matches(".*\\d.*");
    }

    public static boolean validateAnimal(Animal animal) {
        return validateString(animal.getSpecies(), 1, 25)
                && validateString(animal.getEyeColor(), 1, 20)
                && animal.getWeight() > 0
                && animal.getWeight() <= 10000;

    }

    public static boolean validatePerson(Person person) {
        return  validateString(person.getSurname(),1, 50)
                && person.getAge() >= 0
                && person.getAge() <= 120;

    }

    public static boolean validateBarrel(Barrel barrel) {
        return validateString(barrel.getStoredMaterial(), 1, 50)
                && validateString(barrel.getMaterial(),1, 50)
                && barrel.getVolume()  >= 0
                && barrel.getVolume()  <= 100000;

    }
}


