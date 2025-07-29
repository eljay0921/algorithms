"""백준 9095. 1, 2, 3 더하기"""

dp = [0] * 11   # 1 <= n <= 10
dp[1] = 1
dp[2] = 2
dp[3] = 4

numbers = int(input())
for _ in range(0, numbers) :

    target = int(input())
    for i in range(4, target + 1) :
        if (dp[i] == 0) :
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    
    print(dp[target])
