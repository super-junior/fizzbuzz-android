package com.example.fizzbuzz

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class FizzBuzzTest(val n: Int, val expected: String) {

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Collection<Array<Any>> {
            return listOf(
                arrayOf(1, "1"),
                arrayOf(3, "Fizz"),
                arrayOf(5, "Buzz"),
                arrayOf(6, "Fizz"),
                arrayOf(7, "7"),
                arrayOf(10, "Buzz"),
                arrayOf(15, "FizzBuzz"),
                arrayOf(30, "FizzBuzz")
            )
        }
    }

    @Test
    fun check() {
        assertThat(FizzBuzz.check(n), equalTo(expected))
    }

    @Test
    fun checkWithIf() {
        assertThat(FizzBuzz.checkWithIf(n), equalTo(expected))
    }

}
