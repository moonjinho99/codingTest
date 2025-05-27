import java.util.*;

class Solution {
       
    private  int[][] maps;
    private  boolean[][] visited;
    private  int[] dx = {0,0,1,-1};
    private  int[] dy = {1,-1,0,0};
    private  int n = 0;
    private  int m = 0;
    private  int answer = 0;
    private Queue<int[]> queue = new LinkedList<>();
    
    public int solution(int[][] maps) {
        this.maps = maps;
        n = maps.length;
        m = maps[0].length;        
        visited = new boolean[n][m];
        bfs();          
        answer = maps[n-1][m-1];
        
        if(answer == 1)
            return -1;
        
        return answer;
    }
    
    private void bfs()
    {
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty())
        {
            int[] now = queue.poll();
            int x = now[1];
            int y = now[0];
            
            for(int i=0; i<4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n)
                {
                    if(!visited[ny][nx] && maps[ny][nx] == 1){
                        visited[ny][nx] = true;
                        maps[ny][nx] += maps[y][x];
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
    }
    
}