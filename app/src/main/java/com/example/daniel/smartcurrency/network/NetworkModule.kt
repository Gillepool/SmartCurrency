package com.example.daniel.smartcurrency.network

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import timber.log.Timber
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient()
            .newBuilder()
            .addNetworkInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit{

        return Retrofit.Builder()
            .baseUrl("http://www.ecb.europa.eu/stats/eurofxref/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideCurrencyApi(retrofit: Retrofit): CurrencyApi{
        return retrofit.create(CurrencyApi::class.java)
    }



}