import java.util.*;
import java.io.*;

public class Main
{
    private static int[][] graph; 
    private static boolean[] visited;
    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int cnt = 0;

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++)
        {
            String[] nodes = br.readLine().split(" ");
            int node1 = Integer.parseInt(nodes[0]);
            int node2 = Integer.parseInt(nodes[1]);

            graph[node1][node2] = 1;
            graph[node2][node1] = 1;
        }

        for(int i=1; i<=N;i++)
        {
            if(!visited[i])
            {
                dfs(i);
                cnt++;
            }               
        }

        bw.write(Integer.toString(cnt));

        br.close();
        bw.close();
    }

    private static void dfs(int start)
    {
        if(!visited[start])
        {   
            visited[start] = true;
            for(int i=1; i<=N; i++)
            {
                if(!visited[i] && graph[start][i] == 1 && graph[i][start] == 1)
                    dfs(i);
            }
        }
    }
}