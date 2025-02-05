class Solution {
public:
    vector<long long> maximumEvenSplit(long long finalSum) {
        if (finalSum % 2 == 1) {
            return vector<long long>();
        }
        vector<long long> rs; 
        long long curr = 2;
        while (finalSum > (curr << 1) ) { 
            rs.push_back(curr);
            finalSum -= curr;
            curr += 2;
        }
        rs.push_back(finalSum) ; 
        return rs;
    }
};