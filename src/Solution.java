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
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int maxVal = 0;
            int minVal = 0;
            int prev = in.nextInt();
            for (int j = 0; j < n - 1; j++) {
                int current = in.nextInt();
                int temp = maxVal;
                maxVal = Math.max(maxVal+(Math.abs(prev - current)), minVal + (Math.abs(1 - current)));
                minVal = Math.max(temp+(Math.abs(prev - 1)), minVal);
                prev = current;
            }
            System.out.println(Math.max(minVal,maxVal));
        }
        /////////////////////// Main End\\
        in.close();
    }
    ////////////////////////Methods for current Project/////////////////


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
