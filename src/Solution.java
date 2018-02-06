import java.io.*;
import java.util.*;

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
        sol.solve();
        in.close();
    }
}
class Solver{
    Reader in; DataStructures d; CarlString sLi; CarlNumbers m; Ray r; Graph g;

    Solver(Reader in){
        this.in = in;
        d = new DataStructures();
        sLi = new CarlString();
        m = new CarlNumbers();
        r = new Ray();
        g = new Graph();
    }
    public void solve() throws IOException{
        int q = in.nextLintInt();
        int bound = 9000;
        BitSet isPrime = m.isPrimeBit(bound);
        for (int i = 0; i < q; i++) {
            int n = in.nextLintInt();
            int[] nums = new int[4501];
            for (int j = 0; j < n; j++) {
                nums[in.nextInt()]++;
            }
            long total = 0;
            for (int j = 3500; j <= 4500; j++) {
                int numThere = nums[j];
            }
        }
    }
}
class Trie{
    public int numInserted = 0;
    Trie[] children;
    Trie(){
        children = new Trie[26];
    }
    public void add(String remaining){
        if(remaining.length() == 0){
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
    void updateParent(int a, int b, int[][] ray){
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
    public int[][] directions = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};
    public int[][] partKnight = {{-2,1},{-2,-1},{-1,-2},{1,-2}};
    CarlNumbers(){}
    public double distanceBetween(Tuple one, Tuple two){
        return Math.sqrt(Math.pow((one.x - two.x),2) + Math.pow(one.y - two.y, 2));
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
    public BitSet isPrimeBit(int upperBound){
        BitSet primes = new BitSet(upperBound + 1);
        HashSet<Integer> primeNums = new HashSet<>();
        primes.set(1);
        for (int i = 2; i < upperBound; i++) {
            boolean isPrime = true;
            for(Integer num: primeNums){
                if(i%num == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNums.add(i);
                primes.set(i);
            }
        }
        primeNums.add(1);
        return primes;
    }
}
class Ray {
    Ray(){}
    public boolean indexInArray(int [] a, int index){
        return (0 <= index && index < a.length);
    }
    public boolean indexInArray(boolean [] a, int index){
        return (0 <= index && index < a.length);
    }
    public boolean indexInArray(boolean [][] a, int x, int y){
        if(0 <= x && x < a.length){
            boolean[] temp = a[x];
            if (0 <= y && y < a.length){
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
    public int nextLintInt() throws IOException{
        return Integer.parseInt(readLine());
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
