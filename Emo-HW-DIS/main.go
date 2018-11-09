package main

import "fmt"

func calculate(num float64) float64 {
	return (3*num*num - 24*num + 72) / num
}

func getLimit(first float64) interface{} {
	if first == 0 {
		return "an cannot be 0"
	} else if first < 0 {
		return "negative infinity"
	} else if first > 0 && first < 4 {
		return "positive infinity"
	} else if first >= 4 && first <= 6 {
		return 6
	} else {
		return "positive infinity"
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
	fmt.Println("F(x) = (3x^2 - 24x + 72)/x")
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
		_, err := fmt.Scanf("%d", &i)
		if err != nil {
			continue
		}

		fmt.Println(getNumAtIndex(num, i))
		j++
	}
}
