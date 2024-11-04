import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException
	{
			
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int cnt = sc.nextInt();
		List<Integer> stack = new ArrayList<Integer>();		
		
		for(int i=0; i<cnt; i++)
		{
			int command = sc.nextInt();
			
			switch(command)
			{
			case 1:
				stack.add(sc.nextInt());
				break;
			case 2:
				if(stack.size() == 0)
					bw.write("-1\n");				
				else {				
					bw.write(Integer.toString(stack.get(stack.size()-1))+"\n");
					stack.remove(stack.size()-1);											
				}
				break;
			case 3:
				bw.write(Integer.toString(stack.size())+"\n");
				break;
			case 4:
				if(stack.size() == 0)
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case 5:
				if(stack.size() == 0)
					bw.write("-1\n");
				else
					bw.write(Integer.toString(stack.get(stack.size()-1))+"\n");
				break;
			}
		}
			
		bw.close();
		
	}   
}
