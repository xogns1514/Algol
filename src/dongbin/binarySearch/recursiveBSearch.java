package dongbin.binarySearch;
import java.util.*;

public class recursiveBSearch {
    public static int bSearch(int[] arr, int target, int start, int end){
        if(start > end) return -1;
        int mid = (start + end) / 2;
        if(arr[mid] == target) return mid;
        else if(arr[mid] > target) return bSearch(arr, target, start, mid - 1);
        else return bSearch(arr, target, mid+1, end);
    }
}
