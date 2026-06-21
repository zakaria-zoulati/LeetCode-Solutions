#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    int getMax( vector<int> &costs ){
        int ans = 0 ; 
        for( int &c : costs ){
            ans = max(ans,c);
        }
        return ans;
    }
    int maxIceCream(vector<int>& costs, int coins) {
        int maxVal = getMax( costs ) ; 
        vector<int> count( maxVal+1 , 0 ) ; 
        for( int &c : costs ){
            count[c]++ ; 
        }
        int ans = 0 ; 
        int curr = 0 ; 
        for( int i=1 ; i<=maxVal ; ){
            if( count[i] == 0 ){
                i++ ; 
            }else if( i + curr <= coins ){
                count[i]-- ; 
                curr += i ; 
                ans++ ; 
                
            }else {
                break ;
            }
        }
        return ans;  
    }
};