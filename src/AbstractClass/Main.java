package AbstractClass;

public class Main {
    public static void main(String[] args)
    {

    }
}

abstract class Bird {
    int one;

    public Bird() {
    }

    public Bird(int one) {
        this.one = one;
    }
}

class Duck extends Bird{
    int five;
    Duck(){
    }
    Duck(int five)
    {
        this.five = five;
    }
}