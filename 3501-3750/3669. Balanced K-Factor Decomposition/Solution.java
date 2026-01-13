class Solution {
    int[] rs ;
    int n ; 
    int k ; 
    int diff = Integer.MAX_VALUE ;  
    void dfs( int in , int curr ,  List<Integer> divs , List<Integer> path ){
        if( path.size() > k ) return ; 
        if( path.get( path.size() - 1 ) - path.get(0) >= diff ) return ; 
        if( in == divs.size() ){
            if( curr != n ) return ; 
            if( path.size() != k ) return ; 
            diff = path.get(k-1) - path.get(0) ; 
            for( int i=0 ; i<k ; ++i ){
                rs[i] = path.get(i) ; 
            }
            return ; 
        }
        if( n % ( curr *divs.get(in) ) == 0 ){
            path.add( divs.get(in) ) ; 
            dfs( in , curr*divs.get(in) , divs , path ) ;
            path.removeLast() ;
        }
        dfs( in+1 , curr , divs , path ) ; 
    }
    public int[] minDifference(int n, int k) {
        this.n = n ; 
        this.k = k ; 
        this.rs = new int[k] ; 
        List<Integer> divisors = new ArrayList<>();
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                divisors.add(i) ; 
                if( i != n/i ){
                    divisors.add(n/i) ; 
                }
            }
        }
        divisors.add(1) ; 
        Collections.sort( divisors ) ; 
        List<Integer> path = new ArrayList<>() ; 
        for( int i=0 ; i<divisors.size() ; ++i ){    
            path.add( divisors.get(i) ) ; 
            dfs( i , divisors.get(i) , divisors , path ) ; 
            path.removeLast() ; 
        }
        return rs ; 
    }
}