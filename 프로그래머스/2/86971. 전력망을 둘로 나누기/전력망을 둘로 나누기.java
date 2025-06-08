import java.util.*;

class Solution {
    
    private static int[][] node;
    private static int n;
    private static int [][] wires;
    private static boolean[] visited;
    private static int min = 101;
    
    public int solution(int n, int[][] wires) {
        node = new int[n+1][n+1];
        
        this.n = n;
        this.wires = wires;
        
        for(int i=0; i<wires.length; i++)
        {
           if(node[wires[i][0]][wires[i][1]] != 1 && node[wires[i][1]][wires[i][0]]  != 1)
           {
               node[wires[i][0]][wires[i][1]] = 1;
               node[wires[i][1]][wires[i][0]] = 1;
           }
        }
        
        for(int i=0; i<wires.length; i++)
        {
            node[wires[i][0]][wires[i][1]] = 0;
            node[wires[i][1]][wires[i][0]] = 0;
            visited = new boolean[n+1];
            
            int cnt = dfs(1, visited);
            int answer = (n - cnt) - cnt;
            answer = answer > 0 ? answer : answer * -1;
            
            if(min > answer)
            {
                min = answer;
            }
            
            node[wires[i][0]][wires[i][1]] = 1;
            node[wires[i][1]][wires[i][0]] = 1;
        }
        
        return min;
    }
    
    private int dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        int count = 1;

        for (int next = 1; next <= n; next++) {
            if (node[cur][next] == 1 && !visited[next]) {
                count += dfs(next, visited);
            }
        }

        return count;
    }
}