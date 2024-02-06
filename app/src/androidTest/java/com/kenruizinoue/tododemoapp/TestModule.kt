package com.kenruizinoue.tododemoapp

import android.content.Context
import androidx.room.Room
import com.kenruizinoue.tododemoapp.data.AppDatabase
import com.kenruizinoue.tododemoapp.data.TodoDao
import com.kenruizinoue.tododemoapp.data.TodoRepository
import com.kenruizinoue.tododemoapp.di.TodoAppModule
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [TodoAppModule::class]
)
object TestModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): AppDatabase =
        Room.inMemoryDatabaseBuilder(appContext, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideTodoDao(appDatabase: AppDatabase): TodoDao = appDatabase.todoDao()

    @Provides
    @Singleton
    fun provideTodoRepository(todoDao: TodoDao): TodoRepository = TodoRepository(todoDao)

    @Provides
    @Singleton
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}