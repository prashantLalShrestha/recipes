package np.prashant.dev.recipes.ui.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


abstract class ViewModel<A : ViewAction, S : ViewState>(initialState: S) : ViewModel() {

    private val _state = MutableStateFlow(initialState)
    val state = _state.asStateFlow()

    fun trigger(action: A) {
        viewModelScope.launch {
            handleAction(action)
        }
    }

    protected fun setState(block: S.() -> S) {
        _state.value = _state.value.block()
    }

    protected open suspend fun handleAction(action: A) {

    }
}