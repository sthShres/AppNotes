package com.project.a19012021105_assignment2.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.project.a19012021105_assignment2.R
import com.project.a19012021105_assignment2.ViewModel.NotesViewModel
import com.project.a19012021105_assignment2.databinding.FragmentHomeBinding
import com.project.a19012021105_assignment2.ui.Adapter.NotesAdapter

class HomeFragment : Fragment() {
 lateinit var binding:FragmentHomeBinding
 val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentHomeBinding.inflate(layoutInflater,container,false)


        viewModel.getNotes().observe(viewLifecycleOwner,{notesList ->

             binding.rcvAllNotes.layoutManager= GridLayoutManager(requireContext(),2)
            binding.rcvAllNotes.adapter= NotesAdapter(requireContext(),notesList)

        })

        binding.btnAdd.setOnClickListener {
            Navigation.findNavController(it)
                    .navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        return binding.root
    }

}