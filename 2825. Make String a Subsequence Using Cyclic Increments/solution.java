class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n = str1.length() ; 
        int m = str2.length() ; 
        if( n < m ) return false  ; 
        int[] arr = new int[m] ; 
        for( int i=0 ; i<m ; ++i ){
            arr[i] = str2.charAt(i) - 'a' ; 
        }
        int p = 0 ; 
        for( int i=0 ; i<n && p<m ; ++i ){
            int curr = str1.charAt(i) - 'a' ; 
            if( curr == arr[p] || (curr + 1)%26 == arr[p] ){
                ++p ; 
            }
        }
        return p==m ; 
    }
}