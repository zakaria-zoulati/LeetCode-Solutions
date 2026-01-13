class Solution:
    def processQueries(
        self, c: int, connections: List[List[int]], queries: List[List[int]]
    ) -> List[int]:
        def dfs(node, edges, seen, rep, curr):
            seen[node] = True
            rep[node] = curr
            for v in edges[node]:
                if not seen[v]:
                    dfs(v, edges, seen, rep, curr)

        def helper(r, ptrs, els, online):
            while ptrs[r] < len(els) and not online[els[ptrs[r]]]:
                ptrs[r] += 1
            if ptrs[r] == len(els):
                return -1
            return els[ptrs[r]] + 1

        n = len(connections)
        q = len(queries)

        online = [True] * c
        rep = [0] * c

        edges = [[] for i in range(c)]
        for co in connections:
            u = co[0] - 1
            v = co[1] - 1
            edges[u].append(v)
            edges[v].append(u)

        curr = 0
        seen = [False] * c
        for i in range(c):
            if not seen[i]:
                dfs(i, edges, seen, rep, curr)
                curr += 1

        batches = [[] for i in range(curr)]
        for i in range(c):
            batches[rep[i]].append(i)

        ptrs = [0] * curr
        ans = []
        for q in queries:
            x = q[1] - 1
            if q[0] == 1:
                if online[x]:
                    ans.append(x + 1)
                else:
                    ans.append(helper(rep[x], ptrs, batches[rep[x]], online))
            else:
                online[x] = False

        return ans
