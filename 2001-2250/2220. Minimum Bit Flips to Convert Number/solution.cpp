class Solution {
public:
    int minBitFlips(int start, int goal) {
        int inter = start^goal ; 
        return __builtin_popcount(inter) ; 
    }
};