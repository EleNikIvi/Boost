package com.eugene.boost.ui.project.projects

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eugene.boost.domain.model.ProjectModel
import com.eugene.boost.domain.repository.ProjectRepository
import com.eugene.boost.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProjectsViewModel(private val projectRepository: ProjectRepository) : BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _projects = MutableLiveData<List<ProjectModel>>()
    val projects: LiveData<List<ProjectModel>>
        get() = _projects


    fun loadProjects() {

        CoroutineScope(Dispatchers.IO).launch {

            _isLoading.postValue(true)

            _projects.postValue(projectRepository.getAllProjects())

            _isLoading.postValue(false)
        }
    }
}
