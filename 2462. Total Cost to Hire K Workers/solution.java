class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length ; 
        long rs = 0L ;
        if( n == k ){
            for( int i : costs ){
                rs += i ; 
            }
            return rs ; 
        } 
        PriorityQueue<Integer> front = new PriorityQueue<>() ; 
        PriorityQueue<Integer> last = new PriorityQueue<>() ; 
        int f = Math.min(candidates-1,n-1) ;
        for( int i=0 ; i<=f ; ++i ){
            front.add( costs[i] ) ; 
        } 
        int l = Math.max( f+1 , n-candidates ) ; 
        for( int i=l ; i<n ; ++i ){
            last.add( costs[i] ) ; 
        }
        for( int i=0 ; i<k ; ++i ){
            if( front.isEmpty() && last.isEmpty() ) break ; 
            if( front.isEmpty() ){
                rs += last.poll() ; 
            }else if( last.isEmpty() ){
                rs += front.poll() ; 
            }else {
                int a = front.poll() ; 
                int b = last.poll() ; 
                if( a <= b ){
                    rs += a ; 
                    last.add(b) ; 
                    if( f+1 < l ){
                        front.add( costs[++f] ) ; 
                    }
                }else {
                    rs += b ; 
                    front.add(a) ; 
                    if( f < l -1 ){
                        last.add( costs[--l] ) ; 
                    }
                }
            }
        }
        return rs ; 
    }
}