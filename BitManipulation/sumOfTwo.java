package BitManipulation;

public class sumOfTwo {
    public static int getSum(int a, int b) {
        int sum=0,carry=0;
        do{
            sum=a^b;
            carry=a&b;
            a=sum;
            b=carry<<1;
        }while(carry!=0);

        return sum;
    }
    public static void main(String args[])
    {
        int a=6;
        int b=9;
        System.out.println(getSum(a,b));
    }
}
