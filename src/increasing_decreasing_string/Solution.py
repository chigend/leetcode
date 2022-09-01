class Solution(object):
    def sortString(self, s):
        alphabet = [0] * 26
        total = len(s)
        for i in range(total): alphabet[ord(s[i]) - 97] += 1
        res = ""
        while total > 0:
            for i in range(26):
                if alphabet[i] > 0:
                    alphabet[i] -= 1
                    res += chr(97 + i)
                    total -= 1
            for i in range(26):
                j = 25 - i
                if alphabet[j] > 0:
                    alphabet[j] -= 1
                    res += chr(97 + j)
                    total -= 1
        return res


if __name__ == '__main__':
    s = Solution()
    res = s.sortString('aaaabbbbcccc')
    print(res)
