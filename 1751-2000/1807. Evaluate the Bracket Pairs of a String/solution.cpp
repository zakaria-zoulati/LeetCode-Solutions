#include <bits/stdc++.h>

using namespace std ; 

class Solution {
public:
    string evaluate(string s, vector<vector<string>>& knowledge) {
        int n = s.size() ; 
        int m = knowledge.size() ; 

        unordered_map<string,string> kv ; 
        kv.reserve( m ) ; 
        for( auto &kn : knowledge ){
            kv[ kn[0] ] = kn[1] ; 
        }

        string ans ;

        for( int i=0 ; i<n ; ++i ){
            if( s[i] != '(' ){
                ans.push_back( s[i] );
            }else {
                int start = i+1;  
                while( s[i] != ')' ) i++ ; 
                if( kv.find( s.substr( start , i - start ) ) != kv.end() ){
                    ans += kv[ s.substr( start , i - start ) ] ; 
                }else{
                    ans.push_back( '?' ) ; 
                }
            }
        }
        return ans ; 
    }
};