import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException
	{		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt = Integer.parseInt(br.readLine());
		int lastNum = 0;
		
		for(int i=0; i<cnt; i++)
		{			
			String[] command = br.readLine().split(" ");					
			switch(command[0])
			{
			case "push":
				queue.add(Integer.parseInt(command[1]));
				lastNum = Integer.parseInt(command[1]);
				break;
			case "pop":
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.poll()+"\n");				
				break;
			case "size":
				bw.write(queue.size()+"\n");
				break;
			case "empty":
				if(queue.isEmpty())
					bw.write("1\n");
				else
					bw.write("0\n");
				break;
			case "front":
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(queue.peek()+"\n");
				break;
			case "back":
				if(queue.isEmpty())
					bw.write("-1\n");
				else
					bw.write(lastNum+"\n");
				break;
			}
		}
			
		bw.flush();		
		br.close();
		bw.close();
	}   
}