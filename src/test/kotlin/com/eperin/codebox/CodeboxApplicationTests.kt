package com.eperin.codebox

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CodeboxApplicationTests {
    @Test
    fun shouldIsEqual() {
        val expected = 42
        assertThat(expected).isEqualTo(42)
    }
}
