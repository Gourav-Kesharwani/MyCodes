import java.util.*;

public class Mathematics{

    public static void sieveEratosthenesPrimeAlgo(int n)
    {
        ArrayList<Boolean> isPrime=new ArrayList<>(Collections.nCopies(n+1,true));
        
        for(int i=2;i<=n;i++)
        {
            if(isPrime.get(i))
            {
                System.out.print(i+" ");
                for(int j=i*i;j<=n;j=j+i)
                {
                    isPrime.set(j,false);
                }
            }
        }
        // for(int i=2;i*i<=n;i++)
        // {
        //     if(isPrime.get(i))
        //     {
        //         for(int j=2*i;j<=n;j=j+i)
        //         {
        //             isPrime.set(j,false);
        //         }
        //     }
        // }

        // for(int j=2;j<=n;j++)
        // {
        //     if(isPrime.get(j))
        //     System.out.print(j+" ");
        // }
    }

    public static long  powerIterative(long x,long n)
    {
        long res=1;

        while(n>0)
        {
            if(n%2==1)
            res=res*x;

            x=x*x;
            n=n/2;
        }
        return res;
    }

    public static long powerRecursive(long x,long n)
    {
        if(n==0)
        return 1;

        long temp=powerRecursive(x, n/2);

        if(n%2==0)
        return temp;

        else 
        return temp*x;
    }


    public static long power(long N,long R)
    {
        //Your code here
        long res=1;
        
        while(R>0)
        {
            if(R%2!=0)
            res=(res*N);

            N=N*N;
            R=R/2;
        }
        
        return res;
    }

    public static void main(String args[])
    {
        System.out.println(Integer.toBinaryString((~0)));
        System.out.println(Integer.toBinaryString(-1));;
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(~(-1)));
    }
}