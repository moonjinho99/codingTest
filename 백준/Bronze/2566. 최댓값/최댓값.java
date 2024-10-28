import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [][] numArray = new int[9][9];
        int row = 0;
        int col = 0;

        int max = 0;

        for(int i=0; i <9; i++)
        {
            for(int j=0; j<9; j++)
            {
                numArray[i][j] = sc.nextInt();

                if(numArray[i][j] >= max)
                {
                    max = numArray[i][j];
                    row = i+1;
                    col = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.println(row+ " "+col);
    }
}