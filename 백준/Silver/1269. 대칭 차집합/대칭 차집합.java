import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] setCnt = br.readLine().split(" ");
        int cnt = 0;
        int A = Integer.parseInt(setCnt[0]);
        int B = Integer.parseInt(setCnt[1]);

        Set<String> setA = new HashSet<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
        while(st1.hasMoreElements())
        {
            setA.add(st1.nextToken());
        }
        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        while (st2.hasMoreElements())
        {
            if(setA.contains(st2.nextToken()))
                cnt++;
        }
        bw.write((A - cnt) + (B- cnt)+"");
        br.close();
        bw.flush();
        bw.close();
    }
}