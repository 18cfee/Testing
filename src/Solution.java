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





        /////////////////////// Main End\\
        in.close();
    }

    ////////////////////////Methods for current Project/////////////////
    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        int[][] mentions = new int[2][hotel_ids.length + 1];
        String[] main = keywords.toLowerCase().split(" ");
        Set<String> keys = new HashSet<String>(main.length);
        for (String s : main){
            System.out.println("key: " + s);
            keys.add(s);
        }
        int index = 0;
        for(Integer id : hotel_ids){
            String ws = reviews[index].replaceAll("[.|,|!]","");
            ws = ws.toLowerCase();
            String[] words = ws.split(" ");
            int count = 0;
            for(String word: words){

                if(keys.contains(word)){
                    count++;
                    System.out.println(word);
                }
            }

            mentions[id][1] += count;
            mentions[id][0] = index;
            index++;
        }

        java.util.Arrays.sort(mentions, java.util.Comparator.comparingDouble(a -> a[0]));
        return mentions[1];
    }






  /*  static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        int size = callsTimes.length;
        int callsON = 0;
        int time = 0;
        int max = 0;
        List<Integer> callOnEndTimes = new ArrayList<Integer>();
        for(int i = 0; i < size; i++){
            time = callsTimes[i][0];
            int end = callsTimes[i][1];
            callOnEndTimes.add(end);
            int index = 0;
            while(index < callOnEndTimes.size()){
                int j = callOnEndTimes.get(index);
                if(j <= time){
                    callOnEndTimes.remove(index);
                } else{
                    index++;
                }
            }
            int callsOn = callOnEndTimes.size();
            max = Math.max(max,callsOn);
        }

        if(max > noOfCurrentAgents){
            return max - noOfCurrentAgents;
        } else{
            return 0;
        }
    }*/




    ////////////////////////////////////////////////////////////////////
}
