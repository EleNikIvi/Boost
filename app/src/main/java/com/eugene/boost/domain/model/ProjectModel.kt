package com.eugene.boost.domain.model

import com.eugene.boost.domain.enum.ProjectColor

data class ProjectModel(
    var id: Int = 0,
    var createDate: Long = 0,
    var name: String = "",
    var color: ProjectColor = ProjectColor.GREY
)
