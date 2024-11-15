s = input()
t = input()

target = len(s) * len(t)
s_loop = target // len(s)
t_loop = target // len(t)

if s * s_loop == t * t_loop:
    print(1)
else:
    print(0)
