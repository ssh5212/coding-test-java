def recursive(x, y, now):
    global ans
    ans = max(ans, now)

    for d in range(len(dx)):
        nx = dx[d] + x
        ny = dy[d] + y

        if nx < 0 or nx >= r or ny < 0 or ny >= c:
            continue
        elif have[ord(arr[nx][ny]) - 65] == True:
            continue
        # elif arr[nx][ny] in v:
        #     continue
        else:
            # visited[nx][ny] = True
            have[ord(arr[nx][ny]) - 65] = True
            # v.append(arr[nx][ny])
            recursive(nx, ny, now + 1)
            have[ord(arr[nx][ny]) - 65] = False
            # v.remove(arr[nx][ny])
            # visited[ny][ny] = False


r, c = map(int, input().split())

arr = []

for _ in range(r):
    arr.append(list(map(str, input().strip())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# visited = [[False] * c for i in range(r)]
# print(visited)
have = [False] * 26
# v = []
ans = 0
# v.append(arr[0][0])
have[ord(arr[0][0]) - 65] = True
# visited[0][0] = True
recursive(0, 0, 1)
print(ans)