package com.eugene.boost.ui.project.projects.epoxy

import android.widget.TextView
import com.eugene.boost.R
import com.eugene.boost.util.lib.epoxy.EpoxyKotlinHolder

class ProjectEpoxyHolder : EpoxyKotlinHolder() {

    val txtName by bind<TextView>(R.id.txt_project_name)
}
