import java.util.*;
import java.io.*;

public class BitMagic {
public static int countSetBits(int n) {
int count=0;

while(n!=0)
{
n=(n&(n-1));
count++;
}

return count;
        
}
    public static void checkKthBitSet(int n,int k)
    {
        // int Bitmask=1<<(k-1);

        // if((n&Bitmask)!=0)   ////using leftshift
        // System.out.println("Set");
        // else
        // System.out.println("Reset");


        if((n>>(k-1)&1)!=0)
        System.out.println("Set"); //using right shift
        else 
        System.out.println("set");


    }

    // counting bits using lookup table

public static int lookup_table[]=new int[256];

public static void initialize(int lookup_table[])
{
lookup_table[0]=0;

for(int i=1;i<256;i++)
{
lookup_table[i]=(i&1)+lookup_table[i/2];
}

}

public static void countBitsLookup(int n)
{
initialize(lookup_table);
int count=0;
count=count+lookup_table[n&0xff];
n=n>>8;
count=count+lookup_table[n&0xff];
n=n>>8;
count=count+lookup_table[n&0xff];
n=n>>8;
count=count+lookup_table[n&0xff];
System.out.println(count);
}


public static int countOddOccuring(int arr[])
{
int x=0;
for(int i=0;i<arr.length;i++)
{
x=(x^(arr[i]));
}

return x;
}

public static int[] evenOddBit(int n) {
    int arr[]={0,0};

    int pos=0;
    while(n>0)
    {
        if((n&1)==1)
        {
            if(pos%2==0)
            arr[0]+=1;
            else
            arr[1]+=1;
        }
        pos++;

        n=(n>>1);
    }

    return arr;


}   


public static void twoOddOccuring(int arr[],int n)
{
int n1=0,n2=0,xor=0;
for(int i=0;i<n;i++)
{
xor=xor^arr[i];
}

int last_set_bit=(xor&(~(xor-1)));

for(int i=0;i<n;i++)
{
if((arr[i]&last_set_bit)!=0)
n1=(n1^(arr[i]));
else
n2=(n2^arr[i]);
}

System.out.println(n1+"  "+n2);

}


public static void subString(String s)
{
int n=s.length();
int no_substring=(int)Math.pow(2,n);

for(int counter=0;counter<no_substring;counter++)
{

for(int j=0;j<n;j++)
{
if((counter&(1<<j))!=0)
{
System.out.print(s.charAt(j));
}
}
System.out.println();

}
}
    public static void main(String []args)
    {
        // int n=(int)Math.pow(2,31)+1111111111;
        // countBitsLookup(n);
        // System.out.println(countSetBits(n));

        subString("abc");

    }

}