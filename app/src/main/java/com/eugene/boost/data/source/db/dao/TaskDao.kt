package com.eugene.boost.data.source.db.dao

import androidx.room.*
import com.eugene.boost.data.source.db.entity.TaskEntity

@Dao
interface TaskDao {

    @Insert
    fun insert(project: TaskEntity)

    @Update
    fun update(project: TaskEntity)

    @Delete
    fun delete(project: TaskEntity)

    @Query("DELETE FROM tasks WHERE id = :id")
    fun deleteById(id: Int)

    @Query("SELECT * FROM tasks ORDER BY create_date")
    fun getAll(): List<TaskEntity>

    @Query("SELECT * FROM tasks WHERE project_id = :projectId ORDER BY create_date")
    fun getAllByProjectId(projectId: Int)

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getById(id: Int): TaskEntity
}
