package np.prashant.dev.recipes

import app.cash.turbine.test
import com.google.common.truth.Truth
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.test.runTest
import np.prashant.dev.recipes.ui.navigation.model.NavigationIntent
import np.prashant.dev.recipes.ui.navigation.navigator.AppNavigator
import org.junit.jupiter.api.Test


class AppNavigatorTest {

    private lateinit var navigator: AppNavigator

    @Test
    fun `test navigation back function sends NavigateBack Intent on the channel`() = runTest {
        // Arrange
        navigator = AppNavigator(this)

        // Act
        navigator.navigateBack()

        // Assert
        navigator.navigationChannel.receiveAsFlow().test {
            val intent = awaitItem()
            Truth.assertThat(intent).isEqualTo(NavigationIntent.NavigateBack())
        }
    }

}