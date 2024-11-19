import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
			
		int cnt = Integer.parseInt(br.readLine());
		int result = 0;
		for(int i=0; i<cnt; i++)
		{
			String word = br.readLine();
			
			result += goodWord(word);
					
		}	
		bw.write(Integer.toString(result));
		bw.flush();
		br.close();		
		bw.close();
	}			
	
	public static int goodWord(String word)
	{
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<word.length(); i++)
		{
			if(stack.isEmpty())
				stack.add(word.charAt(i));
			else
			{
				if(stack.peek() == word.charAt(i))
					stack.pop();
				else
					stack.add(word.charAt(i));
			}
		}
				
		if(stack.isEmpty())
			return 1;
		else
			return 0;	
	}
}