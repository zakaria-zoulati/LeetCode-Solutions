class Solution {
public:
    bool checkIfExist(vector<int>& arr) {
        unordered_set<int> s; 
        for (int num : arr) { 
            if ((s.count(num * 2) & 1) == 1) {
                return true;
            }
            if ((num & 1) == 0 && (s.count(num >> 1) & 1) == 1) {
                return true;
            }
            s.insert(num);
        }
        return false;
    }
};