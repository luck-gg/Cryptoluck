package com.luckgg.cryptoluck.di

import com.luckgg.cryptoluck.common.Constants
import com.luckgg.cryptoluck.data.remote.CoinPaprikaAPI
import com.luckgg.cryptoluck.data.repository.CoinRepositoryImpl
import com.luckgg.cryptoluck.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class) //All dependencies in the module live as long the application
object AppModule{

    @Provides
    @Singleton //Only an instance through all the lifetime
    fun providePaprikaApi(): CoinPaprikaAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaAPI::class.java)
    }
    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaAPI):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}
