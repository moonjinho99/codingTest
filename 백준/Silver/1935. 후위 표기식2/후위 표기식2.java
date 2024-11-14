import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


public class Main {
	public static void main(String[] args) throws IOException
	{						
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));			
		
		int cnt = Integer.parseInt(br.readLine());
		String inputFormula = br.readLine();
		char[] alphabet = new char[cnt];
		double[] inputNum = new double[cnt];
		
		for(int i=0; i<cnt; i++)
		{
			inputNum[i] = Integer.parseInt(br.readLine());
			alphabet[i] = (char)('A'+i);
		}		
		bw.write(Operation(inputFormula, inputNum ,alphabet));
		
		bw.flush();
		br.close();		
		bw.close();
	}
	
	public static String Operation(String inputFormula , double[] inputNum, char[] alphabet)
	{
		Stack<String> stack = new Stack<String>();

		for(int i=0; i<inputFormula.length(); i++)
		{
			char token = inputFormula.charAt(i);
			switch(token)
			{
			case '+','-','*','/':
				Double temp1 = Double.parseDouble(stack.pop());	
				Double temp2 = Double.parseDouble(stack.pop());	
				stack.add(Double.toString(Calculator(temp1,temp2,token)));
				break;
			default:
				for(int j=0; j<alphabet.length; j++)
				{
					if(token == alphabet[j])
					{
						stack.add(Double.toString(inputNum[j]));
					}
				}
				break;
			}		
		}				
		String result = String.format("%.2f", Math.floor(Double.parseDouble(stack.pop()) * 100) / 100);
		return result;		
	}
	
	public static double Calculator(double temp1, double temp2, char op)
	{
		double result = 0;
		
		switch(op)
		{
		case '+':
			result = temp2 +temp1;
			break;
		case '-':
			result = temp2 - temp1;
			break;
		case '*':
			result = temp2 * temp1;
			break;
		case '/':
			result = temp2 / temp1;
			break;
		}
		
		return result;
	}
	
}