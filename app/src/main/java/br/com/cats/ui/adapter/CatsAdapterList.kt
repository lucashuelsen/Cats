package br.com.cats.ui.adapter

import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import br.com.cats.data.model.Cats
import br.com.cats.ui.adapter.viewHolder.CatsAdapterViewHolder

class CatsAdapterList(
    private val viewLifecycleOwner: LifecycleOwner,
    private val catList: ArrayList<Cats>,
    val onClickListener: View.OnClickListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CatsAdapterViewHolder.from(parent, viewLifecycleOwner)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CatsAdapterViewHolder -> {
                val cat = catList.get(position)
                holder.bind(cat, onClickListener)
            }
        }
    }

    override fun getItemCount(): Int {
        return catList.size
    }
}