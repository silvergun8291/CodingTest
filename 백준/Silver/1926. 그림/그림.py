"""
1. 아이디어
- 2중 for => 값 1 && 방문 X => BFS
- BFS 돌면서 그림 개수 +1, 최대값을 갱신

2. 시간복잡도
- BFS : O(V+E)
- V : 500 * 500
- E : 4 * 500 ** 500
- V+e : 5 * 250000 = 100만 < 2억 >> 가능!

3. 자료구조
- 그래프 전체 지도 : int[][]
- 방문 : bool[][]
- Queue(BFS)
"""

import sys
input = sys.stdin.readline

n, m = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
def bfs(y, x):
    img_size = 1
    q = [(y, x)]
    while q:
        ey, ex = q.pop()
        for k in range(4):
            ny = ey + dy[k]
            nx = ex + dx[k]

            if 0 <= ny < n and 0 <= nx < m:
                if map[ny][nx] == 1 and not visited[ny][nx]:
                    img_size += 1
                    visited[ny][nx] = True
                    q.append((ny, nx))

    return img_size

count = 0
max_size = 0
for j in range(n):
    for i in range(m):
        if map[j][i] == 1 and not visited[j][i]:
            visited[j][i] = True
            count += 1
            max_size = max(max_size, bfs(j, i))

print(count)
print(max_size)