package com.psi.tempesanan.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.psi.tempesanan.R
import com.psi.tempesanan.fragments.room.Tempe
import kotlinx.android.synthetic.main.adapter_mainbarang.view.*

class TempeAdapter (var tempes: ArrayList<Tempe>, var listener: OnAdapterListener) :
    RecyclerView.Adapter<TempeAdapter.TempeViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempeViewHolder {
        return TempeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(
                    R.layout.adapter_mainbarang,
                    parent,
                    false
                )
        )
    }

    override fun getItemCount() = tempes.size

    override fun onBindViewHolder(holder: TempeViewHolder, position: Int) {
        val tempe = tempes[position]
        holder.view.text_title.text = tempe.namabarang
        holder.view.text_title.setOnClickListener {
            listener.onClick(tempe)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(tempe)
        }
        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(tempe)
        }
    }

    class TempeViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(newList: List<Tempe>) {
        tempes.clear()
        tempes.addAll(newList)
    }

    interface OnAdapterListener {
        fun onClick(tempe: Tempe)
        fun onUpdate(tempe: Tempe)
        fun onDelete(tempe: Tempe)
    }
}