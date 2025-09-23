class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length() ; 
        int m = version2.length() ; 
        int i1 = 0 , i2 = 0 ;
        while( i1 < n || i2 < m ){
            int a = 0 , b = 0 ; 
            while( i1 < n ){
                if( version1.charAt(i1) == '.' ){
                    i1++ ; 
                    break ; 
                }
                a = a*10 + ( version1.charAt(i1) - '0') ; 
                i1++ ; 
            } 
            while( i2 < m ){
                if( version2.charAt(i2) == '.' ){
                    i2++ ; 
                    break ; 
                }
                b = b*10 + ( version2.charAt(i2) - '0') ; 
                i2++ ; 
            }
            if( a < b ) return -1 ; 
            else if( a > b ) return 1; 
        }  
        return 0 ; 
    }
}