import java.util.Arrays;

public class WaveArray {

    void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public int[] solve(int[] A) {
        Arrays.sort(A);
        for(int i = 0; i < A.length; i+=2) {
            if(i+1 < A.length) {
                swap(A, i, i+1);
            }
        }
        return A;
    }    
}
