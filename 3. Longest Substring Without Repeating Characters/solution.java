class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length()  ;
        int rs = 0 ;
        int first = 0 ; 
        HashMap< Character , Integer> map = new HashMap<>() ; 
        for(int i = 0 ; i<n ; ++i){
            char c = s.charAt(i) ; 
            if( map.containsKey( c ) ){
                first = Math.max(  map.get(c) +1 , first  ) ; 
            }
            map.put( c, i ) ; 
            rs = Math.max( rs , i - first +1 ) ; 
        }
        
        return rs ; 
    }
}