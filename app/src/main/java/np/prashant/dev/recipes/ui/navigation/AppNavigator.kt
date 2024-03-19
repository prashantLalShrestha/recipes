package np.prashant.dev.recipes.ui.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.core.inject.ProcessLifetime
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class that encapsulates high level navigation logic for the whole app. Navigation events ([Navigation])
 * can be send and be listened to.
 *
 * @param scope The [CoroutineScope] the navigation events will be emitted on.
 */
@Singleton
class AppNavigator @Inject constructor(
    @ProcessLifetime private val scope: CoroutineScope,
) : Navigator {

    private val _navigations = MutableSharedFlow<Navigation>()
    val navigations: SharedFlow<Navigation>
        get() = _navigations

    override fun navigate(navigation: Navigation) {
        scope.launch {
            _navigations.emit(navigation)
        }
    }
}
