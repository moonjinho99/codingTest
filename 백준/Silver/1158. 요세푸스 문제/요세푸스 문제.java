import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> queue = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int people = Integer.parseInt(input[0]);
        int num = Integer.parseInt(input[1]);
        int cnt = 0;
        bw.write("<");

        for(int i=1; i<=people; i++)
            queue.offer(i);

        while(!queue.isEmpty())
        {

            cnt++;
            if(cnt == num)
            {
                if(queue.size() == 1)
                {
                    bw.write(queue.poll()+">");
                }
                else{
                    bw.write(queue.poll()+", ");
                }
                cnt = 0;
            }
            else{
                queue.offer(queue.poll());
            }
        }

        bw.flush();
        br.close();
        bw.close();

    }
}