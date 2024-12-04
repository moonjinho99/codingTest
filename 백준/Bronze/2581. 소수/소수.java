import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());
        int sum=0;
        int min=0;
        for(int i=num1; i<=num2; i++)
        {
            if(decimal(i))
            {
                sum+=i;

                if(sum == i)
                    min=i;
            }

        }
        if(sum ==0)
            bw.write("-1");
        else
        {
            bw.write(sum+"\n");
            bw.write(min+"");
        }


        bw.flush();
        br.close();
        bw.close();
    }


    public static boolean decimal(int num)
    {
        int cnt = 0;
        for(int i =2; i<num; i++)
        {
            if(num % i != 0)
                cnt++;
        }

        if(cnt == num-2)
            return true;
        else
            return false;

    }

}