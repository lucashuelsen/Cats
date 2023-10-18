package br.com.cats.ui.adapter

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.com.cats.model.Cats
import br.com.cats.model.CatsGallery
import br.com.cats.ui.adapter.viewHolder.CatsAdapterViewHolder
import com.squareup.picasso.Picasso

class CatsAdapterList(
    private val viewLifecycleOwner: LifecycleOwner,
    private val catList: ArrayList<CatsGallery>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CatsAdapterViewHolder.from(parent, viewLifecycleOwner)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CatsAdapterViewHolder -> {
                val cat = catList.get(position)
                holder.bind(cat)
            }
        }
    }

    override fun getItemCount(): Int {
        return catList.size
    }
}