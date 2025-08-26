import java.util.*;
import java.io.*;


public class Main{
    
    private static char[][] board;
    private static boolean[][] visited;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int cnt;
    private static int N;

     public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> result= new ArrayList<>();
        
        N = Integer.parseInt(br.readLine());
        
        board = new char[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++)
        {
            String input = br.readLine();
            
            for(int j=0; j<N; j++)
            {
                char c = input.charAt(j);
                board[i][j] = c;
            }
        }
        
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(board[i][j] == '1' && !visited[i][j])
                {
                    cnt = 1;
                    visited[i][j] = true;
                    dfs(i,j);
                    result.add(cnt);
                }
            }
        }
        
        Collections.sort(result);
        bw.write(Integer.toString(result.size())+"\n");
        for(int r : result)
        {
            bw.write(Integer.toString(r)+"\n");
        }
        
        br.close();
        bw.close();
     }
     
     private static void dfs(int x, int y)
     {
         for(int i=0; i<4; i++)
         {
            int nx = x + dx[i];
            int ny = y + dy[i];
             
             if(nx < 0 || ny < 0 || nx >= N || ny >= N)
                continue;
                
             if(visited[nx][ny] || board[nx][ny] == '0')
                continue;
                
            visited[nx][ny] = true;
            cnt++;
            dfs(nx,ny);
         }
     }
     
}