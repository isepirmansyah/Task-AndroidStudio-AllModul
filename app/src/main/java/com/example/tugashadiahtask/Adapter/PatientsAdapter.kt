package com.example.tugashadiahtask.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugashadiahtask.Model.DataItem
import com.example.tugashadiahtask.R

class PatientsAdapter(
    private var dataList: List<DataItem?>,
    private val onItemClick: (Int) -> Unit,
) : RecyclerView.Adapter<PatientsAdapter.ViewHolder>() {

    fun updateData(newData: List<DataItem?>) {
        dataList = newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        item?.let { it ->
            holder.bind(it)
            holder.itemView.setOnClickListener {
                onItemClick(it.id ?: -1)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textName: TextView = itemView.findViewById(R.id.textName)
        private val textPhone: TextView = itemView.findViewById(R.id.textPhone)
        private val textAddress: TextView = itemView.findViewById(R.id.textAddress)
        private val textStatus: TextView = itemView.findViewById(R.id.textStatus)

        fun bind(dataItem: DataItem) {
            textName.text = dataItem.name
            textPhone.text = dataItem.phone
            textAddress.text = dataItem.address
            textStatus.text = dataItem.status
        }
    }
}

