package com.eugene.boost.data.source.db.mapper

import com.eugene.boost.data.source.db.entity.ProjectEntity
import com.eugene.boost.domain.enum.ProjectColor
import com.eugene.boost.domain.model.ProjectModel

class ProjectEntityMapper {

    fun mapToModel(entity: ProjectEntity): ProjectModel {

        return ProjectModel(
            id = entity.id,
            createDate = entity.createDate,
            name = entity.name,
            color = ProjectColor.getColorByInt(entity.color)
        )
    }

    fun mapToModel(entities: Collection<ProjectEntity>) = entities.map { mapToModel(it) }


    fun mapToEntity(model: ProjectModel): ProjectEntity {

        return ProjectEntity(
            model.id,
            model.createDate,
            model.name,
            model.color.colorInt
        )
    }

    fun mapToEntity(models: Collection<ProjectModel>) = models.map { mapToEntity(it) }
}
