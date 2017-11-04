package LinearRegression;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        // This is just generic stuff I use for hackerrank to make it easy to use IDE (reusing though)
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// This is code I wrote for this problem

        TupleXY[] plot= {new TupleXY(1,13),new TupleXY(4,9),new TupleXY(6,2),new TupleXY(8,3)};
        double y_int = 14.5;
        double slope = -1.8;
        System.out.println("R_2: " + rSquared(plot,y_int,slope));
        y_int = 15;
        slope = -1.4;
        System.out.println("R_2: " + rSquared(plot,y_int,slope));
        y_int = 14.5;
        slope = -1.7;
        System.out.println("R_2: " + rSquared(plot,y_int,slope));
        y_int = 15;
        slope = -1.8;
        System.out.println("R_2: " + rSquared(plot,y_int,slope));
        y_int = 14.43;
        slope = -1.617;
        System.out.println("R_2: " + rSquared(plot,y_int,slope));

        /////////////////////// Main End\\
        in.close();
    }

    ////////////////////////Methods for current Project/////////////////

    public static double rSquared(TupleXY[] plot, double y_int, double slope){
        double r_2 = 0;
        for(TupleXY tup: plot){
            r_2 += Math.pow(dY(tup,y_int,slope),2);
        }
        return r_2;
    }

    public static double dY(TupleXY cor, double y_int, double slope){
        //System.out.println(cor.yT - (y_int + slope*cor.xT));
        return Math.abs(cor.yT - (y_int + slope*cor.xT));

    }

    public static double distanceToLine(TupleXY cor, double y_int, double slope){
        double upper = Math.abs(y_int + cor.xT*slope + cor.yT*-1);
        double lower = Math.sqrt(slope*slope + 1); // 1 from (-1)^2 - coe in front of y
        return upper/lower;
    }





    ///////////////////////////////////////////////////////////////////

    //////////////////////Distance Between Tuples (X,Y) (X,Y)/////////////
    public static double distanceBetween(TupleXY one, TupleXY two){
        return Math.sqrt(Math.pow((one.xT - two.xT),2) + Math.pow(one.yT - two.yT, 2));
    }


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

    ///////////////////////Comparator Stuff for sorting/////////////////////////////////////////

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
