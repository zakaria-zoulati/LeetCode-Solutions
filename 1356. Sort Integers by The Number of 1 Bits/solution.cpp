class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        sort(arr.begin(), arr.end(), [](int a, int b) {
            int popcountA = __builtin_popcount(a);
            int popcountB = __builtin_popcount(b);
            return popcountA == popcountB ? a < b : popcountA < popcountB;
        });
        return arr;
    }
};
