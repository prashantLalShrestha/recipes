package np.prashant.dev.recipes.services.remote.common.interceptor

import np.prashant.dev.recipes.services.platform.common.error.RemoteError
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import kotlin.reflect.KClass

object NoInternetInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return try {
            chain.proceed(chain.request())
        } catch (e: Exception) {
            throw noNetworkException(e)
        }
    }

    private fun noNetworkException(exception: Throwable): Throwable {
        val networkExceptions: List<KClass<out IOException>> =
            listOf(
                SocketTimeoutException::class,
                ConnectException::class,
                UnknownHostException::class
            )
        return if (exception::class in networkExceptions) {
            RemoteError.Unavailable
        } else exception
    }
}