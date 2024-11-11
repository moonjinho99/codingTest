import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException
	{		
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		int cnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<cnt; i++)
		{			
			String[] command = br.readLine().split(" ");					
			switch(command[0])
			{
			case "push":
				stack.push(Integer.parseInt(command[1]));
				break;
			case "pop":
				if(stack.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stack.pop()+"\n");				
				break;
			case "size":
				bw.write(stack.size()+"\n");
				break;
			case "empty":
				if(stack.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "top":
				if(stack.isEmpty())
					bw.write("-1\n");
				else
					bw.write(stack.peek()+"\n");
				break;
			}
		}
			
		bw.flush();		
		br.close();
		bw.close();
	}   
}