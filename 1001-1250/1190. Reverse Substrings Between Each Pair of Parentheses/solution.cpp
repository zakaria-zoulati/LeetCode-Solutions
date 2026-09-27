#include <bits/stdc++.h>

using namespace std ;

class Solution {
public:
    string reverseParentheses(string s) {
        int n = s.size(); 
        string ans = "" ; 
        stack<string> st ; 

        for( char ch : s ){
            if( ch == '(' ){
                st.push( ans )  ;
                ans = "" ; 
            }else if( ch == ')' ){
                reverse( ans.begin() , ans.end() ) ; 
                ans = st.top() + ans ;
                st.pop() ;  
            }else {
                ans += ch ; 
            }
        }
        return ans ; 
    }
};