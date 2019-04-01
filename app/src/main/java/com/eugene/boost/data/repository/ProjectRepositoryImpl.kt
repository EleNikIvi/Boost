package com.eugene.boost.data.repository

import com.eugene.boost.data.source.db.dao.ProjectDao
import com.eugene.boost.data.source.db.entity.ProjectEntity
import com.eugene.boost.data.source.db.mapper.ProjectEntityMapper
import com.eugene.boost.domain.model.ProjectModel
import com.eugene.boost.domain.repository.ProjectRepository

class ProjectRepositoryImpl(private val projectDao: ProjectDao) : ProjectRepository {

    override fun createProject(name: String) {

        projectDao.insert(ProjectEntity(0, System.currentTimeMillis(), name, 0))
    }

    override fun getAllProjects(): List<ProjectModel> {

        return projectDao.getAll().map { ProjectEntityMapper().mapToModel(it) }
    }
}
