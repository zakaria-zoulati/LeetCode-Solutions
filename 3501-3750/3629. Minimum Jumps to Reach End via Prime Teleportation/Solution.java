class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length ; 
        int m = 1 ; 
        for( int i : nums ){
            m = Math.max( m , i ) ; 
        }
        int[] isPrime = new int[m+1] ; 
        for( int i=0 ; i<=m ; ++i ){
            isPrime[i] = i ; 
        }
        for( long i=2 ; i<m+1 ;++i ){
            if( isPrime[(int)i] == (int) i ){
                for( long j=i*i ; j<m+1 ; j += i ){
                    isPrime[(int)j] = (int) i ; 
                }
            }
        }
        Map<Integer,ArrayList<Integer>> map = new HashMap<>() ; 
        for( int i=0 ; i<n ; ++i ){
            int ele = nums[i] ; 
            while( isPrime[ele] != ele ){
                int p = isPrime[ele] ; 
                if( map.get(p) == null ){
                    map.put( p , new ArrayList<>() ) ; 
                }
                map.get(p).add( i ) ; 
                while( ele % p == 0 ){
                    ele /= p ; 
                }
            }
            if( ele > 1 ){
                int p = isPrime[ele] ; 
                if( map.get(p) == null ){
                    map.put( p , new ArrayList<>() ) ; 
                }
                map.get(p).add(i) ; 
            }
        }
        boolean[] used = new boolean[m+1] ; 
        boolean[] seen = new boolean[n] ; 
        Queue<Integer> q = new LinkedList<>() ; 
        q.add( 0 ) ; 
        int steps = 0 ; 
        seen[0] = true ; 
        while( !q.isEmpty() ){
            int len = q.size() ; 
            while( len-- > 0 ){
                int curr = q.poll() ; 
                if( curr == n-1 ){
                    return steps ; 
                }
                if( curr - 1 >= 0 && !seen[curr-1] ){
                    seen[curr-1] = true ;
                    q.add( curr-1 ) ;  
                }
                if( curr + 1 < n && !seen[curr+1] ){
                    seen[curr+1] = true ; 
                    q.add( curr+1 ) ; 
                }
                if( nums[curr] > 1 && isPrime[nums[curr]] == nums[curr] && !used[nums[curr]] ){
                    used[ nums[curr] ] = true ; 
                    for( int idx : map.get( nums[curr] ) ){
                        if( !seen[idx] ){
                            q.add(idx) ; 
                            seen[idx] = true ; 
                        }
                    }
                }
            }
            steps++ ; 
        }
        return -1 ; 
    }
}