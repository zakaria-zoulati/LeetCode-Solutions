#include <bits/stdc++.h>

using namespace std; 

class Solution {
public:
    int numberOfSpecialChars(string word) {
        int n = word.size() ; 

        vector<int> upper( 26 , -1 ) ; 
        vector<int> lower( 26 , -1 ) ;

        for( int i=0 ; i<n ; ++i ){
            if( word[i] <= 'Z' ){
                if( upper[ word[i] - 'A' ] == -1 ){
                    upper[word[i]-'A'] = i ; 
                }
            }else {
                lower[ word[i]-'a' ] = i ; 
            }
        }

        int ans = 0 ; 
        for( int i=0 ; i<26 ; ++i ){
            if( upper[i] != -1 && lower[i] != -1 & upper[i] > lower[i] ){
                ans++ ; 
            }
        }

        return ans ; 
    }   
};