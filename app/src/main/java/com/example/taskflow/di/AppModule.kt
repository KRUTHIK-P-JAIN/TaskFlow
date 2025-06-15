package com.example.taskflow.di

import android.content.Context
import androidx.room.Room
import com.example.taskflow.data.local.TaskDao
import com.example.taskflow.data.local.TaskDatabase
import com.example.taskflow.data.remote.TaskApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBaseUrl() = "https://run.mocky.io/v3/"

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String): Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideTaskApi(retrofit: Retrofit): TaskApi =
        retrofit.create(TaskApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): TaskDatabase =
        Room.databaseBuilder(context, TaskDatabase::class.java, "task_db").build()

    @Provides
    fun provideTaskDao(db: TaskDatabase): TaskDao = db.taskDao()
}