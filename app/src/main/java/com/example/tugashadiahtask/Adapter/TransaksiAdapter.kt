package com.example.tugashadiahtask.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugashadiahtask.Model.Transaksi
import com.example.tugashadiahtask.R

class TransaksiAdapter(private val transaksiList: List<Transaksi>) :
    RecyclerView.Adapter<TransaksiAdapter.TransaksiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransaksiViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_transaksi, parent, false)
        return TransaksiViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TransaksiViewHolder, position: Int) {
        val currentItem = transaksiList[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textJudul.text = currentItem.judul
        holder.textTanggal.text = currentItem.tanggal
        holder.textHarga.text = currentItem.harga
    }

    override fun getItemCount(): Int {
        return transaksiList.size
    }

    class TransaksiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_transaksi)
        val textJudul: TextView = itemView.findViewById(R.id.text_judul)
        val textTanggal: TextView = itemView.findViewById(R.id.text_tanggal)
        val textHarga: TextView = itemView.findViewById(R.id.text_harga)
    }
}
