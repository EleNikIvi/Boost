package com.eugene.boost.ui.project.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectsFragment : BaseFragment() {

    private val _projectsViewModel: ProjectsViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_project_projects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView() {

        setToolbarTitle(getString(R.string.app_projects))

        _projectsViewModel.isLoading.observe(this, Observer {

        })

        _projectsViewModel.loadProjects()
    }
}
