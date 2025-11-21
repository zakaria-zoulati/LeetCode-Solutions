class Solution:
    def largestInteger(self, num: int) -> int:
        pairs = []
        impairs = []
        original = str(num)
        while num > 0:
            digit = num % 10
            if digit % 2 == 0:
                pairs.append(digit)
            else:
                impairs.append(digit)
            num //= 10
        pairs.sort()
        impairs.sort()
        ans = ""
        for i in range(len(original)):
            if int(original[i]) % 2 == 0:
                ans += str(pairs.pop())
            else:
                ans += str(impairs.pop())
        return int(ans)
