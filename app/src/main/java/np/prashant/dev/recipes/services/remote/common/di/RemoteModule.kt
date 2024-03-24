package np.prashant.dev.recipes.services.remote.common.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import np.prashant.dev.recipes.services.platform.recipe.contract.remote.RecipeRemote
import np.prashant.dev.recipes.services.remote.common.config.RemoteConfig
import np.prashant.dev.recipes.services.remote.common.interceptor.HttpsInterceptor
import np.prashant.dev.recipes.services.remote.common.interceptor.NoInternetInterceptor
import np.prashant.dev.recipes.services.remote.recipe.remote.DefaultRecipeRemote
import javax.inject.Singleton

@[Module InstallIn(SingletonComponent::class)]
interface RemoteModule {

    @[Binds Singleton]
    fun recipeRemote(remote: DefaultRecipeRemote): RecipeRemote

    companion object {

        private const val HTTP_TIMEOUT = 60_000L

        @OptIn(ExperimentalSerializationApi::class)
        private val json = Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
            explicitNulls = false
            encodeDefaults = true
        }

        @[Provides Singleton]
        fun httpClient(remoteConfig: RemoteConfig): HttpClient {
            val clientEngine = makeHttpClientEngine()
            return HttpClient(clientEngine) {
                defaultRequest(remoteConfig.apiHost, remoteConfig.apiKey)
                httpTimeout()
                json()
                logging(remoteConfig.isDebug)
            }
        }

        private fun makeHttpClientEngine() = OkHttp.create {
            addInterceptor(HttpsInterceptor)
            addInterceptor(NoInternetInterceptor)
        }

        private fun HttpClientConfig<*>.defaultRequest(apiHost: String, apiKey: String) {
            defaultRequest {
                url {
                   protocol = URLProtocol.HTTPS
                   host = apiHost
                }
                headers {
                    append("x-api-key", apiKey)
                }
            }
        }

        private fun HttpClientConfig<*>.httpTimeout() {
            install(HttpTimeout) {
                requestTimeoutMillis = HTTP_TIMEOUT
                connectTimeoutMillis = HTTP_TIMEOUT
            }
        }

        private fun HttpClientConfig<*>.json() {
            install(ContentNegotiation) {
                json(json)
            }
        }

        private fun HttpClientConfig<*>.logging(isDebug: Boolean) {
            if (isDebug) {
                install(Logging) {
                    logger = Logger.DEFAULT
                    level = LogLevel.ALL
                }
            }
        }
    }
}