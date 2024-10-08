package Entity;

import java.util.Comparator;

public final class Person implements Comparable<Person> {
    private final String gender;
    private final int age;
    private final String surname;

    private Person(Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.surname = builder.surname;
    }

    public static class Builder {
        private String gender;
        private int age;
        private String surname;

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    private String normalizeString(String string) {
        return string.toLowerCase().trim().replace('ё', 'е');
    }

    @Override
    public int compareTo(Person other) {
        return Comparator.comparing((Person p) -> normalizeString(p.surname))
                .thenComparing(p -> p.age)
                .thenComparing(p -> normalizeString(p.gender))
                .compare(this, other);
    }

    @Override
    public String toString() {
        return "Человек по фамилии "
                + surname + ", "
                + age + " лет, "
                + (gender.equals("М") ? "мужчина" : "женщина");
    }

    public String prepareToWrite(){
        StringBuilder sbPerson = new StringBuilder();
        sbPerson.append(gender + "\n");
        sbPerson.append(age + "\n");
        sbPerson.append(surname + "\n");
        return sbPerson.toString();
    }
}


