class Solution:
    def countAndSay(self, n: int) -> str:
        def rle(n: int) -> str:
            if n == 1:
                return "1"
            seq = rle(n - 1)
            res = []
            l = len(seq)
            i = 0
            while i < l:
                count = 0
                j = i
                while j < l and seq[j] == seq[i]:
                    j += 1
                    count += 1
                res.append(str(count))
                res.append(str(seq[i]))
                i = j
            return "".join(res)

        return rle(n)
