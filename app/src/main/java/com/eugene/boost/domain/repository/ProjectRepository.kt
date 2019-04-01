package com.eugene.boost.domain.repository

import com.eugene.boost.domain.model.ProjectModel

interface ProjectRepository {

    fun createProject(name: String)

    fun getAllProjects(): List<ProjectModel>
}
