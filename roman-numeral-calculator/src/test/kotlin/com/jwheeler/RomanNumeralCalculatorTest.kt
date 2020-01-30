package com.jwheeler

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RomanNumeralCalculatorTest {

    @Test
    fun `when I and I are added, then the result should equal II`() {
        val result = RomanNumeralCalculator.add("I", "I")

        assertThat(result).isEqualTo("II")
    }
}