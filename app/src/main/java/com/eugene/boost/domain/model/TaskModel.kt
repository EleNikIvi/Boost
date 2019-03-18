package com.eugene.boost.domain.model

import com.eugene.boost.domain.enum.TaskPriority
import com.eugene.boost.domain.enum.TaskStatus

data class TaskModel(
    var id: Int = 0,
    var createDate: Long = 0,
    var scheduleDate: Long = 0,
    var title: String = "",
    var description: String = "",
    var estimatedTime: Long = 0,
    var elapsedTime: Long = 0,
    var priority: TaskPriority = TaskPriority.PRIORITY_4,
    var status: TaskStatus = TaskStatus.OPEN
)
