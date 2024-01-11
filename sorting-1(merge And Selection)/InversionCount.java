
public class InversionCount {
    public int merge(int[] A, int left, int mid, int right) {
        int invCount = 0;
        int i = left, j = mid, k = 0;
        int[] res = new int[right-left+1];
        while(i < mid && (j <= right)) {
            if(A[i]<=A[j]) {
                res[k++]=A[i++];
            }
            else {
                res[k++]=A[j++];
                invCount+=(mid-i);
            }
        }

        while(i<mid) res[k++]=A[i++];
        while(j<=right)res[k++]=A[j++];

        for(i=left, k=0; i <= right; i++, k++) A[i]=res[k];
        return invCount;
    }
    public int mergeSort(int[] A, int left, int right) {
        int invCount = 0;
        int mod = (int)(1e9+7);
        if(right>left) {
            int mid=left+(right-left)/2;
            invCount+=mergeSort(A, left, mid)%mod;
            invCount+=mergeSort(A, mid+1, right)%mod;
            invCount+=merge(A, left, mid+1, right)%mod;
        }
        return invCount;
    }

    public int solve(int[] A) {
        return mergeSort(A, 0, A.length-1);
    }
    
}
