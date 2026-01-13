class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length() ; 
        int r = 0 ; 
        int l = 0 ;  
        for(int i=0 ; i<n ; ++i){
            if( target.charAt(i) == 'L' ){
                if( r>0 ) return false ; 
                ++l ; 
            }
            if( start.charAt(i) == 'R' ){
                if( l>0 ) return false ;  
                ++r ; 
            }else if( start.charAt(i) == 'L' ){
                if( l>0 ) --l ; 
                else return false ; 
            }
            if( target.charAt(i) == 'R' ){
                if( r>0 ) --r ; 
                else return false ; 
            }
        }
        return l==0 && r==0 ; 
    }
}