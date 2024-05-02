from collections import defaultdict


def solution(targets):
    answer = 0
    targets = sorted(targets, key= lambda x : x[1])
    # print(targets)
    
    e = 0
    for i in targets:
        if e <= i[0]:
            answer += 1
            e = i[1]
            
    return answer