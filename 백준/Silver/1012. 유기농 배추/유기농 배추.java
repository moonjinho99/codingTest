import java.util.*;
import java.io.*;

public class Main{

    //흰 지렁이는 인접한 배추의 상하좌우로 움직인다.
    //최소한의 흰 지렁이의 수 구하기
    //1이 배추가 있는 것
    //압력 첫 줄 테스트 케이스의 개수 T
    //테스트 케이스 첫 줄에는 가로 : M , 세로 : N, 배추 위치 K
    //그 다음 K줄에는 배추의 위치

    private static int N;
    private static int M;
    private static int K;
    private static int[][] field;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};
    private static int[] dy = {-1,1,0,0};

    public static void main(String []args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for(int i=0; i<T; i++)
        {
            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            field = new int[N][M];
            visited = new boolean[N][M];
            //값 대입
            for(int j=0; j<K; j++)
            {
                String[] inputXY = br.readLine().split(" ");
                int X = Integer.parseInt(inputXY[0]);
                int Y = Integer.parseInt(inputXY[1]);

                field[Y][X] = 1;
            }


            int cnt = 0;
            //bfs로직 수행
            for(int j=0; j<N; j++)
            {
                for(int k=0; k<M; k++)
                {
                    if(field[j][k] == 1 && !visited[j][k]){
                        bfs(j,k);
                        cnt++;
                    }
                }

            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);

        br.close();
    }


    private static void bfs(int y, int x)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y,x});
        visited[y][x] = true;

        while(!queue.isEmpty())
        {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for(int i=0; i < 4; i++)
            {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if(ny >= 0 && ny < N && nx >=0 && nx < M){
                    if(field[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx});
                    }
                }
            }
        }
    }
}