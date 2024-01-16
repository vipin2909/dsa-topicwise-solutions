
public class MedianMatrix {

    public int lowerBound(int[] A, int target) {
        int low = 0, hi = A.length - 1, ans = -1;
        while(low <= hi) {
            int mid = ((hi - low) >> 1) + low;
            if(A[mid] < target) {
                ans = mid;
                low = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }

        return ans + 1;
    }
    public int findMedian(int[][] A) {
        int N = A.length, M = A[0].length, lo = 0, hi = (int)(1e9), ans = -1;
        int middlePosition = ((N*M)>>1);
        while(lo <= hi) {
            int mid = ((hi-lo)>>1) + lo;
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                cnt += lowerBound(A[i], mid);
            }

            if(cnt > middlePosition) {
                hi = mid - 1;
            }

            else {
                ans = mid;
                lo = mid + 1;
            }
        }

        return ans;
        


    }    
}


/*
 *  int min = A[0][0], max = A[0][0];
    int n = A.size(), m = A[0].size();
    for (int i = 0; i < n; ++i) {
        if (A[i][0] < min) min = A[i][0];
        if (A[i][m-1] > max) max = A[i][m-1];
    }

    int element = (n * m + 1) / 2;
    while (min < max) {
        int mid = min + (max - min) / 2;
        int cnt = 0;
        for (int i = 0; i < n; ++i)
            cnt += upper_bound(&A[i][0], &A[i][m], mid) - &A[i][0];
        if (cnt < element)
            min = mid + 1;
        else
            max = mid;
    }
    return min;
 * 
 */