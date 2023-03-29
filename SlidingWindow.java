import java.util.*;
import java.util.LinkedList;
import java.io.*;


public class SlidingWindow{

    public static int maxSubarraySum(int arr[],int k)
    {
        int sum=0;
        int start=0,end=0;
        int size=arr.length;
        int max=0;

        while(end<size)
        {
            sum+=arr[end];
            if(end-start+1<k)
            end++;
            else if(end-start+1==k)
            {
                max=Math.max(max,sum);
                sum-=arr[start];
                start++;
                end++;
            }
        }
        return max;
    }


    public static void firstNegativeOfWindow(int arr[],int k)
    {
        int start=0;
        int end=0;
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<>();
        while(end<n)
        {
            if(arr[end]<0)
            list.add(arr[end]);

            if(end-start+1<k)
            end++;
            else if(end-start+1==k)
            {
                if(list.size()==0)
                continue;

                System.out.println(list.get(0));
                
                if(arr[start]==list.get(0))
                list.remove(0);

                end++;
                start++;
            }
        }

    }
    
    public static ArrayList<Integer> maxOfAllSubarray(int arr[],int k)
    {
        ArrayList<Integer> max=new ArrayList<>();
        int start=0,end=0;
        int n=arr.length;
        Deque<Integer> d=new LinkedList<>();
        while(end<n)
        {
            while(d.size()>0&&d.peekLast()<arr[end])
            d.removeLast();
            
            d.addLast(arr[end]);

            if(end-start+1<k)
            end++;

            else if(end-start+1==k)
            {
                max.add(d.peekFirst());
                start++;
                end++;

            }
        }
        return max;
    }


    

    public static int lenOfLongSubarrSumK(int A[], int N, int K) {
        //Complete the function
        
        return 0;
        
    }

    public static String substringWithMaxKDistinctChar(String s,int k)
    {
        StringBuilder max=new StringBuilder("");

        for(int i=0;i<s.length()-1;i++)
        {
            StringBuilder temp=new StringBuilder(""),dist=new StringBuilder("");
            dist.append(s.charAt(i));
            temp.append(s.charAt(i));
            int d=0;

            for(int j=i+1;j<s.length();j++)
            {
                for(int l=0;l<=d;l++)
                {
                    if(dist.charAt(l)!=s.charAt(j))
                    {
                        dist.append(s.charAt(d));
                        d++;
                        break;
                    }
                }

                temp.append(s.charAt(j));
                if(dist.length()==k)
                break;
            }

            if(max.length()<temp.length())
            max=temp;
        }
        s=max.toString();
        return s;
    }


    public static void main(String args[])
    {
        // int arr[]={1,6,4,2,2,-3,9,-1,3,5};
        // int k=3;
        // System.out.println(maxOfAllSubarray(arr, k));
        System.out.println(substringWithMaxKDistinctChar("aabacbe", 3));
    }
}