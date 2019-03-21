package com.eugene.boost.data.repository

import com.eugene.boost.data.source.db.dao.ProjectDao

class ProjectRepositoryImpl(private val projectDao: ProjectDao) : ProjectRepository
