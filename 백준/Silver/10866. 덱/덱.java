import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		Deque<Integer> dequeue = new ArrayDeque<Integer>();
		int cnt = Integer.parseInt(br.readLine());
		
		
		int push_num = 0;
		
		for(int i=0; i<cnt; i++)
		{
			String command[] = br.readLine().split(" ");
			if(command.length > 1)
				push_num = Integer.parseInt(command[1]);
			
			switch(command[0])
			{
				case "push_front":
					dequeue.addFirst(push_num);
					break;
				case "push_back":
					dequeue.addLast(push_num);
					break;
				case "pop_front":
					if(dequeue.isEmpty())
						bw.write("-1\n");
					else	
						bw.write(dequeue.pollFirst()+"\n");
					break;
				case "pop_back":
					if(dequeue.isEmpty())
						bw.write("-1\n");
					else	
						bw.write(dequeue.pollLast()+"\n");
					break;
				case "size":
					bw.write(dequeue.size()+"\n");
					break;
				case "empty":
					if(dequeue.isEmpty())
						bw.write("1\n");
					else	
						bw.write("0\n");
					break;
				case "front":
					if(dequeue.isEmpty())
						bw.write("-1\n");
					else	
						bw.write(dequeue.getFirst()+"\n");
					break;
				case "back":
					if(dequeue.isEmpty())
						bw.write("-1\n");
					else	
						bw.write(dequeue.getLast()+"\n");
					break;
			}
		}
				
		bw.flush();
		bw.close();
	}   	
}