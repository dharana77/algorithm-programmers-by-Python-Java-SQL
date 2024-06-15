n=int(input())
data=[list(input()) for _ in range(n)]
answer=0

# 테이블 전부 체크해주는 함수
def count(arr):
  n=len(arr)
  answer=1

  for i in range(n):
    # 가로줄 순회, 연속되는 수 세기
    cnt=1
    for j in range(1,n):
    # 이전과 같다면 +1
      if arr[i][j]==arr[i][j-1]:
        cnt+=1
     #다르면 다시 1로 초기화
      else:
        cnt=1
	#현재 cnt가 더 크면 갱신
      if cnt>answer:
        answer=cnt
     
    #세로줄 순회, 연속 되는 수 세기
    cnt=1
    for j in range(1,n):
      if arr[j][i]==arr[j-1][i]:
        cnt+=1
      else:
        cnt=1
      if cnt>answer:
        answer=cnt

  return answer

for i in range(n):
  for j in range(n):
  #가로줄 바꾸기
    if j+1<n:
    #인접한 것과 바꿈
      data[i][j], data[i][j+1]=data[i][j+1], data[i][j]
      #바꿨을때 가장 긴 연속 부분 체크
      tmp=count(data)
      if tmp>answer:
        answer=tmp
      #바꿨던것 다시 원래대로
      data[i][j], data[i][j+1]=data[i][j+1], data[i][j]
      
	#세로줄 바꾸기
    if i+1<n:
      data[i][j], data[i+1][j]=data[i+1][j], data[i][j]
      tmp=count(data)
      if tmp>answer: 
        answer=tmp

      data[i][j], data[i+1][j]=data[i+1][j], data[i][j]

print(answer)