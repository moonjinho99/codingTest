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
		Stack<Character> stack = new Stack<Character>();
				
		while(true)
		{
			String input = br.readLine();
			
			if(input.equals("."))
				break;
			for(int i=0; i<input.length(); i++)
				stack.add(input.charAt(i));		
			if(checkYn(stack))
				bw.write("yes\n");
			else
				bw.write("no\n");
			
			stack.clear();	
		}

		bw.flush();
		br.close();		
		bw.close();
	}
	
	public static boolean checkYn(Stack<Character> stack)
	{		
		String result = "";
		while(!stack.isEmpty())
		{
			char inputChar = stack.peek();			
			
			if(inputChar == '(' || inputChar == ')' || inputChar =='[' || inputChar ==']')
			{
				result+=stack.pop();
			}else {
				stack.pop();
			}
		}
		int length = result.length();
		
		for(int i=0; i<length; i++)
		{
			if(result.contains(")("))
			{
				result = result.replace(")(", "");
			}
			
			if(result.contains("]["))
			{
				result = result.replace("][", "");
			}
		}
				
		if(result.length() == 0)
			return true;
		else
			return false;
		
	}
	
}