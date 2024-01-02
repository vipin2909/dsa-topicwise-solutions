public class MaximumSumSquareSubMatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int[][] prefix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 && j == 0) prefix[i][j] = A[i][j];
                else if(i == 0 && j > 0) prefix[i][j] = prefix[i][j-1] + A[i][j];
                else if(i > 0 && j == 0) prefix[i][j] = prefix[i-1][j] + A[i][j];
                else prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] + A[i][j] - prefix[i-1][j-1];
            }
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i + B - 1 < n && j + B - 1 < n) {
                    if(i == 0 && j == 0) {
                        sum = prefix[i+B-1][j+B-1];
                    }
                    else if(i == 0) {
                        sum = prefix[i+B-1][j+B-1] - prefix[i+B-1][j-1];
                    }
                    else if(j == 0) {
                        sum = prefix[i+B-1][j+B-1] - prefix[i-1][j+B-1];
                    }

                    else {
                        sum = prefix[i+B-1][j+B-1] - prefix[i-1][j+B-1] - prefix[i+B-1][j-1] + prefix[i-1][j-1];
                    }

                }
                res = Math.max(res, sum);
            }
        }
        return res;
    }
}