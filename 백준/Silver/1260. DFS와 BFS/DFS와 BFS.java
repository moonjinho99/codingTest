import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static boolean visited[];
	static int[][] graph;
	static int N;
	static int M;
	
	
	public static void main(String[] args) throws IOException
	{					
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		graph = new int[N+1][N+1];
		
		for(int i=0; i<M; i++)
		{
			StringTokenizer inputNode = new StringTokenizer(br.readLine()," ");
			int link1 = Integer.parseInt(inputNode.nextToken());
			int link2 = Integer.parseInt(inputNode.nextToken());
			
			graph[link1][link2] = graph[link2][link1] = 1;
		}
		
		dfs(start);
		
		visited = new boolean[N+1];
		System.out.println();
		
		bfs(start);

	}				
	
	
//	public static void dfs(int start)
//	{
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(start);
//		
//		while(!stack.isEmpty())
//		{
//			int node = stack.pop();			
//			System.out.print(node + " ");
//			
//			for(int i=0; i<graph[node].length; i++)
//			{			
//				if(!visited[node] && graph[node][i] != 0)
//				{					
//					visited[i] = true;
//					stack.push(i);
//				}
//			}
//		}
//	}
//	
	
	public static void dfs(int start)
	{
		visited[start] = true;
		System.out.print(start + " ");
			
		for(int i=0; i<graph[start].length; i++)
		{			
			if(!visited[i] && graph[start][i] != 0)
			{					
				dfs(i);
			}
		}
		
	}
	
	
	
	public static void bfs(int start)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
				
		while(!queue.isEmpty())
		{
			int node = queue.poll();
			System.out.print(node + " ");
			
			for(int i=0; i<graph[node].length; i++)
			{
				if(!visited[i] && graph[node][i] != 0)
				{
					visited[i] = true;
					queue.offer(i);
				}
			}
			
		}
		
	}
	
}