package com.eugene.boost.ui.project.projects

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.eugene.boost.R
import com.eugene.boost.domain.model.ProjectModel
import com.eugene.boost.ui.base.BaseFragment
import com.eugene.boost.ui.project.projects.epoxy.project
import com.eugene.boost.util.DialogUtil
import com.eugene.boost.util.ext.gone
import com.eugene.boost.util.ext.visible
import com.eugene.boost.util.lib.epoxy.withModels
import kotlinx.android.synthetic.main.fragment_project_projects.*
import kotlinx.android.synthetic.main.view_empty_screen.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProjectsFragment : BaseFragment() {

    private val _projectsViewModel: ProjectsViewModel by viewModel()

    private val _progressDialog: Dialog by lazy { DialogUtil.getProgressDialog(activity!!) }


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

        setupViewListeners()

        subscribeToViewModel()

        _projectsViewModel.loadProjects()
    }


    private fun setupViewListeners() {

        fab.setOnClickListener {
            findNavController().navigate(ProjectsFragmentDirections.createProject())
        }
    }

    private fun setupEmptyScreen() {

        img_empty_screen_icon.setImageResource(R.drawable.ic_folder_open_black_24dp)
        txt_empty_screen_description.setText(R.string.project_projects_empty_screen_description)
    }

    private fun setupProjectList(projects: List<ProjectModel>) {

        if (rcv_projects.adapter == null) {

            val rcvLayoutManager = LinearLayoutManager(activity)
            rcv_projects.layoutManager = rcvLayoutManager

            rcv_projects.withModels {
                projects.forEach {
                    project {
                        id(it.id)
                        name(it.name)
                    }
                }
            }

            rcv_projects.addItemDecoration(
                DividerItemDecoration(
                    rcv_projects.context,
                    rcvLayoutManager.orientation
                ).apply {
                    setDrawable(ContextCompat.getDrawable(context!!, R.drawable.list_item_decoration)!!)
                })
        } else {
            rcv_projects.requestModelBuild()
        }
    }

    private fun subscribeToViewModel() {

        _projectsViewModel.isLoading.observe(this, Observer {

            if (it) _progressDialog.show() else _progressDialog.hide()
        })

        _projectsViewModel.projects.observe(this, Observer {

            if (it.isNotEmpty()) {
                setupProjectList(it)
                viw_empty_screen.gone()
            } else {
                setupEmptyScreen()
                viw_empty_screen.visible()
            }
        })
    }
}
