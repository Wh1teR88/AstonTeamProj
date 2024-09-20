package projectcore;

public class PersonBuilder implements IPersonBuilder {
    Person currentPerson = new Person();

    @Override
    public IPersonBuilder setPersonForname(String personForname) {
        currentPerson.setPersonForname(personForname);
        return this;
    }

    @Override
    public IPersonBuilder setPersonAge(int personAge) {
        currentPerson.setPersonAge(personAge);
        return this;
    }

    @Override
    public IPersonBuilder setPersonGender(String personGender) {
        currentPerson.setPersonGender(personGender);
        return this;
    }

    @Override
    public Person createPerson() {
        return currentPerson;
    }
}
