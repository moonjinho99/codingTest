import java.util.*;
import java.io.*;

public class Main{
    
    public static List<Integer> ropeList = new ArrayList<>();

     public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++)
        {
            ropeList.add(Integer.parseInt(br.readLine()));
        }
        
        bw.write(Integer.toString(maxWeight()));
        
        br.close();
        bw.close();
     }
     
     public static int maxWeight()
     {
         //오름차순 정렬
         Collections.sort(ropeList);
         int ropeCnt = ropeList.size();
         int maxWeight = ropeList.get(0) * ropeCnt;

         for(int i=1; i<ropeCnt; i++)
         {
             int weight = ropeList.get(i) * (ropeCnt - i);
             if(maxWeight < weight)
                maxWeight = weight;
         }

         return maxWeight;
     }
     
}