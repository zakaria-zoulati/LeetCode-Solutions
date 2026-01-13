class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] complex1 = parseComplex(num1);
        int[] complex2 = parseComplex(num2);
        int a = complex1[0]; 
        int b = complex1[1];
        int c = complex2[0]; 
        int d = complex2[1]; 
        int realPart = a * c - b * d;
        int imaginaryPart = a * d + b * c;
        return realPart + "+" + imaginaryPart + "i";
    }
    public int[] parseComplex(String num) {
        int plusIndex = num.indexOf('+');
        int realPart = Integer.parseInt(num.substring(0, plusIndex));
        int imaginaryPart = Integer.parseInt(num.substring(plusIndex + 1, num.length() - 1));
        return new int[]{realPart, imaginaryPart};
    }
}
