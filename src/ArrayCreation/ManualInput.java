package ArrayCreation;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

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
            System.out.println("У животного есть шерсть? \"1\" - да, любая другая кнопка - нет:");
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
        ArrayList<Barrel> barrels = new ArrayList<>();
        double tempVolume = 0.0;
        String tempStoredMaterial;
        String tempMaterial;
        int added = 0;
        while (added < length) {
            boolean volumeIsCorrect = false;
            while(!volumeIsCorrect) {
                System.out.println("\nВведите объем бочки в литрах (число больше нуля): ");
                int userInput = scanner.nextInt();
                if (userInput > 0) {
                    volumeIsCorrect = true;
                    tempVolume = userInput;
                    scanner.nextLine(); //очистка буфера scanner! не удалять!
                } else {
                    System.out.println("Объем бочки не может быть отрицательным, попробуйте снова.");
                }
            }
            System.out.println("Что находится в бочке?");
            tempStoredMaterial = scanner.nextLine();
            System.out.println("Введите материал, из которого сделана бочка:");
            tempMaterial = scanner.nextLine();
            barrels.add(new Barrel.Builder()
                    .setVolume(tempVolume)
                    .setMaterial(tempMaterial)
                    .setStoredMaterial(tempStoredMaterial)
                    .build());
            added++;
            System.out.println("Добавлено бочек: " + added + ". Осталось добавить: " + (length - added) + ".");
        }
        return (ArrayList<T>) barrels;
    }

    private ArrayList<T> createPersonArray(int length) {
        ArrayList<Person> persons = new ArrayList<>();
        String tempSurname;
        int tempAge = 0;
        String tempGender;
        int added = 0;
        while (added < length) {
            System.out.println("\nВведите фамилию человека:");
            tempSurname = scanner.nextLine();
            boolean ageIsCorrect = false;
            while(!ageIsCorrect) {
                System.out.println("Сколько лет человеку? (введите положительное значение): ");
                int userInput = scanner.nextInt();
                if (userInput > 0) {
                    ageIsCorrect = true;
                    tempAge = userInput;
                    scanner.nextLine(); //очистка буфера scanner! не удалять!
                } else {
                    System.out.println("Возраст не может быть отрицательным, попробуйте снова.");
                }
            }
            System.out.println("Если человек мужчина - введите \"1\", если женщина - введите люое другое значение");
            tempGender = scanner.nextLine().equals("1") ? "М" : "Ж";
            persons.add(new Person.Builder()
                    .setSurname(tempSurname)
                    .setAge(tempAge)
                    .setGender(tempGender)
                    .build());
            added++;
            System.out.println("Добавлено людей: " + added + ". Осталось добавить: " + (length - added) + ".");
        }
        return (ArrayList<T>) persons;
    }
}
