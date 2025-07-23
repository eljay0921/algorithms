"""백준 15666"""
import sys

def dfs(start, depth):
    """backtracking 대신 dfs로 풀이"""

    if (depth == size):
        print(' '.join(map(str, path)))
        return
    
    for i in range(start, len(nums)):
        path.append(nums[i])
        dfs(i, depth + 1)
        path.pop()

count, size = map(int, sys.stdin.readline().split())
nums = sorted(set(map(int, sys.stdin.readline().split())))      # sorted 정렬, set 중복 제거
path = []

dfs(0, 0)
