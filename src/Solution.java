import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

// I am using a file that I use for HackerRank. The code is mine, other than

public class Solution {
    public static void main(String[] args) throws IOException {
        // This is just generic stuff I use for hackerrank to make it easy to use IDE (reusing though)
//        String fileName = "sol.in";
//        File f = new File(fileName);
//        Scanner in = new Scanner(System.in);
//        if (f.exists() && !f.isDirectory()) {
//            in = new Scanner(f);
//        }
        String fileName = "sol.in";
        Reader in = new Reader(fileName);
        Solver sol = new Solver(in);
        int t = 1;
        t = Integer.parseInt(in.readLine());
        for (int i = 0; i < t; i++) {
            sol.solve(i+1);
        }
        in.close();
    }
}


class Solver{
    Reader in; DataStructures d; CarlString sLi; CarlNumbers ma; Ray r; Graph g;

    Solver(Reader in){
        this.in = in;
        d = new DataStructures();
        sLi = new CarlString();
        ma = new CarlNumbers();
        r = new Ray(in);
        g = new Graph();
    }
//    public void solve(int funcCall) throws IOException{
//        float r2 = 1.4142135623730950488016887242096980785f;
//        float num = ((float)in.nextDouble())/r2;

//        float angle = (float)(Math.acos(num)) + pi4;
//        System.out.println("Case #" + funcCall + ":");
//        float x1 = (float)(-Math.sin(angle)*.5);
//        double y1 = (float)(Math.cos(angle)*.5);
//        System.out.println(x1 + " " + y1 + " " + 0);
//        System.out.println("0 0 0.5");
//    }
    float pi4 = (float)Math.PI/4;
    float sqrt2 = (float)Math.sqrt(2);
    public void solve(int funcCall) throws IOException{
        double target = in.nextDouble();
        BigDecimal dec = new BigDecimal(target);
        double upper = .5;
        double lower = .25*sqrt2;
        double x = (lower + upper)/2;
        double theta = Math.acos(x*2);
        double area = Math.cos(theta- pi4)*sqrt2;
        while(!ma.withinTolerance(area,target,.00000001)){
               if(area > target){
                   lower = x;
               } else {
                   upper = x;
               }
               x = (lower + upper)/2;
               theta = Math.acos(x*2);
               area = Math.cos(theta - pi4)*sqrt2;
        }
        System.out.println(x);
        System.out.println(Math.acos(0.35383941912727135) + " " + Math.acos(0.3535533905932738));
    }
}
//Arrays.sort(strings,new sort());
class sort implements Comparator<String>{
    public int compare(String a, String b){
        return b.length() - a.length();
    }
}








