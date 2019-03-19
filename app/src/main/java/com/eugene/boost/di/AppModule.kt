package com.eugene.boost.di

import androidx.room.Room
import com.eugene.boost.AppConstants
import com.eugene.boost.data.source.db.AppDatabase
import org.koin.dsl.module

val appModule = module {

    single {
        Room
            .databaseBuilder(get(), AppDatabase::class.java, AppConstants.AppDatabaseName)
            .build()
    }

    single { get<AppDatabase>().projectDao() }
    single { get<AppDatabase>().taskDao() }
}
