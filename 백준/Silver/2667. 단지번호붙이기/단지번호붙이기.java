import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
		

	private static int[][] house = null;
    private static boolean[][] visited = null;
	private static int[] dx = {0,0,-1,1};	
	private static int[] dy = {-1,1,0,0};
	
	
    private static int cnt = 0, number = 0;
	private static int nowX, nowY, N;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		house = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++)
		{
			String str = br.readLine();
			
			for(int j=0; j<N; j++)
			{
				house[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				
				if(visited[i][j] == false && house[i][j] == 1) {
					cnt = 0;
					number++;
					dfs(i,j);
					list.add(cnt);
				}
			}
		}
		
		Collections.sort(list);
		bw.append(number+"\n");
		for(int num : list)
		{
			bw.append(num+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	private static void dfs(int x, int y)
	{	
		visited[x][y] = true;
		house[x][y] = number;
		cnt++;
		
		for(int i=0; i<4; i++)
		{
			nowX = dx[i] + x;
			nowY = dy[i] + y;
			
			if(Range_check() && visited[nowX][nowY] == false && house[nowX][nowY] == 1)
			{
				visited[nowX][nowY] = true;
				house[nowX][nowY] = number;
				
				dfs(nowX,nowY);
			}
			
		}
		
	}
	
	static boolean Range_check() {
		return (nowX >= 0 && nowX < N && nowY >= 0 && nowY < N);
	}
	
}
