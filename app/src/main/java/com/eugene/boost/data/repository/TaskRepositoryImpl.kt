package com.eugene.boost.data.repository

import com.eugene.boost.data.source.db.dao.TaskDao
import com.eugene.boost.domain.repository.TaskRepository

class TaskRepositoryImpl(private val taskDao: TaskDao) : TaskRepository
