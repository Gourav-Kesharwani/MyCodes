import java.util.*;
import java.io.*;


class dividenconquer{
    public static int rotatedNSortedSearch(int arr[],int target,int start_index,int end_index)
    {
        if(start_index>end_index)
        return -1;

        int mid=start_index+(end_index-start_index)/2;

        if(arr[mid]==target)
        return mid;

        if(arr[start_index]<=arr[mid])
        {
            if(arr[start_index]<=target&&target<=arr[mid])
            {
                return rotatedNSortedSearch(arr, target, start_index, mid-1);
            }
            else
            {
                return rotatedNSortedSearch(arr, target, mid+1, end_index);
            }
        }

        else
        {
            if(arr[mid]<=target&&target<=arr[end_index])
            {
                return rotatedNSortedSearch(arr, target, mid+1, end_index);
            }
            else{
                return rotatedNSortedSearch(arr, target, start_index, mid-1);
            }
        }
    }
    public static void main(String [] args)
    {
        int arr[]={4,5,6,7,0,0,0,1,2,2,2};

        System.out.println(rotatedNSortedSearch(arr,5,0,arr.length-1));
    }
}