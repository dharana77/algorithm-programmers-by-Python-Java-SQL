fun main(args: Array<String>) {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val arr = readln().split(" ").map { it.toInt() }

    var sum = 0
    var start = 0
    var end = 0
    var min = Int.MAX_VALUE
    while(end <= n) {
        if (sum >= s) {
            min = minOf(min, end - start)
            sum -= arr[start]
            start += 1
        }else{
            if(end == n) break
            sum += arr[end]
            end += 1
        }
    }
    if (min == Int.MAX_VALUE) min = 0
    println(min)
}