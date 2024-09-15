class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length() ; 
        int rs = 0 ; 
        int curr = 0 ; 
        HashMap<Integer, Integer > map = new HashMap<>() ; 
        for(int i=0 ; i<n ; ++i){
            char c = s.charAt(i) ; 
            if( c == 'a' ){
                curr ^= 1 << 0 ; 
            }
            else if( c == 'e' ){
                curr ^= 1 << 1 ; 
            }
            else if( c == 'u' ){
                curr ^= 1 << 2 ; 
            }
            else if( c == 'i' ){
                curr ^= 1 << 3 ; 
            }
            else if( c == 'o' ){
                curr ^= 1 << 4 ; 
            }

            if( curr == 0 ){
                rs = i+1  ;
            }
            else if( map.get( curr ) != null  ){
                rs = Math.max( rs , i - map.get(curr)  ) ; 
            }else {
                map.put( curr , i ) ; 
            }
        }


        return rs ; 
        
    }
}