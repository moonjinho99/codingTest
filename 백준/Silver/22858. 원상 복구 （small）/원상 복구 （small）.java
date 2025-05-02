import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
		
	static String[] D = null;
	static String[] S = null;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		S = br.readLine().split(" ");
		D = br.readLine().split(" ");
		
		changeOrigin(N,K);
		
		for(String s : S)
		{
			System.out.print(s+" ");
		}
		
								
		br.close();
		
	}
	
	private static void changeOrigin(int N, int K)
	{			
		for(int i=0; i<K; i++)
		{
			String origin[] = new String[N];
			for(int j=0; j<N; j++)
			{
				origin[Integer.parseInt(D[j])-1] = S[j];			
			}				
			S = origin;
		}
		
	}
	
}