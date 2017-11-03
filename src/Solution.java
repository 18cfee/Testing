import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    public static int n;
    public static int t;
    public static void main(String[] args) throws FileNotFoundException {
        // This is just generic stuff I use for hackerrank to make it easy to use IDE (reusing though)
        File f = new File("sol.in");
        Scanner in = new Scanner(System.in);
        if (f.exists() && !f.isDirectory()) {
            in = new Scanner(new File("sol.in"));
        }
        /////////////////////// This is code I wrote for this problem
        n = in.nextInt();
        int decSince = 0;
        int[] array = new int[n];
        Arrays.fill(array,1);
        int prev = in.nextInt();
        int rating = 0;
        for (int i = 1; i < n; i++) {
            rating = in.nextInt();
            if(rating >= prev && decSince < i -1){
                array[i - 1] = 1;
                for (int j = i - 2; j >= decSince ; j--) {
                    if(array[j] <= array[j+1]){
                        array[j] = array[j+1] + 1;
                    }
                }
            }
            if (rating > prev){
                array[i] = array[i - 1] + 1;
                decSince = i;
            }
            if (rating == prev){
                decSince = i;
            }
            if(i < n -1) prev = rating;
        }
        if(rating < prev && decSince < n){
            array[n - 1] = 1;
            for (int j = n - 2; j >= decSince ; j--) {
                if(array[j] <= array[j+1]){
                    array[j] = array[j+1] + 1;
                }
            }
        }
        System.out.println(sumArray(array));


        /////////////////////// Main End\\
        in.close();
    }

    ////////////////////////Methods for current Project/////////////////









    ///////////////////////////////////////////////////////////////////
    ////////////////////////////////Handy/////////////////////////////
    /*n = in.nextInt();
    List<Tuple> array = new ArrayList<Tuple>(n);
        for (int i = 0; i < n; i++) {
        array.add(new Tuple(in.nextInt(),in.nextInt()));
    }
        Collections.sort(array,new Tuple(1,2));*/

    ///////////////// Sum Array Elements /////////////////////////////////
    public static long sumArray(int[] array){
        long tot = 0;
        for (int i = 0; i < array.length; i++) {
            tot += array[i];
        }
        return tot;
    }

    //////////////////////Distance Between Tuples (X,Y) (X,Y)/////////////
    public static double distanceBetween(TupXY one, TupXY two){
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

class Tuple implements Comparator<Tuple>{
    public int firstT = 0;
    public int lastT = 0;
    Tuple(int first, int last) {
        this.firstT = first;
        this.lastT = last;
    }

    public Tuple[] sortByFirst(Tuple[] tuples) {
        return new Tuple[0];
    }

    @Override
    public int compare(Tuple a, Tuple b){
        return a.lastT - b.lastT;
    }
}
class TupXY{
    public int xT = 0;
    public int yT = 0;
    TupXY(int first, int last){
        this.xT = first;
        this.yT = last;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
