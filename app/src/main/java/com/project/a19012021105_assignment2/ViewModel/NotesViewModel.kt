package com.project.a19012021105_assignment2.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.project.a19012021105_assignment2.Database.NotesDatabase
import com.project.a19012021105_assignment2.Model.Notes
import com.project.a19012021105_assignment2.Repository.NotesRepository


class NotesViewModel(application: Application):AndroidViewModel(application) {

    val repository:NotesRepository
    init{
        val dao= NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository=NotesRepository(dao)

    }
    fun addNotes(notes: Notes){
        repository.insertNotes(notes)

    }
    fun getNotes():LiveData<List<Notes>> = repository.getAllNotes()
    fun deleteNotes(id:Int){
        repository.deleteNotes(id)


    }
    fun updateNotes(notes:Notes){
        repository.updateNotes(notes)
    }
}