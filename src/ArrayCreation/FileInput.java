package ArrayCreation;

import Entity.*;
import Validating.Validate;

import java.io.*;
import java.util.ArrayList;

public class FileInput<T> implements InputManager<T> {
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
        int tempWeight;
        try (BufferedReader reader = new BufferedReader(new FileReader("AnimalsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[4];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.isEmpty()) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 4) {
                    index = 0;
                    tempSpecies = lineObject[0];
                    tempEyeColor = lineObject[1];
                    tempWool = lineObject[2].equalsIgnoreCase("да")
                            || lineObject[2].equalsIgnoreCase("true")
                            || lineObject[2].equalsIgnoreCase("есть")
                            || lineObject[2].equalsIgnoreCase("yes");
                    try {
                        tempWeight = Integer.parseInt(lineObject[3]);
                    } catch (NumberFormatException e) {
                        tempWeight = -1; // -1 чтобы Валидатор не пропустил некорректное животное
                    }
                    Animal tempAnimal = new Animal.Builder()
                            .setSpecies(tempSpecies)
                            .setEyeColor(tempEyeColor)
                            .setWool(tempWool)
                            .setWeight(tempWeight)
                            .build();
                    if(Validate.validateAnimal(tempAnimal)){
                        animals.add(tempAnimal);
                        added++;
                    }
                    else {
                        System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) animals;
    }

    private ArrayList<T> createBarrelArray(int length) {
        ArrayList<Barrel> barrels = new ArrayList<>();
        int tempVolume;
        String tempStoredMaterial;
        String tempMaterial;
        try (BufferedReader reader = new BufferedReader(new FileReader("BarrelsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[3];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.isEmpty()) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 3) {
                    index = 0;
                    try {
                        tempVolume = Integer.parseInt(lineObject[0]);
                    } catch (NumberFormatException e) {
                        tempVolume = -1; // -1 чтобы Валидатор не пропустил некорректную бочку
                    }
                    tempStoredMaterial = lineObject[1];
                    tempMaterial = lineObject[2];
                    Barrel tempBarrel = new Barrel.Builder()
                            .setVolume(tempVolume)
                            .setStoredMaterial(tempStoredMaterial)
                            .setMaterial(tempMaterial)
                            .build();
                    if(Validate.validateBarrel(tempBarrel)){
                        barrels.add(tempBarrel);
                        added++;
                    }
                    else {
                        System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) barrels;
    }


    private ArrayList<T> createPersonArray(int length) {
        ArrayList<Person> persons = new ArrayList<>();
        String tempSurname;
        int tempAge;
        String tempGender = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("PersonsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[3];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.isEmpty()) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 3) {
                    index = 0;
                    tempSurname = lineObject[0];
                    try {
                        tempAge = Integer.parseInt(lineObject[1]);
                    } catch (NumberFormatException e) {
                        tempAge = -1; // -1 чтобы Валидатор не пропустил некорректную бочку
                    }
                    if (lineObject[2].equalsIgnoreCase("м")
                            || lineObject[2].equalsIgnoreCase("муж")
                            || lineObject[2].equalsIgnoreCase("мужской")
                            || lineObject[2].equalsIgnoreCase("мужчина")) {
                        tempGender = "М";
                    } else tempGender = "Ж";
                    Person tempPerson = new Person.Builder()
                            .setSurname(tempSurname)
                            .setAge(tempAge)
                            .setGender(tempGender)
                            .build();
                    if(Validate.validatePerson(tempPerson)){
                        persons.add(tempPerson);
                        added++;
                    }
                    else {
                        System.out.println("\nНекоторые параметры из файла не соответствуют требованиям, объекты не добавлены в список.");
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) persons;
    }
}

