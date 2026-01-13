class Solution {
    public int minChanges(String s) {
        int n = s.length() ; 
        boolean f1 = false ; // 0
        boolean f2 = false ; // 1
        int co = 0 ; 
        int rs = 0 ; 
        for( int i=0 ; i<n ; ++i ){
            if( s.charAt(i) == '0' ){
                co = 1 ; 
                while( i+1<n && s.charAt(i+1) == '0' ){
                    ++i ; 
                    ++co ; 
                }
                if( co % 2 == 1 ){
                    if( f2 ){
                        f2 = false ; 
                        ++rs ; 
                    }else {
                        f1 = true ; 
                    }
                }else {
                    if( f2 ){
                        f2 = false ; 
                        ++rs ; 
                        f1 = true ; 
                    }
                }
            }else {
                co = 1 ;
                while( i+1<n && s.charAt(i+1) == '1' ){
                    ++i ; 
                    ++co ; 
                }
                if( co % 2 == 1 ){
                    if( f1 ){
                        f1 = false ; 
                        ++rs ; 
                    }else {
                        f2 = true ; 
                    }
                }else {
                    if( f1 ){
                        f1 = false ; 
                        ++rs ; 
                        f2 = true ; 
                    }
                }    
            }
        }
        return rs ; 
    }
}