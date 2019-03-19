package com.eugene.boost.data.source.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "projects",
    indices = [Index("id")]
)
data class ProjectEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "create_date")
    var createDate: Long = 0,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "color")
    var color: Int
)
