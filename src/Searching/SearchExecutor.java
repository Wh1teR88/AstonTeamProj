package Searching;

import Entity.*;
import ArrayCreation.ObjectType;

import java.util.List;
import java.util.Scanner;

public class SearchExecutor<T extends Comparable<T>> {
    private final Scanner scanner = new Scanner(System.in);

    public void performSearch(ObjectType objectType, List<T> sortedList) {
        switch (objectType) {
            case ANIMAL:
                searchAnimal((List<Animal>) sortedList);
                break;
            case BARREL:
                searchBarrel((List<Barrel>) sortedList);
                break;
            case PERSON:
                searchPerson((List<Person>) sortedList);
                break;
            default:
                System.out.println("Неизвестный тип объекта для поиска.");
        }
    }

    private void searchAnimal(List<Animal> animalList) {
        System.out.println("\nВведите данные животного для поиска:");
        Animal searchAnimal = createAnimalManually();
        BinarySearch<Animal> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(animalList, searchAnimal);
        if (index != -1) {
            System.out.println("Животное найдено на позиции: " + index);
            System.out.println(animalList.get(index));
        } else {
            System.out.println("Животное не найдено в списке.");
        }
    }

    private void searchBarrel(List<Barrel> barrelList) {
        System.out.println("\nВведите данные бочки для поиска:");
        Barrel searchBarrel = createBarrelManually();
        BinarySearch<Barrel> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(barrelList, searchBarrel);
        if (index != -1) {
            System.out.println("Бочка найдена на позиции: " + index);
            System.out.println(barrelList.get(index));
        } else {
            System.out.println("Бочка не найдена в списке.");
        }
    }

    private void searchPerson(List<Person> personList) {
        System.out.println("\nВведите данные человека для поиска:");
        Person searchPerson = createPersonManually();
        BinarySearch<Person> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(personList, searchPerson);
        if (index != -1) {
            System.out.println("Человек найден на позиции: " + index);
            System.out.println(personList.get(index));
        } else {
            System.out.println("Человек не найден в списке.");
        }
    }

    private Animal createAnimalManually() {
        System.out.println("Введите вид животного:");
        String species = scanner.nextLine();
        System.out.println("Введите цвет глаз животного:");
        String eyeColor = scanner.nextLine();
        System.out.println("У животного есть шерсть? (1 - да, 2 - нет):");
        boolean wool = scanner.nextLine().equals("1");
        System.out.println("Введите вес животного:");
        double weight = Double.parseDouble(scanner.nextLine());

        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setWool(wool)
                .setWeight(weight)
                .build();
    }

    private Barrel createBarrelManually() {
        System.out.println("Введите объем бочки:");
        double volume = Double.parseDouble(scanner.nextLine());
        System.out.println("Введите хранимый материал:");
        String storedMaterial = scanner.nextLine();
        System.out.println("Введите материал бочки:");
        String material = scanner.nextLine();

        return new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial(storedMaterial)
                .setMaterial(material)
                .build();
    }

    private Person createPersonManually() {
        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите пол (М/Ж):");
        String gender = scanner.nextLine();

        return new Person.Builder()
                .setSurname(surname)
                .setAge(age)
                .setGender(gender)
                .build();
    }
}
