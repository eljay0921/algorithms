"""백준 2467"""

def main() :
    """백준 2467 풀이"""
    count = int(input())
    nums = list(map(int, (input().split())))

    left = 0
    right = count - 1
    result = (0, 0)
    min_sum = float('inf')

    while left < right :
        cur_sum = nums[left] + nums[right]

        if abs(cur_sum) < min_sum :
            result = (nums[left], nums[right])
            min_sum = abs(cur_sum)
            if min_sum == 0 :
                break

        if cur_sum < 0 :
            left += 1
        else :
            right -= 1

    print(*result)

if __name__ == "__main__" :
    main()
