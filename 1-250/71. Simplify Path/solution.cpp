#include <bits/stdc++.h>/

using namespace std; 

class Solution {
public:
    string simplifyPath(string path) {
        int n = path.size(); 
        stack<string> st ; 
        string res = "" ; 
        
        for( int i=1 ; i<n ; ){
            string currFile = "" ; 
            while( i<n && path[i] != '/' ){
                currFile += path[i] ; 
                ++i ;
            }

            if( currFile == "." ) continue ; 

            if( currFile == ".." ){
                if( !st.empty() ) st.pop() ; 
                continue ; 
            }

            if( !currFile.empty() ) st.push( currFile ) ; 
            i++ ; 
        }

        while( !st.empty() ){
            string file = st.top() ; 
            st.pop() ; 
            reverse( begin(file) , end(file) ) ; 
            res += ( file + '/' ) ; 
        }
        if( res.empty() ) return "/" ; 
        reverse( begin(res) , end(res) ) ; 
        return res; 
    }
};