package com.eugene.boost.di

import androidx.room.Room
import com.eugene.boost.AppConstants
import com.eugene.boost.data.repository.ProjectRepositoryImpl
import com.eugene.boost.data.repository.TaskRepositoryImpl
import com.eugene.boost.data.source.db.AppDatabase
import com.eugene.boost.domain.repository.ProjectRepository
import com.eugene.boost.domain.repository.TaskRepository
import com.eugene.boost.ui.dashboard.DashboardViewModel
import com.eugene.boost.ui.dashboard.month.MonthViewModel
import com.eugene.boost.ui.dashboard.today.TodayViewModel
import com.eugene.boost.ui.dashboard.tomorrow.TomorrowViewModel
import com.eugene.boost.ui.dashboard.week.WeekViewModel
import com.eugene.boost.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room
            .databaseBuilder(get(), AppDatabase::class.java, AppConstants.AppDatabaseName)
            .build()
    }

    single { get<AppDatabase>().projectDao() }
    single { get<AppDatabase>().taskDao() }

    single<ProjectRepository> { ProjectRepositoryImpl(get()) }
    single<TaskRepository> { TaskRepositoryImpl(get()) }

    viewModel { MainViewModel() }
    viewModel { DashboardViewModel() }
    viewModel { TodayViewModel() }
    viewModel { TomorrowViewModel() }
    viewModel { WeekViewModel() }
    viewModel { MonthViewModel() }
}
