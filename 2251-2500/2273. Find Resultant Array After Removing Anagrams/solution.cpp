class Solution {
    public:
        vector<string> removeAnagrams(vector<string>& words) {
            string prev_key = "" ; 
            vector<string> ans ; 
            for( string s : words ){
                vector<int> f(26,0);  
                for( char c : s ){
                    f[c-'a']++ ; 
                }
                string k = "" ; 
                for( int i=0 ; i<26 ; ++i ){
                    k += (char) ( f[i] + 'a' ) ; 
                    k += "-" ; 
                } 
                if( prev_key == k ){
                    // 
                }else {
                    ans.push_back(s); 
                    prev_key = k ; 
                }
            }
            return ans; 
        }
    };