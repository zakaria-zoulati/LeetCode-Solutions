#include <bits/stdc++.h>

using namespace std ; 

int dp[300001] ;   

class Solution {
public:
    vector<int> validSequence(string &word1, string &word2) {
        int n = word1.size() ; 
        int m = word2.size() ;

        int pos=0 ; 
        for( int k=n-1 ; k>=0 ; --k ){
            if( pos<m && word1[k] == word2[m-1-pos] ){
                pos++ ; 
            }
            dp[k] = pos ;  
        }
    
        vector<int> ans ; 
        int curr = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( word1[i] == word2[curr] ){
                ans.push_back(i) ;
                if( ++curr == m ){
                    return ans ; 
                }
            }else if( curr + 1 == m ){
                ans.push_back( i ) ; 
                return ans ; 
            }else if( i+1 < n && dp[i+1] >= ( m - curr - 1 ) ){
                ans.push_back(i) ; 
                curr++ ; 
                i++ ; 
                while( curr < m ){
                    if( word1[i] == word2[curr] ){
                        ans.push_back(i) ; 
                        curr++ ;  
                    }  
                    i++ ; 
                }
                return ans ; 
            }
        }
        return {} ;  
    }
};