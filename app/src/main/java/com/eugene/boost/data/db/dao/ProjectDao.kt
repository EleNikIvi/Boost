package com.eugene.boost.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.eugene.boost.data.db.entity.ProjectEntity

@Dao
interface ProjectDao {

    @Insert
    fun insert(project: ProjectEntity)

    @Update
    fun update(project: ProjectEntity)

    @Delete
    fun delete(project: ProjectEntity)

    @Query("DELETE FROM projects WHERE id = :id")
    fun deleteById(id: Int)

    @Query("SELECT * FROM projects ORDER BY create_date")
    fun getAll(): LiveData<List<ProjectEntity>>

    @Query("SELECT * FROM projects WHERE id = :id")
    fun getById(id: Int): LiveData<ProjectEntity>
}
