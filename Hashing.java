import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.*;

public class Hashing {

    public static void freqGreaterThanN(int arr[])
    {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(hm.containsKey(arr[i]))
            hm.put(arr[i],hm.get(arr[i])+1);
            else
            hm.put(arr[i],1);
        }

        int n=arr.length/3;
        for(Integer i: hm.keySet())
        {
            if(hm.get(i)>n)
            System.out.print(i+" ");
        }
    }


    public boolean isAnagram(String s, String t) {
        
        HashMap<Character,Integer> hm=new HashMap<>();
        int n=s.length(),m=t.length();
        if(n!=m)
        return false;

        char c=' ';
        for(int i=0;i<n;i++)
        {
            c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        
        int freq=0;
        for(int i=0;i<m;i++)
        {
            c=t.charAt(i);
            if(hm.containsKey(c))
            {
                freq=hm.get(c);
                if(freq==1)
                hm.remove(c);
                else
                hm.put(c,freq-1);
            }
        }

        if(hm.isEmpty())
        return true;
        else
        return false;
    }

    public static void Union(int arr1[],int arr2[])
    {
        HashSet<Integer> t1=new HashSet<>();

        
        for(int i=0;i<arr1.length;i++)
        {
            t1.add(arr1[i]);
        }
        for(int j=0;j<arr2.length;j++)
        {
            t1.add(arr2[j]);
        }

        System.out.println();
        for(Integer i: t1)
        {
            System.out.print(i+"  ");
        }
    }

    public static void Intersection(int arr1[],int arr2[])
    {
        HashSet<Integer> h=new HashSet<>(),h2=new HashSet<>();
        for(int i=0;i<arr1.length;i++)
        {
            h.add(arr1[i]);
        }
        System.out.println();
        for(int j=0;j<arr2.length;j++)
        {
            if(h.contains(arr2[j]))
            h2.add(arr2[j]);

        }

        System.out.println(h2);
    }

    public static void main(String args[]){

        HashSet<String> h=new HashSet<>();
        h.add("Noida");
        h.add("telangana");
        h.add("kashmir");
        h.add("america");
        h.add("usa");

        LinkedHashSet<String> hl=new LinkedHashSet<>();
        hl.add("Noida");
        hl.add("telangana");
        hl.add("kashmir");
        hl.add("america");
        hl.add("usa");
        
        TreeSet<String> ha=new TreeSet<>();
        ha.add("Noida");
        ha.add("telangana");
        ha.add("kashmir");
        ha.add("america");
        ha.add("usa");



        int arr1[]={7,3,9,7,3,8,10},arr2[]={6,3,9,2,9,4};
        Union(arr1, arr2);
        Intersection(arr1, arr2);



    }
    
}
