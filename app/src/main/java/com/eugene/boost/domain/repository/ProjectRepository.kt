package com.eugene.boost.domain.repository

import com.eugene.boost.domain.model.ProjectModel

interface ProjectRepository {

    fun createProject(name: String)

    fun getProject(id: Int): ProjectModel

    fun getAllProjects(): List<ProjectModel>
}
