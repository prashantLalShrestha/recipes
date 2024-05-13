package np.prashant.dev.recipes.store

import android.content.Context
import androidx.room.Room
import np.prashant.dev.recipes.services.store.common.database.StoreDatabase

internal fun createDatabase(context: Context) = Room
    .inMemoryDatabaseBuilder(context, StoreDatabase::class.java)
    .allowMainThreadQueries()
    .build()

