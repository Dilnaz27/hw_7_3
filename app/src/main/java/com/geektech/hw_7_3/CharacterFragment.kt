package com.geektech.hw_7_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.hw_7_3.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {

    private lateinit var binding: FragmentCharacterBinding
    private lateinit var characterList: ArrayList<Character>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = CharacterAdapter(characterList,this::onItemClick)
        binding.recyclerView.adapter = adapter
    }

    private fun loadData() {
        characterList = ArrayList<Character>()

        characterList.apply {
            add(Character("Rick Sanchez", "Alive", R.drawable.ricki))
            add(Character("Morty Smith", "Alive", R.drawable.morty))
            add(Character("Albert Einstein", "Dead", R.drawable.albert))
            add(Character("Jerry Smith", "Alive", R.drawable.jerry))
        }
    }

    private fun onItemClick(character: Character) {
        findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToSingleCharacterFragment(character))
    }
}