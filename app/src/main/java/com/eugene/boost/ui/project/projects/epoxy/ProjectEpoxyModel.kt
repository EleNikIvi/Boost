package com.eugene.boost.ui.project.projects.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.eugene.boost.R

@EpoxyModelClass(layout = R.layout.item_project)
abstract class ProjectEpoxyModel : EpoxyModelWithHolder<ProjectEpoxyHolder>() {

    @EpoxyAttribute
    lateinit var name: String


    override fun bind(holder: ProjectEpoxyHolder) {
        super.bind(holder)

        holder.txtName.text = name
    }
}
