package np.prashant.dev.recipes.services.store.common.di

import android.app.Application
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import np.prashant.dev.recipes.services.platform.recipe.contract.store.RecipeStore
import np.prashant.dev.recipes.services.store.common.database.StoreDatabase
import np.prashant.dev.recipes.services.store.recipe.dao.RecipeDao
import np.prashant.dev.recipes.services.store.recipe.store.DefaultRecipeStore
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface StoreModule {

    @[Binds Singleton]
    fun recipeStore(recipeStore: DefaultRecipeStore): RecipeStore

    companion object {
        @[Provides Singleton]
        fun provideRoomDb(app: Application): StoreDatabase {
            return Room.databaseBuilder(
                app,
                StoreDatabase::class.java,
                StoreDatabase.DATABASE_NAME
            ).build()
        }

        @[Provides Singleton]
        fun provideRecipeDao(database: StoreDatabase): RecipeDao {
            return database.recipeDao
        }
    }
}