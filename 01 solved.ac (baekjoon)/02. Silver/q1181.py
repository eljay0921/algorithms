"""백준 1181. 단어 정렬"""

import sys

input = sys.stdin.readline

def solution() :
    count = int(input())

    words = {input().strip() for _ in range(count)} # set comprehension : 중복을 제거함
    words_sorted = sorted(words, key= lambda x: (len(x), x))
    sys.stdout.write("\n".join(words_sorted) + "\n")

if __name__ == "__main__" :
    solution()
