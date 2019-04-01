package com.eugene.boost.ui.project.editor

import com.eugene.boost.domain.repository.ProjectRepository
import com.eugene.boost.ui.base.BaseViewModel

class EditorViewModel(private val projectRepository: ProjectRepository) : BaseViewModel() {

    var projectId: Int? = null


    fun saveChanges(name: String) {

        projectRepository.createProject(name)
    }
}
