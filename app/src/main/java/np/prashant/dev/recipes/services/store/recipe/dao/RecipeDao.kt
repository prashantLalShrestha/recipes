package np.prashant.dev.recipes.services.store.recipe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import np.prashant.dev.recipes.services.store.recipe.model.RecipeEntity

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes ORDER BY title")
    suspend fun getSavedRecipes(): List<RecipeEntity>

    @Insert
    suspend fun insertRecipe(data: RecipeEntity)

    @Query("DELETE FROM recipes WHERE id = :id")
    suspend fun deleteRecipe(id: Long)

    @Query("DELETE FROM recipes")
    suspend fun deleteAll()
}