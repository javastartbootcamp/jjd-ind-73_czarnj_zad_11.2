package pl.javastart.task;

import java.util.Objects;

public class Person {
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MIN_AGE = 1;
    private String firstName;
    private String lastName;
    private int age;
    private String pesel;

    public Person(String firstName, String lastName, int age, String pesel) {
        preCheckName(firstName);
        preCheckName(lastName);
        preCheckAge(age);
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
    }

    private void preCheckName(String name) {
        if (name == null) {
            throw new NameUndefinedException("Name can't be null");
        } else if (name.length() < MIN_NAME_LENGTH) {
            throw new NameUndefinedException(String.format("Name %s can't be shorter than %d",
                    name, MIN_NAME_LENGTH));
        }
    }

    private void preCheckAge(int age) {
        if (age < MIN_AGE) {
            throw new IncorrectAgeException(String.format("Age %d can't be less than %d",
                    age, MIN_AGE));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        preCheckName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        preCheckName(lastName);
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        preCheckAge(age);
        this.age = age;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", pesel='" + pesel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Person person)) {
            return false;
        }
        return age == person.age && Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(pesel, person.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age, pesel);
    }
}
