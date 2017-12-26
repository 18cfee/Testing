import org.junit.Test;
import static org.junit.Assert.*;

public class testing {
    private final double prec = 10000000;
    CarlNumbers m = new CarlNumbers();
    @Test
    public void testDistance(){
        assertTrue(m.distanceBetween(new Tuple(1,1),new Tuple(1,1)) > -.01);
    }

    @Test
    public void testDistance2(){
        long one = decToLong(m.distanceBetween(new Tuple(1,7),new Tuple(1,1)));
        long two = decToLong(6.0);
        assertEquals(one, two);
    }

    @Test
    public void testDistance3(){
        long one = decToLong(m.distanceBetween(new Tuple(0,0),new Tuple(1,1)));
        long two = decToLong(Math.sqrt(2));
        assertEquals(one, two);
    }

    //// Helpers after this point
    public long decToLong(double num){
        return (long)(prec * num);
    }

    //TODO read from multiple files for test cases?
}


