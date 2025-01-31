import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

	public static void main(String[] args) throws IOException
	{					
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
					
		bw.write(Integer.toString(greedy(n)));
		bw.flush();
		
		br.close();
		bw.close();
	}				
	
	
	private static int greedy(int n)
	{
		int cnt =0;		
		
		if(n<2 || n == 3)
			return -1;
		
		if(n >= 5)
		{
			cnt += n/5;
			n %=5;
		}
		
		if(n >= 2)
		{
			cnt += n/2;
			n %=2;
		}			
		
		if(n != 0)
		{
			n += (cnt*2);
			cnt -= n/2;
			
			n += 5;
			cnt--;
			
			cnt += n/2;
			n%=2;	
		}
		
		if(n != 0)
			cnt = -1;			
		
		return cnt;
		
	}
	
}