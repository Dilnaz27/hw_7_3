package com.geektech.hw_7_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.hw_7_3.databinding.ItemCharacterBinding

class CharacterAdapter(
    private val characterList: List<Character>,
    private val onClick: (character: Character) -> Unit
) : Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from
                    (parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = characterList.size


    inner class CharacterViewHolder(private val binding: ItemCharacterBinding) :
        ViewHolder(binding.root) {
        fun bind() {

            val item = characterList[adapterPosition]

            binding.apply {
                tvName.text = item.name
                tvStatus.text = item.status
                ivCharacter.setImageResource(item.image)
            }
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}