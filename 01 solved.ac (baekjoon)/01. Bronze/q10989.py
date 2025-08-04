"""백준 10989 수 정렬하기 3"""

import sys

count = int(sys.stdin.readline())
offset = 10001
nums = [0] * offset

for i in range(count) :
    num = int(sys.stdin.readline())
    nums[num] += 1

for i in range(offset) :
    if nums[i] > 0 :
        for _ in range(nums[i]) :
            sys.stdout.write(f"{i}\n")
