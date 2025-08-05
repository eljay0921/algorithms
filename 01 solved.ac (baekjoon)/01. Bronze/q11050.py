"""백준 11050. 이항 계수 1"""
import sys

input = sys.stdin.readline

def solution():
    n, k = map(int, input().split())

    if n == k or k == 0 :
        sys.stdout.write(str(1))
        return
        
    dp = [1] * (n + 1)
    for i in range(2, n + 1) :
        dp[i] = dp[i - 1] * i

    result = dp[n] // (dp[k] * dp[n - k])
    sys.stdout.write(str(result))

if __name__ == "__main__" :
    solution()
