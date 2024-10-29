import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] wordArray = new String[5];
        int maxLength = 0;

        String colWord = "";

        for(int i=0; i<5; i++)
        {
            wordArray[i] = sc.nextLine();
            if(maxLength < wordArray[i].length())
                maxLength = wordArray[i].length();
        }

        for(int j=0; j<maxLength; j++)
        {
            for(int i=0; i<5; i++)
            {
                if(wordArray[i].length() - 1 < j)
                    continue;
                else
                    colWord += wordArray[i].charAt(j);
            }
        }
        System.out.println(colWord);
    }
}