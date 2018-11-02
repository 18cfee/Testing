package Sets;

import java.util.HashSet;

public class Main {
    public static void main(String[] args)
    {
        HashSet<Person> set = new HashSet<>();
        Person one = new Person(234,"Carl");
        Person two = new Person(45, "Spencer");
        Person three = new Person(45,"Abigail");
        Person four = new Person(34, "Carl");
        set.add(four);
        set.add(one);
        set.add(two);
        set.add(three);

        for(Person person: set)
        {
            System.out.println(person.age + " " + person.name);
        }
    }
}
