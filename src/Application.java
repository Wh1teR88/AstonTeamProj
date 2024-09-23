import Entity.Animal;
import Entity.Barrel;
import Entity.Person;
import Searching.BinarySearch;
import Sorting.Patterns.Strategy.SortingPlan;

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
        List<Animal> animals = chooseDataInputOption();
        if (animals == null) {
            return;
        }

        SortingPlan<Animal> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(animals);
        }

        System.out.println("Отсортированный список Animals:");
        for (Animal animal : animals) {
            System.out.println(animal);
        }

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
        List<Barrel> barrels = chooseDataInputOption();
        if (barrels == null) {
            return;
        }

        SortingPlan<Barrel> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(barrels); // нужно убрать эти проверки на нулл и пробросить их через validate
        }

        System.out.println("Отсортированный список Barrels:");
        for (Barrel barrel : barrels) {
            System.out.println(barrel);
        }

        // Бинарный поиск
        System.out.print("Введите объем бочкu: ");
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
        List<Person> persons = chooseDataInputOption();
        if (persons == null)  {
            return;
        }

        SortingPlan<Person> sortingPlan = chooseSortStrategyOption();
        if (sortingPlan != null) {
            sortingPlan.sort(persons);
        }

        System.out.println("Отсортированный список Persons:");
        for (Person person : persons) {
            System.out.println(person);
        }

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
    private static <T> List<T> chooseDataInputOption() {
        // через этот метод нужно заполнять List и потом его как-то обрабатывать
        System.out.println("Выберите способ ввода данных:\n");
        System.out.println("1. Ввести самостоятельно.");
        System.out.println("2. Из файла");
        System.out.println("3. Слуйная генерация.");
        System.out.println("4. Выйти.");

        int userChoice = Integer.parseInt(scanner.nextLine());
        if (userChoice == 4)  {
            return null;
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
}