class Trie{
    public int numInserted = 0;
    Trie[] children;
    boolean last = false;
    Trie(){
        children = new Trie[26];
    }
    public void add(String remaining){
        if(remaining.length() == 0){
            last = true;
            numInserted++;
            return;
        }
        int a = remaining.charAt(0) - 'a';
        if(children[a] == null){
            children[a] = new Trie();
        }
        numInserted++;
        children[a].add(remaining.substring(1));
    }
    public boolean subString(String word){
        if(word.length() == 0) return true;
        if(last) return true;
        int cur = word.charAt(0) - 'a';
        if( children[cur] == null) return false;
        return (children[cur].subString(word.substring(1)));
    }
    public int numWords(String word){
        if(word.length() == 0) return 0;
        int cur = word.charAt(0) - 'a';
        if(word.length() == 1 && children[cur] != null) {
            return children[cur].numInserted;
        } else if( children[cur] == null){
            return 0;
        } else return children[cur].numWords(word.substring(1));
    }
}
class Graph{
    Graph(){}
    // effecient set update
    void updateParent(int a, int b, int eW, int[][] ray){
        if(a == b) return;
        int aS = ray[a][1];
        int bS = ray[b][1];
        int aW = ray[a][2];
        int bW = ray[b][2];
        eW += (aW + bW);
        if (aS == bS){
            ray[a][1]++;
            ray[a][2] = eW;
            ray[b][0] = a;
        } else if (aS > bS){
            ray[b][0] = a;
            ray[a][2] = eW;
        } else {
            ray[a][0] = b;
            ray[b][2] = eW;
        }
    }
    void updateParent(int a, int b, int[][] ray){
        if(a == b) return;
        int aS = ray[a][1];
        int bS = ray[b][1];
        if (aS == bS){
            ray[a][1]++;
            ray[b][0] = a;
        } else if (aS > bS){
            ray[b][0] = a;
        } else {
            ray[a][0] = b;
        }
    }
    int parent(int a, int[][] ray){
        if (a == ray[a][0]) return a;
        int p = parent(ray[ray[a][0]][0],ray);
        ray[a][0] = p;
        return p;
    }
}
class DataStructures{
    DataStructures(){}
    public ArrayList<Integer> populateListIntArray(Reader in, int size) throws IOException{
        ArrayList<Integer> array = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            array.add(in.nextInt());
        }
        return array;
    }
    public void printList(List<Integer> thatAr){
        int nnn = thatAr.size();
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr.get(i) + " ");
        }
        System.out.println();
    }
    public ArrayList<Integer> genMaxList(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 31; i++) {
            list.add(2);
        }
        return list;
    }
}
class CarlString{
    CarlString(){}
    int match(ArrayList<Integer[]> list, Integer[] curRep){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer[] cur = list.get(i);
            if(eq(cur,curRep)){
                count++;
            }
        }
        return count;
    }
    boolean eq(Integer[] a, Integer[] b){
        for (int i = 0; i < a.length; i++) {
            if((int)a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
    Integer[] getRep(String c){
        Integer[] ray = new Integer[26];
        for (int i = 0; i < 26; i++) {
            ray[i] = new Integer(0);
        }
        for (int i = 0; i < c.length(); i++) {
            int cur = c.charAt(i) - 'a';
            ray[cur]++;
        }
        return ray;
    }
    public char[] findUniqueChars(String s){
        HashSet<Character> set = new HashSet<Character>(26);
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        char[] ret = new char[set.size()];
        int i = 0;
        for(Character c : set){
            ret[i] = c;
            i++;
        }
        return ret;
    }
    public HashSet<Character> findSetChars(String s){
        HashSet<Character> set = new HashSet<Character>(26);
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return set;
    }
    public String listToString(ArrayList<Integer> list){
        String a = "";
        for (int i = 0; i < list.size(); i++) {
            a += list.get(i).toString();
        }
        return a;
    }
    public String reverse(String a){
        return (new StringBuilder(a)).reverse().toString();
    }
    public String swap(String a, int in1, int in2){
        char [] array = a.toCharArray();
        char temp = array[in1];
        array[in1] = array[in2];
        array[in2] = temp;
        a = new String(array);
        return a;
    }
    public int mod(String num, int mod){
        int ret = 0;
        for (int i = 0; i < num.length(); i++) {
            ret = (ret*10 + num.charAt(i) - '0')%mod;
        }
        return ret;
    }
    public long sumDigits(String x){
        int tot = 0;
        for(int i = 0; i < x.length(); i++){
            tot += x.charAt(i) - '0';
        }
        return tot;
    }
}
class CarlNumbers {
    public long mod = 1000000007;
    public int[][] directions = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int[][] partKnight = {{-2,1},{-2,-1},{-1,-2},{1,-2}};
    CarlNumbers(){}
    public double distanceBetween(Tuple one, Tuple two){
        return Math.sqrt(Math.pow((one.x - two.x),2) + Math.pow(one.y - two.y, 2));
    }
    public long choose(int outside, int inside){
        if(outside < 0 || inside < 0) return 0;
        long fact = 1;
        for (int i = 1; i <= outside; i++) {
            fact = (fact*i)%mod;
        }
        for (int i = 1; i <= inside; i++) {
            fact = (fact/i)%mod;
        }
        for (int i = 1; i <= (outside - inside); i++) {
            fact = (fact/i)%mod;
        }
        return fact;
    }
    public double average(int one, int two){
        return ((double)one + two)/2;
    }
    //3-Way Comparisons
    public int max(int aa, int bb, int cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    public int min(int aa, int bb, int cc){
        return Math.min(aa,Math.min(bb,cc));
    }
    public long max(long aa, long bb, long cc){
        return Math.max(aa,Math.max(bb,cc));
    }
    public long min(long aa, long bb, long cc){
        return Math.min(aa,Math.min(bb,cc));
    }
    public int reverseInt(int x){
        StringBuilder in = new StringBuilder();
        in.append(Integer.toString(x));
        in.reverse();
        x = Integer.parseInt(in.toString());
        return x;
    }
    public boolean withinTolerance(double a, double b, double tolerance){
        return(Math.abs(a - b) < tolerance);
    }
    public boolean withinTolerance(float a, float b, float tolerance){
        return(Math.abs(a - b) < tolerance);
    }
}
class Ray {
    private Reader in;
    Ray(Reader in){
        this.in = in;
    }
//    public boolean indexInBitSet(BitSet[] set, int i, int j){
//        if(0 <= i && i < set.length){
//            return indexInBitSet(set[i], , j);
//        }
//        return false;
//    }
//    public boolean indexInBitSet(BitSet set,int i, int j){
//        int test = set.length();
//        int test2 = set.size();
//        return (0 <= i && i < set.length());
//    }
    public void reverse(int[] a){
        int lastIndex = a.length - 1;
        reverse(a,0,lastIndex);
    }
    public void reverse(long[] a){
        int lastIndex = a.length - 1;
        reverse(a,0,lastIndex);
    }
    public void reverse(int[] a, int indexOne, int indexTwo){
        for (int i = 0; i <= (indexTwo - indexOne)/2 ; i++) {
            swap(a,i + indexOne,indexTwo - i);
        }
    }
    public void reverse(long[] a, int indexOne, int indexTwo){
        for (int i = 0; i <= (indexTwo - indexOne)/2 ; i++) {
            swap(a,i + indexOne,indexTwo - i);
        }
    }
    public void swap(int[] a, int indexOne, int indexTwo){
        int temp = a[indexOne];
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    }
    public void swap(long[] a, int indexOne, int indexTwo){
        long temp = a[indexOne];
        a[indexOne] = a[indexTwo];
        a[indexTwo] = temp;
    }
    public boolean sorted(int[] a){
        int cur = a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i] < cur) return false;
            cur = a[i];
        }
        return true;
    }
    public boolean indexInArray(int [] a, int index){
        return (0 <= index && index < a.length);
    }
    public boolean indexInArray(long [] a, int index){
        return (0 <= index && index < a.length);
    }
    public boolean indexInArray(boolean [] a, int index){
        return (0 <= index && index < a.length);
    }
    public boolean indexInArray(boolean [][] a, int x, int y){
        if(0 <= x && x < a.length){
            boolean[] temp = a[x];
            if (0 <= y && y < temp.length){
                return true;
            }
        }
        return false;
    }
    public boolean indexInArray(String[] a, int x, int y){
        if(0 <= x && x < a.length){
            String temp = a[x];
            if (0 <= y && y < temp.length()){
                return true;
            }
        }
        return false;
    }
    public boolean indexInArray(char [][] a, int x, int y){
        if(0 <= x && x < a.length){
            char[] temp = a[x];
            if (0 <= y && y < temp.length){
                return true;
            }
        }
        return false;
    }
    public boolean indexInArray(char[] a, int index){
        return  (index >= 0 && index < a.length);
    }
    public boolean indexInArray(int [][] a, int x, int y){
        if(0 <= x && x < a.length){
            int[] temp = a[x];
            if (0 <= y && y < temp.length){
                return true;
            }
        }
        return false;
    }
    public void printArray(char[][] ray){
        int height = ray.length;
        for (int i = 0; i < height; i++) {
            System.out.println(ray[i]);
        }
    }
    public void printArray(long[] ray){
        int height = ray.length;
        for (int i = 0; i < height - 1; i++) {
            System.out.print(ray[i] + " ");
        }
        System.out.println(ray[height - 1]);
    }
    public void printArray(String[] ray){
        int height = ray.length;
        for (int i = 0; i < height; i++) {
            System.out.println(ray[i]);
        }
    }
    public long sumArray(int[] array){
        long tot = 0;
        for (int i = 0; i < array.length; i++) {
            tot += array[i];
        }
        return tot;
    }
    public void printArray(int[] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            System.out.print(thatAr[i] + " ");
        }
        System.out.println();
    }
    public int[] populateIntArray(Reader in, int size) throws IOException{
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }
    public Integer[] toIntegerRay(int[] ray){
        Integer[] ray2 = new Integer[ray.length];
        for (int i = 0; i < ray.length; i++) {
            ray2[i] = ray[i];
        }
        return ray2;
    }
    public long[] populateLongArray(int size) throws IOException{
        long[] array = new long[size];
        String[] longs = in.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            array[i] = Long.parseUnsignedLong(longs[i]);
        }
        return array;
    }
    public long[] populateUniqueLong(int size) throws IOException{
        HashSet<Long> set = new HashSet<>(size);
        String[] longs = in.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            long next = Long.parseUnsignedLong(longs[i]);
            set.add(next);
        }
        long[] ray = new long[set.size()];
        int index = 0;
        for (Long num: set){
            ray[index++] = num;
        }
        return ray;
    }
    public int[][] populateIntArray(Reader in, int x, int y) throws IOException{
        int[][] array = new int[x][];
        for (int i = 0; i < x; i++) {
            array[i] = populateIntArray(in,y);
        }
        return array;
    }
    public char[][] populate2DCharArray(Reader in, int size) throws IOException{
        char[][] array = new char[size][size];
        for (int i = 0; i < size; i++) {
            array[i] = in.next().toCharArray();
        }
        return array;
    }
    public char[] populateCharArray(Reader in, int size) throws IOException{
        char[] array = new char[size];
        array = in.next().toCharArray();
        return array;
    }
    public int minArray(int [] array){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min,array[i]);
        }
        return min;
    }
    public int maxArray(int [] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(max,array[i]);
        }
        return max;
    }
    public void printArray(int[][] thatAr){
        int nnn = thatAr.length;
        for(int i = 0; i < nnn; i++){
            int[] current = thatAr[i];
            for(int j= 0; j < current.length; j++){
                System.out.print(current[j] + " ");
            }
            System.out.println();
        }
    }
}
class Tuple implements Comparator<Tuple>{
    public int x = 0;
    public int y = 0;
    Tuple(int first, int last) {
        this.x = first;
        this.y = last;
    }
    Tuple() {
    }

