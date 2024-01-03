#include<iostream>
#include<vector>


int solve(std::vector<int> &A, int B) {
    // crux of the question is to count <= B elements and > B elements and 
    // using window check number of elements larger than B

    int count = 0, larger_element = 0;
    for(int i = 0; i < A.size(); i++) {
        if(A[i] <= B) count += 1;
    }

    // now checking for larger element in first window of size cnt
    for(int i = 0; i < count; i++) {
        if(A[i] > B) larger_element += 1;
    }

    // now checking larger element in each window of size cnt
    int res = larger_element;
    for(int i = 0, j = count; j < A.size(); i++, j++) {
        if(A[i] > B) larger_element-=1;
        if(A[j] > B) larger_element+=1;
        res = std::min(res, larger_element);
    }
    return res;


}

int main(void) {
    int n;
    std::cin >> n;
    std::vector<int> A(n);
    for(int i = 0; i < n; i++) std::cin >> A[i];
    int B;
    std::cin >> B;
    int min_swaps = solve(A, B);
    std::cout << "Minimum Number of swaps: " << min_swaps;
}