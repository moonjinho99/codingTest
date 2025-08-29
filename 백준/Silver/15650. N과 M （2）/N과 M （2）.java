import java.util.*;
import java.io.*;

public class Main{

    private static List<Integer> result;
    private static int N;
    private static int M;
    
     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        result = new ArrayList<>();
        backTracking(bw, 1);
        
        br.close();
        bw.close();
     }
     
     
     private static void backTracking(BufferedWriter bw, int start) throws IOException
     {
         if(result.size() == M)
         {
             for(int i=0; i<result.size(); i++)
             {
                bw.write(Integer.toString(result.get(i)));
                bw.write(" ");
             }
             
             bw.write("\n");
             
             return;
         }
         
         for(int i=start; i<=N; i++)
         {
             result.add(i);
             backTracking(bw, i+1);
             result.remove(result.size()-1);
         }
         
     }
}