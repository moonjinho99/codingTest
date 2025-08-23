import java.util.*;
import java.io.*;

public class Main{

     public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] inputAarr = br.readLine().split(" ");
        int[] Aarr = new int[inputAarr.length];
        
        for(int i=0; i<inputAarr.length; i++)
        {
            Aarr[i] = Integer.parseInt(inputAarr[i]);
        }
        
        //이분 탐색을 위한 정렬 필요
        Arrays.sort(Aarr);
        
        int M = Integer.parseInt(br.readLine());
        String[] inputMarr = br.readLine().split(" ");
        int[] Marr = new int[inputMarr.length];

        for(int i=0; i<inputMarr.length; i++)
        {
            Marr[i] = Integer.parseInt(inputMarr[i]);
        }
        
        int[] result = checkNum(Aarr, Marr);
        
        for(int r : result)
        {
            bw.write(Integer.toString(r)+"\n");
        }
        
        br.close();
        bw.close();
     }
     
     private static int[] checkNum(int[] Aarr, int[] Marr)
     {
         int[] result = new int[Marr.length];
         
         for(int i =0; i<Marr.length; i++)
         {
             if(Marr[i] < Aarr[(Aarr.length-1) / 2])
             {
                 for(int j=0; j<Aarr.length/2; j++)
                 {
                    if(Aarr[j] == Marr[i])
                    {
                        result[i] = 1;
                        break;
                    } else{
                        result[i] = 0;
                    }
                 }
             }
             else if (Marr[i] > Aarr[(Aarr.length-1) / 2])
             {
                for(int j=Aarr.length/2-1; j<Aarr.length; j++)
                 {
                    if(Aarr[j] == Marr[i])
                    {
                        result[i] = 1;
                        break;
                    } else{
                        result[i] = 0;
                    }
                 }
             }
             else
             {
                 result[i] = 1;
             }
         }
         
         return result;
     }
     
}