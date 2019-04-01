package com.eugene.boost.ui.project.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import com.eugene.boost.util.gone
import com.eugene.boost.util.visible
import kotlinx.android.synthetic.main.fragment_project_projects.*
import kotlinx.android.synthetic.main.view_empty_screen.*
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

        img_empty_screen_icon.setImageResource(R.drawable.ic_folder_open_black_24dp)
        txt_empty_screen_description.setText(R.string.project_projects_empty_screen_description)
        viw_empty_screen.visible()

        _projectsViewModel.isLoading.observe(this, Observer {

        })

        _projectsViewModel.projects.observe(this, Observer {

            if (it.isNotEmpty()) {
                viw_empty_screen.gone()
            } else {
                viw_empty_screen.visible()
            }
        })

        _projectsViewModel.loadProjects()

        fab.setOnClickListener {

            findNavController().navigate(ProjectsFragmentDirections.createProject())
        }
    }
}
