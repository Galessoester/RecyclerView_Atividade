package com.example.estergalesso_rm89350

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.estergalesso_rm89350.databinding.FilmeItemViewBinding

class FilmeItemAdapter : RecyclerView.Adapter<FilmeItemAdapter.FilmeHolder>() {
    private val filmes: MutableList<FilmeModel> = mutableListOf()

    class FilmeHolder(val itemHolder: FilmeItemViewBinding) :
        RecyclerView.ViewHolder(itemHolder.root) {
        fun bind(item: FilmeModel) {
            itemHolder.recomendariaView.setImageResource(
                when {
                    item.recomendaria -> R.drawable.like
                    else -> R.drawable.dislike
                }
            )
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeHolder {
        return  FilmeHolder(
            FilmeItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = filmes.size

    override fun onBindViewHolder(holder: FilmeHolder, position: Int) {
        holder.bind(filmes[position])
        holder.itemHolder.close.setOnClickListener {
            removeListItem(filmes[position])
        }
    }

    fun setList(newItems: List<FilmeModel>) {
        filmes.clear()
        filmes.addAll(newItems)
        notifyDataSetChanged()
    }

    fun removeListItem(removed: FilmeModel) {
        val removedIndex = filmes.indexOf(removed)
        filmes.remove(removed)
        notifyItemRemoved(removedIndex)
        notifyItemRangeChanged(removedIndex, filmes.size);
    }

}