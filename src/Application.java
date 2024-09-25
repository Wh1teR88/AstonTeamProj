import ArrayCreation.*;
import Entity.*;
import Searching.BinarySearch;
import Sorting.InsertionSortStrategy;
import Sorting.Patterns.Strategy.SortingPlan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final Scanner scanner = new Scanner(System.in);

    static ObjectType workObject;
    static List<? extends Comparable<?>> workList;
    static SortingPlan<? extends Comparable<?>> sortingPlan;

    public static void main(String[] args) {

        System.out.println("Приветствуем вас в программе для сортировки!");
        System.out.println("============================================");

        while (true) {
            workObject = selectObjectToWork();
            workList = chooseArrayCreator(workObject);
            System.out.println("\nИсходный список " + workObject.toString());
            printList(workList);
            sortingPlan = chooseSortingPlan();
            sortObjects();
            System.out.println("\nОтсортированный список " + workObject.toString());
            printList(workList);
            System.out.println("\nБинарный поиск");
            do {
                performBinarySearch();
                System.out.println("1 чтобы продолжать искать объекты, иначе начать работу с новым списком");
            } while (scanner.nextLine().equals("1"));
        }
    }

    private static ObjectType selectObjectToWork() {
        boolean selected = false;
        ObjectType workObject = null;
        while (!selected) {
            System.out.println("\nС чем нужно работать?");
            System.out.println("1. С животными.");
            System.out.println("2. С бочками.");
            System.out.println("3. С людьми.");
            System.out.println("4. Выход.");

            int userChoice = validateUserInput(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    workObject = ObjectType.ANIMAL;
                    selected = true;
                    break;
                case 2:
                    workObject = ObjectType.BARREL;
                    selected = true;
                    break;
                case 3:
                    workObject = ObjectType.PERSON;
                    selected = true;
                    break;
                case 4:
                    selected = true;
                    stopProgram();
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз.");
            }
        }
        return workObject;
    }

    private static void sortObjects() {
        //TODO разобраться насколько критичная ошибка, по факту мы чекаем по workObject и свитчим соответствующий каст (вероятно костыль)
        switch (workObject) {
            case ANIMAL:
                sortAnimals((List<Animal>) workList, (SortingPlan<Animal>) sortingPlan);
                break;
            case BARREL:
                sortBarrels((List<Barrel>)workList, (SortingPlan<Barrel>) sortingPlan);
                break;
            case PERSON:
                sortPersons((List<Person>) workList, (SortingPlan<Person>) sortingPlan);
                break;
        }
    }

    private static void sortAnimals(List<Animal> animals, SortingPlan<Animal> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(animals);
        } else {
            stopProgram();
        }
    }

    private static void sortBarrels(List<Barrel> barrels, SortingPlan<Barrel> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(barrels);
        } else {
            stopProgram();
        }
    }

    private static void sortPersons(List<Person> persons, SortingPlan<Person> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(persons);
        } else {
            stopProgram();
        }
    }

    private static <T> ArrayList<T> chooseArrayCreator(ObjectType objectType) {

        int arrayLength = 1;
        boolean sizeCorrect = false;
        while (!sizeCorrect) {
            System.out.println("\nВведите размер списка (1 - 100):");

            int userChoice = validateUserInput(scanner.nextLine());

            if (userChoice < 1 || userChoice > 100) {
                System.out.println("Неверный размер списка, попробуйте снова.");
            }
            else {
                arrayLength = userChoice;
                sizeCorrect = true;
            }
        }
        ArrayCreator<T> arrayCreator = new ArrayCreator<>(objectType, arrayLength);

        boolean selected = false;
        while (!selected) {
            System.out.println("Выберите способ ввода данных:\n");
            System.out.println("1. Ввести самостоятельно.");
            System.out.println("2. Из файла.");
            System.out.println("3. Случайная генерация.");
            System.out.println("4. Выход.");

            int userChoice = validateUserInput(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    arrayCreator.setInputManager(new ManualInput<>());
                    selected = true;
                    break;
                case 2:
                    arrayCreator.setInputManager(new FileInput<>());
                    selected = true;
                    break;
                case 3:
                    arrayCreator.setInputManager(new RandomInput<>());
                    selected = true;
                    break;
                case 4:
                    stopProgram();
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз.");
            }
        }
        return arrayCreator.createArray();
    }

    private static <T extends Comparable<T>> SortingPlan<T> chooseSortingPlan() {

        SortingPlan<T> sortingPlan = new SortingPlan<>();
        boolean selected = false;

        while (!selected) {
            System.out.println("\nВыберите стратегию сортировки:");
            System.out.println("1. Insertion sort");
            System.out.println("2. Custom sort");
            System.out.println("3. Выход");

            int userChoice = validateUserInput(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    selected = true;
                    sortingPlan.setStrategy(new InsertionSortStrategy<>());
                    break;
                case 2:
                    //TODO см. дополнительное задание
                    //selected = true;
                    //sortingPlan.setStrategy(new CustomSortStrategy<>());
                    break;
                case 3:
                    return null;
                default:
                    System.out.println("Ошибка ввода, попробуйте ещё раз.");
            }
        }
        return sortingPlan;
    }

    private static void performBinarySearch() {
        int index = switch (workObject) {
            case ANIMAL -> new BinarySearch<Animal>().search((List<Animal>) workList, ManualInput.parseAnimal());
            case BARREL -> new BinarySearch<Barrel>().search((List<Barrel>) workList, ManualInput.parseBarrel());
            case PERSON -> new BinarySearch<Person>().search((List<Person>) workList, ManualInput.parsePerson());
        };
        if (index != -1) {
            System.out.println("Найдено с индексом " + index + ": " + workList.get(index));
        } else {
            System.out.println("Ничего не найдено.");
        }
    }

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    private static void stopProgram() {
        System.out.println("Программа завершает работу...");
        System.exit(0);
    }

    private static int validateUserInput(String input){
        int userChoice;
        try{
            userChoice = Integer.parseInt(input);
        }catch (NumberFormatException e){
            userChoice = 100;
        }
        return userChoice;
    }
}
