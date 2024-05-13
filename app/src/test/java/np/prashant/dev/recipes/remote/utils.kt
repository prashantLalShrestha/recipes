package np.prashant.dev.recipes.remote

import com.google.common.io.Resources
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandler
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.Headers.Companion.headersOf
import java.io.File
import java.net.URL

@Suppress("UnstableApiUsage")
internal fun getJson(path: String): String {
    val uri: URL = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}


internal val responseHeaders =
    headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())

internal fun createMockClient(handler: MockRequestHandler) = HttpClient(MockEngine) {
    engine {
        addHandler(handler)
    }
    install(ContentNegotiation) {
        json(Json {
            isLenient = true
            prettyPrint = true
            ignoreUnknownKeys = true
            encodeDefaults = true
        })
    }
}
