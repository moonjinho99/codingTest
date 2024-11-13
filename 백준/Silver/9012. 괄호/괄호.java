import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++)
		{
			String input = br.readLine();
			int len = input.length();
			for(int j=0; j<len; j++)
			{
				if(input.contains("()"))
					input =input.replace("()", "");
			}
			
			if(input.length() == 0)
				bw.write("YES\n");
			else
				bw.write("NO\n");		
		}		
		br.close();		
		bw.flush();
		bw.close();
	}
}