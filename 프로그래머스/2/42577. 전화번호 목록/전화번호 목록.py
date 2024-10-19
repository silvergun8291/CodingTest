from collections import Counter

def solution(phone_book):
    book = list(Counter(sorted(phone_book)))
    
    for n1, n2 in zip(book, book[1:]):
        if n2.startswith(n1):
            return False
    
    return True
