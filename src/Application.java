import Entity.Animal;
import Entity.Barrel;
import Entity.Person;
import Searching.BinarySearch;
import Sorting.Patterns.Strategy.SortingPlan;
import ArrayCreation.*;

import java.util.Scanner;
import java.util.List;

public class Application         {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean terminate = false;

        while (!terminate) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Работа с Animal");
            System.out.println("2. Работа с Barrel");
            System.out.println("3. Работа с Person");
            System.out.println("4. Выход");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    selectedAnimals();
                    break;
                case 2:
                    selectedBarrels();
                    break;
                case 3:
                    selectedPersons();
                    break;
                case 4:
                    terminate = true;
                    System.out.println("Выход.");
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз.");
            }
        }
    }

    private static void selectedAnimals() {
        List<Animal> animals = chooseDataInputOption(ObjectType.ANIMAL);
        if (animals == null) {
            return;
        }

        System.out.println("Неотсортированный список Animals:");
        printList(animals);

        SortingPlan<Animal> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(animals);
        }

        System.out.println("Отсортированный список Animals:");
        printList(animals);

        System.out.print("Введите вид животного: ");
        String species = scanner.nextLine();
        Animal key = new Animal.Builder()
                .setSpecies(species)
                .setEyeColor("")
                .setWool(false)
                .build();

        BinarySearch<Animal> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(animals, key);

        if (index != -1) {
            System.out.println("Найдено: " + animals.get(index));
        } else {
            System.out.println("Ничего не найдено.");
        }
    }

    private static void selectedBarrels() {
        List<Barrel> barrels = chooseDataInputOption(ObjectType.BARREL);
        if (barrels == null) {
            return;
        }

        System.out.println("Нетсортированный список Barrels:");
        printList(barrels);

        SortingPlan<Barrel> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(barrels); // нужно убрать эти проверки на нулл и пробросить их через validate
        }

        System.out.println("Отсортированный список Barrels:");
        printList(barrels);

        // Бинарный поиск
        System.out.print("Введите объем бочки: ");
        double volume = Double.parseDouble(scanner.nextLine());
        Barrel key = new Barrel.Builder()
                .setVolume(volume)
                .setStoredMaterial("")
                .setMaterial("")
                .build();

        BinarySearch<Barrel> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(barrels, key);

        if (index != -1) {
            System.out.println("Найдено: " + barrels.get(index));
        } else {
            System.out.println("Ничего не найдено.");
        }
    }

    private static void selectedPersons() {
        List<Person> persons = chooseDataInputOption(ObjectType.PERSON);
        if (persons == null)  {
            return;
        }

        System.out.println("Нетсортированный список Persons:");
        printList(persons);

        SortingPlan<Person> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(persons);
        }

        System.out.println("Отсортированный список Persons:");
        printList(persons);

        // Бинарный поиск
        System.out.print("Введите фамилию: ");
        String surname = scanner.nextLine();
        Person key = new Person.Builder()
                .setGender("")
                .setAge(0)
                .setSurname(surname)
                .build();

        BinarySearch<Person> binarySearch = new BinarySearch<>();
        int index = binarySearch.search(persons, key);

        if (index != -1) {
            System.out.println("Найдено: " + persons.get(index));
        } else {
            System.out.println("Не найдено.");
        }
    }

    //не сделано
    private static <T> List<T> chooseDataInputOption(ObjectType objectType) {
        // через этот метод нужно заполнять List и потом его как-то обрабатывать
        System.out.println("Выберите способ ввода данных:\n");
        System.out.println("1. Ввести самостоятельно.");
        System.out.println("2. Из файла");
        System.out.println("3. Случайная генерация.");
        System.out.println("4. Выйти.");

        int userChoice = Integer.parseInt(scanner.nextLine());
        int arrayLength;
        switch (userChoice) {
            case 1:
                System.out.println("Введите размер массива");
                arrayLength = Integer.parseInt(scanner.nextLine());
                return new ArrayCreationContext<>(new ManualInput<T>(), objectType, arrayLength).createArray();
            case 2:
                return new ArrayCreationContext<>(new FileInput<T>(), objectType).createArray();
            case 3:
                System.out.println("Введите размер массива");
                arrayLength = Integer.parseInt(scanner.nextLine());
                return new ArrayCreationContext<>(new RandomInput<T>(), objectType, arrayLength).createArray();
            case 4:
                System.out.println("Выход.");
                break;
            default:
                System.out.println("Ошибка ввода, попробуйте еще раз.");
        }

        return null; // не сделано
    }

    // не сделано
    private static <T extends Comparable<T>> SortingPlan<T> chooseSortStrategyOption() {
        System.out.println("Выберите стратегию сортировки:");
        System.out.println("1. Insertion sort");
        System.out.println("2. Custom sort");

        int userChoice = Integer.parseInt(scanner.nextLine());

        return null; // не сделаон
    }

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }
}
