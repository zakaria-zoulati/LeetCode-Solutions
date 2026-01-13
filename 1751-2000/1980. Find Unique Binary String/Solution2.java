class Solution {
    public void fill( char[] chars , int num ){
        int n = chars.length ; 
        int idx = n-1 ; 
        while( num > 0 ){
            chars[idx--] = (char) ('0' + (num%2) ) ; 
            num >>= 1 ;
        }
        while( idx >= 0 ){
            chars[idx--] = '0' ; 
        }
    }
    public boolean check( char[] chars , String s ){
        int n = s.length() ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) != chars[i] ){
                return false ; 
            }
        }
        return true ; 
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length ; 
        char[] chars = new char[n] ; 
        for( int i=0 ; i<=n ; ++i ){
            fill( chars , i ) ; 
            boolean flag = true ; 
            for( int j=0 ;j<n ; ++j ){
                if( check( chars , nums[j] ) ){
                    flag = false ; 
                    break ; 
                }
            } 
            if( flag ){
                return new String(chars) ; 
            }
        }    
        return "-1" ; 
    }
}