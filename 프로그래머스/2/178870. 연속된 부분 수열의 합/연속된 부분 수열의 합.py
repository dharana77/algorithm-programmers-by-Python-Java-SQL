def solution(sequence, k):
    n = len(sequence)

    mx_sum = 0
    interval = n
    end = 0
    res = []
    
    for start in range(n):
        while mx_sum < k and end < n:
            mx_sum += sequence[end]
            end += 1
        if interval > (end -1 - start) and mx_sum == k:
            interval = end-1 - start
            res = [start, end-1]   
        mx_sum -= sequence[start]
    return res