package br.com.cats.ui.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.com.cats.data.model.Cats
import br.com.cats.databinding.CatsAdatperViewHolderBinding
import br.com.cats.data.model.CatsGallery
import com.bumptech.glide.Glide


class CatsAdapterViewHolder(
    private var binding: CatsAdatperViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cat: Cats) {
        binding.cat = cat
        val imageView = binding.imageView

        //Get online image
        Glide
            .with(binding.root.context)
            .load(cat.link)
            .fitCenter()
            .centerCrop()
            .into(imageView)

        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup, lifecycleOwner: LifecycleOwner): CatsAdapterViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = CatsAdatperViewHolderBinding.inflate(layoutInflater, parent, false)
            binding.lifecycleOwner = lifecycleOwner

            return CatsAdapterViewHolder(binding)
        }
    }
}