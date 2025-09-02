import java.util.*;
import java.io.*;

//A가 B를 신뢰한다
//B를 해킹하면 A도 해킹할 수 있다

public class Main{
        
    private static List<Integer>[] graph;
    private static int N;
    private static int M;

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input[] = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++)
        {
            String[] pcs = br.readLine().split(" ");
            int pc1 = Integer.parseInt(pcs[0]);
            int pc2 = Integer.parseInt(pcs[1]);
            
            //pc1은 pc2를 신뢰한다.
            //pc2가 해킹되면 pc1도 해킹된다.
            //pc1이 다른곳의 pc2인지 탐색을 하는 것이 좋을 것 같다.    
            graph[pc2].add(pc1);
        }
        
        int[] counts = new int[N + 1];
        int max = 0;
        
        for (int i = 1; i <= N; i++) {
            counts[i] = bfs(i);
            max = Math.max(max, counts[i]);
        }
        
       StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (counts[i] == max) sb.append(i).append(" ");
        }

        System.out.println(sb);
        
        br.close();
     }
     
     private static int bfs(int start)
     {
         boolean[] visited = new boolean[N + 1];
         Queue<Integer> q = new LinkedList<>();
         q.add(start);
         visited[start] = true;
         
         int count = 1;
         while(!q.isEmpty())
         {
             int cur = q.poll();
             for(int next : graph[cur]) {
                 if(!visited[next]) {
                     visited[next] = true;
                     q.add(next);
                     count++;
                 }
             }
         }
         return count;
     }
}