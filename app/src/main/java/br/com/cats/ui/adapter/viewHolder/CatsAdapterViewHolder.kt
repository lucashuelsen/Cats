package br.com.cats.ui.adapter.viewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.com.cats.databinding.CatsAdatperViewHolderBinding
import br.com.cats.model.Cats
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.ImageViewTarget
import com.squareup.picasso.Picasso


class CatsAdapterViewHolder(
    private var binding: CatsAdatperViewHolderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(cat: Cats) {
        binding.cat = cat

        //Get online image
        Picasso.get().load(cat.link).into(binding.imageView)

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