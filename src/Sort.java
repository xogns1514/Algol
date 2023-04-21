public class Sort {
    public static void bubbleSort(int[] arr) {
        final int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                if(j + 1 < length && arr[j] > arr[j+1]){
                    arr[j] = arr[j] + arr[j+1];
                    arr[j+1] = arr[j] - arr[j+1];
                    arr[j] = arr[j] - arr[j+1];
                }
            }
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int position = i;
            while(position > 0 && key < arr[position -1]){
                arr[position] = arr[position-1];
                position --;
            }
            arr[position] = key;
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if(l == r-1) return;
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr, m, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int idx1, idx2, idx3;
        int[] tmp = new int[arr.length];
        idx1 = idx3 = l;
        idx2 = m;
        while (idx1 < m && idx2 < r) {
            if(arr[idx1] < arr[idx2]) tmp[idx3++] = arr[idx1++];
            else tmp[idx3++] = arr[idx2++];
        }
        while(idx1 < m) tmp[idx3++] = arr[idx1++];
        while(idx2 < r) tmp[idx3++] = arr[idx2++];
        for (int i = 0; i < r; i++) {
            arr[i] = tmp[i];
        }
    }
    }