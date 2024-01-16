
public class MedianOfArrays {
    public double findMedianOfSortedArrays(int[] A, int[] B) {
        int N = A.length;
        int M = B.length;
        if(M < N) return findMedianOfSortedArrays(B, A);

        int low = 0, high = N;
        while(low <= high) {
            int cut1 = (low+high) >> 1;
            int cut2 = (N + M + 1) / 2 - cut1;
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : A[cut1-1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : B[cut2-1];
            int right1 = cut1 == N ? Integer.MAX_VALUE : A[cut1];
            int right2 = cut2 == M ? Integer.MAX_VALUE : B[cut2];

            if(left1 <= right2 && left2 <= right1) {
                if((N+M)%2==0) {
                    return (Math.max(left1, left2)+Math.min(right1, right2)) / 2.0;
                }
                else return Math.max(left1, left2);
            }

            else if(left1 > right2) {
                high = cut1 - 1;
            }
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }    
}
