package np.prashant.dev.recipes.services.remote.common.config

interface RemoteConfig {
    val apiHost: String
    val apiKey: String
    val isDebug: Boolean
}