import itertools

def solution(numbers, target):
    signs = [[num, -num] for num in numbers]
    combinations = list(map(sum, itertools.product(*signs)))

    return combinations.count(target)