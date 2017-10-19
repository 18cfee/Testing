import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    static int[] array;
    static int n;
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// Scannnner
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        printArray(array);
        array = quickSort(array);
        printArray(array);
        /////////////////////// Main End\\
        in.close();
    }
    ////////////////////////Methods for current Project/////////////////
    public static int[] quickSort(int[] array){
        if(array == null) return null;
        int sizeArray = array.length;
        if(sizeArray == 0) return array;
        Stack<Tuple> stack = new Stack<Tuple>();
        shuffleArray(array);
        int index1 = 0;
        int index2 = sizeArray - 1;
        Tuple tup = new Tuple(index1,index2);
        stack.push(tup);
        while(!stack.isEmpty()){
            tup = stack.pop();
            int first = tup.firstT;
            int last = tup.lastT;
            int pivot = array[last];
            last--;
            while(first < last) {
                int temp = array[first];
                // if less leave than pivot, otherwise swap it with end item and decrement + more comment
                if(temp < pivot){
                    first++;
                } else{
                    array[first] = array[last];
                    array[last] = temp;
                    last--;
                }
            }
            // equal goes in first section
            if(array[first] > pivot){
                array[tup.lastT] = array[first];
                array[first] = pivot;
                first--;
            } else{

                last++;
            }
            if(first - tup.firstT > 0){
                Tuple firstP = new Tuple(tup.firstT,first);
                stack.push(firstP);
            }
            if(tup.lastT - last > 0){
                Tuple lastP = new Tuple(last,tup.lastT);
                stack.push(lastP);
            }
        }
        return array;
    }

    private static void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
    ////////////////////////////////////////////////////////////////////

    ////////////////////////////////////3-Way Max////////////////////////////////////////////////
    public static int max(int aa, int bb, int cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    //////////////////////////////////Print array/////////////////////////////////////////////
    public static void printArray(int[][] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            int[] current = thatAr[i];
            for(int j= 0; j < current.length; j++){
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArray(int[] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr[i] + " ");
        }
        System.out.println();
    }

    public static void printList(List<Integer> thatAr){
        int nnn = thatAr.size();
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr.get(i) + " ");
        }
        System.out.println();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////// Reverse an Int /////////////////////////////////////////////
    public static int reverseInt(int x){
        StringBuilder in = new StringBuilder();
        in.append(Integer.toString(x));
        in.reverse();
        x = Integer.parseInt(in.toString());
        return x;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////Sum the Numeric digits in a String//////////////////////////////////////
    public static long sumDigits(String x){
        int tot = 0;
        for(int i = 0; i < x.length(); i++){
            tot += x.charAt(i) - '0';
        }
        return tot;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    ////////////////////////Default Dictionary//////////////////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////Return List Prime Factorization////////////////////////////////////

    ////////////////////////////////////////////////////////////////////////////////////////////
}
////////////////////////////////// Tuple Classes Here //////////////////////////////////////
class Tuple{
    public int firstT = 0;
    public int lastT = 0;
    Tuple(int first, int last){
        this.firstT = first;
        this.lastT = last;
    }
}
class TupleXY{
    public int xT = 0;
    public int yT = 0;
    TupleXY(int first, int last){
        this.xT = first;
        this.yT = last;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
