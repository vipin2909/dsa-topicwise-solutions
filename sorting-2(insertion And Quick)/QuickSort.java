import java.util.Scanner;

public class QuickSort {

    public static void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }

    public static int partition(int[] A, int low, int high) {
        int pivot = A[high];
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            if(A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, i+1, high);
        return (i+1);
    }


    public static void quickSort(int[] A, int low, int high) {
        if(low < high) {
            int pr = partition(A, low, high);
            quickSort(A, low, pr - 1);
            quickSort(A, pr + 1, high);
        }
    }

    public static void sortArray(int[] A) {
        int lo = 0, hi = A.length - 1;
        quickSort(A, lo, hi);
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();
        sortArray(arr);
        for(int ele: arr) {
            System.out.print(ele+" ");
        }
        System.out.println();
    }
}
