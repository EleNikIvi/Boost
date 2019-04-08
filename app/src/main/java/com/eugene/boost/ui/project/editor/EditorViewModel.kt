package com.eugene.boost.ui.project.editor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eugene.boost.domain.model.ProjectModel
import com.eugene.boost.domain.repository.ProjectRepository
import com.eugene.boost.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditorViewModel(private val _projectRepository: ProjectRepository) : BaseViewModel() {

    var projectId: Int = -1

    val isCreating: Boolean
        get() = projectId == -1

    val isEditing: Boolean
        get() = projectId > -1

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    private val _isSaving = MutableLiveData<Boolean>()
    val isSaving: LiveData<Boolean>
        get() = _isSaving

    private val _project = MutableLiveData<ProjectModel>()
    val project: LiveData<ProjectModel>
        get() = _project


    fun loadProject(id: Int) {

        if (isCreating) return


        CoroutineScope(Dispatchers.IO).launch {

            _isLoading.postValue(true)

            _project.postValue(_projectRepository.getProject(id))

            _isLoading.postValue(false)
        }
    }

    fun saveChanges(name: String) {

        CoroutineScope(Dispatchers.IO).launch {

            _isSaving.postValue(true)

            when {
                isCreating -> _projectRepository.createProject(name)
                isEditing -> {
                    _project.value?.name = name
                    _projectRepository.updateProject(_project.value)
                }
            }

            _isSaving.postValue(false)
        }
    }
}
