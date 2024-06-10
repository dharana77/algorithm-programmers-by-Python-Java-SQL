package main

import "fmt"

func main() {
	var input_first int
	var input_second int
	fmt.Scanln(&input_first)
	fmt.Scanln(&input_second)
	var to_sum_first, to_sum_second, to_sum_third int
	to_sum_first = input_first * (input_second % 10)
	var to_div int
	to_div = input_second/10
	
	to_sum_second = input_first * (to_div % 10)
	to_sum_third = input_first * (input_second / 100)
	fmt.Println(to_sum_first)
	fmt.Println(to_sum_second)
	fmt.Println(to_sum_third)
	fmt.Println(to_sum_first + to_sum_second * 10 + to_sum_third * 100)

}