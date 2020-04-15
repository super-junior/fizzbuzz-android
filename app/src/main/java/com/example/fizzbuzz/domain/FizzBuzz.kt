package com.example.fizzbuzz.domain

object FizzBuzz {

    fun check(n: Int): String {
        val isMultipleOf3 = n % 3 == 0
        val isMultipleOf5 = n % 5 == 0

        return when {
            isMultipleOf3 && isMultipleOf5 -> "FizzBuzz"
            isMultipleOf3 -> "Fizz"
            isMultipleOf5 -> "Buzz"
            else -> n.toString()
        }
    }

    fun checkWithIf(n: Int): String {
        val isMultipleOf3 = n % 3 == 0
        val isMultipleOf5 = n % 5 == 0

        if (isMultipleOf3 || isMultipleOf5) {
            val fizz = if (isMultipleOf3) "Fizz" else ""
            val buzz = if (isMultipleOf5) "Buzz" else ""
            return "$fizz$buzz"
        }

        return n.toString()
    }

}
