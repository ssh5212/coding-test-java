import sys
sys.setrecursionlimit(10**9)
input = sys.stdin.readline

global n, arr, dp


def recursive(cur):
    global n, arr, dp

    if cur > n:
        return -10000000
    if cur == n:
        return 0

    if dp[cur] != -1:
        return dp[cur]

    dp[cur] = max(recursive(cur + arr[cur][0]) + arr[cur][1], recursive(cur + 1))
    return dp[cur]


def main():
    global n, arr, dp
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))

    dp = [-1] * n

    answer = recursive(0)
    print(answer)


main()