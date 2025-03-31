import java.io.*;
import java.util.*;


public class Main {

    static List<Integer>[] cities;
    static boolean visited[];
    static int[] load;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);

        load = new int[N+1];
        visited = new boolean[N+1];
        cities = new ArrayList[N+1];
        for(int i=1; i<N+1; i++)
        {
            cities[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++)
        {
            String[] city = br.readLine().split(" ");
            int city1 = Integer.parseInt(city[0]);
            int city2 = Integer.parseInt(city[1]);

            cities[city1].add(city2);
        }

        bfs(X);

        int printCnt = 0;
        for(int i=1; i<=N; i++)
        {
            if(load[i] == K){
                bw.write(i + "\n");
                printCnt++;
            }
        }

        if(printCnt == 0)
            bw.write("-1\n");

        bw.flush();
        bw.close();
        br.close();
    }


    private static void bfs(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty())
        {
            int city = queue.poll();
            visited[city] = true;
            for(int next : cities[city])
            {
                if(!visited[next])
                {
                    queue.add(next);
                    if(load[next] == 0)
                        load[next] = load[city]+1;
                }

            }

        }

    }
}
