package com.eugene.boost.data.source.db.mapper

import com.eugene.boost.data.source.db.entity.TaskEntity
import com.eugene.boost.domain.enum.TaskPriority
import com.eugene.boost.domain.enum.TaskStatus
import com.eugene.boost.domain.model.TaskModel

class TaskEntityMapper {

    fun mapToModel(entity: TaskEntity): TaskModel {

        return TaskModel(
            id = entity.id,
            createDate = entity.createDate,
            scheduleDate = entity.scheduleDate,
            title = entity.title,
            description = entity.description,
            estimatedTime = entity.estimatedTime,
            elapsedTime = entity.elapsedTime,
            priority = TaskPriority.getPriorityByInt(entity.priority),
            status = TaskStatus.getStatusByInt(entity.status),
            projectId = entity.projectId
        )
    }

    fun mapToModel(entities: Collection<TaskEntity>) = entities.map { mapToModel(it) }


    fun mapToEntity(model: TaskModel): TaskEntity {

        return TaskEntity(
            model.id,
            model.createDate,
            model.scheduleDate,
            model.title,
            model.description,
            model.estimatedTime,
            model.elapsedTime,
            model.priority.priorityInt,
            model.status.statusInt,
            model.projectId
        )
    }

    fun mapToEntity(models: Collection<TaskModel>) = models.map { mapToEntity(it) }
}
