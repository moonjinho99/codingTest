import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        int y=0;
        for(int i=0; i<S.length(); i++)
        {
            char c = S.charAt(i);
            if(c == ' ')
            {
                if(!stack.isEmpty())
                {
                    while(!stack.isEmpty())
                        bw.write(stack.pop());
                }
                bw.write(c);
                continue;
            }

            if(c == '<')
            {
                y=1;
                if(!stack.isEmpty())
                {
                    while(!stack.isEmpty())
                        bw.write(stack.pop());
                }
            }
            if(y==1)
                bw.write(c);

            if(c == '>')
                y=0;

            if(!(c=='>') && y ==0)
            {
                stack.push(c);
            }

            if(i == S.length()-1)
            {
                if(!stack.isEmpty())
                {
                    while(!stack.isEmpty())
                        bw.write(stack.pop());
                }
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }
}