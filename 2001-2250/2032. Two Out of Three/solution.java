class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> list = new ArrayList<>() ; 
        int rs = 0  ;
        int freq1[] = new int[101] ; 
        int freq2[] = new int[101] ; 
        for(int num : nums1){
            freq1[num] = 1 ;
        }
        for(int num : nums2 ){
            if( freq1[num] == 1 && freq2[num] == 0  ){
                list.add( num ) ; 
            }
            freq2[num] = 1 ; 
        }
        for(int num : nums3){
            if( (freq1[num] + freq2[num]) == 1 ){
                freq1[num]++ ; 
                list.add( num ) ; 
            }
        }

        return list ; 

    }
}