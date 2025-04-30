import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	static List<String> board = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String input = br.readLine();	
		String in ="";
		
		for(int i=0; i<input.length(); i++)
		{
			String st = Character.toString(input.charAt(i));
			
			if(st.equals("."))
			{
				if(!in.equals(""))
				{
					board.add(in);
				}
				
				in ="";
				board.add(st);
			}
			else {
				in+=st;
			}	
			
			if(i == input.length()-1 && !in.equals(""))
				board.add(in);
		}		
		System.out.println(greedy());
		
		br.close();
	}	

	
	private static String greedy()
	{		
		
		String result ="";
		
		for(int i=0; i<board.size(); i++)
		{
			
			if(board.get(i).equals("."))
			{
				result+=".";
				continue;
			}
			
			int len = board.get(i).length();
		
			if(len < 4 && len % 2 ==0)
			{
				result += changeString(len,"B");
			}			
			else if(len % 4 == 0)
			{
				result += changeString(len,"A");
			}
			else if((len % 4) % 2 == 0)
			{
				int aCnt = len/4 * 4;
				int bCnt = len%4;				
				result += (changeString(aCnt,"A") + changeString(bCnt,"B"));
			}					
			else 
			{
				return "-1";
			}
			
		}	
		
		return result;
	}
	
	
	private static String changeString(int cnt, String change)
	{
		
		String result ="";
		
		for(int i=0; i<cnt; i++)
			result+=change;
	
		return result;
	}
	
	
}
