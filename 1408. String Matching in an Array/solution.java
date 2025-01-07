class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length ; 
        Set<String> set = new HashSet<>() ; 
        for( int i=0 ; i<n ; ++i ){
            for( int j=i+1 ; j<n ; ++j ){
                if( words[i].indexOf( words[j] ) != -1 ){
                    set.add( words[j] ) ; 
                }
                else if( words[j].indexOf( words[i] ) != -1 ){
                    set.add( words[i] ) ; 
                }
            }  
        }
        return new ArrayList<>( set ) ;
    }
}