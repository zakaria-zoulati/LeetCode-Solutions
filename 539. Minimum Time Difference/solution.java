class Solution {
    public int getHours( String in ){
        return ( ( in.charAt(0) - '0')*10 + ( in.charAt(1) - '0')    )*60 + ( in.charAt(3) - '0')*10 + ( in.charAt(4) - '0') ; 
    }
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size() ; 
        int[] minutes = new int[n] ; 
        for(int i=0 ; i<n ; ++i){
            minutes[i] = getHours( timePoints.get(i) ) ; 
        }
        Arrays.sort(minutes) ; 
        int rs = Integer.MAX_VALUE ; 
        for(int i=1; i<n ; ++i){
            rs = Math.min( minutes[i] - minutes[i-1] , rs ) ; 
        }
        rs = Math.min( rs , 24*60+minutes[0] - minutes[n-1] ) ; 
        return rs ; 
    }
}