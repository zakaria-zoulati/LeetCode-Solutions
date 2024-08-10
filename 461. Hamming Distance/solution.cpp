class Solution {
public:
    int hammingDistance(int x, int y) {
        int inter = x ^ y ; 
        return __builtin_popcount(inter) ; 
    }
};