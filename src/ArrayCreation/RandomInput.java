package ArrayCreation;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

import java.util.ArrayList;
import java.util.Random;

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
            String species = AnimalSpecies.values()[new Random().nextInt(AnimalSpecies.values().length)].toString();
            String eyeColor = AnimalEyeColors.values()[new Random().nextInt(AnimalEyeColors.values().length)].toString();
            boolean wool = random.nextBoolean();
            int weight = random.nextInt(1, 500);
            arrayList.add(new Animal.Builder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setWool(wool)
                    .setWeight(weight)
                    .build());
        }
        return (ArrayList<T>) arrayList;
    }

    private ArrayList<T> createBarrelArray(int length) {
        ArrayList<Barrel> arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            String material = BarrelMaterials.values()[new Random().nextInt(BarrelMaterials.values().length)].toString();
            String storedMaterial = BarrelStoredMaterials.values()[new Random().nextInt(BarrelStoredMaterials.values().length)].toString();
            int volume = random.nextInt(1, 100);
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
            String surname = Surnames.values()[new Random().nextInt(Surnames.values().length)].toString();
            String femaleSurnameCheck = "ая";
            String surnameLastLetter = surname.substring(surname.length() - 1);
            String gender = femaleSurnameCheck.contains(surnameLastLetter) ? "Ж" : "М";
            int age = random.nextInt(1, 125);
            arrayList.add(new Person.Builder()
                    .setAge(age)
                    .setGender(gender)
                    .setSurname(surname)
                    .build());
        }
        return (ArrayList<T>) arrayList;
    }

    private enum AnimalSpecies{
        Млекопитающее,
        Моллюск,
        Иглокожее,
        Рыба,
        Птица,
        Пресмыкающееся,
        Земноводное,
        Членистоногое,
        Ракообразное,
        Паукообразное,
        Насекомое
    }
    private enum AnimalEyeColors{
        Черный,
        Белый,
        Красный,
        Синий,
        Зеленый,
        Желтый,
        Оранжевый,
        Переливающийся,
        Разноцветный,
        Карий,
        Голубой,
        Фиолетовый,
        Нет
    }
    private enum BarrelMaterials{
        Железо,
        Алюминий,
        Дерево,
        Пластик,
        Полиэтилен,
        Нержавейка,
        Стекло,
        Солома,
        Глина,
        Пластилин
    }
    private enum BarrelStoredMaterials{
        Вода,
        Масло,
        Бензин,
        Пиво,
        Спирт,
        Сок,
        Огурцы,
        Песок,
        Молоко,
        Кипяток,
        Грязь,
        Медведь
    }
    private enum Surnames {
        Краснова,
        Егоров,
        Афанасьева,
        Зубкова,
        Алексеев,
        Степанов,
        Орлова,
        Ермаков,
        Медведева,
        Глухов,
        Борисова,
        Яковлев,
        Иванов,
        Королева,
        Скворцов,
        Куликов,
        Борисов,
        Макарова,
        Фирсов,
        Миронов,
        Смирнова,
        Панкратова,
        Максимова,
        Фомин,
        Новикова,
        Гаврилова,
        Юдин,
        Ларионов,
        Окулов,
        Прокофьева,
        Смирнов,
        Маркин,
        Федотова,
        Сахарова,
        Антонов,
        Морозов,
        Козловская,
        Воробьева,
        Розанова,
        Высоцкая,
        Толкачева,
        Павлова,
        Селиванова,
        Чернов,
        Корчагин,
        Мельников,
        Минаева
    }
}
