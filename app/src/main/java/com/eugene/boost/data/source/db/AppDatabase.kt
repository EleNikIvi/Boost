package com.eugene.boost.data.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eugene.boost.data.source.db.dao.ProjectDao
import com.eugene.boost.data.source.db.dao.TaskDao
import com.eugene.boost.data.source.db.entity.ProjectEntity
import com.eugene.boost.data.source.db.entity.TaskEntity

@Database(entities = [ProjectEntity::class, TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun projectDao(): ProjectDao
    abstract fun taskDao(): TaskDao
}
