package ArrayCreation;

import Entity.Animal;

import java.sql.SQLOutput;
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
        String tempSpecies;
        String tempEyeColor;
        boolean tempWool;
        double tempWeight;
        int added = 0;
        while (added < length) {
            System.out.println("\nВведите вид животного: ");
            tempSpecies = scanner.nextLine();
            System.out.println("Введите цвет глаз животного: ");
            tempEyeColor = scanner.nextLine();
            System.out.println("У животного есть шерсть? 1 - да, любая другая кнопка - нет:");
            tempWool = scanner.nextLine().equals("1");
            System.out.println("Сколько килограммов весит животное?");
            tempWeight = Double.parseDouble(scanner.nextLine());
            animals.add(new Animal.Builder()
                    .setSpecies(tempSpecies)
                    .setEyeColor(tempEyeColor)
                    .setWool(tempWool)
                    .setWeight(tempWeight)
                    .build());
            added++;
            System.out.println("Добавлено животных: " + added + ". Осталось добавить: " + (length - added) + ".");
        }
        return (ArrayList<T>) animals;
    }

    private ArrayList<T> createBarrelArray(int length) {
        return null;
    }

    private ArrayList<T> createPersonArray(int length) {
        return null;
    }
}
