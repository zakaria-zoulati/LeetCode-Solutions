#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>

using namespace std ; 

class Solution {
    public:
        struct BIT {
            int n ; 
            vector<int> bit ; 
            BIT(int s) {
                n = s ; 
                bit.assign(n + 1, 0);  
            }
            int sum(int idx) {
                long long rs = 0;
                while (idx > 0) {
                    rs += bit[idx];
                    idx -= idx & -idx;
                }
                return rs;
            }
            void insert(int idx) {
                while (idx <= n) {
                    bit[idx] += 1;
                    idx += idx & -idx;
                }
            }
        };
        int reversePairs(vector<int>& nums) {
            int n = nums.size(); 
            if( n == 1 ) return 0 ; 
            int rs = 0; 
            vector<int> m(nums); 
            sort(m.begin(), m.end()); 
            int curr = 1; 
            unordered_map<int,int> m_iv; 
            unordered_map<int,int> m_vi; 
            for(int i = 0; i < n; ++i) {
                m_vi[m[i]] = curr; 
                m_iv[curr] = m[i]; 
                while(i+1<n && m[i] == m[i + 1]) {
                    i++; 
                }
                curr++; 
            }
            BIT bit(curr); 
            for(int i = 0; i < n; ++i) {
                long long t = 2LL * nums[i]; 
                if(m[n - 1] > t) {
                    int l = 1;
                    int r = curr - 1;
                    while(l < r) {
                        int mid = l + (( r-l )>>1) ;
                        if(m_iv[mid] > t) {
                            r = mid; 
                        } else { 
                            l = mid + 1; 
                        }
                    } 
                    rs += bit.sum(curr - 1) - bit.sum(l - 1); 
                }
                bit.insert(m_vi[nums[i]]); 
            }
            return rs; 
        }
    };