package com.project.a19012021105_assignment2.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.project.a19012021105_assignment2.Dao.NotesDao
import com.project.a19012021105_assignment2.Model.Notes

@Database(entities = [Notes::class],version=1,exportSchema = false)
abstract class NotesDatabase: RoomDatabase(){
    abstract fun myNotesDao(): NotesDao

    companion object
    {
      @Volatile
      var INSTANCE:NotesDatabase?=null
        fun getDatabaseInstance(context:Context):NotesDatabase{


            val tempInstnce= INSTANCE
            if(tempInstnce !=null){
                return tempInstnce

            }
            synchronized(this)
            {
                val roomDatabaseInstance= Room.
                databaseBuilder(context,NotesDatabase::class.java,"Notes").allowMainThreadQueries().build()
                INSTANCE=roomDatabaseInstance
                return return roomDatabaseInstance

            }
        }
    }


}