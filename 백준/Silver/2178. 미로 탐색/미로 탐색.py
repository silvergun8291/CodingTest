""""
1. 아이디어
- 2중 for => 값 1 && 방문 X => BFS
- 다음 칸으로 이동하면 해당 칸의 값을 이전 칸 + 1로 초기화하여 최단 거리 측정

2. 시간복잡도
- BFS : O(V+E)

3. 자료구조
- 미로 전체 지도 : int[][]
- 방문 : bool[][]
- Queue(BFS)
"""

import sys
# input = sys.stdin.readline

n, m = map(int, input().split())
maze = [list(map(int, input())) for _ in range(n)]
visited = [[False] * m for _ in range(n)]

def bfs(ey, ex):
    dy = [0, 1, 0, -1]
    dx = [1, 0, -1, 0]

    queue = [(ey, ex)]

    while queue:
        y, x = queue.pop(0)
        visited[y][x] = True

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < m:
                if maze[ny][nx] == 1 and not visited[ny][nx]:
                    queue.append((ny, nx))
                    maze[ny][nx] = maze[y][x] + 1

bfs(0, 0)

print(maze[n-1][m-1])
