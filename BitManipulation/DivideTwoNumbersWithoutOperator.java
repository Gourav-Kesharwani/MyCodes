package BitManipulation;

public class DivideTwoNumbersWithoutOperator {
    public static int XOR(int n)
    {
        if(n%4==0)
        return n;
        else if(n%4==1)
        return 1;
        else if(n%4==3)
        return 0;
        else 
        return n+1;
    }
    public static int findXOR(int l, int r) {
        return (XOR(l-1)^XOR(r));
    }
    public static void main(String args[])
    {
        System.out.println(findXOR(5, 11));
    }
}
