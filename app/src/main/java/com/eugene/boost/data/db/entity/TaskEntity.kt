package com.eugene.boost.data.db.entity

import androidx.room.*

@Entity(
    tableName = "tasks",
    foreignKeys = [ForeignKey(
        entity = ProjectEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("project_id"),
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("id")]
)
data class TaskEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "create_date")
    var createDate: Long = 0,

    @ColumnInfo(name = "schedule_date")
    var scheduleDate: Long = 0,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "estimated_time")
    var estimatedTime: Long = 0,

    @ColumnInfo(name = "elapsed_time")
    var elapsedTime: Long = 0,

    @ColumnInfo(name = "priority")
    var priority: Int = 0,

    @ColumnInfo(name = "status")
    var status: Int = 0,

    @ColumnInfo(name = "project_id")
    var projectId: Int
)
