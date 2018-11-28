public class TestPrecision {
    public static void main(String[] args)
    {
        double one = 1.2342003423423429;

        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum += one;
        }
        System.out.println("summing ten times: " + sum);
        System.out.println("multiplying by ten: " + one*10);




        double two = 1.34534524356453;
        double three = 2.334534534534534;
        System.out.println(one*two/three);
        System.out.println((two/three)*one);
    }
}
