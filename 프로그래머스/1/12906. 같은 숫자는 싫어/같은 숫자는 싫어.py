import collections

def solution(arr):
    prev = None
    result = []
    
    for n in arr:
        if n == prev:
            continue
        else:
            result.append(n)
        
        prev = n
    
    return result