import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num1 = N%3;
        int num2 = N/3;

        if(num2 % 2 == 0)
        {
            if(num1 % 2 ==0)
                bw.write("CY");
            else
                bw.write("SK");
        }
        else{
            if(num1 % 2 ==0)
                bw.write("SK");
            else
                bw.write("CY");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}