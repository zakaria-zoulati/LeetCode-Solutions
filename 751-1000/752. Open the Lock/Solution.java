class Solution {
    int getNum( String s ){
        int ans = 0 ;
        int curr = 1_000 ; 
        for( int i=0 ; i<4 ; ++i ){
            ans += ( s.charAt(i) - '0' )*curr ; 
            curr /= 10 ; 
        }
        return ans ; 
    }
    public int openLock(String[] deadends, String target) {
        boolean[] seen = new boolean[1_0000] ; 
        for( String d : deadends ){
            seen[ getNum( d ) ] = true ; 
        }
        if( seen[0] ) return -1 ; 
        int val = getNum( target ) ; 
        Queue<Integer> q = new LinkedList<>() ; 
        q.add( 0 ) ; 
        int ops = 0 ; 
        while( !q.isEmpty() ){
            int len = q.size() ; 
            while( len-- > 0 ){
                int curr = q.poll() ; 
                if( curr == val ) return ops ; 
                if( seen[curr] ) continue ;
                seen[curr] = true ; 
                int f = 1 ; 
                int base = curr ; 
                for( int i=0 ; i<4 ; ++i ){
                    int d = base % 10 ; 
                    base /= 10 ; 
                    int x = curr - d*f + (( d + 1 )%10)*f ; 
                    if( !seen[x] ){
                        q.add(x) ; 
                    }   
                    int y = curr - d*f + (( d + 9 )%10)*f ; 
                    if( !seen[y] ){
                        q.add(y) ; 
                    }
                    f *= 10 ; 
                }
            }
            ops++ ; 
        }
        return -1 ; 
    }
}