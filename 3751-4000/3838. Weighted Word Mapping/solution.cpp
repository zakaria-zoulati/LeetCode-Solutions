#include <bits/stdtr1c++.h>

using namespace std ; 

class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        int n = words.size() ; 
        int m = weights.size() ; 
        string ans(n , '-') ; 
        for( int i=0 ; i<n ; ++i ){
            int score = 0 ; 
            for( int j=0 ; j<words[i].size() ; ++j ){
                score += weights[ words[i][j] - 'a' ] ; 
            }
            score %= 26 ; 
            ans[i] = ( char( 'z' - score ) ) ; 
        }
        return ans ;  
    }
};