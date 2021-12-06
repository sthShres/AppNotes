package com.project.a19012021105_assignment2.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.project.a19012021105_assignment2.Model.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM Notes")
    fun getNOtes():LiveData<List<Notes>>

    @Insert(onConflict= OnConflictStrategy.REPLACE)
    fun insertNotes(notes:Notes)
    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes:Notes)


}