import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collector;

public class Main {

    static List<Integer>[] node;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        node = new ArrayList[N+1];
        for(int i=1; i<=N; i++)
        {
            node[i] = new ArrayList<>();
        }

        for(int i=1; i<=M; i++)
        {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st2.nextToken());
            int node2 = Integer.parseInt(st2.nextToken());
            node[node1].add(node2);
            node[node2].add(node1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(node[i]);
        }

        visited = new boolean[N+1];
        dfs(V);

        visited = new boolean[N+1];
        System.out.println();
        bfs(V);

        br.close();
    }

    private static void dfs(int start)
    {
        System.out.print(start+" ");
        visited[start] = true;
        for(int next : node[start])
        {
            if(!visited[next])
                dfs(next);
        }
    }

    private static void bfs(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty())
        {
            int current = queue.poll();
            System.out.print(current+" ");
            for(int next : node[current])
            {
                if(!visited[next])
                {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

}