package np.prashant.dev.recipes.services.remote.recipe.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.platform.recipe.contract.remote.RecipeRemote
import np.prashant.dev.recipes.services.remote.recipe.mapper.toDomain
import np.prashant.dev.recipes.services.remote.recipe.model.RecipeSearchResponse
import javax.inject.Inject

class DefaultRecipeRemote @Inject constructor(
    private val httpClient: HttpClient
) : RecipeRemote {

    override suspend fun searchRecipe(query: String): List<RecipeElement> =
        httpClient.get("recipes/complexSearch") {
            parameter("query", query)
        }.body<RecipeSearchResponse>().toDomain()
}