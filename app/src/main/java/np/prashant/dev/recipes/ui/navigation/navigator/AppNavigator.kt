package np.prashant.dev.recipes.ui.navigation.navigator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import np.prashant.dev.recipes.core.di.scopes.ProcessLifetime
import np.prashant.dev.recipes.ui.navigation.model.NavigationIntent
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Class that encapsulates high level navigation logic for the whole app. Navigation events ([NavigationIntent])
 * can be send and be listened to.
 *
 * @param scope The [CoroutineScope] the navigation events will be emitted on.
 */
@Singleton
class AppNavigator @Inject constructor(
    @ProcessLifetime private val scope: CoroutineScope,
) : Navigator {

    private val _navigationChannel = Channel<NavigationIntent>(
        capacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )
    val navigationChannel: ReceiveChannel<NavigationIntent> = _navigationChannel

    override fun navigateBack(
        route: String?,
        inclusive: Boolean,
        params: List<Pair<String, Any?>>
    ) {
        scope.launch {
            _navigationChannel.trySend(
                NavigationIntent.NavigateBack(
                    route = route,
                    inclusive = inclusive,
                    params = params,
                )
            )
        }
    }

    override fun navigateTo(
        route: String,
        popUpToRoute: String?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        scope.launch {
            _navigationChannel.trySend(
                NavigationIntent.NavigateTo(
                    route = route,
                    popUpToRoute = popUpToRoute,
                    inclusive = inclusive,
                    isSingleTop = isSingleTop,
                )
            )
        }
    }
}