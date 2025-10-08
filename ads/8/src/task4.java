import java.lang.Math;

public class task4 {
    static int solve(int n, int k, int d, int count)
    {
        if (n>=(Math.pow(10, k)))
            return count;

        int digit_sum = 0;
        int n_copy = n;
        while(n!=0)
        {
            digit_sum += n%10;
            n/=10;
        }

        count += (digit_sum == d) ? 1 : 0;
        return solve(n_copy + 1, k,d, count);
    }

    public static void main(String[] args)
    {
        int k = 2;
        int d = 4;
        System.out.println(solve((int)Math.pow(10,k-1), k, d, 0));
    }
}
