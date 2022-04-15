package com.example.finalproject.view
import com.example.finalproject.data.Results
import com.example.finalproject.service.PokeService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class ListPresenterTest {

    private val view: ListsView = mockk(relaxed = true)
    private val pokeService: PokeService = mockk(relaxed = true)

    private val presenter = ListsPresenter(view, pokeService)

    @Test
    fun `On start, call get pokemon`() {
        presenter.start()

        verify { pokeService.getPokemon(any(), any(), any()) }
    }

    @Test
    fun `When get pokemon, given response is success, then bind fruits on view`() {
        // Arrange
        val pokemon = buildPokemon()

        every { pokeService.getPokemon(any(), any(), any()) } answers {
            firstArg<(List<Results?>) -> Unit>().invoke(pokemon)
        }

        // Act
        presenter.start()

        // Assertion
        verify { view.bindPokemon(pokemon) }
    }

    private fun buildPokemon(): List<Results?> {
        return listOf(
            Results(
                name = "bulbasaur",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            )
        )
    }
}