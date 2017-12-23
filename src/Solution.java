import java.io.*;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Solution {
    public static int n;
    public static int t;
    public static void main(String[] args) throws IOException {
        // This is just generic stuff I use for hackerrank to make it easy to use IDE (reusing though)
        String fileName = "sol.in";
        File f = new File(fileName);
        Reader in = new Reader();
        if (f.exists() && !f.isDirectory()) {
            in = new Reader(fileName);
        }
        /////////////////////// This is code I wrote for this problem
        t = in.nextInt();
        in.next();
        for (int i = 0; i < t; i++) {
            String cur = in.next();
            boolean found = false;
            int val = cur.charAt(cur.length() - 1);
            for (int j = cur.length() - 2; j >= 0; j--) {
                int curVal = cur.charAt(j);
                if(curVal < val){
                    found = true;
                    System.out.println(outPut(cur,j));
                    break;
                } else {
                    val = curVal;
                }
            }
            if(!found){
                System.out.println("no answer");
            }
        }

        /////////////////////// Main End\\
        in.close();
    }
    public static String outPut(String a, int index){
        String pre = a.substring(0,index);
        int val = a.charAt(index);
        for (int i = a.length() - 1; i > index; i--) {
            if(val < a.charAt(i)){
                a = swap(a, index, i);
                break;
            }
        }
        String post = a.substring(index,a.length());
        //System.out.println(post);
        post = post.substring(0,1) + reverse(post.substring(1,post.length()));
        return pre + post;
    }

    public static String reverse(String a){
        return (new StringBuilder(a)).reverse().toString();
    }

    public static String swap(String a, int in1, int in2){
        char [] array = a.toCharArray();
        char temp = array[in1];
        array[in1] = array[in2];
        array[in2] = temp;
        a = new String(array);
        return a;
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


    //3-Way Max
    public static int max(int aa, int bb, int cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    //3-Way Min
    public static int min(int aa, int bb, int cc){
        return Math.min(aa,Math.min(bb,cc));
    }
    //3-Way Max
    public static long max(long aa, long bb, long cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    //3-Way Min
    public static long min(long aa, long bb, long cc){
        return Math.min(aa,Math.min(bb,cc));
    }

    //Print  2D array
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
    public static int[] populateIntArray(Reader in, int size) throws IOException{
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }
    public static ArrayList<Integer> populateListIntArray(Reader in, int size) throws IOException{
        ArrayList<Integer> array = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            array.add(in.nextInt());
        }
        return array;
    }
    public static int minArray(int [] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min,array[i]);
        }
        return min;
    }
    public static int maxArray(int [] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max,array[i]);
        }
        return max;
    }
    public static int reverseInt(int x){
        StringBuilder in = new StringBuilder();
        in.append(Integer.toString(x));
        in.reverse();
        x = Integer.parseInt(in.toString());
        return x;
    }
    //Sum the Numeric digits in a String
    public static long sumDigits(String x){
        int tot = 0;
        for(int i = 0; i < x.length(); i++){
            tot += x.charAt(i) - '0';
        }
        return tot;
    }
    public static int mod(String num, int mod){
        int ret = 0;
        for (int i = 0; i < num.length(); i++) {
            ret = (ret*10 + num.charAt(i) - '0')%mod;
        }
        return ret;
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


// Copied the reader class from http://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
class Reader
{
    final private int BUFFER_SIZE = 1 << 16;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;

    public Reader()
    {
        din = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public Reader(String file_name) throws IOException
    {
        din = new DataInputStream(new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }

    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
        }
        return new String(buf, 0, cnt).trim(); // get rid of extra line char
    }

    // edited this one
    public String next() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1)
        {
            if (c == '\n')
                break;
            buf[cnt++] = (byte) c;
            if (cnt == buf.length){
                byte[] temp = buf;
                buf = new byte[temp.length + 64];
                for (int i = 0; i < temp.length; i++) {
                    buf[i] = temp[i];
                }
            }
        }
        return new String(buf, 0, cnt).trim(); // get rid of extra line char
    }

    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do
        {
            ret = ret * 10 + c - '0';
        }  while ((c = read()) >= '0' && c <= '9');

        if (neg)
            return -ret;
        return ret;
    }

    public long nextLong() throws IOException
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
        if (neg)
            return -ret;
        return ret;
    }

    public double nextDouble() throws IOException
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();

        do {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');

        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }
        if (neg)
            return -ret;
        return ret;
    }

    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }

    private byte read() throws IOException
    {
        if (bufferPointer == bytesRead)
            fillBuffer();
        byte buf = buffer[bufferPointer++];
//        if (buf == -1){
//            System.out.println("here");
//        } else {
//            System.out.println("nada");
//        }
        return buf;
    }

    public void close() throws IOException
    {
        if (din == null)
            return;
        din.close();
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////
