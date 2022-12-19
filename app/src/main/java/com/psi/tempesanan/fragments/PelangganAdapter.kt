package com.psi.tempesanan.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.model.Pelanggan

class PelangganAdapter (
    private val listItems: ArrayList<Pelanggan>,
    private val listener: PelangganListener
    ) : RecyclerView.Adapter<PelangganAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_pelanggan, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: PelangganAdapter.NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewNamaPelanggan.text = item.namapelanggan
        holder.textViewNomorTelp.text = item.nomortelp
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewNamaPelanggan = itemView.findViewById<TextView>(R.id.text_view_namapelanggan)
        var textViewNomorTelp = itemView.findViewById<TextView>(R.id.text_view_nomortelp)
    }

    interface PelangganListener {
        fun OnItemClicked(pelanggan: Pelanggan)
    }

}