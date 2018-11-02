package Sets;

import java.util.Objects;

public class Person implements Comparable<Person>{
    public int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Person person)
    {
        return name.compareTo(person.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return person.name.equals(this.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
