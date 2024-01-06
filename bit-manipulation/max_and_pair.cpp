#include<bits/stdc++.h>
using namespace std;

int solve(vector<int> &A) {
    int result = 0, N = A.size();
    for(int i = 31; i >= 0; i -= 1) {
        int count = 0;
        for(int j = 0; j < N; j++) {
            if((A[j] & ( 1 << i )) != 0) {
                count += 1;
            }
        }

        if(count >= 2) {
            result |= (1 << i);
            for(int j = 0; j < N; j++) {
                if((A[j] & (1 << i)) == 0) {
                    A[j] = 0;
                }
            }
        }
    }

    return result;
}
int main() {

}