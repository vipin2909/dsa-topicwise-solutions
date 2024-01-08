/*
    Given an array of integers A, calculate the sum of
    A [ i ] % A [ j ] for all possible i, j pairs. 
    Return sum % (109 + 7) as an output.

    Problem Constraints
    1 <= length of the array A <= 10^5
    1 <= A[i] <= 10^3
*/

// crux of the problem are constraints

// another approach for this problem is to check 
/*
    int N = A.size();
    int max = *max_element(A.begin(), A.end());

    // this array is to store freq of all elements
    int cnt[max+1] = {0};
    for(int i = 0; i < N; i++) {
        cnt[A[i]]++;
    }

    // value to store ans
    ll ans = 0;
    // for all valid pairs
    for(int i = 1; i <= max; i++) {
        for(int j = 1; j <= max; j++) {
            ans = ans + cnt[i] * cnt[j] * (i % j);
            ans = ans % P;
        }
    }

    return (int)(ans % P);
*/
#define ll long long
#include<bits/stdc++.h>
using namespace std;

const ll P = 1000000007;
const int MAX_SIZE = 1005;

int solve(vector<int> &A) {
    int N = A.size();
    vector<int> arr(MAX_SIZE), sum(MAX_SIZE);
    for(int i = 0; i < N; i++) {
        arr[A[i]] += 1;
    }

    for(int i = 1; i <= 1000; i++) {
        for(int j = 0; j < N; j++) {
            sum[i] += i % A[j];
        }
    }

    int res = 0;
    for(int i = 0; i < MAX_SIZE; i++) {
        res = (res % P + (1L*sum[i]*arr[i]) % P) % P;
    }

    return (int)(res % P);

}
int main() {
    int n;
    cin >> n;
    vector<int> A(n);
    for(int i = 0; i < n; i++) cin >> A[i];
    int mod_sum = solve(A);
    cout << "Mod Sum of all pairs: " << mod_sum << "\n";
    return 0;
}