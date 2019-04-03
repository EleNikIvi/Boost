package com.eugene.boost.ui.project.editor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eugene.boost.domain.repository.ProjectRepository
import com.eugene.boost.ui.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditorViewModel(private val projectRepository: ProjectRepository) : BaseViewModel() {

    var projectId: Int? = null

    private val _isSaving = MutableLiveData<Boolean>()
    val isSaving: LiveData<Boolean>
        get() = _isSaving


    fun saveChanges(name: String) {

        CoroutineScope(Dispatchers.IO).launch {

            _isSaving.postValue(true)

            projectRepository.createProject(name)

            _isSaving.postValue(false)
        }
    }
}
