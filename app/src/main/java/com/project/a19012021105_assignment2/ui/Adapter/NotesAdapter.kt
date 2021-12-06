package com.project.a19012021105_assignment2.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.a19012021105_assignment2.Model.Notes
import com.project.a19012021105_assignment2.R
import com.project.a19012021105_assignment2.databinding.ItemNotesBinding

class NotesAdapter(requireContext: Context,val notesList: List<Notes>) : RecyclerView.Adapter<NotesAdapter.notesViewHolder>(){

   class notesViewHolder(val binding:ItemNotesBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(ItemNotesBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
     val data = notesList[position]
        holder.binding.notesTitle.text= data.title
        holder.binding.notesTitle.text= data.subTitle
        holder.binding.notesTitle.text= data.date

        when(data.priority)
        {
            "1" ->{holder.binding.viewPriority.setBackgroundResource(R.drawable.green_dot)}
            "2" ->{holder.binding.viewPriority.setBackgroundResource(R.drawable.yellow_dot)}
            "3" ->{holder.binding.viewPriority.setBackgroundResource(R.drawable.red_dot)}
        }
    }

    override fun getItemCount()= notesList.size
}