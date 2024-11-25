import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		
		List<String> inputString = new ArrayList<String>();
		
		String[] command = br.readLine().split(" ");
		
		int N = Integer.parseInt(command[0]);
		int M = Integer.parseInt(command[1]);
		int cnt = 0;
		
		for(int i=0; i<N; i++)
		{
			inputString.add(br.readLine());
		}
		
		for(int i=0; i<M; i++)
		{
			String setString = br.readLine();
			
			if(inputString.contains(setString))
				cnt++;
		}
		
		bw.write(Integer.toString(cnt));
		
		bw.flush();
		br.close();		
		bw.close();
	}				
	
	
}