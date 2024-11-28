import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		int cnt = Integer.parseInt(br.readLine());
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	
		for(int i=0; i<cnt; i++)
		{
			map.clear();
			int N = Integer.parseInt(br.readLine());
			String[] note1Write = br.readLine().split(" ");
			
			for(String note1Word : note1Write)
				map.put(Integer.parseInt(note1Word),Integer.parseInt(note1Word));	
						
			int M = Integer.parseInt(br.readLine());
			String[] note2Write = br.readLine().split(" ");					
						
			for(String note2Word : note2Write)
			{
				int num = Integer.parseInt(note2Word);
				
				if(map.containsKey(num))
					bw.write("1\n");
				else
					bw.write("0\n");
			}
			
			
		}
		
		bw.flush();
		br.close();		
		bw.close();
	}				
}