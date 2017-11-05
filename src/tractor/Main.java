package tractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Main{

    public static void main(String args[]) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
//    Scanner in = new Scanner(new File("src/tractor/input"));
        while(in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int trac[] = new int[m];
            StringBuffer buf = new StringBuffer();
            trac[0] = in.nextInt();
            for (int i = 1; i < m; i++) {
                int stageTime = in.nextInt();
                trac[i] = stageTime + trac[i-1];
            }
            buf.append(String.valueOf(trac[m-1])+" ");
            for (int i = 1; i < n; i++) {
                for (int x = 0; x < m; x++) {
                    int stageTime = in.nextInt();
                    if (x == 0) {
                        trac[x] = trac[x] + stageTime;
                    } else {
                        trac[x] = Math.max(trac[x],trac[x-1])+stageTime;
                    }
                }
                buf.append(String.valueOf(trac[m-1])+" ");
            }
            System.out.println(buf.toString());
        }
    }

}