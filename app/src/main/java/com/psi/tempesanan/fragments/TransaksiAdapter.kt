package com.psi.tempesanan.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.model.Transaksi

class TransaksiAdapter (
    private val listItems: ArrayList<Transaksi>,
    private val listener: TransaksiListener
        ) : RecyclerView.Adapter<TransaksiAdapter.NoteViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_transaksi, parent, false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    override fun onBindViewHolder(holder: TransaksiAdapter.NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewTanggalTrans.text = item.tanggaltrans
        holder.textViewNamaPelangganTrans.text = item.namapelanggantrans
        holder.textViewNamaBarangTrans.text = item.namabarangtrans
        holder.textViewHargaBarangTrans.text = item.hargabarangtrans
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTanggalTrans = itemView.findViewById<TextView>(R.id.tanggaltrans)
        var textViewNamaPelangganTrans = itemView.findViewById<TextView>(R.id.namapelanggantrans)
        var textViewNamaBarangTrans = itemView.findViewById<TextView>(R.id.namabarangtrans)
        var textViewHargaBarangTrans = itemView.findViewById<TextView>(R.id.tanggaltrans)
    }

    interface TransaksiListener {
        fun OnItemClicked(transaksi: Transaksi)
    }
        }