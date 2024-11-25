import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

//<,> 명령은 스택간의 이동이므로 연산 비용이 O(1)
//- 명령은 스택 제거 연산이므로 O(1)
//기본 문자 입력 연산은 스택에 push하여 O(1)
//전체 문자열의 길이를 L이라 하면 , 한 번의 입력 처리에 대해 O(L)
//종합 : N개의 입력 문자열이 주어지면, 각 문자열에 대해 O(L)이므로 전체 시간 복잡도는 O(N*L)

//이전 코드의 문제점
//add(index, inputchar)을 사용했는데 이는 최악의 경우 O(n)이 소요됨
//문자열 길이가 L이면, 한 번 입력처리에 최악의 경우 O(L^2)가 소요됨
//종합 시간 복잡성은 O(N*(L^2))가 걸리기에 시간초과가 발생했음

public class Main {

	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));				
		
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0)
		{
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();
			String input = br.readLine();
			
			for(char ch : input.toCharArray()) {
				switch(ch) {
					case '<':
						if(!left.empty())
							right.push(left.pop());
						break;
					case '>':
						if(!right.empty())
							left.push(right.pop());
						break;
					case '-':
						if(!left.empty())
							left.pop();
						break;
					default:
						left.push(ch);
						break;
				}
			}
			
			while(!left.empty())
				right.push(left.pop());
			while(!right.empty())
				bw.write(right.pop());
			bw.write("\n");
		}
		
		
		bw.flush();
		br.close();		
		bw.close();
	}				
	
	
}
