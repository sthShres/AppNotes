package com.project.a19012021105_assignment2.Repository

import com.project.a19012021105_assignment2.Dao.NotesDao
import androidx.lifecycle.LiveData
import com.project.a19012021105_assignment2.Model.Notes


class NotesRepository(val dao:NotesDao){

     fun getAllNotes():LiveData<List<Notes>>{
          return dao.getNOtes()

     }
     fun insertNotes(notes: Notes){
          dao.insertNotes(notes)

     }
    fun deleteNotes(id:Int)
    {
         dao.deleteNotes(id)

    }
     fun updateNotes(notes: Notes){
          dao.updateNotes(notes)

     }

}