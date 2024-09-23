package ArrayCreation;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class RandomInput<T> implements InputManager<T> {
    private final Random random = new Random();
    @Override
    public ArrayList<T> createArray(ObjectType objectType, int length) {
        return switch (objectType) {
            case ANIMAL -> createAnimalArray(length);
            case BARREL -> createBarrelArray(length);
            case PERSON -> createPersonArray(length);
        };
    }

    private ArrayList<T> createAnimalArray(int length) {
        ArrayList<Animal> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String species = randomString();
            String eyeColor = randomString();
            boolean wool = random.nextBoolean();
            arrayList.add(new Animal.Builder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setWool(wool)
                    .build());
        }
        return (ArrayList<T>) arrayList;
    }

    private ArrayList<T> createBarrelArray(int length) {
        ArrayList<Barrel> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String material = randomString();
            String storedMaterial = randomString();
            double volume = random.nextInt(10,100);
            arrayList.add(new Barrel.Builder()
                    .setVolume(volume)
                    .setMaterial(material)
                    .setStoredMaterial(storedMaterial)
                    .build());
        }
        return (ArrayList<T>) arrayList;
    }

    private ArrayList<T> createPersonArray(int length) {
        ArrayList<Person> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String surname = randomString();
            String gender = random.nextDouble() < 0.5 ? "М" : "Ж";
            int age = random.nextInt(0,125);
            arrayList.add(new Person.Builder()
                    .setAge(age)
                    .setGender(gender)
                    .setSurname(surname)
                    .build());
        }
        return (ArrayList<T>) arrayList;
    }

    private String randomString() {
        int left = 1072;
        int right = 1104;
        int length = random.nextInt(1, 15);
        StringBuilder buffer = new StringBuilder(length);
        buffer.append((char)random.nextInt(left - 32, right - 32));
        for (int i = 0; i < length; i++) {
            int randomLimitedInt = left + (int)
                    (random.nextFloat() * (right - left));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}
