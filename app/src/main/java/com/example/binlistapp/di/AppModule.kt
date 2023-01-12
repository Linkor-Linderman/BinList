package com.example.binlistapp.di


import android.app.Application
import androidx.room.Room
import com.example.binlistapp.common.Constants
import com.example.binlistapp.data.data_sourse.RequestDatabase
import com.example.binlistapp.data.remote.BinlistApi
import com.example.binlistapp.data.repository.BinlistRepositoryImpl
import com.example.binlistapp.domain.repository.BinlistRepository
import com.example.binlistapp.domain.use_case.AddNewRequest
import com.example.binlistapp.domain.use_case.GetCardDetailByBinUseCase
import com.example.binlistapp.domain.use_case.GetRequestListUseCase
import com.example.binlistapp.domain.use_case.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBinlistApi(): BinlistApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BinlistApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRequestDataBase(app: Application): RequestDatabase {
        return Room.databaseBuilder(
            app,
            RequestDatabase::class.java,
            RequestDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(api: BinlistApi, db: RequestDatabase): BinlistRepository {
        return BinlistRepositoryImpl(
            api,
            db.requestDao
        )
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: BinlistRepository): UseCases {
        return UseCases(
            getRequestListUseCase = GetRequestListUseCase(repository),
            getCardDetailByBinUseCase = GetCardDetailByBinUseCase(repository),
            addNewRequest = AddNewRequest(repository)
        )
    }
}