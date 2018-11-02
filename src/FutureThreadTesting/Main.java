package FutureThreadTesting;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    private static ExecutorService executor =
            Executors.newSingleThreadExecutor();

    public static void main(String[] args)
    {
        System.out.println("what is going on?");
        System.out.println(calcSquare(1));
        System.out.println("end");
    }

    public static Future<Integer> calc(int a)
    {
        return executor.submit(() -> {
           Thread.sleep(1000);
           return a*a;
        });
    }

    static Integer calcSquare(int a)
    {
        try{
        Future<Integer> out = calc(a);
        while(!out.isDone()){
            Thread.sleep(200);
            System.out.println("not done yet");
        }
        return out.get();
        } catch (Exception e)
        {
            System.out.println("there was an exception");
        }
        return null;
    }
}
