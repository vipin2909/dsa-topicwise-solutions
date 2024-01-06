#include<bits/stdc++.h>
using namespace std;

int trap(const vector<int> &A) {
    // Using LeftMax And RightMax Array which adds O(n) space complexity

    /*
        int n = A.size(); 
        vector<int> leftMax(n);
        vector<int> rightMax(n);

        leftMax[0] = A[0];
        rightMax[n-1] = A[n-1];
        for(int i = 1; i < n; i++) {
            if(A[i] > leftMax[i-1]) {
                leftMax[i] = A[i];
            }
            else {
                leftMax[i] = leftMax[i-1];
            }
        }
        for(int i = n-2; i >= 0; i-=1) {
            if(A[i] > rightMax[i+1]) {
                rightMax[i] = A[i];
            }
            else {
                rightMax[i] = rightMax[i+1];
            }
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            int temp = min(leftMax[i], rightMax[i]) - A[i];
            res += (temp >= 0 ? temp : 0);
        }
        return res;
    */


   // Using LeftMax And RightMax Variable to store leftmax and rightmax values (SC: O(1)).
   int left_index = 0, right_index = A.size()-1, left_max = 0, right_max = 0;

   int res = 0;
   while(left_index <= right_index) {
        if(left_max <= right_max) {
            res += max(left_max - A[left_index], 0);
            left_max = max(left_max, A[left_index]);
            left_index += 1;
        }
        else {
            res += max(right_max - A[right_index], 0);
            right_max = max(right_max, A[right_index]);
            right_index -= 1;
        }
   }
   return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) {
        cin >> A[i];
    }

    int res = trap(A);
    cout << "Maximum Rain Water Trapped is: " << res << "\n";
    return 0;
}