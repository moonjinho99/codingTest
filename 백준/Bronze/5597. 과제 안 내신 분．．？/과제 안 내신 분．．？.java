import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stdNum = new int[30];
        int[] SubmitStd = new int[28];
        
        int h=0;

        for(int i=0; i<28; i++)
            SubmitStd[i] = sc.nextInt();

        for(int i=1; i<=30; i++)
            stdNum[i-1] = i;

        for(int i=0; i<30; i++)
        {
            for(int j=0; j<28; j++)
            {
                if(stdNum[i] == SubmitStd[j])
                    stdNum[i] = -1;
            }
        }

        for(int noSubmit : stdNum)
        {
            if(noSubmit != -1)
            {
                System.out.println(noSubmit);
            }
        }

    }

}