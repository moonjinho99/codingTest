import java.awt.Point;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
		
	private static int N;
	private static int M;
	private static int[][] maze = null;
    private static boolean[][] visited = null;
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
    
	
	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N][M];
		visited = new boolean[N][M];
		sc.nextLine();
		
		
		for(int i=0; i < N; i++) {
			String line = sc.next();
			for(int j=0; j <M; j++)
			{
				maze[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
			}
		}
		
		bfs(0,0);
		
		System.out.println(maze[N-1][M-1]);
	}
	
	private static void bfs(int x, int y)
	{
		Queue<Point> queue = new LinkedList<Point>();
		queue.offer(new Point(x,y));
		visited[x][y] = true;
		
		
		while(!queue.isEmpty())
		{
			Point currentPoint = queue.poll();
			
			for(int i=0; i<4; i++){
				int nextX = currentPoint.x + dx[i];
				int nextY = currentPoint.y + dy[i];
				
				if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
					continue;
				if(maze[nextX][nextY] == 0)
					continue;
				if(visited[nextX][nextY])
					continue;
				
				queue.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = true;
				
				maze[nextX][nextY] = maze[currentPoint.x][currentPoint.y] + 1;
			}
		}
		
	}
		
  
}
