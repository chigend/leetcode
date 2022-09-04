class Solution(object):
    def validPath(self, n, edges, source, destination):
        root = [i for i in range(n)]
        self.root = root
        for edge in edges: self.union(edge[0], edge[1])
        return self.find(source) == self.find(destination)

    def union(self, p, q):
        self.root[self.find(p)] = self.find(q)

    def find(self, x):
        root = self.root
        while x != root[x]:
            t = root[x]
            root[x] = root[root[x]]
            x = t
        return x