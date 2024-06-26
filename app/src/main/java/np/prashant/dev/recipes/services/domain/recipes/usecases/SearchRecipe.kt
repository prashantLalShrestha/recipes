package np.prashant.dev.recipes.services.domain.recipes.usecases

import kotlinx.coroutines.flow.Flow
import np.prashant.dev.recipes.services.domain.common.error.requireParams
import np.prashant.dev.recipes.services.domain.common.usecases.FlowUseCase
import np.prashant.dev.recipes.services.domain.recipes.model.RecipeElement
import np.prashant.dev.recipes.services.domain.recipes.repositories.RecipeRepository
import javax.inject.Inject

class SearchRecipe @Inject constructor(
    private val weatherRepository: RecipeRepository,
) : FlowUseCase<String, List<RecipeElement>>() {

    override fun execute(params: String?): Flow<List<RecipeElement>> {
        requireParams(params)
        return weatherRepository.searchRecipe(params)
    }
}