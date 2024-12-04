import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());

        for(int i=0; i<cnt; i++)
        {
            String nums[] = br.readLine().split(" ");
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            long result = 1;
            int min = 0;

            if(num1 > num2)
                min = num2;
            else
                min = num1;

            for(int j=1; j<=min; j++)
            {
                if(num1 % j == 0 && num2 % j == 0)
                {
                    result*=j;
                    num1/=j;
                    num2/=j;
                }
            }
            result*=num1;
            result*=num2;

            bw.write(result+"\n");

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