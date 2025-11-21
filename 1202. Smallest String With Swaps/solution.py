from typing import List

class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        def find(rep, a):
            if rep[a] != a:
                rep[a] = find(rep, rep[a])
            return rep[a]

        def unite(rep, a, b):
            r1 = find(rep, a)
            r2 = find(rep, b)
            rep[r1] = r2

        n = len(s)
        rep = list(range(n))

        for a, b in pairs:
            unite(rep, a, b)

        m = {}
        for i in range(n):
            root = find(rep, i)
            m.setdefault(root, []).append(s[i])

        for lst in m.values():
            lst.sort(reverse=True)

        ans = []
        for i in range(n):
            root = find(rep, i)
            ans.append(m[root].pop())

        return "".join(ans)
