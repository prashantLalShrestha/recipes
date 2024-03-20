package np.prashant.dev.recipes.services.store.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import np.prashant.dev.recipes.services.store.recipe.dao.RecipeDao
import np.prashant.dev.recipes.services.store.recipe.model.RecipeEntity

@Database(
    entities = [RecipeEntity::class],
    version = 1
)
abstract class StoreDatabase : RoomDatabase() {
    abstract val recipeDao: RecipeDao

    companion object {
        const val DATABASE_NAME = "store_db"
    }
}