#include<bits/stdc++.h>
using namespace std;

int solve(vector<int> &A);
int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) {
        cin >> A[i];
    }
    int res = solve(A);
    cout << "Minimum number of swaps required: " << res << '\n';
    return 0;
}

int solve(vector<int> &A) {
    // crux of the problem is 
    // suppose at a's position b exists 
    // at b's position c exists
    // and so on form a cycle 
    // so we start by fixing a's position at a's position a should exists

    int swaps = 0;
    for(int i = 0; i < A.size(); i++) {
        while(A[i] != i) 
        {
            int temp = A[i];
            int temp2 = A[A[i]];
            A[i] = temp2;
            A[temp] = temp;
            swaps+=1;
        }
    }
    return swaps;
}