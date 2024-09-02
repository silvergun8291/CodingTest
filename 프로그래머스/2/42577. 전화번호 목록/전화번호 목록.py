from collections import Counter

def solution(phone_book):
    counter = Counter(phone_book)

    for phone_number in phone_book:
        target = ""
        
        for number in phone_number:
            target += number
            
            if target in counter and target != phone_number:
                return False
    
    return True