class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>() ; 
        StringBuilder sb = new StringBuilder() ; 
        for( int i=0 ; i<target.length() ; ++i ){
            char c = target.charAt(i)  ; 
            sb.append( "a" ) ; 
            ans.add( sb.toString() ) ; 
            for( char j='b' ; j<=c ; ++j ){
                sb.setCharAt(i,j) ; 
                ans.add( sb.toString() ) ;
            }    
        }
        return ans ; 
    }
}