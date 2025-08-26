import java.util.*;
import java.io.*;

public class Main{

    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int[][] board;
    private static boolean[][] visited;
    private static int n;
    private static int m;
    private static int cnt;
    
     public static void main(String []args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        List<Integer> result = new ArrayList<>();
        
        String[] input = br.readLine().split(" ");
        
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        
        board = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++)
        {
            String[] line = br.readLine().split(" ");
            for(int j=0; j<m; j++)
            {
                board[i][j] = Integer.parseInt(line[j]);   
            }
        }
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(board[i][j] == 1 && !visited[i][j])
                {
                    cnt=1;
                    bfs(i,j);
                    result.add(cnt);
                }
            }
        }
        
        Collections.sort(result);
        int size = result.size();
        
        bw.write(Integer.toString(size)+"\n");
        
        if(size != 0)
            bw.write(Integer.toString(result.get(size-1)));
        else
            bw.write("0");
        
        br.close();
        bw.close();
     }
     
     private static void bfs(int y, int x)
     {
         Queue<int[]> q = new LinkedList<>();
         q.add(new int[]{y,x});
         visited[y][x] = true;
         
         while(!q.isEmpty()) {
             int[] cur = q.poll();
             int cy = cur[0];
             int cx = cur[1];
             
             for(int i=0; i<4; i++) {
                 int ny = cy + dy[i];
                 int nx = cx + dx[i];
                 
                 if(ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                 
                 if(visited[ny][nx] || board[ny][nx] == 0) continue;
                 
                 visited[ny][nx] = true;
                 cnt++;
                 q.add(new int[]{ny, nx});
             }
         }
     }
}