package main

import "fmt"

func calculate(num float64) float64 {
	return (2*num*num + 4*num + 1) / (num*num + 3*num + 3)
}

func getLimit(first float64) interface{} {
	if first > -(4/3) && first < -1 {
		return -1
	} else {
		return 1
	}
}

func getNumAtIndex(a1 float64, index int) float64 {
	currentNumAtIndex := a1

	for i := 2; i <= index; i++ {
		currentNumAtIndex = calculate(currentNumAtIndex)
	}

	return currentNumAtIndex
}

func main() {
	fmt.Println("F(x) = (2x^2 + 4x + 1) / (x^2 + 3x + 3)")
	fmt.Print("a1: ")

	var num float64
	_, err := fmt.Scanf("%f", &num)
	if err != nil {
		fmt.Println(err)
	}
	fmt.Println("Limit: ", getLimit(num))

	var j int
	for j < 5 {
		fmt.Print("Element at index: ")

		var i int
		fmt.Scan(&i)

		fmt.Println(getNumAtIndex(num, i))
		j++
	}

	fmt.Print("Write something and then press enter to exit the program: ")

	var s string
	fmt.Scan(&s)
}
