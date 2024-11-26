import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++)
		{
			String command = br.readLine();
			
			if(command.equals("0"))
			{
				if(queue.isEmpty())
					bw.write("0\n");
				else
					bw.write(queue.poll()+"\n");
			}else {
				queue.offer(Integer.parseInt(command));
			}
			
		}
		bw.flush();
		br.close();		
		bw.close();
	}				
}