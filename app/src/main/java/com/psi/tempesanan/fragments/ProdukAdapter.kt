package com.psi.tempesanan.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.model.Tempe


class ProdukAdapter(
    private val listItems: ArrayList<Tempe>,
    private val listener: TempeListener
) : RecyclerView.Adapter<ProdukAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewNamaBarang.text = item.namabarang
        holder.textViewHargaBarang.text = item.hargabarang
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNamaBarang = itemView.findViewById<TextView>(R.id.text_view_namabarang)
        var textViewHargaBarang = itemView.findViewById<TextView>(R.id.text_view_hargabarang)
    }

    interface TempeListener{
        fun OnItemClicked(tempe: Tempe)
    }
}

