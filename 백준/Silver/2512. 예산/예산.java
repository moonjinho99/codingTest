import java.util.*;
import java.io.*;


public class Main {

    private static int N;
    private static int M;
    private static List<Integer> moneyList = new ArrayList();

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for(String money : input)
        {
            moneyList.add(Integer.parseInt(money));
        }

        M = Integer.parseInt(br.readLine());
        Collections.sort(moneyList);

        int result = findBudgetMax();

        bw.write(Integer.toString(result));
        bw.flush();

        br.close();
        bw.close();
    }

    private static boolean checkBudget()
    {
        int sum = 0;

        for(int money : moneyList)
        {
            sum+=money;
        }

        if(sum > M)
            return false;
        else
            return true;
    }

    private static int findBudgetMax()
    {
       if(checkBudget()) {
            return moneyList.get(N - 1);
       }

       int left = 0;
       int right = moneyList.get(N - 1);
       int result = 0;

       while(left <= right) {
            int mid = (left + right)/2;
            long sum = 0;

            for(int money : moneyList){ 
                sum += Math.min(money, mid);
            }

            if(sum <= M) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
       }

       return result;
    }
}