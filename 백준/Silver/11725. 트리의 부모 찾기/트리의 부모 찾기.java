import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] tree;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        tree = new ArrayList[cnt + 1];
        for(int i=1; i<=cnt; i++){
            tree[i] = new ArrayList<>();
        }

        for(int i=1; i<cnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            tree[num1].add(num2);
            tree[num2].add(num1);
        }

        parent = new int[cnt + 1];
        bfs(1);

        for(int i=2; i<=cnt; i++){
            System.out.println(parent[i]);
        }
        br.close();
    }

    public static void bfs(int start)
    {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for (int next : tree[node]){
                if(parent[next] == 0){
                    parent[next] = node;
                    queue.add(next);
                }
            }
        }
    }
}