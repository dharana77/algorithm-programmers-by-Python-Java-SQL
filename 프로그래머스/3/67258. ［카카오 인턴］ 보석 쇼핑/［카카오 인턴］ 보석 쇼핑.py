#2:12
from collections import defaultdict

def solution(gems):
    answer = []
    unique = set()
    unique_count = []
    for g in gems:
        unique.add(g)
        unique_count.append(len(unique))
    mx = max(unique_count)
    mx_idx = -1
    mn = 1e5
    temp_count = set()
    i =0
    j =1
    kind_dict = {gems[0]: 1}
    print(mx)
    while i < len(gems) and j <len(gems):
        if len(kind_dict) == mx:
            if (j-i)<mn and (j-i)>0:
                mn = j-i
                answer = [i+1,j]
            kind_dict[gems[i]] = kind_dict.get(gems[i],0) - 1
            if kind_dict[gems[i]]==0:
                del kind_dict[gems[i]]
            i+=1
        else:
            kind_dict[gems[j]] = kind_dict.get(gems[j],0) + 1
            j+=1
            

    if len(kind_dict) == mx:
        if (j-i)<mn and (j-i)>=0:
            mn = j-i
            answer = [i+1,j]
    
    while i < len(gems):
        if len(kind_dict)==mx:
            if(j-i)<mn:
                answer = [i+1, j]
        kind_dict[gems[i]]-=1
        if kind_dict[gems[i]]==0:
            del kind_dict[gems[i]]
        i+=1
                
    return answer