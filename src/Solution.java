import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for(int i = 0; i < n; i++){
            array[i] = in.nextInt();
        }
        int finalNum = functione(array);
        System.out.println(finalNum);
    }
    public static int functione(int[] S){
        int uBound = S.length -1;
        int i = 2;
        while (i < uBound){
            if(S[i+1] >= S[i] && S[i] <= S[i-1]){ // found local min
                return i;
            }
            if(S[i+1] > S[i]){ // next spot is not local min
                i+=2;
            } else{
                i++;
            }
        }
        return -1; //not found
    }
}