package np.prashant.dev.recipes

import app.cash.turbine.test
import com.google.common.truth.Truth
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import np.prashant.dev.recipes.services.domain.common.executor.PostExecutionThread
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.domain.recipes.repositories.RecipeRepository

import org.junit.Assert.*
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val recipeRepository = mockk<RecipeRepository>()
    private val executor = mockk<PostExecutionThread>()

    @BeforeEach
    fun setup() {
        every { executor.io } answers { Dispatchers.Unconfined }
    }

    @Test
    fun sampleTest() = runTest {
        val recipes: List<RecipeElement> = mockk()
        coEvery { recipeRepository.searchRecipe("Pancakes") } returns flowOf(recipes)

        val fetchedRecipes = recipeRepository.searchRecipe("Pancakes")

        fetchedRecipes.test {
            val item = awaitItem()
            Truth.assertThat(item).isEqualTo(recipes)
        }
    }

    @Test
    fun addition_isCorrect() {
        Assertions.assertEquals(4, 2 + 2)
    }
}