
public class SortedInsertPosition {
    int solve(int[] A, int target) {
        int lo = 0, hi = A.length;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(A[mid] >= target) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }   
    
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int ind = new SortedInsertPosition().solve(arr, 8);
        System.out.println("Element Inserting At: " + ind);
    }
}
