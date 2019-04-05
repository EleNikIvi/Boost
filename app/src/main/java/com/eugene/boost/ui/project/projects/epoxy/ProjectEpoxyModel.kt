package com.eugene.boost.ui.project.projects.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.eugene.boost.R

@EpoxyModelClass(layout = R.layout.list_item_project)
abstract class ProjectEpoxyModel : EpoxyModelWithHolder<ProjectEpoxyHolder>() {

    @EpoxyAttribute
    lateinit var name: String

    @EpoxyAttribute
    lateinit var itemClickListener: () -> Unit


    override fun bind(holder: ProjectEpoxyHolder) {
        super.bind(holder)

        holder.txtName.text = name
        holder.viwRoot.setOnClickListener { itemClickListener() }
    }
}
