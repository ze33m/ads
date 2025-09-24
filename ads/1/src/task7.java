import java.util.Scanner;

public class task7 {
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println(fact(Integer.valueOf(console.nextLine())));
        console.close();
    }
    public static int fact(int n)
    {
        int res = 1;
        for (int i = 2; i<=n; i++) res*=i;
        return res;
    }
}
