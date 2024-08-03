class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";  
        char[] hexDigits = "0123456789abcdef".toCharArray();
        StringBuilder rs = new StringBuilder();
        while (num != 0) {
            int inter = num & 15; 
            rs.append(hexDigits[inter]);
            num >>>= 4; 
        }
        return rs.reverse().toString(); 
    }
}
