class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int large = 0 ; 
        for( int num : candies ){
            if( large < num ) large = num ; 
        }
        List<Boolean> rs = new ArrayList<>() ; 
        for( int num : candies ){
            if( num + extraCandies >= large ){
                rs.add( true ) ; 
            }else  rs.add(false) ; 
        }
        return rs  ;
    }
}