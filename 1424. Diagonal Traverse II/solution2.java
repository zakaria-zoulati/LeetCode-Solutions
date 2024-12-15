class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<int[]> elements = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                elements.add(new int[]{i + j ,i});
            }
        }
        elements.sort((a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0] ) ;
        int len = elements.size() ; 
        int[] rs = new int[len];
        int in = 0; 
        for (int[] i : elements ) {
            rs[in++] = nums.get( i[1] ).get( i[0] - i[1] ) ; 
        }
        return rs;
    }
}
