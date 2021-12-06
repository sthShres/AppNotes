package com.project.a19012021105_assignment2.ui.Fragments

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.project.a19012021105_assignment2.Model.Notes
import com.project.a19012021105_assignment2.R
import com.project.a19012021105_assignment2.ViewModel.NotesViewModel
import com.project.a19012021105_assignment2.databinding.FragmentCreateNoteBinding

import java.util.*

class CreateNoteFragment : Fragment() {

lateinit var binding:FragmentCreateNoteBinding
 var priority: String="1"
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
      binding = FragmentCreateNoteBinding.inflate(layoutInflater, container, false)
        binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)

      binding.pGreen.setOnClickListener {
          priority="1"
      binding.pGreen.setImageResource(R.drawable.ic_baseline_done_24)
          binding.pRed.setImageResource(0)
          binding.pYellow.setImageResource(0)

      }
        binding.pYellow.setOnClickListener {
            priority="2"
            binding.pYellow.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pRed.setImageResource(0)
            binding.pGreen.setImageResource(0)
        }
        binding.pRed.setOnClickListener {
            priority="3"
            binding.pRed.setImageResource(R.drawable.ic_baseline_done_24)
            binding.pGreen.setImageResource(0)
            binding.pYellow.setImageResource(0)
        }


        binding.btnSaveNOtes.setOnClickListener {
            createNotes(it)
        }

        return binding.root
    }

    private fun createNotes(it: View?) {
       var title= binding.editTitle.text.toString()
       var subTitle= binding.editSubtitle.text.toString()
       var notes= binding.editNotes.text.toString()

        val d = Date()
        val notesDate: CharSequence = DateFormat.format("MMMM d, yyyy ", d.time)

        val data=Notes(null,
                title= title,
                subTitle=subTitle,
                notes = notes,
                date = notesDate.toString(),
                priority
                )
        viewModel.addNotes(data)
        Toast.makeText(requireContext(),"Notes created sucessfully",Toast.LENGTH_SHORT).show()


        Navigation.findNavController(it!!).navigate(R.id.action_createNoteFragment_to_homeFragment)

    }

}