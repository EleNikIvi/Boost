package com.eugene.boost.ui.project.projects.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.eugene.boost.R

@EpoxyModelClass(layout = R.layout.list_item_project)
abstract class ProjectEpoxyModel : EpoxyModelWithHolder<ProjectEpoxyHolder>() {

    @EpoxyAttribute
    var projectId: Int = 0

    @EpoxyAttribute
    lateinit var projectName: String

    @EpoxyAttribute
    lateinit var itemClickListener: () -> Unit


    override fun bind(holder: ProjectEpoxyHolder) {
        super.bind(holder)

        holder.txtProjectName.text = projectName
        holder.viwRoot.setOnClickListener { itemClickListener() }
    }
}
