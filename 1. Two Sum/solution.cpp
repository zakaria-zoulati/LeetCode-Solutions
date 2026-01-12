#include<iostream>
#include<vector>
#include<unordered_map>
using namespace std;
class Solution {
int n;
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        n = nums.size();
        unordered_map<int, int> mp;
        for (int i = 0; i < n; i++) {
            if (mp.find(target - nums[i]) != mp.end()) {
                return {mp[target - nums[i]], i};
            }
            mp[nums[i]] = i;
        }
        return {-1, -1};
    }
};