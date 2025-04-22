import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
			
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		String[] input = br.readLine().split(" ");
		
		int A = Integer.parseInt(input[0]);
		int B = Integer.parseInt(input[1]);
		
		System.out.println(greedy(A,B));
		
		br.close();						
	}	
			
	private static int greedy(int A, int B)
	{
		int result = 0;
		
		while(B != 0)
		{			
		
			if(B % 2 == 0)
			{
				B/=2;
			}
			else {
				B -=1;
				B/=10;
				
			}
			result++;
			
			if(A == B)
			{
				result++;
				break;
			}
		
			if(B < A || (B % 10 != 1 && B % 2 !=0))
			{
				result = -1;
				break;
			}
		}
								
		return result;
	}
			
}
