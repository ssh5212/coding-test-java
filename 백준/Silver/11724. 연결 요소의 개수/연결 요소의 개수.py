def dfs(cnt):
    visited[cnt] = True
    for numb in graph[cnt]:
        if visited[numb] == False:
            dfs(numb)


n, m = map(int, input().split()) # n : 정점의 개수, m : 간선의 개수

graph = [[] for i in range(n + 1)]
visited = [False] * (n + 1)
for _ in range(m):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

ans = 0

for i in range(1, len(graph)):
    if visited[i] == False:
        dfs(i)
        ans += 1

print(ans)