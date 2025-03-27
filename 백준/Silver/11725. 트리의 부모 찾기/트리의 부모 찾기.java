import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Integer>[] node;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        parents = new int[cnt+1];
        node = new ArrayList[cnt+1];
        for(int i=1; i<=cnt; i++)
        {
            node[i] = new ArrayList<>();
        }

        for(int i=1; i<cnt; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            node[node1].add(node2);
            node[node2].add(node1);
        }
        bfs(1);

        for(int i=2; i<=cnt; i++)
        {
            System.out.println(parents[i]);
        }

        br.close();
    }

    private static void bfs(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty())
        {
            int current = queue.poll();
            for(int next : node[current])
            {
                if(parents[next] == 0)
                {
                    parents[next] = current;
                    queue.add(next);
                }
            }
        }
    }

}