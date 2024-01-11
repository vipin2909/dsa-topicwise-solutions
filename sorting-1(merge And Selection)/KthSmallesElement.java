
public class KthSmallesElement {
    int kthSmallest(int[] A, int B) {
        int ind = 0;
        for(int i = 0; i < B; i++) {
            ind = i;
            for(int j = i+1; j < A.length; j++) {
                if(A[ind] > A[j]) {
                    ind = j;
                }
            }
            int temp = A[i];
            A[i] = A[ind];
            A[ind] = temp;
        }
        return A[B-1];
    }    
}
