import java.util.*;
import java.io.*;

public class Main{

    private static List<Integer[]> print;
    private static List<Integer> result;
    private static boolean[] visited;
    private static int N;
    private static int M;
    
     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        result = new ArrayList<>();
        visited = new boolean[N+1];
        print = new ArrayList<>();
        
        backTracking(bw);
        
        br.close();
        bw.close();
     }
     
     
     private static void backTracking(BufferedWriter bw) throws IOException
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
         
         for(int i=1; i<=N; i++)
         {
             if(!visited[i])
             {
                 visited[i] = true;
                 result.add(i);
                 backTracking(bw);
                 visited[i] = false;
                 result.remove(result.size()-1);
             }
         }
         
     }
}