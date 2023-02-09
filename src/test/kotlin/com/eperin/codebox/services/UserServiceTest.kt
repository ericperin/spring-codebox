package com.eperin.codebox.services

import com.eperin.codebox.services.dtos.*
import com.eperin.codebox.services.interfaces.RandomUserService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UserServiceTest {
    private val randomUserService = mockk<RandomUserService>()
    private val userService = UserService(randomUserService)

    @Test
    fun `should return sum of users`() {
        every { randomUserService.getAll() } returns UserDto(
            results = listOf(
                Result(
                    "", Name("", "", ""),
                    Location(
                        Street(1, ""), "", "", "", "",
                        Coordinates("", ""), Timezone("", "")
                    ), "",
                    Login("", "", "", "", "", "", ""),
                    Dob("", 1),
                    Dob("", 2),
                    "", "", ID("", ""),
                    Picture("", "", ""), ""
                )
            ),
            info = Info(
                "", 2, 1, "1.2.3"
            )
        )

        val result = userService.getAll()

        verify(exactly = 1) { randomUserService.getAll() }
        Assertions.assertThat(result).isEqualTo(1)
    }
}