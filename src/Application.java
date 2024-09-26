import ArrayCreation.*;
import Entity.*;
import Output.ListWriter;
import Searching.*;
import Sorting.*;
import Sorting.Patterns.Strategy.SortingPlan;

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
            selectObjectToWork();
            chooseArrayCreator(workObject);
            System.out.println("\nИсходный список " + workObject.toString());
            printList(workList);
            chooseSortingPlan();
            sortObjects();
            System.out.println("\nОтсортированный список " + workObject.toString());
            printList(workList);
            chooseNextStep();
        }
    }

    private static void selectObjectToWork() {
        boolean selected = false;
        while (!selected) {
            System.out.println("""
                    \nС чем нужно работать?\
                    \n1. С животными.\
                    \n2. С бочками.\
                    \n3. С людьми.\
                    \n4. Выход.""");

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
    }

    private static <T> void chooseArrayCreator(ObjectType objectType) {

        int arrayLength = 1;
        boolean sizeCorrect = false;
        while (!sizeCorrect) {
            System.out.println("\nВведите размер списка (1 - 100):");
            int userChoice = validateUserInput(scanner.nextLine());
            if (userChoice > 1 && userChoice < 100) {
                arrayLength = userChoice;
                sizeCorrect = true;
            } else {
                System.out.println("Неверный размер списка, попробуйте снова.");
            }
        }

        ArrayCreator<T> arrayCreator = new ArrayCreator<>(objectType, arrayLength);

        boolean selected = false;
        while (!selected) {
            System.out.println("""
                    \nВыберите способ ввода данных:\
                    \n1. Ввести самостоятельно.\
                    \n2. Из файла.\
                    \n3. Случайная генерация.\
                    \n4. Выход.""");

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
        workList = (List<? extends Comparable<?>>) arrayCreator.createArray();
    }

    private static void chooseSortingPlan() {

        sortingPlan = new SortingPlan<>();
        boolean selected = false;

        while (!selected) {
            System.out.println("""
                    \nВыберите следующее действие:\
                    \n1. Сортировка вставками\
                    \n2. Сортировка только четных значений\
                    \n3. Записать неотсортированный список в файл.\
                    \n4. Выход""");

            int userChoice = validateUserInput(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    selected = true;
                    sortingPlan.setStrategy(new InsertionSortStrategy<>());
                    break;
                case 2:
                    selected = true;
                    sortingPlan.setStrategy(new CustomSortStrategy<>());
                    break;
                case 3:
                    ListWriter.writeAll(workList);
                    break;
                case 4:
                    stopProgram();
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте ещё раз.");
            }
        }
    }

    private static void sortObjects() {
        switch (workObject) {
            case ANIMAL:
                sortAnimals((List<Animal>) workList, (SortingPlan<Animal>) sortingPlan);
                break;
            case BARREL:
                sortBarrels((List<Barrel>) workList, (SortingPlan<Barrel>) sortingPlan);
                break;
            case PERSON:
                sortPersons((List<Person>) workList, (SortingPlan<Person>) sortingPlan);
                break;
        }
    }

    private static void sortAnimals(List<Animal> animals, SortingPlan<Animal> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(animals);
            System.out.println("Ваш список отсортирован!");
        } else {
            System.out.println("Ошибка, метод сортировки не найден. Программа завершает работу.");
            stopProgram();
        }
    }

    private static void sortBarrels(List<Barrel> barrels, SortingPlan<Barrel> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(barrels);
        } else {
            System.out.println("Ошибка, метод сортировки не найден. Программа завершает работу.");
            stopProgram();
        }
    }

    private static void sortPersons(List<Person> persons, SortingPlan<Person> sortingPlan) {
        if (sortingPlan != null) {
            sortingPlan.sort(persons);
        } else {
            System.out.println("Ошибка, метод сортировки не найден. Программа завершает работу.");
            stopProgram();
        }
    }

    private static void performBinarySearch() {
        do {
            int index = switch (workObject) {
                case ANIMAL -> new BinarySearch<Animal>().search((List<Animal>) workList, ManualInput.parseAnimal());
                case BARREL -> new BinarySearch<Barrel>().search((List<Barrel>) workList, ManualInput.parseBarrel());
                case PERSON -> new BinarySearch<Person>().search((List<Person>) workList, ManualInput.parsePerson());
            };
            if (index != -1) {
                System.out.println("\nОбъект найден!\nНаходится по индексу " + index + ": " + workList.get(index));
            } else {
                System.out.println("С такими параметрами ничего не найдено.");
            }
            System.out.println("\nВведите \"1\" чтобы продолжить поиск, или любое другое значение чтобы вернуться в начало программы.");
        } while (scanner.nextLine().equals("1"));

    }

    private static void chooseNextStep() {
        boolean selected = false;
        sortOrFind:
        while (!selected) {
            System.out.println("""
                    \nВыберите что делать дальше:\
                    \n1. Найти объект в полученном списке.\
                    \n2. Отсортировать список другим способом.\
                    \n3. Записать полученный список в файл.\
                    \n4. Выбрать другой объект.\
                    \n5. Выход.""");

            int userChoice = validateUserInput(scanner.nextLine());

            switch (userChoice) {
                case 1:
                    performBinarySearch();
                    selected = true;
                    break;
                case 2:
                    chooseSortingPlan();
                    sortObjects();
                    System.out.println("\nСписок " + workObject.toString() + " заново отсортирован");
                    printList(workList);
                    chooseNextStep();
                    selected = true;
                    break;
                case 3:
                    ListWriter.writeAll(workList);
                    break;
                case 4:
                    break sortOrFind;
                case 5:
                    selected = true;
                    stopProgram();
                    break;
                default:
                    System.out.println("Ошибка ввода, попробуйте еще раз.");
            }
        }
    }

    private static <T> void printList(List<T> list) {
        for (T element : list) {
            System.out.println(element);
        }
    }

    private static void stopProgram() {
        System.out.println("\nПрограмма завершает работу...");
        System.exit(0);
    }

    private static int validateUserInput(String input) {
        int userChoice;
        try {
            userChoice = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            userChoice = 101;
        }
        return userChoice;
    }
}
