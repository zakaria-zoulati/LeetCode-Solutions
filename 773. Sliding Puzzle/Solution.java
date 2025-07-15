class Solution {
    public int slidingPuzzle(int[][] board) {
        boolean[] seen = new boolean[ 543_211 ] ; 
        int[] powers = new int[6] ; 
        powers[0]=1 ; 
        for(int i=1 ; i<6 ; ++i){
            powers[i] = 10*powers[i-1] ; 
        }
        int start = 0; 
        for( int i=0 ; i<6 ; ++i ){
            start += board[i/3][i%3]*powers[5-i] ; 
        }
        Queue< Integer > q = new ArrayDeque<>() ; 
        q.add( start ) ; 
        seen[start] = true ; 
        int round = 0  ; 
        while( !q.isEmpty() ){
            int len = q.size() ; 
            while( len-- > 0 ){
                int curr = q.poll() ;
                if( curr == 123450 ){
                    return round ; 
                }
                int[] coeffs = new int[6]  ; 
                int pos = 0 ; 
                int copy = curr ; 
                for( int i=5 ; i>=0 ; --i ){
                    int ai = copy/powers[i] ; 
                    coeffs[i] = ai ; 
                    if( ai == 0 ) {
                        pos = i ; 
                    }
                    copy -= ai*powers[i] ; 
                }
                if( pos >= 3 ){
                    int next = curr + coeffs[pos-3]*(powers[pos] - powers[pos-3] ) ; 
                    if( !seen[next] ){
                        q.add(next) ;
                        seen[next] = true ;  
                    }
                }else {
                    int next = curr + coeffs[pos+3]*(powers[pos] - powers[pos+3] ) ; 
                    if( !seen[next] ){
                        q.add(next) ;
                        seen[next] = true ;  
                    }
                }
                if( pos % 3 != 0 ){
                    int next = curr + coeffs[pos-1]*9*powers[pos-1] ; 
                    if( !seen[next] ){
                        q.add(next) ; 
                        seen[next] = true ; 
                    }
                }
                if( (pos+1) % 3 != 0 ){
                    int next = curr + coeffs[pos+1]*( powers[pos] - powers[pos+1] ) ; 
                    if( !seen[next] ){
                        q.add(next) ; 
                        seen[next] = true ; 
                    }
                }
            }
            round++ ; 
        } 
        return -1 ; 
    }
}