class OrderedStream:

    pr = 1
    values=[]
    def __init__(self, n: int):
        self.values = [None] * (n + 1)



    def insert(self, idKey: int, value: str) -> List[str]:
        self.values[idKey] = value
        length = len(self.values)
        res = []
        while self.pr < length and self.values[self.pr]:
            res.append(self.values[self.pr])
            self.pr += 1
        return res
