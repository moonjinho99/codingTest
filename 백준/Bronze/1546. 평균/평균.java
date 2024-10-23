import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subjectCnt = sc.nextInt();
        double max = 0;
        double totalNum = 0;

        double score[] = new double[subjectCnt];

        for(int i=0; i<subjectCnt; i++)
        {
            score[i] = sc.nextInt();
            if(max < score[i])
                max = score[i];
        }
        for(int i=0; i<subjectCnt; i++)
        {
            totalNum += (score[i] / max * 100);
        }
        System.out.println(totalNum/subjectCnt);

    }

}