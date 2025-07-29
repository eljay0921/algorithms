"""백준 9095. 1, 2, 3 더하기"""

def backTrack(target, current) :
    """back tracking for target"""
    if current == target : return 1
    if current > target : return 0

    temp_count = 0
    for i in range(1, 4) :
        temp_count += backTrack(target, current + i)

    return temp_count


numbers = int(input())

for _ in range(numbers) :
    num = int(input())
    total = backTrack(num, 0)
    print(total)
