package np.prashant.dev.recipes.core.config

import np.prashant.dev.recipes.BuildConfig
import np.prashant.dev.recipes.services.remote.common.config.RemoteConfig
import javax.inject.Inject


class AppRemoteConfig @Inject constructor() : RemoteConfig {
    override val apiHost: String = BuildConfig.API_HOST
    override val apiKey: String = BuildConfig.API_KEY
    override val isDebug: Boolean = BuildConfig.DEBUG
}