    public Tuple[] sortByFirst(Tuple[] tuples) {
        return new Tuple[0];
    }

    @Override
    public int compare(Tuple a, Tuple b){
        return a.y - b.y;
    }
}
class TupleC implements Comparable{
    public int x = 0;
    public int y = 0;
    public int compareTo(Object tup2){
        TupleC tup = (TupleC) tup2;
        return this.y - tup.y;
    }
}
class Reader {
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

    public Reader(String fileName) throws IOException
    {
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            din = new DataInputStream(new FileInputStream(fileName));
        } else {
            din = new DataInputStream(System.in);
        }
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
        String ret = new String(buf, 0, cnt).trim(); // get rid of extra line char
        if(ret.length() == 0){
            ret = next();
        }
        return ret; // get rid of extra line char
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
class Triplet implements Comparator<Triplet>{
    public int x = 0;
    public int y = 0;
    public int w = 0;
    Triplet(int first, int last, int w) {
        this.x = first;
        this.y = last;
        this.w = w;
    }
    Triplet() {
    }

    public Tuple[] sort(Tuple[] tuples) {
        return new Tuple[0];
    }

    @Override
    public int compare(Triplet a, Triplet b){
        int sol = a.w - b.w;
        if (sol == 0){
            return a.x + a.y - (b.x + b.y);
        }else{
            return sol;
        }
    }
}
class HashParam {
    public long n;
    public HashSet<Long> set;
    public HashParam(long n, HashSet<Long> set){
        this.n = n;
        this.set = set;
    }
    @Override
    public int hashCode() {
        return (int)n + set.hashCode();
    }
}
class byLength implements Comparator<String>{
    @Override
    public int compare(String a, String b){
        return b.length() - a.length();
    }
}
//enum HeapType {Max,Min};
//class Heap{
//    private int[] nums;
//    private int index = 0;
//    private HeapType type;
//    Heap(HeapType type, int size){
//        this.type = type;
//        nums = new int[size];
//    }
//    public int getSize(){
//        return index;
//    }
//    public void insert(int a){
//        if(index == nums.length){
//            grow();
//        }
//        int cur = index++;
//        int parent = parentIndex(cur);
//        while(cur > 0 && nums[parent] < nums[cur]){
//            nums[cur] = nums[parent];
//            cur = parent;
//            parent = parentIndex(parent);
//        }
//        nums[cur] = a;
//    }
//    private int parentIndex(int index){
//        return((index + 1)/2 - 1);
//    }
//    private void grow(){
//        int[] temp = nums;
//        nums = new int[temp.length*2];
//        for (int i = 0; i < temp.length; i++) {
//            nums[i] = temp[i];
//        }
//    }
//    public int pop(){
//        return nums[0];
//    }
//}