package ArrayCreation;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        try (BufferedReader reader = new BufferedReader(new FileReader("AnimalsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[4];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.length() == 0) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 4) {
                    index = 0;
                    animals.add(new Animal.Builder()
                            .setSpecies(lineObject[0])
                            .setEyeColor(lineObject[1])
                            .setWool(Boolean.valueOf(lineObject[2]))
                            .setWeight(Double.parseDouble(lineObject[3]))
                            .build());
                    added++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) animals;
    }

    private ArrayList<T> createBarrelArray(int length) {
        ArrayList<Barrel> barrels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("BarrelsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[3];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.length() == 0) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 3) {
                    index = 0;
                    barrels.add(new Barrel.Builder()
                            .setVolume(Double.parseDouble(lineObject[0]))
                            .setStoredMaterial(lineObject[1])
                            .setMaterial(lineObject[2])
                            .build());
                    added++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) barrels;
    }


    private ArrayList<T> createPersonArray(int length) {
        ArrayList<Person> persons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("PersonsInput.txt"));) {
            String readedLine;
            int added = 0;
            int index = 0;
            String[] lineObject = new String[3];
            while ((readedLine = reader.readLine()) != null && added < length) {
                readedLine = readedLine.trim();
                if (readedLine.length() == 0) {
                    continue;
                }
                lineObject[index++] = readedLine;
                if (index == 3) {
                    index = 0;
                    persons.add(new Person.Builder()
                            .setGender(lineObject[0].toUpperCase())
                            .setAge(Integer.parseInt(lineObject[1]))
                            .setSurname(lineObject[2])
                            .build());
                    added++;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return (ArrayList<T>) persons;
    }
}

