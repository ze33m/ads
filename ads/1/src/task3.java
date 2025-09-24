public class task3 {
    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        float summa = 0;
        for (int i=0; i<nums.length; i++) summa += nums[i];

        System.out.println("Сумма чисел: "+summa);
        System.out.println("Среднее арифметическое: "+ summa/nums.length);
    }
}
