package jp.cordea.cymophane

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import jp.cordea.cymophane.data.Search
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object PexelsApiClient : PexelsApi {
    private val service: PexelsApi
        get() {
            val key = ""
            var builder = OkHttpClient.Builder()
                    .addInterceptor {
                        it.proceed(it.request()
                                .newBuilder()
                                .addHeader("Authorization", key)
                                .build())
                    }

            if (BuildConfig.DEBUG) {
                builder = builder.addInterceptor(
                        HttpLoggingInterceptor()
                                .setLevel(HttpLoggingInterceptor.Level.BASIC)
                )
            }

            val moshi = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()
            return Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .client(builder.build())
                    .build()
                    .create(PexelsApi::class.java)
        }

    override fun search(query: String, perPage: Int, page: Int): Call<Search> =
            service.search(query, perPage, page)
}
