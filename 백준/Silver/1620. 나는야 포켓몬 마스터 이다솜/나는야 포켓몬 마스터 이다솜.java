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
		Map<Integer,String> nameMap = new HashMap<Integer,String>();
		Map<String,Integer> numMap = new HashMap<String, Integer>();
		
		String[] command = br.readLine().split(" ");
		int addPocketmon = Integer.parseInt(command[0]);
		int questionCnt = Integer.parseInt(command[1]);
		
		for(int i=1; i<=addPocketmon; i++)
		{
			String name = br.readLine();
			nameMap.put(i,name);
			numMap.put(name, i);
		}
			
		for(int i=0; i<questionCnt; i++)
		{
			String question =br.readLine();
			char firstChar = question.charAt(0);
			
			if(firstChar >= 65 && firstChar<= 90)
				bw.write(numMap.get(question)+"\n");
			else 
				bw.write(nameMap.get(Integer.parseInt(question))+"\n");
		}
		
		bw.flush();
		br.close();		
		bw.close();
	}				
}