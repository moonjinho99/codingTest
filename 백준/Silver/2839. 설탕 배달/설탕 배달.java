import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int kg = sc.nextInt();
        int firstInput = kg;
        int reload = 0;
        int cnt = 0;

        while(kg > 0)
        {
            if(kg % 5 == 0)
            {
                cnt += kg/5;
                kg %=5;
            }
            else{
                if(reload == 0)
                {
                    cnt += kg /5;
                    kg%=5;
                    if(kg % 3 == 0)
                    {
                        cnt += kg/3;
                        kg %=3;
                    }else{
                        if(kg == firstInput)
                        {
                            cnt = -1;
                            break;
                        }
                        kg+=5;
                        cnt--;
                        reload = 1;
                    }
                }else{
                    if(kg % 3 == 0)
                    {
                        cnt += kg/3;
                        kg %=3;
                    }
                    else{
                        if(kg == firstInput)
                        {
                            cnt = -1;
                            break;
                        }
                        kg+=5;
                        cnt--;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}