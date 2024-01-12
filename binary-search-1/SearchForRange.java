
public class SearchForRange {
    public int[] searchRange(final int[] A, int B) {
        int[] result = new int[]{findFirstIndex(A, B), findLastIndex(A, B)};
        return result;
    }

    int findFirstIndex(int[] A, int B) {
        int ans = -1;
        int lo = 0, hi = A.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] >= B) {
                hi = mid - 1;
            }
            else if(A[mid] < B) {
                lo = mid + 1;
            }
            if(A[mid] == B) {
                ans = mid;
            }
        }
        return ans;
        
    }

    int findLastIndex(int[] A, int B) {
        int ans = -1;
        int lo = 0, hi = A.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] <= B) {
                lo = mid + 1;
            }
            else if(A[mid] > B) {
                hi = mid - 1;
            }
            if(A[mid] == B) {
                ans = mid;
            }
        }
        return ans;
    }
}
