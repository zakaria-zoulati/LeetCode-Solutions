class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length() ; 
        if( numFriends == 1 ){
            return word  ; 
        }
        PriorityQueue<String> pq = new PriorityQueue<>(
            (a,b) -> b.compareTo(a) 
        );
        int curr = word.charAt(0) - 'a' ; 
        for( int i=0 ; i<n ; ++i ){
            if( word.charAt(i) - 'a' < curr ) continue ; 
            pq.add( word.substring( i , Math.min( n , i+n-numFriends+1 ) )) ; 
        } 
        return pq.poll() ; 
    }
}