import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int [][] game = new int[5][5];
	static List<Integer> check = new ArrayList<Integer>();
	static int cnt =0;
	
	public static void main(String[] args) throws IOException
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		for(int i=0; i<5; i++)
		{
			String input[] = br.readLine().split(" ");
			game[i][0] = Integer.parseInt(input[0]);
			game[i][1] = Integer.parseInt(input[1]);
			game[i][2] = Integer.parseInt(input[2]);
			game[i][3] = Integer.parseInt(input[3]);
			game[i][4] = Integer.parseInt(input[4]);
		}
				
		for(int i=0; i<5; i++)
		{
			String input[] = br.readLine().split(" ");
			check.add(Integer.parseInt(input[0]));
			check.add(Integer.parseInt(input[1]));
			check.add(Integer.parseInt(input[2]));
			check.add(Integer.parseInt(input[3]));
			check.add(Integer.parseInt(input[4]));
		}
				
		start();
		
		br.close();
	}	
				
	private static void start()
	{		
		
		for(int num : check)
		{
			if(bingo(num))
			{
				System.out.println(cnt);
				break;
			}
				
		}
	}
	
	private static boolean bingo(int num)
	{
				
		cnt++;		
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{								
				if(game[i][j] == num)
				{
				    int line =0;
					game[i][j] =0;
				
					if(game[0][0] == 0 && game[1][1] == 0 && game[2][2] == 0 && game[3][3] == 0 && game[4][4] == 0)
					{
						line++;
					}
					
					if(game[4][0] == 0 && game[3][1] == 0 && game[2][2] == 0 && game[1][3] == 0 && game[0][4] == 0)
					{
						line++;
					}
					
					for(int h=0; h<5; h++)
					{
						if(game[h][0] == 0 && game[h][1] == 0 && game[h][2] == 0 && game[h][3] == 0 && game[h][4] == 0)
						{
							line++;
						}
						
						if(game[0][h] == 0 && game[1][h] == 0 && game[2][h] == 0 && game[3][h] == 0 && game[4][h] == 0)
						{
							line++;
						}
					}
											
					if(line >= 3)
						return true;
				}
			}
		}		
		
		return false;
	}
}