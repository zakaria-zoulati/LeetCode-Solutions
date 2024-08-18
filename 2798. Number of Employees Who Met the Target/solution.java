class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int rs = 0 ; 
        int n = hours.length ; 
        for(int i=0 ; i<n ; ++i){
            if( hours[i] >= target ) rs++ ;
        }
        return rs ; 
    }
}