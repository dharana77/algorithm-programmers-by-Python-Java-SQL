while 1:
    try:
        n = int(input())
    except:
        break

    num = 1

    while 1:
        if num % n == 0:
            print(len(str(num)))
            break
        num = num * 10 + 1