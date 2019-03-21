package com.eugene.boost.data.repository

import com.eugene.boost.data.source.db.dao.TaskDao

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository
