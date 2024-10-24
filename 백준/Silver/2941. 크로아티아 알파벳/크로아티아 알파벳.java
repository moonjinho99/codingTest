import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] croati = {"c=","c-","dz=","d-","lj","nj","s=","z="};
        String inputString = sc.next();
        for(int i=0; i<croati.length; i++)
        {
            if(inputString.contains(croati[i])) {
                inputString = inputString.replace(croati[i], "&");
            }
        }
        System.out.println(inputString.length());
    }
}