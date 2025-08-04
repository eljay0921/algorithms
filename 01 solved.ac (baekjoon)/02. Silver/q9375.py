"""백준 9375. 패션왕 신해빈"""

import sys
from collections import defaultdict
from functools import reduce

input = sys.stdin.readline

def solution_v1():
    """v1"""
    case_count = int(input().strip())

    for _ in range(case_count) :
        cloth_count = int(input().strip())
        cloth_dict = defaultdict(int)
        
        for _ in range(cloth_count) :
            name, kind = input().strip().split()
            cloth_dict[kind] += 1

        result_count = 1
        for count in cloth_dict.values() :
            result_count *= (count + 1)

        result_count -= 1

        sys.stdout.write(str(result_count) + "\n")

def solution_v2():
    """v2"""
    case_count = int(input().strip())

    for _ in range(case_count) :
        cloth_count = int(input().strip())
        cloth_dict = defaultdict(int)
        
        for _ in range(cloth_count) :
            name, kind = input().strip().split()
            cloth_dict[kind] += 1

        result_count = reduce(lambda acc, num: acc * (num + 1), cloth_dict.values(), 1) - 1
        sys.stdout.write(str(result_count) + "\n")

if __name__ == "__main__":
    solution_v2()
