class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<>() ;
        for(int i=1 ; i<=1000 ; ++i){
            int left =1 ;
            int right = 1000 ; 
            while( left <= right ){
                int mid = left + (right-left)/2 ; 
                if( customfunction.f(i,mid) < z ){
                    left = mid+1 ; 
                }else if( customfunction.f(i,mid)>z ){
                    right = mid-1 ;
                }else {
                    List<Integer> inter = new ArrayList<>() ; 
                    inter.add( i ) ; 
                    inter.add( mid ) ; 
                    list.add(inter) ; 
                    break ;
                }
            }
        }
        return list ; 
    }
}