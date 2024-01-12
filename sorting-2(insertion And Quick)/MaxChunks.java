
public class MaxChunks {
    int ans = 0;

    void swap(int[] A, int index1, int index2) {
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    int partition(int[] A, int low, int high) {
        int pivot = A[high];
        
        // index of smaller element and indicates 
        // the right position of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++) {
            // if curr element smaller than the pivot element
            if(A[j] < pivot) {
                // incr. index of smaller element
                i += 1;
                swap(A, i, j);
            }
        }

        swap(A, i + 1, high);
        return (i + 1);
    }
    public void quickSort(int[] A, int low, int high) {
        if(low < high) {
            int pi = partition(A, low, high);
            ans += 1;
            quickSort(A, low, pi - 1);
            quickSort(A, pi + 1, high);
        }
    }
    public int solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return ans;
    }    
}
