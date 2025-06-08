import java.io.*;
import java.util.*;


public class Main {

    private static int[][] map;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static int[] gram = new int[2];

    private static int cnt = 0;
    private static int N = 0;
    private static int M = 0;

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] con = br.readLine().split(" ");
        N = Integer.parseInt(con[0]);
        M = Integer.parseInt(con[1]);
        int T = Integer.parseInt(con[2]);

        int time = 0;

        int findGTime=0;
        int findPTime=0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            String[] input = br.readLine().split(" ");

            for(int j=0; j<M; j++)
            {
                int data = Integer.parseInt(input[j]);
                if(data == 2)
                    gram = new int[]{i,j};

                map[i][j] = data;
            }

        }

        //일반 탐색
        time = bfs(0,0,N-1,M-1);
        if(time == -1)
            time = T+1;
        visited = new boolean[N][M];

        //검찾고 탐색
        findGTime = bfs(0,0,gram[0],gram[1]);

        if(findGTime == -1)
        {
            findGTime = T;
            findPTime = T;
        }else{
            map = new int[N][M];
            visited = new boolean[N][M];
            findPTime = bfs(gram[0],gram[1],N-1,M-1);
        }

        if(time > (findPTime+findGTime))
            time = findPTime+findGTime;

        if(time <= T)
            System.out.println(time);
        else
            System.out.println("Fail");

        br.close();
    }


    private static int bfs(int startX, int startY, int endX, int endY)
    {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{startX,startY,0});
        visited[startX][startY] = true;

        while(!queue.isEmpty())
        {
            Integer[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            if(currentX == endX && currentY == endY)
                return current[2];

            for(int i=0; i<4; i++)
            {
                int x = currentX + dx[i];
                int y = currentY + dy[i];

                if(x < N && y < M && x >= 0 && y >= 0 && map[x][y] != 1 && !visited[x][y]) {
                    cnt++;
                    visited[x][y] = true;
                    queue.offer(new Integer[]{x, y, current[2]+1});
                }
            }

        }

        return -1;
    }
}