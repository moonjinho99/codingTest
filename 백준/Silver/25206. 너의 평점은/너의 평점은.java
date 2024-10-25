import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double scoreSum = 0;
        double scoreRankSum = 0;

        String[] subject = new String[20];
        double[] score = new double[20];

        String[] rank = new String[20];
        double[] rankScore = new double[20];
        
        for(int i=0; i<20; i++)
        {
            subject[i] = sc.next();
            score[i] = sc.nextDouble();
            rank[i] = sc.next();

            if(rank[i].equals("A+"))
                rankScore[i] = 4.5;
            if(rank[i].equals("A0"))
                rankScore[i] = 4.0;
            if(rank[i].equals("B+"))
                rankScore[i] = 3.5;
            if(rank[i].equals("B0"))
                rankScore[i] = 3.0;
            if(rank[i].equals("C+"))
                rankScore[i] = 2.5;
            if(rank[i].equals("C0"))
                rankScore[i] = 2.0;
            if(rank[i].equals("D+"))
                rankScore[i] = 1.5;
            if(rank[i].equals("D0"))
                rankScore[i] = 1.0;
            if(rank[i].equals("F"))
                rankScore[i] = 0.0;
            if(rank[i].equals("P"))
                continue;
            scoreSum += score[i];
            scoreRankSum += score[i] * rankScore[i];
        }
        System.out.println(scoreRankSum/scoreSum);
    }
}