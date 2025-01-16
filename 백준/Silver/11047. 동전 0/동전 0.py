# N과 K를 입력 받는다.
N, K = map(int, input().split())
coins = []

for i in range(N):
    coins.append(int(input()))

coins = sorted(coins, reverse=True)
count = 0

for coin in coins:
    if coin <= K:
        div = K // coin
        K = K - div * coin
        count += div

print(count)