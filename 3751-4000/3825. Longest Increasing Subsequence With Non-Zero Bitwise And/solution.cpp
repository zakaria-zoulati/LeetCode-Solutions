#include<bits/stdc++.h>
using namespace std;
class Solution {
public:
    int longestSubsequence(vector<int>& nums) {
        int ans = 0, n = nums.size();
        auto findLIS = [] (auto &arr) {
            vector<int> temp;
            for (int i = 0; i < arr.size(); i++) {
                if (temp.empty() || temp.back() < arr[i]) {
                    temp.push_back(arr[i]);
                } else {
                    int idx = upper_bound(temp.begin(), temp.end(), arr[i]) - temp.begin();
                    if (idx == temp.size() || (idx > 0 && temp[idx - 1] == arr[i])) {
                        
                    }
                    else {
                        temp[idx] = arr[i];
                    }
                }
            }
            return temp.size();
        };
        for (int i = 30; i >= 0; i--) {
            vector<int> temp;
            for (int j = 0; j < n; j++) {
                if (nums[j] & (1 << i)) temp.push_back(nums[j]);
            }
            ans = max(ans, (int)findLIS(temp));
        }
        return ans;
    }
};