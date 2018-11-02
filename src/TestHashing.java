import java.util.HashSet;
import java.util.Objects;

public class TestHashing {
    public static void main(String[] args)
    {
        System.out.println("it is working");
        HashSet<HashingClass> set = new HashSet<>();
        set.add(new HashingClass(1,"two"));
        set.add(new HashingClass(1,"two"));


        HashSet<Integer> two = new HashSet<>();

        two.add(3);
        two.add(6);
        two.add(6);

        int stop = 0;

        Wazzup one = new HashingClass(1,"tow");
        one.calculate();

        Wazzup amd = new HashClassTwo(1,"sdf");
        amd.calculate();
    }
}

class HashClassTwo extends HashingClass
{
    HashClassTwo(int one, String two){super(one,two);}
}

class HashingClass implements Wazzup{
    private int one;
    private String two;
    HashingClass(int one,String two)
    {
        this.one = one;
        this.two = two;
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(one,two);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HashingClass)) return false;
        HashingClass that = (HashingClass) o;
        return one == that.one &&
                two.equals(that.two);
    }
    @Override
    public void calculate()
    {
        System.out.println("the calculate method worked");
    }
}



interface Wazzup {
    public void calculate();
}