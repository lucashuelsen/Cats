package br.com.cats.ui.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.com.cats.databinding.CatsAdatperViewHolderBinding
import br.com.cats.model.CatsGallery
import br.com.cats.util.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso


class CatsAdapterViewHolder(
    private var binding: CatsAdatperViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cat: CatsGallery) {
        binding.cat = cat
        val imageView = binding.imageView

        //Get online image
        Glide
            .with(binding.root.context)
            .load(cat.getFirstImage())
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