package tractor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



class Main{

    public static void main(String args[]) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
//    Scanner in = new Scanner(new File("src/tractor/input"));

        StringBuffer buf = new StringBuffer();
        while(true){
            break;
            //in.next();
            /*
            short n = (short)in.nextInt();
            short m = (short)in.nextInt();
            short trac[][] = new short[n][m];
            for (short i = 0; i < n; i++) {
                for (short j = 0; j < m; j++) {
                    trac[i][j] = (short)in.nextInt();
                }
            }
            short[] firstRow = trac[0];
            for (short i = 1; i < m; i++) {
                firstRow[i] += firstRow[i-1];
            }

            buf.append(String.valueOf(firstRow[m-1])+" ");
            try{
                for (short i = 1; ; i++) {
                    short[] row = trac[i];
                    try{
                        for (short x = 0; ; x++) {
                            if (x == 0) {
                                row[x] += trac[i-1][x];
                            } else {
                                //row[x] += Math.max(trac[i-1][x],row[x-1]);
                            }
                        }
                    } catch (ArrayIndexOutOfBoundsException e){}
                    buf.append(String.valueOf(row[m-1])+" ");
                }
            } catch (ArrayIndexOutOfBoundsException e){}
            */
        }
        System.out.println(buf.toString());
    }

}



//class Main{
//
//    public static void main(String args[]) throws FileNotFoundException{
//        Scanner in = new Scanner(System.in);
////    Scanner in = new Scanner(new File("src/tractor/input"));
//        for (int ii = 0; ii < 12; ii++){
//            int n = in.nextInt();
//            int m = in.nextInt();
//            short trac[] = new int[m];
//            StringBuffer buf = new StringBuffer();
//            trac[0] = in.nextInt();
//            for (int i = 1; i < m; i++) {
//                int stageTime = in.nextInt();
//                trac[i] = stageTime + trac[i-1];
//            }
//            buf.append(String.valueOf(trac[m-1])+" ");
//            for (int i = 1; i < n; i++) {
//                for (int x = 0; x < m; x++) {
//                    int stageTime = in.nextInt();
//                    if (x == 0) {
//                        trac[x] += stageTime;
//                    } else {
//                        trac[x] = Math.max(trac[x],trac[x-1])+stageTime;
//                    }
//                }
//                buf.append(String.valueOf(trac[m-1])+" ");
//            }
//            System.out.println(buf.toString());
//        }
//    }
//
//}