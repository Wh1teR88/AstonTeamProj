package projectcore;

public interface IPersonBuilder {
    IPersonBuilder setPersonForname(String personForname);

    IPersonBuilder setPersonAge(int personAge);

    IPersonBuilder setPersonGender(String personGender);

    Person createPerson();
}
