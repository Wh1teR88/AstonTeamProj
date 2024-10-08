package ArrayCreation;

import Entity.*;
import Validating.Validate;

import java.util.ArrayList;
import java.util.Scanner;

public class ManualInput<T> implements InputManager<T> {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public ArrayList<T> createArray(ObjectType objectType, int length) {
        return switch (objectType) {
            case ANIMAL -> createAnimalArray(length);
            case BARREL -> createBarrelArray(length);
            case PERSON -> createPersonArray(length);
        };
    }

    private ArrayList<T> createAnimalArray(int length) {
        ArrayList<Animal> animals = new ArrayList<>();
        int added = 0;
        while (added < length) {
            Animal tempAnimal = ManualInput.parseAnimal();
            if(Validate.validateAnimal(tempAnimal)){
                animals.add(tempAnimal);
                added++;
                System.out.println("Добавлено животных: " + added + ". Осталось добавить: " + (length - added) + ".");
            }
            else {
                System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
            }
        }
        return (ArrayList<T>) animals;
    }

    private ArrayList<T> createBarrelArray(int length) {
        ArrayList<Barrel> barrels = new ArrayList<>();
        int added = 0;
        while (added < length) {
            Barrel tempBarrel = ManualInput.parseBarrel();
            if(Validate.validateBarrel(tempBarrel)){
                barrels.add(tempBarrel);
                added++;
                System.out.println("Добавлено бочек: " + added + ". Осталось добавить: " + (length - added) + ".");
            }
            else {
                System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
            }
        }
        return (ArrayList<T>) barrels;
    }

    private ArrayList<T> createPersonArray(int length) {
        ArrayList<Person> persons = new ArrayList<>();
        int added = 0;
        while (added < length) {
            Person tempPerson = ManualInput.parsePerson();
            if(Validate.validatePerson(tempPerson)){
                persons.add(tempPerson);
                added++;
                System.out.println("Добавлено людей: " + added + ". Осталось добавить: " + (length - added) + ".");
            }
            else {
                System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
            }
        }
        return (ArrayList<T>) persons;
    }

    public static Animal parseAnimal() {
        String tempSpecies;
        String tempEyeColor;
        boolean tempWool;
        int tempWeight;
        System.out.println("\nВведите вид животного: (25 букв максимум)");
        tempSpecies = scanner.nextLine();
        System.out.println("Введите цвет глаз животного: (20 букв максимум)");
        tempEyeColor = scanner.nextLine();
        System.out.println("У животного есть шерсть? \"1\" - да, любая другая кнопка - нет:");
        tempWool = scanner.nextLine().equals("1");
        System.out.println("Сколько килограммов весит животное? (значение от 1 до 10000)");
        tempWeight = Validate.getIntFromInput(scanner.nextLine());
        return new Animal.Builder()
                .setSpecies(tempSpecies)
                .setEyeColor(tempEyeColor)
                .setWool(tempWool)
                .setWeight(tempWeight)
                .build();
    }

    public static Barrel parseBarrel() {
        int tempVolume;
        String tempStoredMaterial;
        String tempMaterial;
        System.out.println("\nВведите объем бочки в литрах (значение от 1 до 100000): ");
        tempVolume = Validate.getIntFromInput(scanner.nextLine());
        System.out.println("Что находится в бочке? (50 букв максимум)");
        tempStoredMaterial = scanner.nextLine();
        System.out.println("Введите материал, из которого сделана бочка: (50 букв максимум)");
        tempMaterial = scanner.nextLine();
        return new Barrel.Builder()
                .setVolume(tempVolume)
                .setMaterial(tempMaterial)
                .setStoredMaterial(tempStoredMaterial)
                .build();
    }

    public static Person parsePerson() {
        String tempSurname;
        int tempAge;
        String tempGender;System.out.println("\nВведите фамилию человека: (50 букв максимум)");
        tempSurname = scanner.nextLine();
        tempAge = Validate.getIntFromInput(scanner.nextLine());
        System.out.println("Если человек мужчина - введите \"1\", если женщина - введите любое другое значение");
        tempGender = scanner.nextLine().equals("1") ? "М" : "Ж";
        return new Person.Builder()
                .setSurname(tempSurname)
                .setAge(tempAge)
                .setGender(tempGender)
                .build();
    }

}
