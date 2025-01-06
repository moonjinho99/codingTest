import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] pc;
	static boolean[] visited;
	static int node, line;
	
	static int count = 0;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		node = Integer.parseInt(br.readLine());
		line = Integer.parseInt(br.readLine());
		
		visited = new boolean[node+1];
		pc = new ArrayList[node+1];
		
		for(int i=1; i<=node; i++)
			pc[i] = new ArrayList<Integer>();
		
		for(int i=1; i<=line; i++)
		{
			StringTokenizer str = new StringTokenizer(br.readLine());
			
			int n1 = Integer.parseInt(str.nextToken());
			int n2 = Integer.parseInt(str.nextToken());
			
			pc[n1].add(n2);
			pc[n2].add(n1);
		}
		
		DFS(1);
		
		System.out.println(count - 1);
		
	}
	
	
	public static void DFS(int v)
	{
		Stack<Integer> warm = new Stack<Integer>();
		
		warm.push(v);
		
		while(!warm.isEmpty())
		{
			int cur = warm.pop();
			
			if (visited[cur]) continue;
			
			visited[cur] = true;
			count++;
			
			for(int i: pc[cur]) {								
				if(!visited[i]) {		
					warm.push(i);
				}
			}
			
		}
	}
	
}
