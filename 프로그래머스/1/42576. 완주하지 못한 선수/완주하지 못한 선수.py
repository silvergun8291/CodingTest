from collections import Counter

def solution(participant, completion):
    p = Counter(participant)
    s = Counter(completion)
    
    return list(p-s)[0]