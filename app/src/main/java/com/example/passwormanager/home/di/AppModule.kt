package com.example.passwormanager.home.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.PasswordDao
import com.example.todoapp.data.PasswordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideTodoDao(passwordDatabase: PasswordDatabase):PasswordDao = passwordDatabase.PasswordDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context) :PasswordDatabase =
        Room.databaseBuilder(
            context,PasswordDatabase::class.java,
            "passwordManager"
        ).fallbackToDestructiveMigration().build()


}