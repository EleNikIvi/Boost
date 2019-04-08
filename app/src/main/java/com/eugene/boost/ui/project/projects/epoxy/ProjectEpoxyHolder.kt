package com.eugene.boost.ui.project.projects.epoxy

import android.view.View
import android.widget.TextView
import com.eugene.boost.R
import com.eugene.boost.util.lib.epoxy.EpoxyKotlinHolder

class ProjectEpoxyHolder : EpoxyKotlinHolder() {

    val viwRoot by bind<View>(R.id.viw_root)
    val txtProjectName by bind<TextView>(R.id.txt_project_name)
}
