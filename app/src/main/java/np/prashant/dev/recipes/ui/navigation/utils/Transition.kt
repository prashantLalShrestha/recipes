package np.prashant.dev.recipes.ui.navigation.utils

import androidx.navigation.AnimBuilder
import np.prashant.dev.recipes.R

fun AnimBuilder.defaultTransition() {
    enter = R.anim.fade_in
    exit = R.anim.fade_out
    popEnter = R.anim.fade_in
    popExit = R.anim.fade_out
}