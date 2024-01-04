public class RowWithMaximumNumberOfOnes {
    public int solve(int[][] A) {
        // int count = 0, best = Integer.MIN_VALUE, minIndex = 0;
        // for(int i = 0; i < A.length; i++) {
        //     for(int j = 0; j < A[i].length; j++) {
        //         if(A[i][j] == 1) {
        //             count = A[i].length - j + 1;
        //             if(best < count) {
        //                 best = count;
        //                 minIndex = i;
        //             }
        //         }
        //     }
        // }
        // return minIndex;

        // More optimised approach for checking number of ones fron ending of every row
        // as given rows are sorted so 1 in lower rows exists from starting

        int n = A.length;
        int ans = 0;
        for(int i = 0, j = n-1; i < n && j >= 0; i++) {
            while(A[i][j] == 0 && j >= 0) {
                ans = i;
                j -= 1;
            } 
        }
        return ans;
    }
    
}
