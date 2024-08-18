class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]); 
        int rs = 0;
        for (int[] boxType : boxTypes) {
            int boxes = boxType[0];
            int units = boxType[1];
            int inter = Math.min(boxes, truckSize);
            rs += inter * units;
            truckSize -= inter;

            if (truckSize == 0) {
                break; 
            }
        }
        return rs;
    }
}
