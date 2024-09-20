package projectcore;

public class Person {
    private String personForname;
    private int personAge;
    private String personGender;

    public Person() {
        this.personForname = "Nobody";
        this.personAge = 0;
        this.personGender = "None";
    }

    public Person(String personForname, int personAge, String personGender) {
        this.personForname = personForname;
        this.personAge = personAge;
        this.personGender = personGender;
    }

    public String getPersonForname() {
        return personForname;
    }
    public void setPersonForname(String personForname) {
        this.personForname = personForname;
    }
    public int getPersonAge() {
        return personAge;
    }
    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }
    public String getPersonGender() {
        return personGender;
    }
    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    @Override
    public String toString() {
        return "Person{" + personForname + ":" + personAge + ":" + personGender + '}';
    }
}
