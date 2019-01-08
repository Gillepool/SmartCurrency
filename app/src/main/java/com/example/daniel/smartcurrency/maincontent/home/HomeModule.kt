package com.example.daniel.smartcurrency.maincontent.home

import com.example.daniel.smartcurrency.network.CurrencyApi
import com.example.daniel.smartcurrency.network.NetworkModule
import com.example.daniel.smartcurrency.network.NetworkRepository
import com.example.daniel.smartcurrency.utils.FileRepository
import com.example.daniel.smartcurrency.utils.NetworkUtil
import dagger.Module
import dagger.Provides

@Module(includes = [NetworkModule::class])
class HomeModule {

    @Provides
    fun providesHomeRepository(currencyApi: CurrencyApi): HomeRepository.Network{
        return NetworkRepository(currencyApi)
    }

    @Provides
    fun providesHomeModel(networkRepository: NetworkRepository,
                          fileRepository: FileRepository,
                          networkUtil: NetworkUtil): HomeContract.Model{
        return HomeModel(networkRepository, fileRepository, networkUtil)
    }
}