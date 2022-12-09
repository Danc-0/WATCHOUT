package com.danc.watchout.di

import com.danc.watchout.data.remote.StarWarsAPI
import com.danc.watchout.data.repository.PeopleRepositoryImpl
import com.danc.watchout.domain.repository.PeopleRepository
import com.danc.watchout.domain.usecases.PeoplesUseCase
import com.danc.watchout.domain.usecases.SpecificFilmUseCase
import com.danc.watchout.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePeoplesUseCase(peopleRepository: PeopleRepository): PeoplesUseCase {
        return PeoplesUseCase(peopleRepository)
    }

    @Provides
    @Singleton
    fun provideSpecificFilmUSeCase(peopleRepository: PeopleRepository): SpecificFilmUseCase {
        return SpecificFilmUseCase(peopleRepository)
    }

    @Provides
    @Singleton
    fun providePeopleRepository(starWarsAPI: StarWarsAPI): PeopleRepository {
        return PeopleRepositoryImpl(starWarsAPI)
    }

    private val httpLoggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient: OkHttpClient = OkHttpClient().newBuilder().addInterceptor(
        httpLoggingInterceptor).build()

    @Provides
    @Singleton
    fun provideRetrofit(): StarWarsAPI {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(StarWarsAPI::class.java)
    }

}