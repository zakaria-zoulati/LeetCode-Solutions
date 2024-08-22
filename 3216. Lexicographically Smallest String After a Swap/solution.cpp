class Solution {
public:
    void swap( string &s , int i , int j ){
        char temp = s[i] ; 
        s[i] = s[j] ; 
        s[j] = temp ; 
    }
    string getSmallestString(string s) {
        bool flag = true ; 
        int n = s.length() ; 
        for(int i=0 ; i<n ; ++i){
            int a = s[i] - '0' ; 
            if( flag && i+1<n ){
                int b = s[i+1] - '0' ; 
                if( b<a && (a-b) %2==0 ){
                    swap(s,i,i+1) ; 
                    i++ ;
                    flag = false ; 
                    continue ; 
                }
            }
        }
        return s ; 
    }
};