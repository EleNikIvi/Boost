package com.eugene.boost.data.repository

import com.eugene.boost.data.source.db.dao.ProjectDao
import com.eugene.boost.domain.repository.ProjectRepository

class ProjectRepositoryImpl(private val projectDao: ProjectDao) : ProjectRepository
