package com.vamarmu.marvel.di


import android.app.Application
import com.vamarmu.marvel.BuildConfig
import com.vamarmu.marvel.data.remote.MarvelService
import com.vamarmu.marvel.data.remote.RemoteConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {


    @Provides
    fun okHttpClientProvider(
        @Named("ts") ts:String,
        @Named("apiKey") apiKey: String,
        @Named("hash") hash : String
    ) :OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }

        builder.addInterceptor { chain ->
            val original = chain.request()
            val originalHttpUrl = original.url


            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("ts", ts)
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("hash", hash)
                .build()

            val requestBuilder = original.newBuilder().url(url)

            chain.proceed(requestBuilder.build())
        }

        return builder.build()
    }

    @Provides
    @Singleton
    fun retrofitProvider(okHttpClient :OkHttpClient) : Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(RemoteConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun marvelServiceProvider(retrofit: Retrofit): MarvelService = retrofit.create(MarvelService::class.java)



    @Provides
    @Singleton
    @Named("apiKey")
    fun apiKeyProvider(app: Application): String = RemoteConfig.getApikey(app)

    @Provides
    @Named("hash")
    fun hashProvider(app : Application) : String = RemoteConfig.getHash(app)

    @Provides
    @Named("ts")
    fun tsProvider() : String = RemoteConfig.ts

}