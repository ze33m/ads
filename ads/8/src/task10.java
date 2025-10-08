public class task10 {
    
    public static int reverse(int n, int reversed) {

        if (n == 0) {
            return reversed;
        }
        
        int lastDigit = n % 10;
        
        int remainingNumber = n / 10;
        
        return reverse(remainingNumber, reversed * 10 + lastDigit);
    }

    public static void main(String[] args) {
        System.out.println();
        int n = 12345; 
        System.out.println(reverse(n, 0));
    }
}
