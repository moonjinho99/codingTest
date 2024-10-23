import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] chessCnt = new int[6];
        int[] minusCnt = new int[6];

        for(int i = 0; i < 6; i++)
        {
            chessCnt[i] = sc.nextInt();
            if(i == 0 || i == 1)
            {
                minusCnt[i] =countAddMinus(chessCnt[i],1);
            }
            if(i == 2 || i == 3 || i == 4)
            {
                minusCnt[i] =countAddMinus(chessCnt[i],2);
            }
            if(i == 5)
            {
                minusCnt[i] =countAddMinus(chessCnt[i],8);
            }
        }

        for(int num : minusCnt)
        {
            System.out.print(num + " ");
        }

    }


    public static int countAddMinus(int chessCnt, int staticCnt)
    {
        int minusCnt;

        if(chessCnt == 0)
        {
            minusCnt = staticCnt;
        }
        else if(chessCnt == staticCnt)
        {
            minusCnt = 0;
        }
        else
        {
            minusCnt = staticCnt - chessCnt;
        }

        return minusCnt;
    }

}