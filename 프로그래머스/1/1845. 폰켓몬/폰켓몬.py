from collections import Counter

def solution(nums: list):
    max_length = len(nums) // 2
    answer: int = 0
    pokemon = Counter(nums)
    key_length = len(pokemon.keys())
    answer = max_length if max_length < key_length else key_length
    
    return answer