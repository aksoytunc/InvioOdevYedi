package com.tuncaksoy.invioodevyedi.di

import android.content.Context
import androidx.room.Room
import com.tuncaksoy.invioodevyedi.data.datasource.YapilacaklarDataSource
import com.tuncaksoy.invioodevyedi.data.repo.YapilacaklarRepository
import com.tuncaksoy.invioodevyedi.room.YapilacaklarDao
import com.tuncaksoy.invioodevyedi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYapilacaklarRepository(yds: YapilacaklarDataSource): YapilacaklarRepository {
        return YapilacaklarRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDataSource(ydao: YapilacaklarDao): YapilacaklarDataSource {
        return YapilacaklarDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideYapilacaklarDao(@ApplicationContext context: Context): YapilacaklarDao {
        val vt =
            Room.databaseBuilder(context, Veritabani::class.java, "yapilacaklar.sqlite")
                .createFromAsset("yapilacaklar.sqlite").build()
        return vt.getYapilacaklarDao()
    }
}