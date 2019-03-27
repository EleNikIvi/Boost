package com.eugene.boost.domain.repository

import com.eugene.boost.domain.model.ProjectModel

interface ProjectRepository {

    fun getAllProjects(): List<ProjectModel>
}
