package com.eugene.boost.ui.project.projects

import android.app.Dialog
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyTouchHelper
import com.eugene.boost.R
import com.eugene.boost.domain.model.ProjectModel
import com.eugene.boost.ui.base.BaseFragment
import com.eugene.boost.ui.project.projects.epoxy.ProjectEpoxyModel
import com.eugene.boost.ui.project.projects.epoxy.project
import com.eugene.boost.util.DialogUtil
import com.eugene.boost.util.ext.gone
import com.eugene.boost.util.ext.visible
import com.eugene.boost.util.lib.epoxy.EpoxyKotlinSwipeCallbacks
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
            findNavController().navigate(ProjectsFragmentDirections.openProjectEditor())
        }
    }

    private fun setupEmptyScreen() {

        img_empty_screen_icon.setImageResource(R.drawable.ic_folder_open_black_24dp)
        txt_empty_screen_description.setText(R.string.project_projects_empty_screen_description)
    }

    private fun setupProjectList(projects: List<ProjectModel>) {

        val rcvLayoutManager = LinearLayoutManager(activity)
        rcv_projects.layoutManager = rcvLayoutManager

        rcv_projects.withModels {
            projects.forEach {
                project {
                    id(it.id)
                    projectId(it.id)
                    projectName(it.name)
                    itemClickListener {

                    }
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

        val itemBackgroundColor = TypedValue()
        context!!.theme.resolveAttribute(R.attr.colorInactiveLight, itemBackgroundColor, true)

        val swipes = object : EpoxyKotlinSwipeCallbacks<ProjectEpoxyModel>(
            _rightIcon = context?.getDrawable(R.drawable.ic_edit_black_24dp),
            _leftIcon = context?.getDrawable(R.drawable.ic_delete_black_24dp),
            _rightIconColor = context!!.getColor(R.color.whiteColor),
            _leftIconColor = context!!.getColor(R.color.whiteColor),
            _foregroundRightColor = context!!.getColor(R.color.orangeColor),
            _foregroundLeftColor = context!!.getColor(R.color.redColor),
            _backgroundColor = itemBackgroundColor.data,
            _padding = context!!.resources.getDimensionPixelSize(R.dimen.app_space_lg)
        ) {
            override fun onSwipeCompleted(
                model: ProjectEpoxyModel,
                itemView: View,
                position: Int,
                direction: Int
            ) {
                when (direction) {
                    //4 ->
                    8 -> findNavController().navigate(ProjectsFragmentDirections.openProjectEditor(model.projectId))
                }
            }
        }

        EpoxyTouchHelper.initSwiping(rcv_projects)
            .leftAndRight()
            .withTarget(ProjectEpoxyModel::class.java)
            .andCallbacks(swipes)
    }

    private fun subscribeToViewModel() {

        _projectsViewModel.isLoading.observe(this, Observer {

            if (it) _progressDialog.show() else _progressDialog.hide()
        })

        _projectsViewModel.projects.observe(this, Observer {

            if (it.isNotEmpty()) {
                setupProjectList(it)
                viw_empty_screen.gone()
                rcv_projects.visible()
            } else {
                setupEmptyScreen()
                rcv_projects.gone()
                viw_empty_screen.visible()
            }
        })
    }
}
