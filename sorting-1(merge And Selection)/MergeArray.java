public class MergeArray {
    int[] solve(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while(i < A.length && j < B.length) {
            if(A[i] <= B[j]) {
                res[k] = A[i];
                i+=1;
            }
            else {
                res[k] = B[i];
                j++;
            }
            k++;
        }

        while(i < A.length) {
            res[k++] = A[i++];
        }

        while(j < B.length) {
            res[k++] = B[j++];
        }

        return res;
    }
}
